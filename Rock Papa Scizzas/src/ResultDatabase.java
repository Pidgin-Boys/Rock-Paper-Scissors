import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ResultDatabase 
{
    private LinkedList<String> results;
    private HashMap<String, Integer> sequences;
    private int ties, playerWins, computerWins;
    private String sequence, lastFour, lastOutcome;
    
    /**Creates a new ResultDatabase that keeps track of wins, losses, and ties.
     * Uses a HashMap to map throw sequences to number of occurrences
     * Holds sequences of moves in a format like "RPSRP" ending in the player's 
     * choice and allows access to the last 4 moves in the same format, but 
     * ending with the computer's choice to enable sequence prediction.
     */
    public ResultDatabase() 
    {
        results = new LinkedList<String>();
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
    public void add(Result r) 
    {        
        //sequence = lastFour + r.getUserChoice().toString().substring(0,1);
        //lastFour = sequence + r.getComputerChoice().toString().substring(0,1);
        // tally wins/losses/draws and store last outcome
        switch(r.getOutcome()) 
        {
            case -1:
                ++ties;
                lastOutcome = "You tied";
                break;
            case 0: 
                ++computerWins;
                lastOutcome = "Computer won";
                break;
            case 1:
                ++playerWins;
                lastOutcome = "You won";
        }
        
        // add the last N=2,3,4,5 character sequences to the map
        String u = r.getUserChoice().toString();
        String c = r.getComputerChoice().toString();
        sequence = lastFour + u.substring(0,1);
        lastFour = sequence + c.substring(0,1);
        
        if (lastFour.length() == 6) 
            lastFour = lastFour.substring(2);
        
        for (int i = 1; i < sequence.length(); ++i) 
            put(sequence.substring(i-1));
        
        // add round #, human choice, computer choice, last outcome to results for GUI
        results.add(String.format("%5s      %-14s%-12s%-10s", results.size()+1, u, c, lastOutcome));
    }

     /**@return Returns the score as int[playerWins, computerWins, ties] */
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
    public int getOccurrences(String seq) 
    { 
        Integer occ = sequences.get(seq);
        return occ != null ? occ : 0;
    }
    
    public LinkedList<String> getResults() { return results; }    
    
    public String getLastOutcome() { return lastOutcome; }
}
