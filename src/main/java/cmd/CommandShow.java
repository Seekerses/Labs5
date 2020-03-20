package cmd;
import Control.TableController;
import Control.TableManager;

import java.util.Hashtable;

/**
 * show all elements in String format
 *
 *
 */

public class CommandShow implements Command {

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().show();
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "show";
    }
}
