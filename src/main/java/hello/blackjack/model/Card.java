package hello.blackjack.model;

public class Card {
private Rank rank;
    private String name;
private int cost;
private Suit suit;
    //add private fields!
	public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.name = rank.getValues();
        this.cost = rank.getCost();//implement me, please!
    }

	public Rank getRank() {
            return this.rank;
    }

    public String getValues(){

        return this.name;
    }

	public int getCost() {
            return this.cost;
    }

    public Suit getSuit() {
            return this.suit;
    }
}
