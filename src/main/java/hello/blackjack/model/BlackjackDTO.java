package hello.blackjack.model;

public class BlackjackDTO extends MessageDTO {
    private String userState;
    private String dealerState;

    public BlackjackDTO(String message, String userState, String dealerState) {
        super(message);
        this.userState = userState;
        this.dealerState = dealerState;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getDealerState() {
        return dealerState;
    }

    public void setDealerState(String dealerState) {
        this.dealerState = dealerState;
    }
}