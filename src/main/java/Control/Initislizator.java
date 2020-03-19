package Control;
import java.io.*;
import java.time.LocalDateTime;

import Exceptions.NotUniqueFullName;
import productdata.*;

public class Initislizator {

    public static void init(TableManager table, String address){
        try {
            File file = new File(address);
            FileReader fileReader = new FileReader(file); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader

            String line = bufferedReader.readLine();
            if (line.contains(";")){
                table.setCreationDate(LocalDateTime.now());
                build(table,line.split(";"));
            }
            else {
                table.setCreationDate("".equals(line) ? LocalDateTime.now() : LocalDateTime.parse(line));
            }
            while ((line = bufferedReader.readLine()) != null) {
                build(table,line.split(";"));
            }
            bufferedReader.close(); // закрываем поток
            System.out.println("Initializing complete...");

        } catch (Exception e) {
            System.out.println("Содержимое файла содержит ошибку, введите адрес файла :");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                init(table , reader.readLine());
            }
            catch (IOException ex){
                e.printStackTrace();
            }
        }
    }

    public static Product build(TableManager table, String[] str){
        Location location;
        if (!"".equals(str[7] +  str[9])){
            location = new Location(Long.parseLong(str[7]),"".equals(str[8])? 0 : Integer.parseInt(str[8]), Long.parseLong(str[9]));
        }
        else{
            location = null;
        }
        Address adr;
        if (!"".equals(str[6])) {
            adr = new Address(str[6], location);
        } else {
             adr = null;
        }
        Product product = null;
        try {
            Coordinates coord = new Coordinates("".equals(str[3]) ? 0 : Double.parseDouble(str[3]), Integer.parseInt(str[4]));
            Organization org;
            if(!"".equals(str[11])) {
                try {
                    org = new Organization(Integer.parseInt(str[5]), str[10], str[11], "".equals(str[12]) ? null : OrganizationType.valueOf(str[12]), adr);
                }
                catch (NotUniqueFullName e){
                    Organization comp = UniqueController.getOrgTable().get(str[11]);
                    if(comp.getPostalAddress().equals(adr) && comp.getName().equals(str[10])
                            && comp.getType().equals("".equals(str[12]) ? null : OrganizationType.valueOf(str[12])))
                        org = comp;
                    else throw new NotUniqueFullName();
                }
            }
            else {org = null;}
            product = new Product(Long.parseLong(str[1]),str[2], coord, str.length < 16 ? null : Float.parseFloat(str[15]), UnitOfMeasure.valueOf(str[13]), org , "".equals(str[14]) ? null: LocalDateTime.parse(str[14]));
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