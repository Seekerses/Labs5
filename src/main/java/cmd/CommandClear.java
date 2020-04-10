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
        if(TableController.getCurrentTable().getSize()==0){
            System.out.println("Collection is empty already.");
        } else{
            TableController.getCurrentTable().clear();
            System.out.println("Collection has been cleared.");
        }
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
