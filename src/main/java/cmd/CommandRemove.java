package cmd;
import Control.TableController;
import Control.TableManager;

import java.io.FileNotFoundException;

/**
 * removes element with given key
 *
 *
 */

public class CommandRemove implements Command {

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().remove(args[0]);
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "remove_key";
    }
}
