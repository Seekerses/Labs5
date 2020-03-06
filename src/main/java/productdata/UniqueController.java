package productdata;
import java.util.Hashtable;

public class UniqueController {
    private static Hashtable<String, Organization> orgTable = new Hashtable<>();

    public static void put(String index, Organization org){
        orgTable.put(index, org);
    }

    public static boolean check(String index){
        return orgTable.containsKey(index);
    }

    public static Organization get(String index){
        return orgTable.get(index);
    }

    public static Hashtable<String, Organization> getOrgTable(){
        return orgTable;
    }
}