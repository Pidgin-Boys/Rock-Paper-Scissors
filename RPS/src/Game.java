public class Game 
{
    private int roundsRemaining;
    private Input input;
    private Output output;
    private DecisionEngine engine;    
    private static ResultDatabase history;

     /**
     * @return a Game object with access to I/O for a certain number of rounds
     * @param inputType - String : "text" or "gui" Type of input chosen for this game
     * @param outputType - String : "text" or "gui" Type of output chosen for this game
     * @param engineType - String : "smart" or "predictive" Type of method used to generate computer output for this game
     * @param rounds - int : number of rounds this game will be 
     */
    public Game(String inputType, String outputType, String engineType, int rounds) 
    {
        this.input  = Input.makeInput(inputType);
        this.output = Output.makeOutput(outputType);
        this.engine = DecisionEngine.makeEngine(engineType);
        
        this.history = new ResultDatabase();
        this.roundsRemaining = rounds;        
    }

    public static void main(String[] args) 
    {
        int rounds = 1;
        
        // Get the number of rounds from first argument
        if (args.length > 0) 
        {
            try { rounds = Integer.parseInt(args[0]); }
            catch (NumberFormatException ex) 
            {
                System.out.println("Invalid argument. Must be a positive integer.");
                System.exit(1);
            }
        } 
        Game g = new Game("text", "text", "smart", rounds);
        Choice choice; 
        Result result;
        
         // Continue playing game while rounds remain
         // Determine user input for each round, and take appropiate action
        g.output.displayStartup();
        while (g.roundsRemaining > 0)
        {
            g.output.displayPrompt();
            choice = g.input.getUserChoice();
            if (choice == null || choice.getValue() > Choice.EXIT.getValue()) 
            {
                System.out.println("Invalid command. Please choose from the following: ");
                g.output.displayHelp();
            }
            else if (choice.getValue() <= Choice.SCISSORS.getValue()) 
            {
                result = new Result(choice, g.engine.getComputerChoice(history));
                g.history.add(result);
                g.output.displayResult(result);
                --g.roundsRemaining;
            }
            else if (choice.equals(Choice.HELP))  g.output.displayHelp();
            else if (choice.equals(Choice.SCORE)) g.output.displayScore(g.history.getScore(), false);
            else break; // if (choice.equals(Choice.EXIT))  
        }
         // Display score when game ends and state the winner
        g.output.displayScore(g.history.getScore(), true);
    }
}
