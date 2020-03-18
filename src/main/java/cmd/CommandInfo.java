package cmd;
import Control.TableController;
import Control.TableManager;

import java.util.Hashtable;

public class CommandInfo implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Size of collection: " + TableController.getCurrentTable().getSize() + "\n"
        + "Type of collection: " + TableController.getCurrentTable().getType() + "\n" +
                "Date of creation: " + TableController.getCurrentTable().getCreationDate());

    }

    public String toString(){
        return "info";
    }
}
