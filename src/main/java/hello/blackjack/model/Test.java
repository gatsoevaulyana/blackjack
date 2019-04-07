package hello.blackjack.model;

public class Test {

    private String gameResult;
    private Integer score;

    public Test() {
    }

    public Test(String gameResult, Integer score) {
        this.gameResult = gameResult;
        this.score = score;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
