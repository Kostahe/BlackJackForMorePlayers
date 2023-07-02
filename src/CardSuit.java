public enum CardSuit {
    Hearts, Tiles, Clovers, Pikes;

    // generates random cardsuit for card
    public static CardSuit getRandomSuit() {
        return values()[(int) (Math.random() * values().length)];
    }
}
