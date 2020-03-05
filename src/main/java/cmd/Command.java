package cmd;
import java.io.FileNotFoundException;

public interface Command {
    void execute() throws FileNotFoundException;
}
