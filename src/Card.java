public enum Card {
    ace(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), jack(10), queen(10), king(10);

    private final int VALUE;
    private final CardSuit cardSuit = CardSuit.getRandomSuit();

    Card(int VALUE) {
        this.VALUE = VALUE;
    }
    public int getVALUE() {
        return this.VALUE;
    }
    @Override
    public String toString() {
        return this.cardSuit + " " + this.name();
    }
    // generates random card
    public static Card getRandomCard() {
        return values()[(int) (Math.random() * values().length)];
    }

}
