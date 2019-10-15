package hello.blackjack.controller;


import hello.blackjack.model.Card;
import hello.blackjack.model.WinState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    private static GameController controller;
    List<Card> deck;
    List<Card> userHand;
    List<Card> dealerHand;

    private GameController() {

        deck = new ArrayList<>();
        userHand = new ArrayList<>();
        dealerHand = new ArrayList<>();// инициализация переменных тут
    }

    public static GameController getInstance() {
        if (controller == null) {
            controller = new GameController();
        }
        return controller;
    }

    public void newGame() {
        newGame(new Shuffler() {
            @Override
            public void shuffle(List<Card> deck) {
                Collections.shuffle(deck);
            }
        });
    }

    /**
     * Создает новую игру.
     * - перемешивает колоду (используйте для этого shuffler.shuffle(list))
     * - раздает две карты игроку
     * - раздает одну карту диллеру.
     *
     * @param shuffler shuffle interface
     */
    void newGame(Shuffler shuffler) {
        deck.clear();
        userHand.clear();
        dealerHand.clear();
        deck = Deck.createDeck(8);
        shuffler.shuffle(deck);
        userHand.add(deck.get(0));
        deck.remove(0);
        userHand.add(deck.get(0));
        deck.remove(0);
        dealerHand.add(deck.get(0));
        deck.remove(0);
    }

    /**
     * Метод вызывается когда игрок запрашивает новую карту.
     * - если сумма очков на руках у игрока больше максимума или колода пуста - ничего не делаем
     * - если сумма очков меньше - раздаем игроку одну карту из коллоды.
     *
     * @return true если сумма очков у игрока меньше максимума (или равна) после всех операций и false если больше.
     */

    public List<Card> addUserCard(List<Card> s) {
        s.add(deck.get(0));
        userHand.add(deck.get(0));
        deck.remove(0);
        return s;
    }

    public List<Card> addDealerCard(List<Card> s) {

        dealerHand.add(deck.get(0));
        s.add(deck.get(0));
        deck.remove(0);
        return s;
    }


    /**
     * Вызывается когда игрок получил все карты и хочет чтобы играло казино (диллер).
     * Сдаем диллеру карты пока у диллера не наберется 17 очков.
     */

    /**
     * Сравниваем руку диллера и руку игрока.
     * Если у игрока больше максимума - возвращаем WinState.LOOSE (игрок проиграл)
     * Если у игрока меньше чем у диллера и у диллера не перебор - возвращаем WinState.LOOSE (игрок проиграл)
     * Если очки равны - это пуш (WinState.PUSH)
     * Если у игрока больше чем у диллера и не перебор - это WinState.WIN (игрок выиграл).
     */


    public WinState getWinState() {
        int dealerCost = Deck.costOf(dealerHand);
        int userCost = Deck.costOf(userHand);

        if (userCost > 21) {
            return WinState.LOOSE;
        }
        if (dealerCost > 21) {
            return WinState.WIN;
        }
        if (userCost < dealerCost && dealerCost <= 21) {
            return WinState.LOOSE;
        }
        if (userCost > dealerCost) {
            return WinState.WIN;
        }
        if (dealerCost == userCost) {
            return WinState.PUSH;
        }
        return WinState.WIN;
    }

    /**
     * Возвращаем руку игрока
     */
    public List<Card> getMyHand() {
        return userHand;
    }

    /**
     * Возвращаем руку диллера
     */
    public List<Card> getDealersHand() {

        return dealerHand;
    }
}
