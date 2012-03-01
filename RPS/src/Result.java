public class Result {
    private Choice computer;
    private Choice player;
    public int    outcome; // 1 = player won, 0 = computer won,  -1 = draw

    public Result(Choice player, Choice computer) {
        this.computer = computer;
        this.player   = player;
        
        if      (computer.equals(player))
            this.outcome = -1;
        else if (computer.equals(Choice.PAPER) && player.equals(Choice.ROCK)
              || computer.equals(Choice.ROCK) && player.equals(Choice.SCISSORS)
              || computer.equals(Choice.SCISSORS) && player.equals(Choice.PAPER))
            this.outcome = 0;
        else if (player.equals(Choice.HELP))
            this.outcome = 2;
        else if (player.equals(Choice.SCORE))
            this.outcome = 3;
        else if (player.equals(Choice.EXIT))
            this.outcome = 4;
        else
            this.outcome = 1;
    }
}
