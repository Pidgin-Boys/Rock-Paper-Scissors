import java.util.ArrayList;
import java.util.HashMap;

public class ResultDatabase {
    private ArrayList<Result> results;
    private HashMap<String, Integer> sequences;
    private int ties, playerWins, computerWins, lastMovesLength, sequenceLength;
    private String sequence, lastFourMoves;
    
    /**
     * Creates a new ResultDatabase that can hold 100+ results
     * Uses a HashMap to map sequences to number of occurrences
     * Also holds the last four moves as a string
     */
    public ResultDatabase() {
        results = new ArrayList<Result>(100);
        sequences = new HashMap<String, Integer>();
        ties = 0; playerWins = 0; computerWins = 0; lastMovesLength = 0; sequenceLength = 0;
        sequence = "";  lastFourMoves  = "";
    }
    
    /**
     * Adds the given sequence to the sequence map, or increments it if it exists
     * @param seq String : sequence to add to map
     */
    private void putInMap(String seq) {
        Integer val = sequences.get(seq);
        if (val != null) 
            sequences.put(seq, val+1);
        else
            sequences.put(seq, 1);
    }

    /**
     * Add a round result to the results data base
     * @param r - the given round result
     * @return true if the result was added to the database successfully
     */
    public boolean add(Result r) {
        // add the result to the arraylist for later access
        results.add(r); 
        
        // get the computer and user choices and add to the move sequence (ends with human's choice)
        // and the last four moves (ending  with the computer's choice)
        String u       = r.getUserChoice().toString().substring(0,1);
        String c       = r.getComputerChoice().toString().substring(0,1);
        sequence       = lastFourMoves + u;
        lastFourMoves += u + c;
                
        // update lastMovesLength anad sequenceLength -- only need to update while last four moves are not saturated
        if (lastMovesLength < 4) {
            lastMovesLength = lastFourMoves.length();
            sequenceLength  = sequence.length();
        }
        else {
            lastFourMoves   = lastFourMoves.substring(2);
            lastMovesLength = 4;
            sequenceLength  = 5;
        }
        
        // add the last N=2,3,4,5 character sequences to the map if sequence is long enough
        for (int i = 1; i < sequenceLength; ++i) {
            putInMap(sequence.substring(i-1));
        }
        
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
    
    /**
     * Gets the number of occurrences of seq
     * @param seq String : the sequence to check occurrences on
     * @return int : the number of occurrences of seq
     */
    public int getNumberOfSequences(String seq) {
        return sequences.get(seq);
    }
    
    /**
     * @param n Number of moves to get (PRECONDITION: n <= 4)
     * @return String : the sequence of the last n moves
     */
    public String getLastNMoves(int n) {
        return lastMovesLength == 4 ? lastFourMoves.substring(4-n) : null;
    }
    
    /* Use this if you want to test the sequence map to see its contents... I 
     * tested it and the getNumberOfSequences() and add() methods should work correctly */
    public void printSequenceMap() {
        System.out.println(sequences);
    }
}
