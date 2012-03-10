import java.util.Scanner;

public class TextInput extends Input {
    
    private String in;
    private Scanner key;
    
    /*
     * Creates a new TextInput object
     * Initializes key to a console input scanner
     */
    public TextInput() 
    {        
        key = new Scanner(System.in);
    }

    @Override
    /*
     * Determines what command the user entered
     * @return the choice object that contains the user's input
     */
    public Choice getUserChoice() {
        Choice userChoice = null;
        in = key.nextLine();
        
            if(in.equalsIgnoreCase("rock")){
                userChoice = Choice.ROCK;
            }
            else if(in.equalsIgnoreCase("paper")){
                userChoice = Choice.PAPER;
            }
            else if(in.equalsIgnoreCase("scissors") || in.equalsIgnoreCase("scissor")){
                userChoice = Choice.SCISSORS;
            }
            else if(in.equalsIgnoreCase("help")){
                userChoice = Choice.HELP;
            }
            else if(in.equalsIgnoreCase("quit") || in.equalsIgnoreCase("exit")){
                userChoice = Choice.EXIT;
            }
            else if(in.equalsIgnoreCase("score")){
                userChoice = Choice.SCORE;
            }
            return userChoice;
        }
}
