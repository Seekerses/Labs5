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

//receiver

/**
 * Class that works with one concrete Hashtable of Products
 */
public class TableManager {
    /**
     * Table which instance will work with
     */
    private Hashtable<String, Product> table;
    /**
     * Creation date of this Table Manager
     */
    private java.time.LocalDateTime Date;

    /**
     * Standard constructor
     * @param name Name of this Table Manager in the TableController`s table
     */
    public TableManager(String name){
        table = new Hashtable<>();
        TableController.put(name,this);
    }

    /**
     * Returns size of HashTable
     * @return Size
     */
    public int getSize(){
        return table.size();
    }

    /**
     * Put Product into Hashtable
     * @param index Key
     * @param product Product
     */
    public void put(String index, Product product){
        table.put(index,product);
    }

    /**
     * Replaces the Product with the new one
     * @param key Key of Product
     * @param product New Product
     */
    public void replace(String key,Product product){
        table.replace(key,table.get(key),product);
    }

    /**
     * Returns the Product from HashTable
     * @param index Key
     * @return Product
     */
    public Product get(String index){
        return table.get(index);
    }

    /**
     * Cleans the Hashtable
     */
    public void clear(){
        table.clear();
    }

    /**
     * Saves the table to the file
     * @param address Address of file
     * @throws FileNotFoundException IF something went wrong
     */
    public void save(String address) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(address);
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

    /**
     * Prints the table to the console
     */
    public void show(){
        table.forEach((k,v) -> System.out.println(v.toString()));
    }

    /**
     * Returns type of collection
     * @return name of type of collection
     */
    public String getType(){
        return table.getClass().getTypeName();
    }

    /**
     * Removes the Product from Hashtable
     * @param key Key of Product
     */
    public void remove(String key){
        table.remove(key);
    }

    /**
     * Returns the Set of Products
     * @return Set of Products
     */
    public Set<Map.Entry<String, Product>> getSet() {
        return table.entrySet();
    }

    /**
     * Returns the Collection of Products
     * @return Collection of Products
     */
    public Collection<Product> getProducts(){
        return table.values();
    }

    /**
     * Returns creation date of Table Manager
     * @return LocalDateTime
     */
    public LocalDateTime getCreationDate() {
        return Date;
    }

    /**
     * Sets creation date of Table Manager
     * @param date new creation date
     */
    void setCreationDate(LocalDateTime date){
            Date = date;
    }

    /**
     * Returns Set of keys
     * @return Set of keys of Hashtable
     */
    public Set<String> getkeySet() {
        return table.keySet();
    }

}