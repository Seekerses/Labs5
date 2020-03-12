package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Coordinates {
    private double x;
    private Integer y; //Значение поля должно быть больше -150, Поле не может быть null

    Coordinates(BufferedReader reader){
            System.out.println("Введите координаты организации. Введите координату x:");
            while (true){
                try {
                    x = Double.parseDouble(reader.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введено некорректное значение");
                } catch (IOException e) {
                    System.out.println("Ошибка: введено некорректное значение.");
                }
            }
            System.out.println("Введите координату y:");
            while (y == null) {
                try {
                    y = Integer.parseInt(reader.readLine());
                }
                catch (Exception e) {
                    System.out.println("Ошибка: введено некорректное значение");
                    continue;
                }
                if (y < -150){
                    System.out.println("Ошибка: число выходит за диапазон. Введите координату y > -150:");
                    y = null;
                }
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

    public String output(){
        return x + ";" + y;
    }
}