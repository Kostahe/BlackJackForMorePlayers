import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private int sumaValue = 0;
    final private int id;
    private String name;
    private ArrayList<Card> cardCollection = new ArrayList<>();

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        for(int i = 0; i < 2;i++) {
            this.takeCard();
        }
    }
    public int getSumaValueCards() {
        return sumaValue;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Card> getCardCollection() {
        return cardCollection;
    }
    public void setSumaValue(int sumaValue) {
        this.sumaValue = sumaValue;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player" + this.id + " : " + this.name;
    }

    public void takeCard() {
        Card card = Card.getRandom();
        cardCollection.add(card);
        sumaValue += card.getVALUE();
    }
}