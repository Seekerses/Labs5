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

    public Float getPrice() {
        return price;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}