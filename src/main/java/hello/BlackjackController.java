package hello;

import hello.blackjack.model.BlackjackDTO;
import hello.blackjack.model.MessageDTO;
import hello.blackjack.model.Test;
import hello.blackjack.view.CommandLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackjackController {


    @Autowired
    CommandLineService commandLineInterface;


    @PostMapping(path = "/play")
    public String cmd() {
        return commandLineInterface.play();
    }

    @GetMapping("/test")
    public Test test() {
        return new Test(commandLineInterface.getWinState(), 21);
    }

    @GetMapping("/play")
    public BlackjackDTO play() {
        String message = commandLineInterface.play();

        String state = commandLineInterface.printUserState() + '\n' +
                commandLineInterface.printDealerState();
        return new BlackjackDTO(state, message);
    }

    @GetMapping("/more")
    public BlackjackDTO more() {
        return new BlackjackDTO(commandLineInterface.getStateAfterMore(), commandLineInterface.finishMessageAfterMore());
    }

    @GetMapping("/stop")
    public BlackjackDTO stop() {
        return new BlackjackDTO(commandLineInterface.getStateAfterStop(), commandLineInterface.finishMessage());
    }

    @GetMapping("/help")
    public MessageDTO help() {
        return new MessageDTO(commandLineInterface.help());
    }

    @PostMapping(path = "/more")
    public String cMd() {
        return commandLineInterface.more();
    }

    @PostMapping(path = "/stop")
    public String cmD() {
        return commandLineInterface.stop();
    }

    @PostMapping(path = "/help")
    public String CMD() {
        return commandLineInterface.help();
    }


}
