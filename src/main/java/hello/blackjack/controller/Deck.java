package hello.blackjack.controller;


import hello.blackjack.model.Card;
import hello.blackjack.model.Rank;
import hello.blackjack.model.Suit;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private Deck(){}

    public static List<Card> createDeck(int size) {
        List<Card> deck = new ArrayList<Card>();

        // An array of 52 Cards, representing the deck.
        if (size < 0) {
            size = 1;
        }
        if (size > 10) {
            size = 10;
        }


        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < suits.length; i++) {
                for (int j = 0; j < ranks.length; j++) {
                    deck.add(new Card(ranks[j], suits[i]));
                }
            }
        }

        return deck;
    }

    public static int costOf(List<Card> hand) {
        int costOfHand = 0;

        for (Card element : hand) {
            costOfHand = costOfHand + element.getCost();
        }

        return costOfHand;
    }
}
