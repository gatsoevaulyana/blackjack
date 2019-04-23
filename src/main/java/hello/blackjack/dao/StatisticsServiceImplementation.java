package hello.blackjack.dao;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsServiceImplementation implements StatisticsServiceI {


    @Override
    public void save(Statistics stat, String username) {
        List<Statistics> statFromFile = load(username);
        if (statFromFile != null) {
            statFromFile.add(stat);

        } else {
            statFromFile = new ArrayList<>();
            statFromFile.add(stat);

        }
        try {
            FileOutputStream fos = new FileOutputStream(username);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(statFromFile);
            oos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Statistics> load(String username) {
        File f = new File(username);
        if (f.exists() && !f.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<Statistics>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex);
                return null;
            }
        } else {
            return null;
        }
    }

}
