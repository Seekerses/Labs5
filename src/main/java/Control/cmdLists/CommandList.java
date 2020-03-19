package Control.cmdLists;

import cmd.Command;

import java.util.Map;

public interface CommandList {

    Map<String,Command> getCommands();
    static void addCommand(String name, Command command){}
}
