package productdata;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class Product {
    static long idCounter;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле может быть null, Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле может быть null


    public Product(BufferedReader reader) {
        try {
            idCounter++;
            id = idCounter;

            System.out.println("Введите имя продукта:");
            while (name == null) {
                name = reader.readLine();
                if (name == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите имя продукта:");
                }
            }
            System.out.println("Введите цену:");
            while (price == null) {
                this.price = Float.parseFloat(reader.readLine());
                if (price == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите единицы массы:");
                }
                if(price <0f){
                    System.out.println("Ошибка: цена не может быть отрицательной. Введите цену:");
                    price = null;
                }
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
                this.unitOfMeasure = UnitOfMeasure.valueOf(reader.readLine().toUpperCase());
                if (unitOfMeasure == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите единицы массы:");
                }
            }
            manufacturer = new Organization(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ProductBuilder{
        private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.LocalDateTime creationDate = LocalDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Float price; //Поле может быть null, Значение поля должно быть больше 0
        private UnitOfMeasure unitOfMeasure; //Поле не может быть null
        private Organization manufacturer;

        public ProductBuilder buildName(String name){
            this.name = name;
            return this;
        }
        public ProductBuilder buildCoordinates(Coordinates coordinates){
            this.coordinates = coordinates;
            return this;
        }
        private ProductBuilder buildCreationDate(LocalDateTime date){
            this.creationDate = date;
            return this;
        }
        public ProductBuilder buildPrice(Float price){
            this.price = price;
            return this;
        }
        public ProductBuilder buildMeasure(UnitOfMeasure unitOfMeasure){
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }
        public ProductBuilder buildOrg(Organization org){
            this.manufacturer = org;
            return this;
        }

        public Product build(){
            try {
                return new Product(name, coordinates, price, unitOfMeasure, manufacturer);
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }

    public Product(String name, Coordinates coordinates, Float price, UnitOfMeasure unitOfMeasure, Organization organization) throws Exception {
        idCounter++;
        id = idCounter;
        if (name == null || coordinates == null || unitOfMeasure == null) throw new NullPointerException();
        if (price < 0) throw new Exception("Цена не может быть меньше 0");
        this.name = name;
        this.coordinates = coordinates;
        creationDate = LocalDateTime.now();
        this.unitOfMeasure = unitOfMeasure;
        this.manufacturer = organization;
    }

    public String out(){
        return id.toString() + ";" + name + ";" + coordinates.toString() + ";" + manufacturer.getPostalAddress() + ";" +
                manufacturer.getName() + ";" + manufacturer.getFullName() + ";" + manufacturer.getType() + ";" +
                unitOfMeasure.toString();
    }

    @Override
    public String toString() {
        return ("ID продукта: " + id + " \nимя продукта: " + name + " \nКоординаты продукта: "
                + coordinates.toString() + " \nДата создания : " + creationDate.toString()
                + " \nЦена продукта : " + (price == null ? "не указано":price.toString())+ " \nЕдиницы измерения : "
                + unitOfMeasure.toString() + " \nПроизводит : " + (manufacturer == null ? "не указано" : manufacturer.toString()));
    }
}