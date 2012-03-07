public abstract class Input {
    public static Input input;
    
    public static Input makeInput(int type){
        switch(type)
        {
            case 1: input = new TextInput();
            //case 2:  input = new GUIInput();
            //default: input = new TextInput();
        }
        
        return input;
    }
    
    public abstract Choice getUserChoice();
}
