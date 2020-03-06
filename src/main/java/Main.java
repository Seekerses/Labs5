import Control.CommandController;
import Control.Initislizator;
import Control.TableController;
import Control.TableManager;

public class Main {

    public static void main(String[] args){
        TableManager prodTable = new TableManager();
        TableController.setCurrentTable(prodTable);
        Initislizator.init(prodTable,"C:\\projects\\kurs1\\Prog\\Laba\\src\\main\\resources\\test.csv");
        //Fix bug of first element
        CommandController cmd = new CommandController();
        cmd.start();
    }
}