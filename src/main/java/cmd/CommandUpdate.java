package cmd;

import Control.Initislizator;
import Control.TableController;
import Control.TableManager;
import cmd.Command;
import productdata.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

public class CommandUpdate implements Command {

    @Override
    public void execute(String[] args) {
        int counter = 0;
        Iterator<Map.Entry<String, Product>> it = TableController.getCurrentTable().getSet().iterator();
        int i = Integer.parseInt(args[0]);
        while(it.hasNext()){
            Map.Entry<String,Product> map = it.next();
            if (map.getValue().getId() == i) {
                counter ++;
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                TableController.getCurrentTable().replace(map.getKey(),new Product(reader));
            }
        }
        if(counter==0){
            System.out.println("Элемента с данным id не существует. Повторите ввод: ");
        }
    }

    @Override
    public String toString() {
        return "update id";
    }
}
