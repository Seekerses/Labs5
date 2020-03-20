package cmd;
import Control.TableController;
import Control.TableManager;

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
            TableController.getCurrentTable().save(args[0]);
        }
        else{
            TableController.getCurrentTable().save("src\\saves\\saved.csv");
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
