package tudor.foodScheduler.utils;

import java.util.*;

public class Counter<T> {
    private Map<T, Integer> counts = new HashMap<>();

    public void count(T item) {
        Integer count = counts.get(item);
        //noinspection Java8MapApi
        if (count == null) {
            counts.put(item, 1);
        } else {
            counts.put(item, count + 1);
        }
    }

    public void count(T item, int quantity) {
        Integer count = counts.get(item);
        //noinspection Java8MapApi
        if (count == null) {
            counts.put(item, quantity);
        } else {
            counts.put(item, count + quantity);
        }
    }

    public void deCount(T item) {
        Integer count = counts.get(item);
        if (count == null) {
            counts.put(item, -1);
        } else {
            counts.put(item, count -1);
        }
    }

    public int get(T item) {
        Integer count = counts.get(item);
        if (count == null) return 0;
        return count;
    }

    public List<Map.Entry<T, Integer>> getSortedDescending() {
        List<Map.Entry<T, Integer>> classification = new ArrayList<>(counts.entrySet());

        classification.sort(new Comparator<Map.Entry<T, Integer>>() {
            @Override
            public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        return classification;
    }

    public void clear() {
        counts.clear();
    }
}
