package cmd;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class CommandHistory implements Command{
    private Stack<Command> history = new Stack<>();

    public void pushStack(Command c) {
        history.push(c);
    }

    public boolean isEmpty() { return history.isEmpty(); }

    @Override
    public void execute() throws FileNotFoundException {
        Stack<Command> stack = new Stack<>();
        int i=0;
        for(i=0;i<=history.size();i++){
            System.out.println(history.peek().toString());
            stack.push(history.pop());
            if(i==6){break;}
        }
        for(i=0;i<=stack.size();i++){
            history.push(stack.pop());
        }
    }

    public String toString(){
        return "history";
    }
}