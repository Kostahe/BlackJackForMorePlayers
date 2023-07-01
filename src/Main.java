import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> arrayPlayers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int countPlayers;

        System.out.println("Welcome to blackjack");

        loop: while (true) {
            arrayPlayers.clear();
            System.out.println("Enter 1 to start\nEnter 2 to read the rules\nEnter 3 to end the game");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Amount of players is 2-7");

                    while (true) {
                        System.out.println("Input amount of players: ");
                        countPlayers = scanner.nextInt();
                        scanner.nextLine();
                        if(countPlayers < 8) {
                            break;
                        }
                        System.out.println("Error input again max is 7 players");
                    }
                    for(int i = 0; i<countPlayers; i++) {

                        System.out.print("Input name of player" + (i+1) + ": ");
                        arrayPlayers.add(new Player(scanner.nextLine(), (i+1)));
                    }
                    game(arrayPlayers);
                    continue;
                case 2:
                    printRules();
                    continue;
                case 3:
                    System.out.println("Bye");
                    break loop;

                default:
                    System.out.println("Error input 1 or 2 or 3");

            }
        }
    }
    public static void printRules() {
        System.out.println("There are the rules:");
        System.out.println("Blackjack hands are scored by their point total.\nThe hand with the highest total wins as long as it doesn't exceed 21.\nThe hand with a higher total than 21 is said to bust.");
        System.out.println("Max amount of players is 7");
    }


    public static void game(ArrayList<Player> playerArrayList) {
        Scanner scanner = new Scanner(System.in);
        for(Player player: playerArrayList) {
            System.out.println(player.getName() + " now plays!");
            loop: while (true) {
                System.out.println("Your cards are: ");
                for(Card card : player.getCardcollection()) {
                    System.out.println(card + " ");
                }
                System.out.println("Suma is: " + player.getSumaValueCards());

                System.out.println("\nEnter 1 for hit\nEnter 2 for stand");
                switch (scanner.nextInt()) {
                    case 1:
                        player.takeCard();
                        System.out.println("You took: " + player.getCardcollection().get(player.getCardcollection().toArray().length-1));
                        break;
                    case 2:
                        System.out.println("____________________________");
                        break loop;
                    default:
                        System.out.println(player.getName() + " input only 1 or 2");
                        break;


                }
            }
            // end of game

        }
    }
}