public class CLI
{
    private int rounds;
    private TextIO console;
    private DecisionEngine engine;
    private static ResultDatabase history; 
            
    public static void run(String[] args)
    {
        int rounds = 5;
        String engType = "smart";
        
        // get the number of rounds and engine type from the first two arguments
        try { rounds = Integer.parseInt(args[0]); }
        catch (NumberFormatException ex) 
        {
            System.out.println("Invalid rounds argument (arg1). Must be a positive integer.");
            System.exit(0);
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
                                + "Defaulting to the Smart AI Engine.");   
                
        TextIO console = new TextIO();
        ResultDatabase history = new ResultDatabase();
        DecisionEngine engine  = DecisionEngine.make(engType);
        
        console.showStartup();
        Choice choice; Result result;
        
         // Continue playing game while rounds remain
         // Determine user input for each round, and take appropriate action
        while (rounds > 0)
        {
            console.showPrompt();
            choice = console.getUserChoice();
            
            switch (choice.getValue()) 
            {
                case 1:
                case 2:
                case 3:
                    --rounds;
                    result = new Result(choice, engine.getComputerChoice(history));
                    history.add(result);
                    console.showResult(result); 
                    break;
                case 4:
                    console.showHelp();
                    break;
                case 5:
                    console.showScore(history.getScore());
                    break;
                case 6:
                    System.exit(0);
                default:
                    console.showHelp();                    
            }
        }
        int[] score = history.getScore();
        console.showScore(score);
        console.showWinner(score);
    }
}
