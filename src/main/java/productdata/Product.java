package productdata;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class Product {
    private static long idCounter;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле может быть null


    public Product(BufferedReader reader) {
            idCounter++;
            id = idCounter;

            System.out.println("Введите имя продукта:");
            while (name == null) {
                try {
                    name = reader.readLine();
                }
                catch (IOException e){
                    System.out.println(" Введено некорректное значение.");
                }
                if ("".equals(name)) {
                    System.out.println("Ошибка: введено пустое значение. Введите имя продукта:");
                    name = null;
                }
            }
            System.out.println("Ввести цену ?\n yes \n any words to no:");
            try {
                if ("yes".equals(reader.readLine())) {
                    while (price == null) {
                        try {
                            this.price = Float.parseFloat(reader.readLine());
                        } catch (Exception e) {
                            System.out.println("Введего некорректное значение.");
                        }
                        if (price != null && price < 0f) {
                            System.out.println("Ошибка: цена не может быть отрицательной. Введите цену:");
                            price = null;
                        }
                    }
                } else {
                    price = null;
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            creationDate = LocalDateTime.now();
            coordinates = new Coordinates(reader);
            System.out.println("Введите единицы массы: \n" +
                    "    KILOGRAMS,\n" +
                    "    CENTIMETERS,\n" +
                    "    PCS,\n" +
                    "    LITERS,\n" +
                    "    MILLILITERS;");

            while (unitOfMeasure == null) {
                try {
                    this.unitOfMeasure = UnitOfMeasure.valueOf(reader.readLine().toUpperCase());
                }
                catch (Exception e ){
                    System.out.println("Ошибка: введено неккоректное значение. Введите единицы массы:");
                }
            }
            System.out.println("Ввести данные о производителе ? \n yes \n any words to no");
            try {
                if(reader.readLine().equals("yes")) {
                    while (true) {
                        System.out.println("Назначить из существующих ? \n yes \n any words to no");
                        try {
                            if (reader.readLine().equals("yes")) {
                                String key;
                                System.out.println("Выберите из списка : ");
                                UniqueController.getOrgTable().forEach((k, v) -> System.out.println(k));
                                try {
                                    key = reader.readLine();
                                } catch (Exception e) {
                                    System.out.println("Ошибка: введено некорректное значение.");
                                    continue;
                                }
                                try {
                                    manufacturer = UniqueController.get(key);
                                    break;
                                }
                                catch (Exception e){
                                    System.out.println("Такой компании нет в списке");
                                }
                            }
                            else {
                                manufacturer = new Organization(reader);
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка: введено некорректное значение.");
                        }
                    }
                }
            }
            catch (Exception e){
                System.out.println("Ошибка: введено некорректное значение.");
            }
    }

    public Product(Long id,String name, Coordinates coordinates, Float price, UnitOfMeasure unitOfMeasure, Organization organization,LocalDateTime data) throws Exception {
        if (id == null ) {
            idCounter++;
            this.id = idCounter;
        }
        else
        {
            this.id = id;
        }
        if (name == null || coordinates == null || unitOfMeasure == null) throw new NullPointerException();
        if (price < 0) throw new Exception("Цена не может быть меньше 0");
        this.name = name;
        this.price = price;
        this.coordinates = coordinates;
        if (data == null) {
            creationDate = LocalDateTime.now();
        }
        else {
            creationDate = data;
        }
        this.unitOfMeasure = unitOfMeasure;
        this.manufacturer = organization;
    }

    public String out(){
        return id.toString() + ";" + name + ";" + coordinates.output() + ";" +
                (manufacturer == null ? ";;;;;;;":manufacturer.getId() + ";" +
                        (manufacturer.getPostalAddress() == null ? ";;;" : manufacturer.getPostalAddress())
                        + ";" + manufacturer.getName() + ";" + manufacturer.getFullName() + ";"
                        + (manufacturer.getType() == null?"":manufacturer.getType())) + ";" +
                unitOfMeasure.toString() + ";" + creationDate.toString() + ";" + (price == null ? "":price.toString());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ("ID продукта: " + id + " \nProduct name: " + name + " \nКоординаты продукта: "
                + coordinates.toString() + " \nДата создания : " + creationDate.toString()
                + " \nЦена продукта : " + (price == null ? "не указано":price.toString())+ " \nЕдиницы измерения : "
                + unitOfMeasure.toString() + " \nПроизводит : " + (manufacturer == null ? "не указано" : manufacturer.toString()));
    }

    public Long getId() {
        return id;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }
}