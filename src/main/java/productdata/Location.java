package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Location {
    private Long x; //Поле не может быть null
    private int y;
    private Long z; //Поле не может быть null

    Location(BufferedReader reader){
        try {
            System.out.println("Введите координаты организации. Введите координату x:");
            while(x == null) {
                try {
                    x = Long.parseLong(reader.readLine());
                }
                catch (NumberFormatException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите координату x:");
                    x = null;
                }
            }
            System.out.println("Введите координату y:");
            while (true){
                try {
                    y = Integer.parseInt(reader.readLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введено некорректное значение");
                } catch (IOException e) {
                    System.out.println("Ошибка: введено некорректное значение.");
                }
            }

            System.out.println("Введите координату z:");
            while(z == null) {
                try {
                    z = Long.parseLong(reader.readLine());
                }
                catch (NumberFormatException e){
                    System.out.println("Ошибка: введено некорректное значение. Введите координату z:");
                    z = null;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Location(Long x, int y, Long z) throws NullPointerException{
        if ( x == null || z == null) throw new NullPointerException();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString(){
        return ("x = " + x + " y = " + y + " z = " + z);
    }
}