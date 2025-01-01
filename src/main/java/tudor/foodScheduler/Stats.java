package tudor.foodScheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.model.Ingredient;

import java.util.*;

public class Stats {
    private static final Logger logger = LoggerFactory.getLogger(Stats.class);

    static Map<Ingredient, Integer> counts = new HashMap<>();

    public static void add(Ingredient ingredient) {
        Integer count = counts.get(ingredient);
        if (count == null) {
            counts.put(ingredient, 1);
        } else {
            counts.put(ingredient, count + 1);
        }
    }

    public static void report() {
        List<Map.Entry<Ingredient, Integer>> classification = new ArrayList<>(counts.entrySet());

        classification.sort(new Comparator<Map.Entry<Ingredient, Integer>>() {
            @Override
            public int compare(Map.Entry<Ingredient, Integer> o1, Map.Entry<Ingredient, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Ingredient, Integer> entry : classification) {
            logger.info("{} -> {}", entry.getKey(), entry.getValue());
        }
    }
}
