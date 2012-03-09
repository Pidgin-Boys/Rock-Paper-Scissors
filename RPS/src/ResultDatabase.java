import java.util.ArrayList;

public class ResultDatabase {
    private ArrayList<Result> results;
    private int ties, playerWins, computerWins;
    
    /*
     * Creates a new ResultDataBase constructor
     * Initializes instance varaibles result, ties, playerWins, and computerWins
     */
    public ResultDatabase() {
        results = new ArrayList<Result>();
        ties = 0; playerWins = 0; computerWins = 0;
    }

    /*
     * Add a round result to the results data base
     * @param r - the given round result
     * @return true if the result was added to result data base, false otherwise
     */
    public boolean add(Result r) {
        results.add(r);
        int outcome = r.getOutcome();
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

     /*
     * Gets the score for the current game
     * @return array containing the number of player wins, computer wins, and ties
     * for the current game
     */
    public int[] getScore()
    {
        int[] a = new int[3];
        a[0] = playerWins;
        a[1] = computerWins;
        a[2] = ties;
        return a;
    }
}
