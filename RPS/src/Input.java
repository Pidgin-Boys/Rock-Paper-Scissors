public abstract class Input {
    public static Input makeInput(String type){
        if (type.equals("text")) 
            return new TextInput();
        //else if (type.equals("gui"))
        //    return new GUIInput();
        else
            return new TextInput(); // default to command line input
    }
    
    public abstract Choice getUserChoice();
}
