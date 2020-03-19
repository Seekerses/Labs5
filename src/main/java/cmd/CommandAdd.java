package cmd;
import Control.Initislizator;
import Control.TableController;
import Control.TableManager;
import productdata.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CommandAdd implements Command{

    @Override
    public void execute(String[] args) {
        if (args == null) {
            System.out.println(" Ведите ключ продукта : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                TableController.getCurrentTable().put(reader.readLine(), new Product(reader));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Initislizator.build(TableController.getCurrentTable(),args);
        }
    }

    @Override
    public String toString() {
        return "insert";
    }
}