package cmd;
import Control.TableController;
import Control.TableManager;

import java.io.FileNotFoundException;

public class CommandSave implements Command {

    @Override
    public void execute(String[] args) throws FileNotFoundException {
        TableController.getCurrentTable().save();
    }

    public String toString(){
        return "save";
    }
}
