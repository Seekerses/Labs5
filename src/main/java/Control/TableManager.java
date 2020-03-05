package Control;
import productdata.Product;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
//reciever
public class TableManager {
    private Hashtable<String, Product> table;

    public TableManager(){
        table = new Hashtable<>();
    }

    public int getSize(){
        return table.size();
    }

    public void put(String index, Product product){
        table.put(index,product);
        table.forEach((k,v) -> System.out.println(v.toString()));
    }

    public Product get(String index){
        return table.get(index);
    }

    public void clear(){
        table.clear();
    }

    public void save() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("C:\\projects\\kurs1\\Prog\\Laba\\src\\main\\resources\\saved.csv");
        String text= "";
        for (Map.Entry<String, Product> entry : table.entrySet()) {

            text += entry.getKey() + ";" + entry.getValue().out() + "\n";
        }
        try {
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
            bos.flush();
            bos.close();
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

    public Iterable<? extends Map.Entry> getSet() {
        return table.entrySet();
    }
}