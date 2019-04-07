package hello.blackjack.view;


import hello.blackjack.controller.Deck;
import hello.blackjack.controller.GameController;
import hello.blackjack.model.Card;
import hello.blackjack.model.WinState;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;


@Service
public class CommandLineService {

    private static final String LOSE_MSG = "Sorry, today is not your day. You loose.";
    private static final String PUSH_MSG = "Push. Everybody has equal amount of points.";
    private static final String WIN_MSG = "Congrats! You win!";
    private Scanner scanner;
    private PrintStream output;

    public CommandLineService() {
//        this.scanner = new Scanner(input);
        this.output = System.out;
    }

    public String getStateAfterMore() {
        GameController controller = GameController.getInstance();
        controller.requestMore();
        String text = printState(controller);
        return text;
    }

    public String finishMessageAfterMore() {
        GameController controller = GameController.getInstance();
        List<Card> myHand = controller.getMyHand();
        String text = "";
        if (Deck.costOf(myHand) > 21) {
            text = finishMessage(controller);

        }
        return text;
    }

    public String stop() {
        GameController controller = GameController.getInstance();
        controller.requestStop();
        String text = "Dealer turn: " + "\n" + printState(controller) + "\n" + finishMessage(controller);
        execute(Command.STOP, controller);
        return text;
    }

    public String play() {
        GameController controller = GameController.getInstance();


        controller.newGame();
        String text = "Console Blackjack application.\n" +
                "Author: (Ulyana Hatsoieva)\n" +
                "(C) 2019\n";


        return text;
    }

    public String more() {
        GameController controller = GameController.getInstance();
        controller.requestMore();
        String text = printState(controller);
        List<Card> myHand = controller.getMyHand();
        if (Deck.costOf(myHand) > 21) {
            text = text + finishMessage(controller);
            return text;
        }
        return text;
    }
   /* public String getHand(){

    }
    */

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
    private boolean execute(String command, GameController controller) {
        if (command.equals(Command.HELP)) {
            getHelp();
        }
        if (command.equals(Command.MORE)) {
            getMore(controller);
        }
        if (command.equals(Command.STOP)) {
            stop(controller);
        }
        if (command.equals(Command.EXIT)) {

            return false;
        }
        return true;
    }


    private boolean getMore(GameController controller) {
        controller.requestMore();
        printState(controller);
        List<Card> myHand = controller.getMyHand();
        if (Deck.costOf(myHand) > 21) {
            finishMessage(controller);
            return false;
        }
        return true;
    }

    private boolean stop(GameController controller) {
        controller.requestStop();
        output.println("Dealer turn:");
        output.println();
        printState(controller);
        output.println();
        finishMessage(controller);

        return false;
    }

    public String getStateAfterStop() {
        GameController controller = GameController.getInstance();
        controller.requestStop();
        String text = "Dealer turn:" + printState(controller);
        return text;
    }

    public String getWinState() {
        GameController controller = GameController.getInstance();
        String s = controller.getWinState().toString();
        return s;
    }

    public String finishMessage(GameController controller) {
        WinState winState = controller.getWinState();
        if (winState == WinState.LOOSE) {
            return LOSE_MSG;
        }
        if (winState == WinState.PUSH) {
            return PUSH_MSG;
        }
        if (winState == WinState.LOOSE) {
            return LOSE_MSG;
        }

        return WIN_MSG;
    }

    public String finishMessage() {
        GameController controller = GameController.getInstance();
        WinState winState = controller.getWinState();
        if (winState == WinState.LOOSE) {
            return LOSE_MSG;
        }
        if (winState == WinState.PUSH) {
            return PUSH_MSG;
        }
        if (winState == WinState.LOOSE) {
            return LOSE_MSG;
        }

        return WIN_MSG;
    }

    public String help() {
        String text = "Usage: \n" +
                "\thelp - prints this message\n" +
                "\thit - requests one more card\n" +
                "\tstand - I'm done - lets finish\n" +
                "\texit - exits game";
        return text;
    }

    private void getHelp() {
        output.println(help());
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

    public String getState() {
        GameController controller = GameController.getInstance();
        String text = controller.getState();
        return text;
    }

    public String printUserState() {
        GameController controller = GameController.getInstance();
        List<Card> myHand = controller.getMyHand();
        String text = format(myHand);
        return text;
    }

    public String printDealerState() {
        GameController controller = GameController.getInstance();
        List<Card> dealersHand = controller.getDealersHand();
        String text = format(dealersHand);
        return text;
    }
}