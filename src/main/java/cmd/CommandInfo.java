package cmd;
import Control.TableManager;

import java.util.Hashtable;

public class CommandInfo implements Command {
    private TableManager hashtable;

    public CommandInfo(TableManager productHashtable){
        this.hashtable=productHashtable;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Size of collection: " + hashtable.getSize() + "\n"
        + "Type of collection: " + hashtable.getType() + "\n" +
                "Date of creation: " + hashtable.getCreationDate());

    }

    public String toString(){
        return "info";
    }
}
