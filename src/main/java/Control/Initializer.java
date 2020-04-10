package Control;
import java.io.*;
import java.time.LocalDateTime;

import Exceptions.NotUniqueFullName;
import productdata.*;

/**
 * This class upload a table of Products from files(files must be correctly filled)
 */
public class Initializer {
    /**
     * This method fills the table with Product that creates using the csv file
     * @param table Table, which will filled
     * @param file csv File
     */
    public static void init(TableManager table, File file){
        try {
            if(!file.canRead()) throw new IllegalAccessException();
            if(file.length() == 0){
                table.setCreationDate(LocalDateTime.now());
                System.out.println("Initializing complete...");
                return;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
            bufferedReader.close();
            System.out.println("Initializing complete...");

        }
        catch (IllegalAccessException a) {
            System.out.println("The file cannot be accessed, enter the file address:");
            try {
                a.printStackTrace();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                if(!"exit".equals(line)) init(table , new File(line));
                else System.exit(0);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        catch (Exception e) {
            System.out.println("The file contains an error, enter the file address:");
            try {
                e.printStackTrace();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                if(!"exit".equals(line)) init(table , new File(line));
                else System.exit(0);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    /**
     * Creates the new Product using the Strings array where all arguments are located in correct positions(as in the saved file)
     * @param table Built product will be placed here
     * @param str Strings array of arguments for building Product
     * @return Built Product
     */
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
                    org = new Organization("".equals(str[5]) ? null : Integer.parseInt(str[5]), str[10], str[11], "".equals(str[12]) ? null : OrganizationType.valueOf(str[12]), adr);
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
            product = new Product("".equals(str[1])? null:Long.parseLong(str[1]),str[2], coord, str.length < 16 ? null : Float.parseFloat(str[15]), UnitOfMeasure.valueOf(str[13]), org , "".equals(str[14]) ? null: LocalDateTime.parse(str[14]));
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