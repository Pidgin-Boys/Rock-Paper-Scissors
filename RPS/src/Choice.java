public enum Choice {
    ROCK(1), PAPER(2), SCISSORS(3), GAME(4), HELP(5), SCORE(6), MENU(7), EXIT(8);

    private int value;

    private Choice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
