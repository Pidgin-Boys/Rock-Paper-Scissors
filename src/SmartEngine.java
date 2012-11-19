public class SmartEngine extends DecisionEngine
{
    /**Intelligently generate the computer's next move. Familiar move sequences
     * are checked against a database to determine the player's most likely next
     * move and make the opposite move. 
     * 
     * An equal weighting algorithm is applied to make the decision. Ties are 
     * decided simply by R>P>S. If none of the found sequences occur more than
     * twice, a random decision is made to prevent early predictability.
     * 
     * @param history the ResultDatabase containing the throw history
     * @return Choice : the computer's predictively determined choice
     */
    @Override
    public Choice getComputerChoice(ResultDatabase history) 
    {     
        int r, p, s; r = p = s = 0;
        
        for (int n = 1; n < 5; ++n) 
        {
            String lastNMoves = history.getLastNMoves(n);            
            r += history.getOccurrences(lastNMoves + "R");
            p += history.getOccurrences(lastNMoves + "P");
            s += history.getOccurrences(lastNMoves + "S");            
        }
        
        if (r < 3 && p < 3 && s < 3)
        {
            switch((int) (Math.random() * 3 + 1)) 
            {
                case 1:  return Choice.ROCK;
                case 2:  return Choice.PAPER;
                case 3:  return Choice.SCISSORS;
                default: return Choice.ROCK;
            }
        }        
        if (s >= r && s >= p) return Choice.ROCK;
        if (r >= p && r >= s) return Choice.PAPER; 
        else                  return Choice.SCISSORS;
    }
}
