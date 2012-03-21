public abstract class Input 
{
    /**@param type String: "text" or "gui" 
     * @return new Input object of the given type
     */
    public static Input makeInput(String type)
    {
        if (type.equals("text")) return new TextInput();
        //else if (type.equals("gui")) return new GUIInput();
        else return new TextInput(); // default to command line input
    }
    
    public abstract Choice getUserChoice();
}
