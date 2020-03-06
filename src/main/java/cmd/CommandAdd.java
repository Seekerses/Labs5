package cmd;
import Control.Initislizator;
import Control.TableManager;
import productdata.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CommandAdd implements Command{
    private TableManager hashtable;

    public CommandAdd(TableManager hashtable){
        this.hashtable=hashtable;
    }

    @Override
    public void execute(String[] args) {
        if (args == null) {
            System.out.println(" Ведите ключ продукта : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                hashtable.put(reader.readLine(), new Product(reader));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Initislizator.build(hashtable,args);
        }
    }

    @Override
    public String toString() {
        return "insert key";
    }
}