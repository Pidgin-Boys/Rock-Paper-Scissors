public abstract class DecisionEngine {
    public static DecisionEngine engine;
    
    public static DecisionEngine makeDecision(int type){
        switch(type)
        {
            case 1: engine = new RandomEngine();
            //case 2:  engine = new SmartEngine();
            //case 3: engine = new GeniusEngine();
            //default: engine = new RandomEngine();
        }
        
        return engine;
    }
    public abstract Choice getComputerChoice();
}
