import Control.*;


public class Main {

    public static void main(String[] args){
        TableManager prodTable = new TableManager();
        TableController.setCurrentTable(prodTable);
        Initislizator.init(prodTable,"C:\\Users\\seeke\\Desktop\\saved.csv");
        CommandController cmd = new CommandController();
        cmd.start(new CommandInterpretator());
        cmd.stop();
    }
}