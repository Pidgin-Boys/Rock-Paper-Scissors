public abstract class DecisionEngine 
{
    /**@param type String "random" or "predictive"
     * @return returns a new DecisionEngine of the given type
     */
    public static DecisionEngine make(String type)
    {
        if (type.equals("random")) return new RandomEngine();
        if (type.equals("smart")) return new SmartEngine();
        //else if (type.equals("predictive")) return new PredictiveEngine();
        else return new RandomEngine(); // default to random
    }
    
    public abstract Choice getComputerChoice(ResultDatabase history);
}
