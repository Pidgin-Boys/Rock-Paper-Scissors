public enum Choice 
{
    ROCK(1), PAPER(2), SCISSORS(3), HELP(4), SCORE(5), EXIT(6);
    private int value;
    
    private Choice(int value) { this.value = value; }

    /** @return int : the value assigned to this enum */
    public int getValue() { return value; }
}
