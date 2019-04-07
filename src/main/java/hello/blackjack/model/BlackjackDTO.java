package hello.blackjack.model;

import hello.blackjack.view.CommandLineService;

public class BlackjackDTO {
    private String state;
    private String finishMessage;
    public BlackjackDTO() {
    }

    public BlackjackDTO(String state, String finishMessage) {
        this.state = state;
        this.finishMessage = finishMessage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFinishMessage() {
        return finishMessage;
    }

    public void setFinishMessage(String finishMessage) {
        this.finishMessage = finishMessage;
    }
}
