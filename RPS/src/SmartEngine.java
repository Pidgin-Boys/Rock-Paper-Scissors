public class SmartEngine extends DecisionEngine{
    /**
     * Randomly generates the computer's Choice
     * @param history this parameter is ignored for random choice.
     * @return Choice : the computer's choice
     */
    public Choice getComputerChoice(ResultDatabase history) {
        int rand = (int) (Math.random() * 3 + 1); // get randint from 1 to 3
        switch(rand) {
            case 1:  return Choice.ROCK;
            case 2:  return Choice.PAPER;
            case 3:  return Choice.SCISSORS;
            default: return Choice.ROCK;
        }
    }
}
