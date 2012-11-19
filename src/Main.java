public class Main 
{
    public static void main(String[] args)
    {
        if (args.length == 0)
            new GUI();
        else
            new CLI(args);
    }
}
