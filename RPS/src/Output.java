public abstract class Output 
{
    /**@param type String : "text" or "gui"
     * @return a new Output object of the given type
     */
    public static Output makeOutput(String type)
    {
        if (type.equals("text")) return new TextOutput();
        if (type.equals("gui")) return new GUIOutput();
        else return new TextOutput(); // default to CLI
    }
    
    public abstract void displayHelp();
    public abstract void displayPrompt();
    public abstract void displayStartup();
    public abstract void displayScore(int[] score);
    public abstract void displayWinner(int[] score);
    public abstract void displayResult(Result r);
}
