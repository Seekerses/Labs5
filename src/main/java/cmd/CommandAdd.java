package cmd;
import Control.Initializer;
import Control.TableController;
import productdata.ReaderProductBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CommandAdd implements Command{

    @Override
    public void execute(String[] args) {
        if (args == null) {
            System.out.println(" Ведите ключ продукта : ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                TableController.getCurrentTable().put(reader.readLine(), ReaderProductBuilder.buildProduct(reader));
                System.out.println("Insertion complete...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Initializer.build(TableController.getCurrentTable(),args);
        }
    }

    @Override
    public String toString() {
        return "insert";
    }
}