package cmd;
import Control.TableController;
import Control.TableManager;

import java.util.Hashtable;

/**
 * remove all elements from the collection
 *
 *
 */

public class CommandClear implements Command {

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().clear();
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "clear";
    }
}
