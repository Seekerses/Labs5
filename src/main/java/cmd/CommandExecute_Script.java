package cmd;

import Control.ScriptParcer;

import java.io.IOException;

/**
 * execute command from script
 *
 * @author Daniel
 */

public class CommandExecute_Script implements Command{

    @Override
    public void execute(String[] args) throws IOException {
        ScriptParcer.parseScript(args[0]);
    }

    /**
     * get name of command
     *
     * @return String
     */

    @Override
    public String toString() {
        return "execute_script";
    }
}
