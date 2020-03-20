import Control.*;


public class Main {

    public static void main(String[] args){
        TableManager prodTable = new TableManager("products");
        TableController.setCurrentTable(prodTable);
        Initializer.init(prodTable,"C:\\projects\\kurs1\\Prog\\Labs5\\src\\main\\resources\\test.csv");
        CommandController cmd = new CommandController();
        cmd.start(new CommandInterpreter());
        cmd.stop();
    }
}