package hello.blackjack.model;

public class BlackjackDTO extends MessageDTO {
    private String state;

    public BlackjackDTO(String state, String message) {
        super(message);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
