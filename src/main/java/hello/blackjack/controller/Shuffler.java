package hello.blackjack.controller;


import hello.blackjack.model.Card;

import java.util.List;

interface Shuffler {
	void shuffle(List<Card> deck);
}
