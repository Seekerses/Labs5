package Control;
import java.io.*;
import java.time.LocalDateTime;

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
        Location location;
        if (!"".equals(str[7] + str[8] + str[9])){
            location = new Location(Long.parseLong(str[7]),"".equals(str[8])? 0 : Integer.parseInt(str[8]), Long.parseLong(str[9]));
        }
        else{
            location = null;
        }
        Address adr = new Address(str[6], location);
        Product product = null;
        try {
            Coordinates coord = new Coordinates(Double.parseDouble(str[3]), Integer.parseInt(str[4]));
            Organization org;
            if(!"".equals(str[11])) {
                org = new Organization(Integer.parseInt(str[5]), str[10], str[11],"".equals(str[12]) ? null : OrganizationType.valueOf(str[12]), adr);
            }
            else {org = null;}
            product = new Product(Long.parseLong(str[1]),str[2], coord, "".equals(str[15]) ? null : Float.parseFloat(str[15]), UnitOfMeasure.valueOf(str[13]), org ,str[14] == null || "".equals(str[14])? null: LocalDateTime.parse(str[14]));
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