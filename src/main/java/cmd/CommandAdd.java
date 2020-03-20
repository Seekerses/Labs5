package cmd;
import Control.Initislizator;
import Control.TableController;
import Control.TableManager;
import productdata.Product;
import productdata.ReaderProductBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * get name of command
 *
 * @author Alexandr
 */

public class CommandAdd implements Command{

    /**
     * insert product to hashtable
     *
     * @param args is key to new product
     */

    @Override
    public void execute(String[] args) {
        if (args == null) {
            System.out.println(" Ведите ключ продукта : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                TableController.getCurrentTable().put(reader.readLine(), ReaderProductBuilder.buildProduct(reader));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Initislizator.build(TableController.getCurrentTable(),args);
        }
    }

    /**
     * get name of command
     *
     * @return String
     */

    @Override
    public String toString() {
        return "insert";
    }
}