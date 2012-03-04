import java.util.ArrayList;

public class ResultDatabase {
    private ArrayList<Result> results;
    private int ties, playerWins, computerWins;
    
    public ResultDatabase() {
        results = new ArrayList<Result>();
        ties = 0; playerWins = 0; computerWins = 0;
    }

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

    public int[] getScore()
    {
        int[] a = new int[3];
        a[0] = playerWins;
        a[1] = computerWins;
        a[2] = ties;
        return a;
    }
}
