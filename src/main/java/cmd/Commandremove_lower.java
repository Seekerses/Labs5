package cmd;
import Control.TableController;
import Control.TableManager;
import cmpr.IDComparator;
import cmpr.OrganizationIDComparator;
import productdata.Organization;
import productdata.Product;

import java.io.FileNotFoundException;
import java.util.*;

public class Commandremove_lower implements Command{

    @Override
    public void execute(String[] args) {
        Iterator<Map.Entry<String, Product>> it = TableController.getCurrentTable().getSet().iterator();
        int i = Integer.parseInt(args[0]);
        while(it.hasNext()){
            Map.Entry<String,Product> map = it.next();
            if (map.getValue().getId() < i) {
                TableController.getCurrentTable().remove(map.getKey());
            }
        }
    }
}
