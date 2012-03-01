public class RandomEngine implements DecisionEngine{
    public Choice getComputerChoice() {
        int rand = (int) (Math.random() * 3 + 1); // get randint from 1 to 3
        switch(rand) {
            case 1: return Choice.PAPER;
            case 2: return Choice.ROCK;
            case 3: return Choice.SCISSORS;
            default: return Choice.ROCK;
        }
    }
}
