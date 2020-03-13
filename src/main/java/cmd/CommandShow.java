package cmd;
import Control.TableController;
import Control.TableManager;

import java.util.Hashtable;

public class CommandShow implements Command {

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().show();
    }

    public String toString(){
        return "show";
    }
}
