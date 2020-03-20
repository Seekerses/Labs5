package cmd;
import Control.TableController;
import Control.TableManager;

import java.util.Hashtable;

/**
 * gives info about date of collection's creation, collection's size and collection's type
 *
 *
 */

public class CommandInfo implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Size of collection: " + TableController.getCurrentTable().getSize() + "\n"
        + "Type of collection: " + TableController.getCurrentTable().getType() + "\n" +
                "Date of creation: " + TableController.getCurrentTable().getCreationDate().toString());

    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "info";
    }
}
