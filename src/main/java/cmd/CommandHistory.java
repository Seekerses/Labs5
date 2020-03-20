package cmd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * gives commands history
 *
 *
 */

public class CommandHistory implements Command{
    private static List<String> history = new ArrayList<>();

    public void addCommand(String name) {
        history.add(name);
    }

    public void execute(String[] args) {
        System.out.println(history.subList(Math.max(history.size() - 7, 0), history.size()));
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "history";
    }
}