package cmd;

import Control.ScriptParcer;

import java.io.IOException;

public class CommandExecute_Script implements Command{

    @Override
    public void execute(String args[]) throws IOException {
        ScriptParcer.parseScript(args[0]);
    }
}
