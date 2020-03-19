package productdata;
import java.io.BufferedReader;
import java.io.IOException;

public class Location {
    private Long x; //Поле не может быть null
    private int y;
    private Long z; //Поле не может быть null

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

    public String output(){
        return x + ";" + y + ";" + z;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Location){
            return (((Location) obj).x.equals(x)  && ((Location) obj).y == y && ((Location) obj).z.equals(z));
        }
        else return false;
    }

}