package Control.cmdLists;

import Control.CommandController;
import Control.cmdLists.CommandList;
import cmd.*;

import java.util.HashMap;
import java.util.Map;

public class StdCommandList implements CommandList {
    private static Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        CommandHelp commandHelp = new CommandHelp();
        CommandInfo commandInfo = new CommandInfo();
        CommandClear commandClear = new CommandClear();
        CommandSave commandSave = new CommandSave();
        CommandShow commandShow = new CommandShow();
        CommandAdd commandAdd = new CommandAdd();
        Commandmin_by_name commandMin = new Commandmin_by_name();
        CommandRemove commandRemove = new CommandRemove();
        CommandExecute_Script commandExecute_script = new CommandExecute_Script();
        CommandExit commandExit = new CommandExit();
        CommandUpdate commandUpdate = new CommandUpdate();
        Commandremove_lower commandremove_lower = new Commandremove_lower();
        Commandfilter_less_than_manufacturer commandfilter_less_than_manufacturer = new Commandfilter_less_than_manufacturer();

        commands.put("help", commandHelp);
        commands.put("info", commandInfo);
        commands.put("clear", commandClear);
        commands.put("save", commandSave);
        commands.put("show", commandShow);
        commands.put("history", CommandController.getCommandHistory());
        commands.put("insert", commandAdd);
        commands.put("min_by_name", commandMin);
        commands.put("remove_key", commandRemove);
        commands.put("execute_script", commandExecute_script);
        commands.put("update", commandUpdate);
        commands.put("exit", commandExit);
        commands.put("remove_lower", commandremove_lower);
        commands.put("filter_less_than_manufacturer", commandfilter_less_than_manufacturer);
    }

    public Map<String,Command> getCommands(){
        return commands;
    }

    public static void addCommand(String name, Command command){
        commands.put(name,command);
    }
}
