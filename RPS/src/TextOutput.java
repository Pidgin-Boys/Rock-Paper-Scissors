public class TextOutput extends Output {
    /*
     * Displays the result of the previous round
     * @param r - the result object containing the outcome of the previous round
     */
    public void displayResult(Result r) {
        System.out.format("You played %s. The computer played %s. ", 
                r.getUserChoice().toString(), r.getComputerChoice().toString());
        
        switch(r.getOutcome()) {
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
    // Displays the help message generated after entering the help command
    
    public void displayHelp() {
        System.out.println("+-------------- Help ---------------+");
        System.out.println("| Enter 'Rock' to play a rock       |");
        System.out.println("| Enter 'Paper' to play paper       |");
        System.out.println("| Enter 'Scissors' to play scissors |");
        System.out.println("| Enter 'Score' for score           |");
        System.out.println("| Enter 'Quit' to quit              |");
        System.out.println("+-----------------------------------+");
    }
    
    // Displays the start up  menu at the beginning of the game
    public void displayStartup() {
        System.out.println("Welcome to The Pigeon Boys' Rock Paper Scissor Game!");
        System.out.println("If you need help, just type 'help' into the console.");
        System.out.println("----------------------------------------------------");
//        System.out.print("Enter How Many Rounds You Would Like to Play:");
    }
    
    /*
     * Displays the formatted score of the current game
     * @param a - the array containing the amount of ties, player wins, and computer wins
     * for the current game
     */
     
    public void displayScore(int[] a) {
        System.out.println("+-------------- Score --------------+");
        System.out.format ("| Wins   = %-25d|\n| Losses = %-25d|\n| Ties   = %-25d|\n", a[0], a[1], a[2]);
        System.out.println("+-----------------------------------+");
    }
    
    // Displays a message prompting the user to enter their choice
    
    public void displayPrompt() {        
        System.out.print("Enter your choice: ");
    }
}
