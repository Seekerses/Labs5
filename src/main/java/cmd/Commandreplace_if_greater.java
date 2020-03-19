package cmd;
import Control.TableController;
import Control.TableManager;
import cmpr.IDComparator;
import cmpr.OrganizationIDComparator;
import productdata.Organization;
import productdata.Product;

import java.io.FileNotFoundException;
import java.util.*;

public class Commandreplace_if_greater implements Command{

    @Override
    public void execute(String[] args) {

    }

    @Override
    public String toString() {
        return "replace_if_greater";
    }
}
