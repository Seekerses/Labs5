package cmd;
import Control.TableController;
import Control.TableManager;

import java.util.Hashtable;

public class CommandClear implements Command {

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().clear();
    }

    public String toString(){
        return "clear";
    }
}
