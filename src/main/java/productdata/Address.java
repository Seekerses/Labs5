package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Address {
    private String street; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String street, Location town) {
        if(street == null) throw new NullPointerException();
        this.street = street;
        this.town = town;
    }

    @Override
    public String toString(){
        return (street + ";" + (town == null ? "не указано": town.output()));
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Address){
            return ((Address) obj).street.equals(street) && ((Address) obj).town.equals(town);
        }
        else return false;
    }

}