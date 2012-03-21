import java.util.Scanner;

public class TextInput extends Input 
{
    
    private String in;
    private Scanner key;
    
    /**
     * Creates a new TextInput object
     * Initializes key to a console input scanner
     */
    public TextInput() { key = new Scanner(System.in); }

    /**
     * Determines what command the user entered
     * @return the choice object that contains the user's input
     */
    public Choice getUserChoice() 
    {
        in = key.nextLine();
        
        if      (in.equalsIgnoreCase("rock"))  return Choice.ROCK;
        else if (in.equalsIgnoreCase("paper")) return Choice.PAPER;
        else if (in.equalsIgnoreCase("scissors")) return Choice.SCISSORS;
        else if (in.equalsIgnoreCase("help"))  return Choice.HELP;
        else if (in.equalsIgnoreCase("score")) return Choice.SCORE;
        else if (in.equalsIgnoreCase("quit") || in.equalsIgnoreCase("exit"))
            return Choice.EXIT;
        else return null;
    }
}
