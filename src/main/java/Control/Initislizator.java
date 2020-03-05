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

                String[] str = line.split(";");
                Location location = new Location(Long.parseLong(str[2]), Integer.parseInt(str[3]), Long.parseLong(str[4]));
                Address adr = new Address(str[5], location);
                Coordinates coord = new Coordinates( Double.parseDouble(str[10]), Integer.parseInt(str[11]));
                Organization org = new Organization(str[6], str[7], OrganizationType.valueOf(str[8]), adr);
                //Product product = new Product.ProductBuilder()
                //        .buildName(str[1])
                //        .buildCoordinates(coord)
                //        .buildPrice(Float.parseFloat(str[10]))
                //       .buildMeasure(UnitOfMeasure.valueOf(str[9]))
                //      .buildOrg(org).build();
                Product product = new Product(str[1], coord, Float.parseFloat(str[10]), UnitOfMeasure.valueOf(str[9]), org);
                table.put(str[0], product);
            }
            bufferedReader.close(); // закрываем поток
            System.out.println("Initializing complete...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}