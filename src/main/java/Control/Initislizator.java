package Control;
import java.io.*;
import productdata.*;

public class Initislizator {

    public static void init(TableManager table, String address){
        try {
            File file = new File(address);
            FileReader fileReader = new FileReader(file); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                build(table,line.split(";"));
            }
            bufferedReader.close(); // закрываем поток
            System.out.println("Initializing complete...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Product build(TableManager table, String[] str){
        Location location = new Location(Long.parseLong(str[2]), Integer.parseInt(str[3]), Long.parseLong(str[4]));
        Address adr = new Address(str[5], location);
        Product product = null;
        try {
            Coordinates coord = new Coordinates(Double.parseDouble(str[10]), Integer.parseInt(str[11]));
            Organization org = new Organization(str[6], str[7], OrganizationType.valueOf(str[8]), adr);
            product = new Product(str[1], coord, Float.parseFloat(str[10]), UnitOfMeasure.valueOf(str[9]), org);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (product != null) {
            table.put(str[0], product);
        }
        return product;
    }
}