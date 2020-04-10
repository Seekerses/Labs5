package cmd;

/**
 * break the programm
 *
 *
 */

public class CommandExit implements Command {

    @Override
    public void execute(String[] args){
        System.out.println("Program completion");
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
