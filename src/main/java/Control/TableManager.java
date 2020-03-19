package Control;
import productdata.Product;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

//reciever
public class TableManager {
    private Hashtable<String, Product> table;
    private java.time.LocalDateTime Date;

    public TableManager(){

        table = new Hashtable<>();

    }

    public int getSize(){
        return table.size();
    }

    public void put(String index, Product product){
        table.put(index,product);
    }

    public Product get(String index){
        return table.get(index);
    }

    public void clear(){
        table.clear();
    }

    public void save() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\seeke\\Desktop\\Saved.csv");
        StringBuilder text= new StringBuilder();
        text.append(Date.toString()).append("\n");
        for (Map.Entry<String, Product> entry : table.entrySet()) {

            text.append(entry.getKey()).append(";").append(entry.getValue().out()).append("\n");
        }
        try {
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] buffer = text.toString().getBytes();
            bos.write(buffer, 0, buffer.length);
            bos.flush();
            bos.close();
            System.out.println("Save complete...");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show(){
        table.forEach((k,v) -> System.out.println(v.toString()));
    }

    public String getType(){
        return table.getClass().getTypeName();
    }

    public void remove(String key){
        table.remove(key);
    }

    public Set<Map.Entry<String, Product>> getSet() {
        return table.entrySet();
    }

    public Collection<Product> getProducts(){
        return table.values();
    }

    public String getCreationDate() {
        return Date.toString();
    }

    void setCreationDate(LocalDateTime date){
            Date = date;
    }

    public Set<String> getkeySet() {
        return table.keySet();
    }
}