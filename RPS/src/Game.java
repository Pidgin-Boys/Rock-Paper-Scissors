public class Game {
    //private ResultDatabase results; to be implemented later
    private Input          input;
    private Output         output;
    private DecisionEngine engine;
    public int            roundsRemaining;

    public Game(int rounds) {
        this.input  = new TextInput();
        this.output = new TextOutput();
        this.output.displayStartUp();
        this.engine = new RandomEngine();
        this.roundsRemaining = rounds;
    }

    public static void main(String[] args) {
        Game g = new Game(Integer.parseInt(args[0]));
        Choice c;
        Result r;
        while (g.roundsRemaining > 0)
        {
            c = g.input.getUserChoice();
            r = new Result(c, g.engine.getComputerChoice());
            g.output.displayResult(r);
            if (r.outcome < 2)
                g.roundsRemaining--;
        }
    }
}