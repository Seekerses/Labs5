package cmd;
import Control.TableManager;

import java.io.FileNotFoundException;

public class CommandSave implements Command {
    private TableManager hashtable;

    public CommandSave(TableManager hashtable){
        this.hashtable=hashtable;
    }

    @Override
    public void execute(String[] args) throws FileNotFoundException {
        hashtable.save();
    }

    public String toString(){
        return "save";
    }
}
