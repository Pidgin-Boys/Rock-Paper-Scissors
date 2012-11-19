import java.util.Scanner;

public class TextIO
{    
    private String in;
    private Scanner key;
    
    /**
     * Creates a new TextIO object to handle console input/output
     */
    public TextIO() { key = new Scanner(System.in); }    
    
    /**
     * Displays the result of the previous round
     * @param r - the result object containing the outcome of the previous round
     */
    public void showResult(Result r) 
    {
        System.out.format("You played %s. The computer played %s. ", 
                r.getUserChoice().toString(), r.getComputerChoice().toString());
        
        switch(r.getOutcome()) 
        {
            case 1:
                System.out.println("You won!");
                break;
            case -1:
                System.out.println("You tied.");
                break;
            case 0:
                System.out.println("You lost.");
                break;
        }
    }
    
    /** Displays the help message generated after entering the help command */    
    public void showHelp() 
    {
        System.out.println("+-------------- Help ---------------+\n"
                         + "| Enter 'Rock' to play a rock       |\n"
                         + "| Enter 'Paper' to play paper       |\n"
                         + "| Enter 'Scissors' to play scissors |\n"
                         + "| Enter 'Score' for score           |\n"
                         + "| Enter 'Quit' to quit              |\n"
                         + "+-----------------------------------+\n");
    }
    
    /** Displays the start up  menu at the beginning of the game */
    public void showStartup() 
    {
        System.out.println("Welcome to The Pigeon Boys' Rock Paper Scissor Game!\n"
                         + "If you need help, just type 'help' into the console.\n"
                         + "----------------------------------------------------\n");
    }
    
    /**
     * Displays the formatted score of the current game
     * @param a - the array containing the amount of player wins, computer wins, and draws
     * for the current game
     */
    public void showScore(int[] score) 
    {
        System.out.println("\n+-------------- Score --------------+");
        System.out.format ("| Wins   = %-25d|\n| Losses = %-25d|\n| Draws  = %-25d|\n", score[0], score[1], score[2]);
        System.out.println("+-----------------------------------+");
    }
    
    public void showWinner(int[] score)
    {        
        if (score[0] >  score[1]) 
            System.out.println("Congratulations, you beat the computer!");
        else if (score[0] == score[1]) 
            System.out.println("You tied with the computer.");
        else
            System.out.println("The computer beat you; better luck next time.");
    }
    
    /** Displays a message prompting the user to enter their choice */
    public void showPrompt() { System.out.print("Enter your choice: "); }

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