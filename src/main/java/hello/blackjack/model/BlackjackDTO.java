package hello.blackjack.model;

import java.util.List;

public class BlackjackDTO extends MessageDTO {
    private List<Card> userState;
    private List<Card> dealerState;

    public BlackjackDTO(String message, List<Card> userState, List<Card> dealerState) {
        super(message);
        this.userState = userState;
        this.dealerState = dealerState;
    }

    public List<Card> getUserState() {
        return userState;
    }

    public void setUserState(List<Card> userState) {
        this.userState = userState;
    }

    public List<Card> getDealerState() {
        return dealerState;
    }

    public void setDealerState(List<Card> dealerState) {
        this.dealerState = dealerState;
    }


}