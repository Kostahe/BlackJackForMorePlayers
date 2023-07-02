import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private int sumaValue = 0;
    final private int id;
    private String name;
    private final ArrayList<Card> cardCollection = new ArrayList<>();

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        for(int i = 0; i < 2;i++) {
            this.takeCard();
        }
    }
    public int getSumaValueCards() {
        return this.sumaValue;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public ArrayList<Card> getCardCollection() {
        return this.cardCollection;
    }
    public void setSumaValue(int sumaValue) {
        this.sumaValue = sumaValue;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player" + this.id + " : " + this.name + " with cards: " + this.cardCollection + " suma of cards is " + this.sumaValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player that = (Player) o;
        return sumaValue == that.sumaValue && id == that.id && Objects.equals(name, that.name) && Objects.equals(cardCollection, that.cardCollection);
    }

    public void takeCard() {
        Card card = Card.getRandomCard();
        cardCollection.add(card);
        sumaValue += card.getVALUE();
    }
}