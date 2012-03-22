public class SmartEngine extends DecisionEngine
{
    /**Intelligently generate the computer's next move by predicting what the 
     * player is most likely to throw next using past throw history.
     * @param history the ResultDatabase containing the throw history
     * @return Choice : the computer's choice
     * 
     * 
     * TODO
     * The smart move does not take into account if two choices are equally likely
     * Also the code is pretty messy and could be cleaned up.
     * 
     */
    public Choice getComputerChoice(ResultDatabase history) 
    {
        String lastTwoMoves = history.getLastNMoves(2), 
                lastFourMoves = history.getLastNMoves(4);
        Choice result  = Choice.ROCK, result2 = Choice.ROCK;
        int numOfTimes2 = 0, numOfTimes4 = 0;
        
//        Checks if there are 2 moves that have been made and then tries to make
//        a good move
        
        if (lastTwoMoves.length() > 0){
            System.out.println(lastTwoMoves + "P");
            int paperGuessTwoMoves = history.getOccurrences(lastTwoMoves + "P"),
                    rockGuessTwoMoves = history.getOccurrences(lastTwoMoves + "R"),
                    scissorsGuessTwoMoves = history.getOccurrences(lastTwoMoves + "S");
            if(scissorsGuessTwoMoves > paperGuessTwoMoves && 
                    scissorsGuessTwoMoves > rockGuessTwoMoves){
                result = Choice.ROCK;
                numOfTimes2 = scissorsGuessTwoMoves;
            }
            else if(paperGuessTwoMoves > rockGuessTwoMoves && 
                    paperGuessTwoMoves > scissorsGuessTwoMoves){
                result = Choice.SCISSORS;
                numOfTimes2 = paperGuessTwoMoves;
            }
            else if(rockGuessTwoMoves > paperGuessTwoMoves && 
                    rockGuessTwoMoves > scissorsGuessTwoMoves){
                result = Choice.PAPER;
                numOfTimes2 = rockGuessTwoMoves;

            }
        }
        
//        Checks if there are 4 moves and then tries to guess a good move
        
        if (lastFourMoves.length() > 0){
            int paperGuessFourMoves = history.getOccurrences(lastTwoMoves + "P"),
                    rockGuessFourMoves = history.getOccurrences(lastTwoMoves + "R"),
                    scissorsGuessFourMoves = history.getOccurrences(lastTwoMoves + "S");
            
            if(scissorsGuessFourMoves > paperGuessFourMoves && 
                    scissorsGuessFourMoves > rockGuessFourMoves){
                result2 = Choice.ROCK;
                numOfTimes4 = scissorsGuessFourMoves;
                
            }
            else if(paperGuessFourMoves > rockGuessFourMoves && 
                    paperGuessFourMoves > scissorsGuessFourMoves){
                result2 = Choice.SCISSORS;
                numOfTimes4 = paperGuessFourMoves;
            }
            else if(rockGuessFourMoves > paperGuessFourMoves && 
                    rockGuessFourMoves > scissorsGuessFourMoves){
                result2 = Choice.PAPER;
                numOfTimes4 = rockGuessFourMoves;
            }
        }
        
//        Algorithm to add more weight to the 4 sequence
        
        if((numOfTimes4*6) > (numOfTimes2*4)){
            result = result2;
        }
        return result;
    }
}
