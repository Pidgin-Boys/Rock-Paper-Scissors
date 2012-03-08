public abstract class Output {    
    public static Output makeOutput(String type){
        if (type.equals("text"))
            return new TextOutput();
        //else if (type.equals("gui"))
        //    return new GUIOutput();
        else
            return new TextOutput(); // default to CLI
    }
    
    public abstract void displayHelp();
    public abstract void displayPrompt();
    public abstract void displayStartup();
    public abstract void displayScore(int[] a);
    public abstract void displayResult(Result r);
}
