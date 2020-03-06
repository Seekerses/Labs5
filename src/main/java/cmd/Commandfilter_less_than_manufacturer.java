package cmd;
import Control.TableManager;

import java.io.FileNotFoundException;
import java.util.TreeSet;

public class Commandfilter_less_than_manufacturer implements Command{
    private TableManager table;
    private String manufacturer;

    public Commandfilter_less_than_manufacturer(TableManager table){
        this.table=table;
    }

    @Override
    public void execute(String[] args) throws FileNotFoundException {
        //Comparator<Organization> comp = new OrganizationIDComparator().compare();
    }
}
