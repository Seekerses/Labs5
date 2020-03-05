package productdata;
import java.io.BufferedReader;
import java.time.LocalDateTime;

public class Address {
    private String street; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(BufferedReader reader) {
        try {
            System.out.println("Введите улицу: ");
            while (street == null) {
                street = reader.readLine();
                if (street == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите улицу:");
                }

            }
            town = new Location(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Address(String street, Location town) {
        if(street == null) throw new NullPointerException();
        this.street = street;
        this.town = town;
    }

    public Address(String street) {
        if(street == null) throw new NullPointerException();
        this.street = street;
    }

    @Override
    public String toString(){
        return (street + "," + (town == null ? "не указано": town.toString()));
    }

}