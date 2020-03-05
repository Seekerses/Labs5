package productdata;
import java.io.BufferedReader;

public class Organization {
    static int orgId;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Длина строки не должна быть больше 1404, Значение этого поля должно быть уникальным, Поле не может быть null
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    public Organization(BufferedReader reader) {
        try {
            orgId++;
            id = orgId;
            System.out.println("Введите имя организации:");
            while (name == null) {
                name = reader.readLine();
                if (name == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите имя организации:");
                }
            }
            System.out.println("Введите полное имя организации :");
            while (fullName == null) {
                fullName = reader.readLine();
                if (fullName == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите имя организации:");
                }
                if (fullName.length() > 1404) {
                    System.out.println("Ошибка: введено слишком длинное имя. Введите имя организации:");
                    fullName = null;
                }
                if (UniqueController.check(fullName)){
                    System.out.println("Not unique full name");
                    fullName = null;
                }
            }
            System.out.println("Введите тип организации:\n" +
                    " PUBLIC,\n" +
                    " TRUST,\n" +
                    " PRIVATE_LIMITED_COMPANY");
            type = OrganizationType.valueOf(reader.readLine());
            postalAddress = new Address(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UniqueController.put(this.fullName,this);
    }

    public Organization(String name, String fullName, OrganizationType type, Address postalAddress) throws Exception{
        if (name == null || fullName == null) throw new NullPointerException();
        if (fullName.length() >1404) throw new Exception("Too large full name");
        if (UniqueController.check(fullName)) throw new Exception("Not unique full name");
        orgId++;
        id = orgId;
        this.name = name;
        this.fullName = fullName;
        this.type = type;
        this.postalAddress = postalAddress;
        UniqueController.put(this.fullName,this);
    }

    public Organization(String name, String fullName, OrganizationType type) throws Exception{
        if (name == null || fullName == null) throw new NullPointerException();
        if (fullName.length() >1404) throw new Exception("Too large full name");
        if (UniqueController.check(fullName)) throw new Exception("Not unique full name");
        orgId++;
        id = orgId;
        this.name = name;
        this.fullName = fullName;
        this.type = type;
        UniqueController.put(this.fullName,this);
    }


    public Organization(String name, String fullName) throws Exception{
        if (name == null || fullName == null) throw new NullPointerException();
        if (fullName.length() >1404) throw new Exception("Too large full name");
        if (UniqueController.check(fullName)) throw new Exception("Not unique full name");
        orgId++;
        id = orgId;
        this.name = name;
        this.fullName = fullName;
        UniqueController.put(this.fullName,this);
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPostalAddress() {
        return postalAddress.toString();
    }

    public String getType(){
        return type.toString();
    }

    @Override
    public String toString(){
        return ("ID организации: " + id + " имя организации: " + name
                + " Полное имя: " + fullName + " Тип организации: " + (type == null ? "не указано" : type.toString())
                + " Адресс организации " + (postalAddress == null ? "не указано" : postalAddress.toString()));
    }
}