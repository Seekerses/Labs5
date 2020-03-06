package cmd;
import Control.TableManager;

import java.io.FileNotFoundException;

public class CommandRemove implements Command {
    private TableManager table;
    private String key;

    public CommandRemove(TableManager table){
        this.table=table;
    }

    @Override
    public void execute(String[] args) {
        table.remove(key);
    }

    public String toString(){
        return "remove_key";
    }
}
