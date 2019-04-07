package hello.blackjack.model;

public enum Rank {
    RANK_ACE("A", 11),
    RANK_2("2", 2),
    RANK_3("3", 3),
    RANK_4("4", 4),
    RANK_5("5", 5),
    RANK_6("6", 6),
    RANK_7("7", 7),
    RANK_8("8", 8),
    RANK_9("9", 9),
    RANK_10("10", 10),
    RANK_JACK("J", 10),
    RANK_QUEEN("Q", 10),
    RANK_KING("K", 10);
    private String values;
    private int weight;

    Rank(String values, int weight) {
        this.values = values;
        this.weight = weight;
    }

    public String getValues() {
        return values;
    }

    public int getCost() {
        return this.weight;
    }
}