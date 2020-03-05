package cmd;
import Control.TableManager;

import java.io.FileNotFoundException;

public class CommandRemove implements Command {
    private TableManager table;
    private String key;

    public CommandRemove(TableManager table, String key){
        this.table=table;
        this.key=key;
    }

    @Override
    public void execute() throws FileNotFoundException {
        table.remove(key);
    }

    public String toString(){
        return "remove";
    }
}
