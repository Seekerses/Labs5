package cmd;
import Control.TableController;
import Control.TableManager;

import java.io.FileNotFoundException;

public class CommandRemove implements Command {

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().remove(args[0]);
    }

    public String toString(){
        return "remove_key";
    }
}
