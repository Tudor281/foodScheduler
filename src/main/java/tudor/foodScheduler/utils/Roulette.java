package tudor.foodScheduler.utils;

import tudor.foodScheduler.InitialRun;

import java.util.ArrayList;
import java.util.List;

public class Roulette<T> {
    int sum = 0;

    List<Entry<T>> entries = new ArrayList<>();

    public void add(T payload, int score) {
        entries.add(new Entry<>(payload, score));
        sum += score;
    }

    public T getRandom() {
        int value = InitialRun.random.nextInt(sum);
        int counter = 0;
        for (Entry<T> entry : entries) {
            if (value >= counter && value < counter+entry.score) {
                return entry.payload;
            } else {
                counter += entry.score;
            }
        }
        System.err.println("Value: "+value);
        for (Entry<T> entry : entries) {
            System.err.println(entry.score + "\t\t"+entry.payload);
        }
        throw new RuntimeException("Roulette failure");
    }

    private static class Entry<T> {
        T payload;
        int score;

        public Entry(T payload, int score) {
            this.payload = payload;
            this.score = score;
        }
    }
}
