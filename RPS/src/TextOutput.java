public class TextOutput implements Output {
    public boolean displayResult(Result r) {
        switch(r.outcome){
        case 1:
            System.out.println("You Win");
            break;
        case -1:
            System.out.println("You Tie");
            break;
        case 0:
            System.out.println("You Lost");
            break;
        case 2:
            displayHelp();
            break;
        }
        System.out.println("Enter your choice:");
        return true; // to be implemented
    }
    public boolean displayHelp() {
        System.out.println("------------ Help ------------");
        System.out.println("Enter 'Rock' to play a rock");
        System.out.println("Enter 'Paper' to play paper");
        System.out.println("Enter 'Scissors' to play scissors");
        System.out.println("Enter 'Score' for score");
        System.out.println("Enter 'Quit' for quit");
        System.out.println("------------------------------");
        return true; // to be implemented
    }
    public boolean displayStartUp() {
        System.out.println("Welcome to Pidgeon Boy's Rock Paper Scissor Game!");
        System.out.println(" If You Need Help, Just Type 'Help' at Any Time");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter Your Throw:");
//        System.out.print("Enter How Many Rounds You Would Like to Play:");
        return true;
    }
}
