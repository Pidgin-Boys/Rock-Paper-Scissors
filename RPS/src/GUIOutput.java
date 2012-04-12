public class GUIOutput extends Output 
{
    /**
     * Displays the result of the previous round in a graphical user interface
     * @param r - the result object containing the outcome of the previous round
     */
    public void displayResult(Result r) 
    {
        // display user and computer moves, then who won
        switch(r.getOutcome()) 
        {
            case 1:
                // do something
                break;
            case -1:
                // do something
                break;
            case 0:
                // do something
                break;
        }
    }
    
    /** Displays the help menu */    
    public void displayHelp() 
    {
        // do something
    }
    
    /** Displays the start up  menu at the beginning of the game */
    public void displayStartup() 
    {
        // do stuff
    }
    
    /**
     * Displays the formatted score of the current game
     * @param a - the array containing the amount of player wins, computer wins, and draws
     * for the current game
     */
    public void displayScore(int[] score) 
    {
        // display the # of wins, losses, and draws
    }
    
    public void displayWinner(int[] score)
    {
        // display the winner and maybe some additional stats?
    }
    
    /** Displays a message prompting the user to enter their choice */
    public void displayPrompt() { System.out.print("Enter your choice: "); }
}
