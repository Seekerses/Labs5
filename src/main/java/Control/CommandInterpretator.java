package Control;


import Control.cmdLists.CommandList;
import Control.cmdLists.StdCommandList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//client
public class CommandInterpretator implements Interpretator{
    private CommandList cmdList =  new StdCommandList();

    @Override
    public void handle(String[] args) throws IOException {
            if (cmdList.getCommands().containsKey(args[0])) {
                CommandController.getCommandHistory().addCommand(cmdList.getCommands().get(args[0]).toString());
                try {
                    ArrayList<String> arguments;
                    if (args.length > 1) {
                        arguments = new ArrayList<>(Arrays.asList(args));
                        arguments.remove(0);
                    } else arguments = null;

                    cmdList.getCommands().get(args[0]).execute(arguments == null ? null : arguments.toArray(new String[0]));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    public void changeCommandList(CommandList list){
        cmdList = list;
    }
}