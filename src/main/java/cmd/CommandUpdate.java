package cmd;

import Control.TableManager;
import cmd.Command;

public class CommandUpdate implements Command {
    private TableManager table;
    private Long id;

    public CommandUpdate(TableManager table,Long id){
        this.table=table;
        this.id=id;
    }

    @Override
    public void execute(String[] args) {

    }
}
