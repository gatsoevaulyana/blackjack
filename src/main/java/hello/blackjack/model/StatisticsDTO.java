package hello.blackjack.model;

import hello.blackjack.dao.Statistics;

import java.util.List;

public class StatisticsDTO {
    private List<Statistics> statistics;

    public StatisticsDTO(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public StatisticsDTO() {
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }
}
