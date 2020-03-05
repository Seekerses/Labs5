package cmd;
import Control.TableManager;

import java.util.Hashtable;

public class CommandClear implements Command {
    private TableManager hashtable;

    public CommandClear(TableManager hashtable){
        this.hashtable=hashtable;
    }

    @Override
    public void execute() {
        hashtable.clear();
    }

    public String toString(){
        return "clear";
    }
}
