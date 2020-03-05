package cmd;
import Control.CommandInterpretator;
import Control.Interpretator;
import Control.TableManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

//Invoker
public class CommandController {
    private Interpretator interpretator;

    public void start(TableManager currentTable){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            interpretator = new CommandInterpretator(currentTable);
            String line = reader.readLine();

            while (!"exit".equals(line)){
                interpretator.handle(line.split(";"));
                line = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}