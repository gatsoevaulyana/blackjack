package hello.blackjack.dao;

import hello.blackjack.model.Card;
import hello.blackjack.model.WinState;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImplementation implements StatisticsServiceI {

    private Map<String, List<Statistics>> statisticsMap = new HashMap<>();

    @Override
    public void save(List<Card> state, WinState winstate, String username) {
        List<Statistics> statistics = this.statisticsMap.get(username);
        Statistics stat = null;
        if (statistics == null) {
            statistics = new ArrayList<>();
            statistics.add(stat);
            this.statisticsMap.put(username, statistics);
        } else {
            statistics.add(stat);
            this.statisticsMap.put(username, statistics);
        }
    }

    @Override
    public List<Statistics> getStatForUser(String username) {
        return this.statisticsMap.get(username);
    }
}
