package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Organization {
    private static int orgId;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Длина строки не должна быть больше 1404, Значение этого поля должно быть уникальным, Поле не может быть null
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле может быть null

    Organization(BufferedReader reader) {
        try {
            orgId++;
            id = orgId;
            System.out.println("Введите имя организации:");
            while (name == null) {
                try {
                    name = reader.readLine();
                }
                catch (IOException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите имя организации:");
                }
                if (name == null || name.equals("")) {
                    System.out.println("Ошибка: введено пустое значение. Введите имя организации");
                }
            }
            System.out.println("Введите полное имя организации :");
            while (fullName == null) {
                while(fullName == null) {
                    try {
                        fullName = reader.readLine();
                    } catch (IOException e) {
                        System.out.println("Ошибка: введено некорректное значение. Введите полное имя организации:");
                    }
                }
                if (fullName.length() > 1404) {
                    System.out.println("Ошибка: введено слишком длинное имя. Введите имя организации:");
                    fullName = null;
                }
                if (UniqueController.check(fullName)){
                    System.out.println("Полное имя организации должно быть уникальным.");
                    fullName = null;
                }
            }
            System.out.println("Ввести тип организации ? \n yes \n any words to no");
            try {
                if(reader.readLine().equals("yes")) {
                    System.out.println("Введите тип организации:\n" +
                            " PUBLIC,\n" +
                            " TRUST,\n" +
                            " PRIVATE_LIMITED_COMPANY");
                    while(type == null) {
                        try {
                            type = OrganizationType.valueOf(reader.readLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println(" Введено неверное значение.");
                            type = null;
                        }
                    }
                }
            }
            catch (IOException e){
                System.out.println("Ошибка: введено некорректное значение.");
            }
            System.out.println("Ввести адрес ? \n yes \n any words to no");
            try {
                if(reader.readLine().equals("yes")) {
                    postalAddress = new Address(reader);
                }
            }
            catch (IOException e){
                System.out.println("Ошибка: введено некорректное значение.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UniqueController.put(this.fullName,this);
    }

    public Organization(Integer id,String name, String fullName, OrganizationType type, Address postalAddress) throws Exception{
        if (name == null || fullName == null) throw new NullPointerException();
        if (fullName.length() >1404) throw new Exception("Too large full name");
        if (UniqueController.check(fullName)) throw new Exception("Not unique full name");
        if (id == null) {
            orgId++;
            this.id = orgId;
        }
        else{
            this.id = id;
        }
        this.name = name;
        this.fullName = fullName;
        this.type = type;
        this.postalAddress = postalAddress;
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
        return postalAddress == null ? null : postalAddress.toString();
    }

    public String getType(){
        return type == null ? null : type.toString();
    }

    @Override
    public String toString(){
        return ("ID организации: " + id + " имя организации: " + name
                + " Полное имя: " + fullName + " Тип организации: " + (type == null ? "не указано" : type.toString())
                + " Адресс организации " + (postalAddress == null ? "не указано" : postalAddress.toString()));
    }
}