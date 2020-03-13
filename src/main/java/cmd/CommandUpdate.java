package cmd;

import Control.TableManager;
import cmd.Command;

public class CommandUpdate implements Command {
    private Long id;

    public CommandUpdate(Long id){
        this.id=id;
    }

    @Override
    public void execute(String[] args) {

    }
}
