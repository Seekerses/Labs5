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
        }
        else{
            TableController.getCurrentTable().save(new File("saved.txt"));
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
