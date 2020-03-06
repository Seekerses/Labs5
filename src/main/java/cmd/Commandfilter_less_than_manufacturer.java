package cmd;
import Control.TableManager;
import cmpr.IDComparator;
import cmpr.OrganizationIDComparator;
import productdata.Organization;
import productdata.Product;

import java.io.FileNotFoundException;
import java.util.*;

public class Commandfilter_less_than_manufacturer implements Command{
    private TableManager table;
    private String manufacturer;

    public Commandfilter_less_than_manufacturer(TableManager table){
        this.table=table;
    }

    @Override
    public void execute() {
        IDComparator<Organization> comp = new OrganizationIDComparator();


        System.out.println("Введите ID, по которому происходит сравнение: ");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLong()){
            Long id = scanner.nextLong();

        }else{
            System.out.println("Неправильный ввод. Попробуйте снова: ");
            execute();
        }
    }
}
