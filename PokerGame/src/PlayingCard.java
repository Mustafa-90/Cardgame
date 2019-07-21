public class PlayingCard {

    String cardNr;
    CardSuit suit;
    CardColor color;
    boolean isShown = false;

    public PlayingCard() {
    }

    public PlayingCard(String cardNr, CardSuit suit, boolean isShown) {
        this.cardNr = cardNr;
        this.suit = suit;
        this.isShown = isShown;
    }

    public PlayingCard(String cardNr, CardSuit suit, CardColor color, boolean isShown) {
        this.cardNr = cardNr;
        this.suit = suit;
        this.color = color;
        this.isShown = isShown;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }
}
