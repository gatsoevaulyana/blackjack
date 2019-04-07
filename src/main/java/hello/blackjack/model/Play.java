package hello.blackjack.model;

public class Play {
    private String newGame;
    private String userHand;
    private String dealerHand;
    public Play() {
    }

    public String getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(String dealerHand) {
        this.dealerHand = dealerHand;
    }

    public String getUserHand() {
        return userHand;
    }

    public void setUserHand(String userHand) {
        this.userHand = userHand;
    }

    public String getNewGame() {
        return newGame;
    }

    public void setNewGame(String newGame) {
        this.newGame = newGame;
    }

    public Play( String newGame, String userHand, String dealerHand) {
        this.newGame = newGame;
        this.userHand = userHand;
        this.dealerHand = dealerHand;
    }
}
