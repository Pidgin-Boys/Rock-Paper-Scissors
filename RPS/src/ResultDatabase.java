import java.util.HashMap;

public class ResultDatabase 
{
    private HashMap<String, Integer> sequences;
    private int ties, playerWins, computerWins, lastMovesLength, sequenceLength;
    private String sequence, lastFourMoves;
    
    /**Creates a new ResultDatabase that keeps track of wins, losses, and ties.
     * Uses a HashMap to map throw sequences to number of occurrences
     * Holds sequences of moves in a format like "RPSRP" ending in the player's 
     * choice and allows access to the last 4 moves in the same format, but 
     * ending with the computer's choice to enable sequence prediction.
     */
    public ResultDatabase() 
    {
        sequences = new HashMap<String, Integer>();
        ties = playerWins = computerWins = lastMovesLength = sequenceLength = 0;
        sequence = lastFourMoves  = "";
    }
    
    /**
     * Adds the given sequence to the sequence map, or increments it if it exists
     * @param seq String : sequence to add to map
     */
    private void putInMap(String seq) 
    {
        Integer val = sequences.get(seq);
        sequences.put(seq, (val != null) ? val+1 : 1);
    }

    /**
     * Add a round result to the result database
     * @param r - the result to add
     * @return true if the result was added to the database successfully
     */
    public boolean add(Result r) 
    {   
        // get the computer and user choices and add to the move sequence (ends with human's choice)
        // and the last four moves (ending  with the computer's choice)
        sequence      = lastFourMoves + r.getUserChoice().toString().substring(0,1);
        lastFourMoves = sequence + r.getComputerChoice().toString().substring(0,1);
                
        // update lastMovesLength and sequenceLength until sequences are saturated
        if (lastMovesLength < 4) 
        {
            lastMovesLength = lastFourMoves.length();
            sequenceLength  = sequence.length();
        } else 
        {
            sequenceLength  = 5; // can't find a way to make this more efficient AND add the sequences before saturation
            lastFourMoves   = lastFourMoves.substring(2);
        } 
        // add the last N=2,3,4,5 character sequences to the map if sequence is long enough
        for (int i = 1; i < sequenceLength; ++i) 
            putInMap(sequence.substring(i-1));
        
        switch(r.getOutcome()) 
        {
            case -1:
                ++ties;
                return true;
            case 0: 
                ++computerWins;
                return true;
            case 1:
                ++playerWins;
            default: return true;
        }
    }

     /**
     * Gets the score for the current game
     * @return int[playerWins, computerWins, ties]
     */
    public int[] getScore()
    {
        int[] score = new int[3];
        score[0] = playerWins;
        score[1] = computerWins;
        score[2] = ties;
        return score;
    }
        
    /**@param n Number of moves to get (PRECONDITION: n <= 4)
     * @return String : the sequence of the last n moves such as "RPSS"
     */
    public String getLastNMoves(int n) 
    {
        return lastMovesLength == 4 ? lastFourMoves.substring(4-n) : null;
    }
        
    /**@param seq String : the move sequence to check the occurrences of
     * @return int : the number of occurrences of seq
     */
    public int getOccurrences(String seq) { return sequences.get(seq); }
}
