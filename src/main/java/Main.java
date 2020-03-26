import Control.*;

import java.io.*;


public class Main {

    public static void main(String[] args){
        TableManager prodTable = new TableManager("products");
        TableController.setCurrentTable(prodTable);
        try {
            if(new File("saved.csv").createNewFile()){
                System.out.println("Save file created.");
            }
        }
        catch (IOException e ){
            System.out.println("Could not create default save file, please please specify it manually\n");
        }
        if(args.length != 0) {
            Initializer.init(prodTable,new File(args[0]));
        }
        else {
            Initializer.init(prodTable, new File("saved.csv").exists() ? new File("saved.csv") : null);
        }
        CommandController cmd = new CommandController();
        cmd.start(new CommandInterpreter());
        cmd.stop();
    }
}