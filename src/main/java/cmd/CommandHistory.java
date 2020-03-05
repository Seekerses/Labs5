package cmd;
import java.io.FileNotFoundException;
import java.util.Stack;

public class CommandHistory implements Command{
    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }

    @Override
    public void execute() throws FileNotFoundException {
        for(int i=0;i<=history.size();i++){
            System.out.println(history.peek().toString());
            history.pop();
            if(i==6){break;}
        }
    }

    public String toString(){
        return "history";
    }
}