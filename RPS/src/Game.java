public class Game {
    private int            roundsRemaining;
    private Input          input;
    private Output         output;
    private DecisionEngine engine;
    
    private static ResultDatabase history;

     /*
     * Creates a Game object with access to I/O for the specified number of rounds. 
     * @param inputType - String : "text" or "gui" Method of user input.
     * @param outputType - String : "text" or "gui" Method of output to the user.
     * @param engineType - String : "smart" or "predictive" Which AI Engine to use.
     * @param rounds - int : number of rounds the game will last
     */
    public Game(String inputType, String outputType, String engineType, int rounds) 
    {
        this.input   = Input.makeInput(inputType);
        this.output  = Output.makeOutput(outputType);
        this.engine  = DecisionEngine.makeEngine(engineType);
        
        this.history = new ResultDatabase();
        this.roundsRemaining = rounds;        
    }

    public void setRounds(int rounds) { roundsRemaining = rounds; }
    
    public static void main(String[] args)
    {
        if (args.length == 0) 
            runGUI(args);
        else 
            runCLI(args);
    }
        
    public static boolean runCLI(String[] args)
    {
        int rounds = 5;
        String engType = "smart";
        
        try { rounds = Integer.parseInt(args[0]); }
        catch (NumberFormatException ex) 
        {
            System.out.println("Invalid rounds argument (arg1). Must be a positive integer.");
            System.exit(1);
        }
        if (args.length == 2) 
        {
            engType = args[1].toLowerCase();
            if (!engType.equals("random") && !engType.equals("smart") /* && !engType.equals("predictive") */)
            {
                engType = "smart";
                System.out.println("Incorrect argument for AI Engine type. Must be 'smart' or 'random'\n"
                                    + "Defaulting to the Smart AI Engine.\n");
            }
        }
        else System.out.println("No second argument provided. Must be 'smart' or 'random'\n"
                                + "Defaulting to Smart AI Engine.");   
            
        Game g = new Game("text", "text", engType, rounds);
        g.output.displayStartup();
        
        Choice userChoice;
        Result result;
         // Continue playing game while rounds remain
         // Determine user input for each round, and take appropriate action
        while (g.roundsRemaining > 0)
        {
            g.output.displayPrompt();
            userChoice = g.input.getUserChoice();
            if (userChoice == null || userChoice.getValue() > 6) 
            {
                System.out.println("Invalid command. Please choose from the following: ");
                g.output.displayHelp();
            }
            else if (userChoice.getValue() < 4) 
            {
                --g.roundsRemaining;
                result = new Result(userChoice, g.engine.getComputerChoice(history));
                g.history.add(result);
                g.output.displayResult(result);
            }
            else if (userChoice.equals(Choice.HELP))
                g.output.displayHelp();
            else if (userChoice.equals(Choice.SCORE))
                g.output.displayScore(g.history.getScore());
            else break; // (userChoice.equals(Choice.EXIT))
        }
        int[] score = g.history.getScore();
        g.output.displayScore(score);
        g.output.displayWinner(score);
        return true;
    }
    
    public static boolean runGUI(String[] args)
    {
        // create the game object with a default rounds value so we can call methods
        Game g = new Game("gui", "gui", "smart", 5);
        g.output.displayStartup();
        // get the user's input for # of rounds and then change it
        //g.setRounds(the user's input at the starting prompt);
        
        // insert code to handle the interface interactions. 
        // encapsulate by having the actionListeners call functions from g.output
        return true;
    }
}
