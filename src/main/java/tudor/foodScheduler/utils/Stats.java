package tudor.foodScheduler.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.model.Ingredient;

import java.util.*;

public class Stats {
    private static final Logger logger = LoggerFactory.getLogger(Stats.class);

    static Counter<Ingredient> minScoreIngredientCounts = new Counter<>();

    static int optimalInsertionFailures = 0;
    static int suitableReplacementsNotFound = 0;
    static int runOutOfOptimalInsertsAttempts = 0;
    static int optimalInsertsConstrained = 0;
    static int swapsEndedPrematurely = 0;
    static int swapsExecuted = 0;

    public static void addMinScoreIngredient(Ingredient ingredient) {
        minScoreIngredientCounts.count(ingredient);
    }

    public static void countSwapsEndedPrematurely() {swapsEndedPrematurely++; }
    public static void countSwapsExecuted() {swapsExecuted++; }


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
        List<Map.Entry<Ingredient, Integer>> classification = minScoreIngredientCounts.getSortedDescending();

        for (Map.Entry<Ingredient, Integer> entry : classification) {
            logger.info("{} -> {}", entry.getKey(), entry.getValue());
        }

        logger.info("Optimal insert failures: {}", optimalInsertionFailures);
        logger.info("Suitable replacements not found: {}", suitableReplacementsNotFound);
        logger.info("Run out of optimal inserts attempts: {}", runOutOfOptimalInsertsAttempts);
        logger.info("Optimal Inserts constraints lock: {}", optimalInsertsConstrained);
        logger.info("Swaps ended prematurely: {}", swapsEndedPrematurely);
        logger.info("Swaps executed: {}", swapsExecuted);
    }
}
