public enum CardSuit {
    Hearts, Tiles, Clovers, Pikes;

    public static CardSuit getRandomSuit() {
        return values()[(int) (Math.random() * values().length)];
    }
}
