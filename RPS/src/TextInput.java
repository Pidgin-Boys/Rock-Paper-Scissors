import java.util.Scanner;

public class TextInput extends Input {
    
    private String in;
    private Scanner key;
    
    public TextInput(){
        
        key = new Scanner(System.in);
    }

    @Override
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
