package cmd;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void execute(String[] args) throws IOException;
}
