import java.util.HashMap;

public class ResultDatabase 
{
    private HashMap<String, Integer> sequences;
    private int ties, playerWins, computerWins;
    private String sequence, lastFour;
    
    /**Creates a new ResultDatabase that keeps track of wins, losses, and ties.
     * Uses a HashMap to map throw sequences to number of occurrences
     * Holds sequences of moves in a format like "RPSRP" ending in the player's 
     * choice and allows access to the last 4 moves in the same format, but 
     * ending with the computer's choice to enable sequence prediction.
     */
    public ResultDatabase() 
    {
        sequences = new HashMap<String, Integer>();
        ties = playerWins = computerWins = 0;
        sequence = lastFour  = "";
    }
    
    /**Adds the given sequence to the sequence map, or increments it if it exists
     * @param seq String : sequence to add to map
     */
    private void put(String seq) 
    {
        Integer val = sequences.get(seq);
        sequences.put(seq, (val != null) ? val+1 : 1);
    }

    /**@param r - the result to add to the database
     * @return true if the result was added to the database successfully
     */
    public boolean add(Result r) 
    {   
        // update the move sequence and the last four moves (including computer's move)
        sequence = lastFour + r.getUserChoice().toString().substring(0,1);
        lastFour = sequence + r.getComputerChoice().toString().substring(0,1);
        if (lastFour.length() == 6) lastFour = lastFour.substring(2);
        
        // add the last N=2,3,4,5 character sequences to the map
        for (int i = 1; i < sequence.length(); ++i) 
            put(sequence.substring(i-1));
        
        switch(r.getOutcome()) 
        {
            case -1:
                ++ties;
                return true;
            case 0: 
                ++computerWins;
                return true;
            default:
                ++playerWins;
                return true;
        }
    }

     /** @return The score in the format: int[playerWins, computerWins, ties] */
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
        return lastFour.length() == 4 ? lastFour.substring(4-n) : "";
    }
        
    /**@param seq String : the move sequence to check the occurrences of
     * @return int : the number of occurrences of seq
     */
    public int getOccurrences(String seq) { return sequences.get(seq); }
}
