package Control;

import java.io.*;
import java.util.ArrayList;

/**
 * Class that parse the script files
 */
public class ScriptParser {
    /**
     * Creates a ArrayList of commands from script file and throws commands to interpreter
     * @param file Script file
     * @throws IOException If an I/O error occurs
     */
    public static void parseScript(String file) throws IOException {
        FileReader reader = new FileReader(new File(file));
        BufferedReader buffReader = new BufferedReader(reader);
        String line;
        ArrayList<String[]> commands = new ArrayList<>();
        CommandInterpreter itr = new CommandInterpreter();

        while ((line = buffReader.readLine()) != null){
            String[] cmd = line.split(" ");
            if(line.equals("execute_script " + file)){
                System.out.println("Recursion detected.");
                return;
            }
            for(int i =0;i<= cmd.length-1;i++){
                if (";".equals(cmd[i])){
                    cmd[i]="";
                }

            }
            commands.add(cmd);
        }
        for (String[] command : commands) {
            itr.handle(command);
        }
        buffReader.close();
    }
}
