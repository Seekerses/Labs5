package productdata;
import java.io.BufferedReader;

public class Location {
    private Long x; //Поле не может быть null
    private int y;
    private Long z; //Поле не может быть null

    public Location(BufferedReader reader){
        try {
            System.out.println("Введите координаты организации. Введите координату x:");
            while(x == null) {
                x = Long.parseLong(reader.readLine());
                if (x == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите координату x:");
                }
            }
            System.out.println("Введите координату y:");
            y = Integer.parseInt(reader.readLine());
            while(z == null) {
                System.out.println("Введите координату z:");
                z = Long.parseLong(reader.readLine());
                if (z == null) {
                    System.out.println("Ошибка: введено пустое значение. Введите координату z:");
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