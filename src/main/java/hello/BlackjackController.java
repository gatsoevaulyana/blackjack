package hello;

import hello.blackjack.model.BlackjackDTO;
import hello.blackjack.model.MessageDTO;
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
    public BlackjackDTO more() {
        return commandLineInterfaceInstance.more();
    }

    @GetMapping("/stop")
    public BlackjackDTO stop() {
        return commandLineInterfaceInstance.stop();
    }

    @GetMapping("/help")
    public MessageDTO help() {
        return commandLineInterfaceInstance.help();
    }

}
