public abstract class Output {
    
    public static Output output;
    
    public static Output makeOutput(int type){
        switch(type)
        {
            case 1: output = new TextOutput();
            //case 2:  output = new GUIOutput();
        }
        
        return output;
    }
    
    public abstract void displayHelp();
    public abstract void displayPrompt();
    public abstract void displayStartup();
    public abstract void displayScore(int[] a);
    public abstract void displayResult(Result r);
}
