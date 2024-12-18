public class Player {
    private String name;
    private CardQueue cardQueue;

    public Player(String name) {
        this.name = name;
        this.cardQueue = new CardQueue();
    }

    public String getName() {
        return name;
    }

    public void addCard(String card) {
        cardQueue.enqueue(card);
    }

    public void sortCards() {
        String[] cards = cardQueue.toArray();
        sortByRank(cards);
        cardQueue = new CardQueue();
        for (String card : cards) {
            cardQueue.enqueue(card);
        }
    }

    public void printCards() {
        cardQueue.printQueue();
    }

    private void sortByRank(String[] cards) {
        String[] rankOrder = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (compareRank(cards[i], cards[j], rankOrder) > 0) {
                    String temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    private int compareRank(String card1, String card2, String[] rankOrder) {
        String rank1 = card1.split(" ")[0];
        String rank2 = card2.split(" ")[0];
        int index1 = -1, index2 = -1;
        for (int i = 0; i < rankOrder.length; i++) {
            if (rankOrder[i].equals(rank1)) index1 = i;
            if (rankOrder[i].equals(rank2)) index2 = i;
        }
        return Integer.compare(index1, index2);
    }
}
