package cmd;
import Control.TableManager;

import java.util.Hashtable;

public class CommandShow implements Command {
    private TableManager hashtable;

    public CommandShow(TableManager hashtable){
        this.hashtable=hashtable;
    }

    @Override
    public void execute(String[] args) {
        hashtable.show();
    }

    public String toString(){
        return "show";
    }
}
