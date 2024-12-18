import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Initialize the deck
        String[] deck = new String[52];
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[i * ranks.length + j] = ranks[j] + " of " + suits[i];
            }
        }

        // Shuffle the deck
        shuffleDeck(deck);

        // Distribute 9 cards to 4 players
        String[][] players = new String[4][9];
        int cardIndex = 0;
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players[i].length; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }

        // Print the cards received by each player
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
            System.out.println();
        }
    }
    public static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = random.nextInt(deck.length);
            // Swap the cards
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

}