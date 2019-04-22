package hello;

import hello.blackjack.model.BlackjackDTO;
import hello.blackjack.model.MessageDTO;
import hello.blackjack.model.StatisticsDTO;
import hello.blackjack.view.CommandLineInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackjackController {


    @Autowired
    CommandLineInterface commandLineInterfaceInstance;

    @GetMapping("/play")
    public BlackjackDTO play(@RequestHeader("Username") String username) {

        return commandLineInterfaceInstance.play();
    }

    @GetMapping("/more")
    public BlackjackDTO more(@RequestHeader("Username") String username) {
        return commandLineInterfaceInstance.more(username);
    }

    @GetMapping("/stop")
    public BlackjackDTO stop(@RequestHeader("Username") String username) {
        return commandLineInterfaceInstance.stop(username);
    }

    @GetMapping("/stats")
    public StatisticsDTO getUserStat(@RequestHeader("Username") String username) {
        return commandLineInterfaceInstance.getStatForUser(username);
    }

    @GetMapping("/help")
    public MessageDTO help() {
        return commandLineInterfaceInstance.help();
    }


}
