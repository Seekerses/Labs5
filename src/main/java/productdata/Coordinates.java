package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Coordinates {
    private double x;
    private Integer y; //Значение поля должно быть больше -150, Поле не может быть null


    public Coordinates(double x, Integer y)throws Exception{
        if (y == null) throw new NullPointerException();
        if (y < -150 ) throw new Exception("Неверная координата y");
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return (" x = " + x + " y = " + y);
    }

    public String output(){
        return x + ";" + y;
    }
}