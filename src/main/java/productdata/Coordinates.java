package productdata;
import java.io.BufferedReader;

public class Coordinates {
    private double x;
    private Integer y; //Значение поля должно быть больше -150, Поле не может быть null

    public Coordinates(BufferedReader reader){
        try {
            System.out.println("Введите координаты организации. Введите координату x:");
            x = Double.parseDouble(reader.readLine());
            System.out.println("Введите координату y:");
            while (y == null) {
                y = Integer.parseInt(reader.readLine());
                if (y == null)System.out.println("Ошибка: введено пустое значение. ВВедите координату y:");
                if (y < -150)System.out.println("Ошибка: число выходит за диапазон. ВВедите координату y > -150:");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}