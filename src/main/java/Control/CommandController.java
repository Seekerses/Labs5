package Control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandController {
    private boolean isOn;

    public void start(Interpretator interpretator){
        isOn = true;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            while (isOn){
                interpretator.handle(line.split(" "));
                line = reader.readLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void stop(){
        isOn = false;
    }

}