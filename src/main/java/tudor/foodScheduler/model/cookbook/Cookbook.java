package tudor.foodScheduler.model.cookbook;

import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.utils.Roulette;

import java.util.*;

import static tudor.foodScheduler.model.Multiplicity.*;
import static tudor.foodScheduler.model.Multiplicity.AtMostOnce;

public class Cookbook {
    public final Map<String, Recipe> all = new HashMap<>();

    void add(Recipe recipe) {
        all.put(recipe.getName(), recipe);
    }

    public Recipe get(String name) {
        Recipe recipe = all.get(name);
        if (recipe == null) throw new RuntimeException("Recipe not found: "+name);
        return recipe;
    }

    public List<Recipe> getAll() {
        return new ArrayList<>(all.values());
    }

    public List<Recipe> getAtLeastOnceRecipes(Schedule schedule) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : all.values()) {
            if (!(recipe.multiplicity == AtLeastOnce || recipe.multiplicity == Once)) continue;

            if (schedule.isRecipePresent(recipe)) continue;

            result.add(recipe);
        }
        return result;
    }

    public Roulette<Recipe> getSupplementalRecipes(Schedule schedule) {
        Map<Recipe, Integer> counts = new HashMap<>();
        int maxCounts = 0;
        for (Recipe recipe : all.values()) {
            if (recipe.multiplicity == Disabled || recipe.multiplicity == Once) continue;

            if (recipe.multiplicity == AtMostOnce) {
                if (schedule.isRecipePresent(recipe)) continue;
            }

            if (schedule.reachedLimit(recipe)) continue;

            //also if (recipe.multiplicity == AtLeastOnce || recipe.multiplicity == Optional)
            int recipeCounts = schedule.recipeCounts.get(recipe);
            counts.put(recipe, recipeCounts);
            if (maxCounts < recipeCounts) maxCounts = recipeCounts;
        }

        maxCounts++; // such that maxCount items have score 1. Also works beautifully if maxCount is 0

        Roulette<Recipe> roulette = new Roulette<>();
        for (Map.Entry<Recipe, Integer> entry : counts.entrySet()) {
            roulette.add(entry.getKey(), maxCounts - entry.getValue());
        }

        return roulette;
    }
}
