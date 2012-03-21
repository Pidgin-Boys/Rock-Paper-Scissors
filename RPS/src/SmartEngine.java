public class SmartEngine extends DecisionEngine
{
    /**Intelligently generate the computer's next move by predicting what the 
     * player is most likely to throw next using past throw history.
     * @param history the ResultDatabase containing the throw history
     * @return Choice : the computer's choice
     */
    public Choice getComputerChoice(ResultDatabase history) 
    {
        return Choice.ROCK;
    }
}
