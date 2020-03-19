package cmd;

import Control.TableController;
import productdata.Product;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Commandfilter_less_than_manufacturer implements Command {

    @Override
    public void execute(String[] args) throws IOException {
        Iterator<Map.Entry<String, Product>> it = TableController.getCurrentTable().getSet().iterator();
        int i = Integer.parseInt(args[0]);
        while(it.hasNext()){
            Map.Entry<String,Product> map = it.next();
            if (map.getValue().getManufacturer().getId() < i) {
                System.out.println(TableController.getCurrentTable().get(map.getKey()).toString());
            }
        }
    }

    @Override
    public String toString() {
        return "filter_less_than_manufacturer";
    }
}
