public class TextOutput extends Output 
{
    /**
     * Displays the result of the previous round
     * @param r - the result object containing the outcome of the previous round
     */
    public void displayResult(Result r) 
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
    public void displayHelp() 
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
    public void displayStartup() 
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
    public void displayScore(int[] score) 
    {
        System.out.println("\n+-------------- Score --------------+");
        System.out.format ("| Wins   = %-25d|\n| Losses = %-25d|\n| Draws  = %-25d|\n", score[0], score[1], score[2]);
        System.out.println("+-----------------------------------+");
    }
    
    public void displayWinner(int[] score)
    {        
        if (score[0] >  score[1]) 
            System.out.println("Congratulations, you beat the computer!");
        else if (score[0] == score[1]) 
            System.out.println("You tied with the computer.");
        else
            System.out.println("The computer beat you; better luck next time.");
    }
    
    /** Displays a message prompting the user to enter their choice */
    public void displayPrompt() { System.out.print("Enter your choice: "); }
}
