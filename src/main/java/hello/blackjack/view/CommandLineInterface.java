package hello.blackjack.view;

import hello.blackjack.model.BlackjackDTO;
import hello.blackjack.model.MessageDTO;
import hello.blackjack.model.StatisticsDTO;

public interface CommandLineInterface {
    MessageDTO help();

    BlackjackDTO play();

    BlackjackDTO more(String username);

    BlackjackDTO stop(String username);

    StatisticsDTO getStatForUser(String username);
}
