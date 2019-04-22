package hello.blackjack.dao;

import hello.blackjack.model.Card;
import hello.blackjack.model.WinState;

import java.io.Serializable;
import java.util.List;

public class Statistics implements Serializable {
    private List<Card> cards;
    private WinState winState;

    public Statistics() {
    }

    public Statistics(List<Card> cards, WinState winState) {
        this.cards = cards;
        this.winState = winState;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public WinState getWinState() {
        return winState;
    }

    public void setWinState(WinState winState) {
        this.winState = winState;
    }
}
