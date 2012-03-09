public class Result {
    private Choice computer;
    private Choice player;
    private int    outcome; // 1 = player won, 0 = computer won,  -1 = draw

    /*
     * Creates a Result constructor that compares the player and computer choices to determine a winner
     * @param player - the player's choice
     * @param computer - the computer's choice
     */
    public Result(Choice player, Choice computer) {
        this.computer = computer;
        this.player   = player;

        if      (computer.equals(player))
            this.outcome = -1;
        else if (computer.equals(Choice.PAPER) && player.equals(Choice.ROCK)
              || computer.equals(Choice.ROCK) && player.equals(Choice.SCISSORS)
              || computer.equals(Choice.SCISSORS) && player.equals(Choice.PAPER))
            this.outcome = 0;
        else
            this.outcome = 1;
    }
     /*
     * Gets the computer's choice
     * @return decision computer made
     */
    public Choice getComputerChoice() {
        return computer;
    }
     /* Gets the player's choice
     * @return decision player made
     */
    public Choice getUserChoice() {
        return player;
    }
     /*
     * Gets the outcome of the round
     * @return integer corresponding to the outcome of the round
     */
    public int getOutcome() {
        return outcome;
    }
}
