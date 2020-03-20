package Control;

import cmd.CommandHistory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class that works with console input
 */
public class CommandController {
    /**
     * Field which define works this controller or not, sets to true when controller starts and sets to false when its stops
     */
    private boolean isOn;
    /**
     * Field that created to save a history of completed commands
     */
    private  static CommandHistory commandHistory = new CommandHistory();

    /**
     * Starts the controller. When controller is working user can enter a commands into console.
     * Controller takes command and split it on String array (command and arguments), then throw it to Interpreter
     * @param interpreter Interpreter, which controller will use to interpret commands
     */
    public void start(Interpreter interpreter){
        isOn = true;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            while (isOn){
                interpreter.handle(line.split(" "));
                line = reader.readLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Stops the session of Controller
     */
    public void stop(){
        isOn = false;
    }

    /**
     * Returns the Command History
     * @return Command History
     */
    public static CommandHistory getCommandHistory(){
        return commandHistory;
    }

}