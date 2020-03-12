package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Address {
    private String street; //Поле не может быть null
    private Location town; //Поле может быть null

    Address(BufferedReader reader) {
            System.out.println("Введите улицу: ");
            while (street == null) {
                try {
                    street = reader.readLine();
                }
                catch (IOException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите улицу:");
                }
                if (street == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите улицу:");
                }
            }
            System.out.println("Ввести город ? \n yes \n any words to no");
        try {
            if(reader.readLine().equals("yes")) {
                town = new Location(reader);
            }
        }
        catch (IOException e){
            System.out.println("Ошибка: введено некорректное значение.");
        }
    }

    public Address(String street, Location town) {
        if(street == null) throw new NullPointerException();
        this.street = street;
        this.town = town;
    }

    @Override
    public String toString(){
        return (street + ";" + (town == null ? "не указано": town.output()));
    }

}