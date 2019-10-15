package hello.blackjack.view;


import hello.blackjack.controller.Deck;
import hello.blackjack.controller.GameController;
import hello.blackjack.dao.Statistics;
import hello.blackjack.dao.StatisticsServiceI;
import hello.blackjack.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class CommandLineService implements CommandLineInterface {

    private static final String LOSE_MSG = "Sorry, today is not your day. You loose.";
    private static final String PUSH_MSG = "Push. Everybody has equal amount of points.";
    private static final String WIN_MSG = "Congrats! You win!";
    @Autowired
    StatisticsServiceI statisticsService;
    private Scanner scanner;
    private PrintStream output;


    public CommandLineService() {
        this.output = System.out;
    }



    public BlackjackDTO stop(String username) {
        GameController controller = GameController.getInstance();
        List<Card> s = new ArrayList<>();
        while (Deck.costOf(controller.getDealersHand()) < 17) {
            controller.addDealerCard(s);
        }
        String text = "";
        statisticsService.save(new Statistics(getUserState(), controller.getWinState()), username);
        text = finishMessage(controller);
        return new BlackjackDTO(text, getUserState(), s);
    }

    @Override
    public StatisticsDTO getStatForUser(String username) {
        return new StatisticsDTO(statisticsService.load(username));
    }

    public BlackjackDTO more(String username) {
        GameController controller = GameController.getInstance();
        List<Card> s = new ArrayList<>();
        controller.addUserCard(s);
        String text = "";
        List<Card> myHand = controller.getMyHand();
        if (Deck.costOf(myHand) > 21) {
            statisticsService.save(new Statistics(myHand, WinState.LOOSE), username);
            text = text + finishMessage(controller);
            return new BlackjackDTO(text, s, getDealerState());
        }
        return new BlackjackDTO(text, s, getDealerState());
    }

    public BlackjackDTO play() {
        GameController controller = GameController.getInstance();


        controller.newGame();
        String text = "Console Blackjack application.\n" +
                "Author: (Ulyana Hatsoieva)\n" +
                "(C) 2019\n";


        return new BlackjackDTO(text, getUserState(), getDealerState());
    }

    /**
     * Выполняем команду, переданную с консоли. Список разрешенных комманд можно найти в классе {@link Command}.
     * Используйте методы контроллера чтобы обращаться к логике игры. Этот класс должен содержать только интерфейс.
     * Если этот метод вернет false - игра завершится.
     * <p/>
     * Более детальное описание формата печати можно узнать посмотрев код юниттестов.
     *
     * @see CommandLineService
     * <p/>
     * Описание команд:
     * Command.HELP - печатает помощь.
     * Command.MORE - еще одну карту и напечатать Состояние (GameController.requestMore())
     * если после карты игрок проиграл - напечатать финальное сообщение и выйти
     * Command.STOP - игрок закончил, теперь играет диллер (GameController.requestStop())
     * после того как диллер сыграл напечатать:
     * Dealer turn:
     * пустая строка
     * состояние
     * пустая строка
     * финальное сообщение
     * Command.EXIT - выйти из игры
     * <p/>
     * Состояние:
     * рука игрока (total вес)
     * рука диллера (total вес)
     * <p/>
     * например:
     * 3 J 8 (total 21)
     * A (total 11)
     * <p/>
     * Финальное сообщение:
     * В зависимости от состояния печатаем:
     * Congrats! You win!
     * Push. Everybody has equal amount of points.
     * Sorry, today is not your day. You loose.
     * <p/>
     * Постарайтесь уделить внимание чистоте кода и разделите этот метод на несколько подметодов.
     */



    public String finishMessage(GameController controller) {
        WinState winState = controller.getWinState();
        if (winState == WinState.LOOSE) {
            return LOSE_MSG;
        }
        if (winState == WinState.PUSH) {
            return PUSH_MSG;
        }
        return WIN_MSG;
    }


    public MessageDTO help() {
        return new MessageDTO("Usage: \n" +
                "\thelp - prints this message, \n" +
                "\thit - requests one more card, \n" +
                "\tstand - I'm done - lets finish, \n" +
                "\texit - exits game");
    }


    private String format(List<Card> hand) {
        String result = "";
        int total = Deck.costOf(hand);

        for (Card aHand : hand) {
            result += aHand.getValues() + " ";
        }
        result += "\n(total " + total + ")\n";

        return result;
    }

    private String printState(GameController controller) {
        List<Card> myHand = controller.getMyHand();
        List<Card> dealersHand = controller.getDealersHand();
        String text = format(myHand) + format(dealersHand);
        return text;
    }


    public List<Card> getUserState() {
        GameController controller = GameController.getInstance();
        return controller.getMyHand();
    }

    public List<Card> getDealerState() {
        GameController controller = GameController.getInstance();
        return controller.getDealersHand();
    }
}
