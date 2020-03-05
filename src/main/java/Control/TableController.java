package Control;

public class TableController {
    private static TableManager currentTable;

    public static void setCurrentTable(TableManager table){
        currentTable = table;
    }

    public static TableManager getCurrentTable() {
        return currentTable;
    }
}
