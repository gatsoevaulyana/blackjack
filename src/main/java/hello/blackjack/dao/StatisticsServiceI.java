package hello.blackjack.dao;

import java.util.List;

public interface StatisticsServiceI {

    void save(Statistics stat, String username);

    List<Statistics> load(String username);

}
