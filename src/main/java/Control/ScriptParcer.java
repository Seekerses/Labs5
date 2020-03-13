package Control;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ScriptParcer {

    public static void parseScript(String file) throws IOException {
        FileReader reader = new FileReader(new File(file));
        BufferedReader buffReader = new BufferedReader(reader);
        String line;
        ArrayList<String[]> commands = new ArrayList<>();
        CommandInterpretator itr = new CommandInterpretator();

        while ((line = buffReader.readLine()) != null){
            String[] cmd = line.split(" ");
            commands.add(cmd);
        }
        for (String[] command : commands) {
                itr.handle(command);
        }
        buffReader.close();
    }
}
