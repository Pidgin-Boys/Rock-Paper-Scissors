public abstract class DecisionEngine {    
    public static DecisionEngine makeEngine(String type){
        if (type.equals("random"))
            return new RandomEngine();
        //else if (type.equals("smart"))
        //    return new SmartEngine();
        //else if (type.equals("predictive"))
        //    return new PredictiveEngine();
        else
            return new RandomEngine(); // default to random
    }
    
    public abstract Choice getComputerChoice();
}
