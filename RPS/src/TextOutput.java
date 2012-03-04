public class TextOutput implements Output {
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
    public void displayHelp() {
        System.out.println("+-------------- Help ---------------+");
        System.out.println("| Enter 'Rock' to play a rock       |");
        System.out.println("| Enter 'Paper' to play paper       |");
        System.out.println("| Enter 'Scissors' to play scissors |");
        System.out.println("| Enter 'Score' for score           |");
        System.out.println("| Enter 'Quit' to quit              |");
        System.out.println("+-----------------------------------+");
    }
    public void displayStartup() {
        System.out.println("Welcome to The Pigeon Boys' Rock Paper Scissor Game!");
        System.out.println("If you need help, just type 'help' into the console.");
        System.out.println("----------------------------------------------------");
//        System.out.print("Enter How Many Rounds You Would Like to Play:");
    }
    
    public void displayScore() {
        // implement me!
    }
    
    public void displayPrompt() {        
        System.out.print("Enter your choice: ");
    }
}
