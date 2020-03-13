package Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandController {

    public void start(Interpretator interpretator){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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