package tudor.foodScheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.model.Ingredient;

import java.util.*;

public class Stats {
    private static final Logger logger = LoggerFactory.getLogger(Stats.class);

    static Map<Ingredient, Integer> counts = new HashMap<>();

    static int optimalInsertionFailures = 0;
    static int suitableReplacementsNotFound = 0;
    static int runOutOfOptimalInsertsAttempts = 0;
    static int optimalInsertsConstrained = 0;

    public static void add(Ingredient ingredient) {
        Integer count = counts.get(ingredient);
        if (count == null) {
            counts.put(ingredient, 1);
        } else {
            counts.put(ingredient, count + 1);
        }
    }

    public static void countOptimalInsertFailure() {
        optimalInsertionFailures++;
    }

    public static void countSuitableReplacementsNotFound() {
        suitableReplacementsNotFound++;
    }

    public static void countRunOutOfOptimalInsertsAttempts() {
        runOutOfOptimalInsertsAttempts++;
    }

    public static void countOptimalInsertsConstrained() {
        optimalInsertsConstrained++;
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

        logger.info("Optimal insert failures: {}", optimalInsertionFailures);
        logger.info("Suitable replacements not found: {}", suitableReplacementsNotFound);
        logger.info("Run out of optimal inserts attempts: {}", runOutOfOptimalInsertsAttempts);
        logger.info("Optimal Inserts constraints lock: {}", optimalInsertsConstrained);
    }
}
