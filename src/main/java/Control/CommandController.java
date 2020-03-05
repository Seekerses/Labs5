package Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandController {
    private Interpretator interpretator;

    public void start(TableManager currentTable){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            interpretator = new CommandInterpretator(currentTable);
            String line = reader.readLine();
            while (!"exit".equals(line)){
                interpretator.handle(line.split(" "));
                line = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}