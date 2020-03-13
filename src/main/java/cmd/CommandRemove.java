package cmd;
import Control.TableController;
import Control.TableManager;

import java.io.FileNotFoundException;

public class CommandRemove implements Command {
    private String key;

    @Override
    public void execute(String[] args) {
        TableController.getCurrentTable().remove(key);
    }

    public String toString(){
        return "remove_key";
    }
}
