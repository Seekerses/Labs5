package cmd;

/**
 * break the programm
 *
 * @author  Alexandr
 */

public class CommandExit implements Command {

    @Override
    public void execute(String[] args){
        System.exit(0);
    }

    /**
     * get name of command
     *
     * @return String
     */

    @Override
    public String toString() {
        return "exit";
    }
}
