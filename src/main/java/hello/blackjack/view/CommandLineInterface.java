package hello.blackjack.view;

import hello.blackjack.model.BlackjackDTO;
import hello.blackjack.model.MessageDTO;

public interface CommandLineInterface {
    MessageDTO help();

    BlackjackDTO play();

    BlackjackDTO more();

    BlackjackDTO stop();
}
