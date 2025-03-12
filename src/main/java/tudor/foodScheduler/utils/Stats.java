package tudor.foodScheduler.utils;

import tudor.foodScheduler.model.Ingredient;

import java.util.*;

public class Stats {
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
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Optimal insert failures: "+ optimalInsertionFailures);
        System.out.println("Suitable replacements not found: "+ suitableReplacementsNotFound);
        System.out.println("Run out of optimal inserts attempts: "+ runOutOfOptimalInsertsAttempts);
        System.out.println("Optimal Inserts constraints lock: "+ optimalInsertsConstrained);
        System.out.println("Swaps ended prematurely: "+ swapsEndedPrematurely);
        System.out.println("Swaps executed: "+ swapsExecuted);
    }
}
