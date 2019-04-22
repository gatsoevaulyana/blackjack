package hello.blackjack.dao;

import hello.blackjack.model.Card;
import hello.blackjack.model.WinState;

import java.util.List;

public interface StatisticsServiceI {

    void save(List<Card> state, WinState winstate, String username);

    List<Statistics> getStatForUser(String username);

}
