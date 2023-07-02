import java.util.Collections;
import java.util.InputMismatchException;
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

            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("Amount of players is 2-7");

                    while (true) {
                        try {
                            System.out.println("Input amount of players: ");
                            countPlayers = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Fatal error input needs to be number");
                             break loop;
                        }
                        scanner.nextLine();
                        if(countPlayers < 8 && countPlayers > 1) {
                            break;
                        } else {
                            System.out.println("Error input needs to be between 2-7");
                        }
                    }
                    for(int i = 0; i<countPlayers; i++) {
                        System.out.print("Input name of player" + (i+1) + ": ");
                        arrayPlayers.add(new Player(scanner.nextLine(), (i+1)));
                    }
                    game(arrayPlayers);
                    continue;
                case "2":
                    printRules();
                    continue;
                case "3":
                    System.out.println("Bye");
                    break loop;
                default:
                    System.out.println("Error input 1 or 2 or 3");
            }
        }
    }
    // Prints rules of the game
    public static void printRules() {
        System.out.println("There are the rules:");
        System.out.println("Blackjack hands are scored by their point total.\nThe hand with the highest total wins as long as it doesn't exceed 21.\nThe hand with a higher total than 21 is said to bust.");
        System.out.println("Amount of players that can play is between 2-7.");
        System.out.println("Ace is 1\nJack, king and queen is 10");
    }
    public static void game(ArrayList<Player> playerArrayList) {

        int maxPoints = 0;
        ArrayList<Player> loosePlayers = new ArrayList<>();
        ArrayList<Player> firedPlayers = new ArrayList<>();
        ArrayList<Player> winnerPlayers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for(Player player : playerArrayList) {
            System.out.println(player.getName() + " now plays!");
            loop: while (true) {
                System.out.println("Your cards are: ");
                for(Card card : player.getCardCollection()) {
                    System.out.println(card + " ");
                }
                System.out.println("Suma is: " + player.getSumaValueCards());

                System.out.println("\nEnter 1 for hit\nEnter 2 for stand");
                switch (scanner.nextLine()) {
                    case "1":
                        player.takeCard();
                        System.out.println("You took: " + player.getCardCollection().get(player.getCardCollection().toArray().length-1));
                        break;
                    case "2":
                        System.out.println("____________________________");
                        break loop;
                    default:
                        System.out.println(player.getName() + " input only 1 or 2");
                        break;
                }
            }
        }
        for(Player endPlayer: playerArrayList) {
            if(endPlayer.getSumaValueCards() > 21) {
                firedPlayers.add(endPlayer);
            } else {
                winnerPlayers.add(endPlayer);
            }
        }
        for(Player endPlayer: winnerPlayers) {
            if(endPlayer.getSumaValueCards() > maxPoints) {
                maxPoints = endPlayer.getSumaValueCards();
            }
        }
        for(Player endPlayer: winnerPlayers) {
            if(endPlayer.getSumaValueCards() != maxPoints) {
                loosePlayers.add(endPlayer);
            }
        }
        loosePlayers.sort((o1, o2)
                -> o1.getSumaValueCards().compareTo(o2.getSumaValueCards()));
        Collections.reverse(loosePlayers);
        firedPlayers.sort((o1, o2)
                -> o1.getSumaValueCards().compareTo(o2.getSumaValueCards()));
        loosePlayers.addAll(firedPlayers);
        winnerPlayers.removeAll(loosePlayers);

        System.out.println("_____________________________");
        System.out.println("Players that won:");
        for (Player winnerPlayer: winnerPlayers) {
            System.out.println("1. " + winnerPlayer);
        }
        int counterPlace = 2;
        System.out.println("Players that lost:");
        for (Player loosePlayer: loosePlayers) {
            System.out.println(counterPlace + ". " +loosePlayer);
            counterPlace ++;
        }

        System.out.println();
        loosePlayers.clear();
        winnerPlayers.clear();
    }
}
