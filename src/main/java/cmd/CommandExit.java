package cmd;

import cmd.Command;

import java.io.FileNotFoundException;

public class CommandExit implements Command {

    @Override
    public void execute(String[] args){
        System.exit(0);
    }
}
