public enum Card {
    Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

    private final int VALUE;

    Card(int VALUE) {
        this.VALUE = VALUE;
    }
    public int getVALUE() {
        return this.VALUE;
    }

    public static Card getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
