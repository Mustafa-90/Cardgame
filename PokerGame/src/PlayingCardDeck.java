import java.util.ArrayList;
import java.util.Collections;

public class PlayingCardDeck extends PlayingCard {

    private String[] deckOfCards = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private PlayingCardDeck[] cardDeck = new PlayingCardDeck[13];
    private ArrayList<PlayingCardDeck> pcDeck = new ArrayList<>();

    /**
     * Constructors for the Card deck.
     */

    public PlayingCardDeck() {
    }

    public PlayingCardDeck(String cardNr, CardSuit suit, CardColor color, boolean isShown) {
        super(cardNr, suit, color, isShown);
    }


    /**
     * Method to generate a deck which will loop through the String-array deckOfCards and give it
     * a suit (and color)
     *
     * @return an arraylist of a whole card deck with 52 cards.
     */

    public ArrayList<PlayingCardDeck> generateDeck() {
        isShown = false;

        for (int j = 0; j < 4; j++) {
            suit = generateSuit(j);

            if (suit == CardSuit.SPADES || suit == CardSuit.CLUBS) {
                color = CardColor.BLACK;
            } else if (suit == CardSuit.HEARTS || suit == CardSuit.DIAMONDS) {
                color = CardColor.RED;
            }

            for (int i = 0; i < deckOfCards.length; i++) {
                cardDeck[i] = new PlayingCardDeck(deckOfCards[i], suit, color, isShown);
                pcDeck.add(cardDeck[i]);
            }
        }
        return pcDeck;
    }


    /**
     * Method to draw out the first card
     *
     * @return the first card in the deck.
     */
    public String firstCard() {
        return pcDeck.get(0).getCardNr() + pcDeck.get(0).getSuit() + " ";
    }

    /**
     * Method to draw out the second card in the deck.
     *
     * @return the second card in the deck.
     */

    public String secondCard() {
        return pcDeck.get(1).getCardNr() + pcDeck.get(1).getSuit() + " ";
    }

    /**
     * Remove the first card from the top of the deck and place it all the way back in the deck.
     */

    public void returnCard() {
        PlayingCardDeck pcx = this.pcDeck.get(0);
        pcDeck.remove(0);
        pcDeck.add(pcx);
    }

    /**
     * Generates the suit when creating the card deck.
     *
     * @param suitGen
     * @return
     */

    private CardSuit generateSuit(int suitGen) {
        if (suitGen == 0) {
            suit = CardSuit.DIAMONDS;
        } else if (suitGen == 1) {
            suit = CardSuit.HEARTS;
        } else if (suitGen == 2) {
            suit = CardSuit.CLUBS;
        } else if (suitGen == 3) {
            suit = CardSuit.SPADES;
        }
        return suit;
    }

    /**
     * Shuffles the full card deck (52 cards)
     */
    public void shuffle() {
        Collections.shuffle(pcDeck);
    }

    /**
     * Prints out the whole deck (52 cards) with the card number and card suit.
     * Good for error handling and or checking what the next card is.
     */
    public void printDeck() {
        System.out.println();
        for (int j = 0; j < pcDeck.size(); j++) {
            System.out.print(pcDeck.get(j).getCardNr() + pcDeck.get(j).getSuit() + " ");
        }
    }
}
