import Control.*;

import java.io.*;


public class Main {

    public static void main(String[] args){
        TableManager prodTable = new TableManager("products");
        TableController.setCurrentTable(prodTable);
        if(args.length != 0) {
            Initializer.init(prodTable,new File(args[0]));
        }
        else {
            Initializer.init(prodTable, new File("../saved.csv"));
        }
        CommandController cmd = new CommandController();
        cmd.start(new CommandInterpreter());
        cmd.stop();
    }
}