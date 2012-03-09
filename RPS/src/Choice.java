public enum Choice {
    ROCK(1), PAPER(2), SCISSORS(3), HELP(4), SCORE(5), EXIT(6);

    private int value;

     /*
     * Creates Choice constructor with integer value that corresponds to the user's choice
     * @param value - number that corresponds to user's choice
     */
    private Choice(int value) {
        this.value = value;
    }

     /*
     * Gets integer value that is stored in instance variable value
     * @return integer value that corresponds to user's choice
     */
    public int getValue() {
        return value;
    }
}
