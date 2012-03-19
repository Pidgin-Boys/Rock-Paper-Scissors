public class Game {
    private Input          input;
    private Output         output;
    private DecisionEngine engine;
    
    private static ResultDatabase history;
    private int roundsRemaining;

     /*
     * Creates Game constructor and initializes instance variables
     * @param inputType - String : "text" or "gui" Type of input choosen for this game
     * @param outputType - String : "text" or "gui" Type of output choosen for this game
     * @param engineType - String : "smart" or "predictive" Type of method used to generate computer output for this game
     * @param rounds - int : number of rounds this game will be 
     */
    public Game(String inputType, String outputType, String engineType, int rounds) {
        this.input   = Input.makeInput(inputType);
        this.output  = Output.makeOutput(outputType);
        this.engine  = DecisionEngine.makeEngine(engineType);
        
        this.history = new ResultDatabase();
        this.roundsRemaining = rounds;        
    }

    public static void main(String[] args) {
        int rounds = 1;
        
        // Get the number of rounds from first argument
        if (args.length > 0) {
            try {
                rounds = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid argument. Must be a positive integer.");
                System.exit(1);
            }
        }
        Game g = new Game("text", "text", "random", rounds);
        g.output.displayStartup();
        
        Choice userChoice;
        Result result;
         // Continue playing game while rounds remain
         // Determine user input for each round, and take appropiate actoin
        while (g.roundsRemaining > 0)
        {
            g.output.displayPrompt();
            userChoice = g.input.getUserChoice();
            if (userChoice == null || userChoice.getValue() > 6) {
                System.out.println("Invalid command. Please choose from the following: ");
                g.output.displayHelp();
            }
            else if (userChoice.getValue() < 4) {
                --g.roundsRemaining;
                result = new Result(userChoice, g.engine.getComputerChoice(history));
                g.history.add(result);
                g.output.displayResult(result);
            }
            else if (userChoice.equals(Choice.HELP))
                g.output.displayHelp();
            else if (userChoice.equals(Choice.SCORE))
                g.output.displayScore(g.history.getScore());
            else if (userChoice.equals(Choice.EXIT))
                break;
        }
         // Display score when game ends and state the winner
        int[] score = g.history.getScore();
        System.out.println();
        if (score[0] > score[1]) 
            System.out.println("Congratulations, you beat the computer!");
        else if (score[0] == score[1]) 
            System.out.println("You tied with the computer.");
        else 
            System.out.println("The computer beat you; better luck next time.");
        g.output.displayScore(score);
    }
}
