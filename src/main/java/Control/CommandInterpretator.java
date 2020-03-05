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

        commands.put("help",commandHelp);
        commands.put("info",commandInfo);
        commands.put("clear",commandClear);
        commands.put("save",commandSave);
        commands.put("add",commandAdd);
        commands.put("show",commandShow);
        commands.put("history",commandHistory);
        commands.put("update id",commandAdd);
    }

    public void setCommands(Map<String, Command> commandslist) {
        commands = commandslist;
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    @Override
    public void handle(String[] args){
        if (commands.containsKey(args[0])){
            try {
                commandHistory.push(commands.get(args[0]));
                commands.get(args[0]).execute();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}