package cmd;
import Control.TableManager;
import productdata.Product;

import java.io.FileNotFoundException;
import java.util.Map;

public class Commandmin_by_name implements Command {
    private TableManager table;

    public Commandmin_by_name(TableManager table){
        this.table=table;
    }

    @Override
    public void execute() throws FileNotFoundException {
        for(Map.Entry<String, Product> entry : table.getSet()){
            String min = "";
            //if(entry.getValue());
        }
    }
}
