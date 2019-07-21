public enum CardSuit {
    DIAMONDS("♦"),
    CLUBS("♣"),
    HEARTS("♥"),
    SPADES("♠");

    private String value;

    CardSuit(String value) {
        this.value = value;
    }


    /**
     * Method to print out the symbols for the different suits.
     *
     * @return the symbol of the suit.
     */
    public String toString() {
        return this.value;
    }
}