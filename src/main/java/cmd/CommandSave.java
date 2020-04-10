package cmd;
import Control.TableController;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * save the collection to file .csv
 *
 *
 */

public class CommandSave implements Command {

    @Override
    public void execute(String[] args) throws FileNotFoundException {
        if(args != null) {
            TableController.getCurrentTable().save(new File(args[0]));
            System.out.println("Collection has been saved");
        }
        else{
            System.out.println("Collection has been saved");
            TableController.getCurrentTable().save(new File("saved.csv"));
        }
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "save";
    }
}
