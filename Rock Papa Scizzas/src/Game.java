public class Game 
{
    public static void main(String[] args)
    {
        if (args.length == 0)
            new GUI().setVisible(true);
        else
            CLI.run(args);
    }
}
