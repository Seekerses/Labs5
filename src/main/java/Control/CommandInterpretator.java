package Control;
import cmd.*;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
//client
public class CommandInterpretator implements Interpretator{
    private Map<String, Command> commands;
    private CommandHistory commandHistory = new CommandHistory();

    public CommandInterpretator(TableManager table){
        commands = new HashMap<>();
        CommandHelp commandHelp = new CommandHelp();
        CommandInfo commandInfo = new CommandInfo(table);
        CommandClear commandClear = new CommandClear(table);
        CommandSave commandSave = new CommandSave(table);
        CommandShow commandShow = new CommandShow(table);
        CommandAdd commandAdd = new CommandAdd(table);
        Commandmin_by_name commandmin = new Commandmin_by_name(table);
        CommandRemove commandRemove = new CommandRemove(table);
        CommandExit commandExit = new CommandExit();

        commands.put("help",commandHelp);
        commands.put("info",commandInfo);
        commands.put("clear",commandClear);
        commands.put("save",commandSave);
        commands.put("show",commandShow);
        commands.put("add",commandAdd);
        commands.put("history",commandHistory);
        commands.put("insert key",commandAdd);
        commands.put("min_by_name",commandmin);
        commands.put("remove_key",commandRemove);
        commands.put("exit",commandExit);
    }

    public void setCommands(Map<String, Command> commandslist) {
        commands = commandslist;
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    @Override
    public void handle(String[] args) {
        if (commands.containsKey(args[0])) {
            try {
                commands.get(args[0]).execute();
                commandHistory.addCommand(commands.get(args[0]).toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}