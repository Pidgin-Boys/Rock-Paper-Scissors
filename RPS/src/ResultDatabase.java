import java.util.ArrayList;

public class ResultDatabase {
    private ArrayList<Result> results;
    private int ties, playerWins, computerWins;
    
    /**
     * Creates a new ResultDatabase
     * Initializes instance variables result, ties, playerWins, and computerWins
     */
    public ResultDatabase() {
        results = new ArrayList<Result>();
        ties = 0; playerWins = 0; computerWins = 0;
    }

    /**
     * Add a round result to the results data base
     * @param result - the given round result
     * @return true if the result was added to result data base, false otherwise
     */
    public boolean add(Result result) {
        results.add(result);
        int outcome = result.getOutcome();
        switch(outcome) {
            case -1:
                ++ties;
                return true;
            case 0: 
                ++computerWins;
                return true;
            case 1:
                ++playerWins;
                return true;
        }
        return true;
    }

     /**
     * Gets the score for the current game
     * @return int[] containing [playerWins, computerWins, ties] for the current game
     */
    public int[] getScore()
    {
        int[] score = new int[3];
        score[0] = playerWins;
        score[1] = computerWins;
        score[2] = ties;
        return score;
    }
}
