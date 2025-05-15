package tudor.foodScheduler.model;

import java.util.*;

public class Recipe {
    public String name;
    public List<IngredientEntry> ingredients;
    public List<Spice> spices;
    public Multiplicity multiplicity;
    public Fel fel;
    public Integer limit = null;

    public Recipe(String name, Multiplicity multiplicity, List<IngredientEntry> ingredients, Fel fel, List<Spice> spices) {
        if (ingredients.isEmpty()) throw new RuntimeException("Ingredients can't be empty");
        this.name = name;
        this.ingredients = ingredients;
        this.multiplicity = multiplicity;
        this.fel = fel;
        this.spices = spices;
    }

    public Recipe(String name, Multiplicity multiplicity, List<IngredientEntry> ingredients, Fel fel, List<Spice> spices, int limit) {
        this(name, multiplicity, ingredients, fel, spices);
        this.limit = limit;
    }

    public int getSeasonalityScore() {
        int smallestScore = Integer.MAX_VALUE;
        for (IngredientEntry ingredientEntry : ingredients) {
            int score = ingredientEntry.ingredient.getSeasonalityScore();
            if (score < smallestScore) smallestScore = score;
        }
        return smallestScore;
    }

    public String getName() {
        return name;
    }

    public static List<Recipe> extractLowPriorityRecipes(List<Recipe> input) {
        List<Recipe> lowPriorityRecipes = new LinkedList<>();
        for (Recipe recipe : input) {
            if (recipe.getSeasonalityScore() == Integer.MAX_VALUE) {
                lowPriorityRecipes.add(recipe);
            }
        }
        input.removeAll(lowPriorityRecipes);
        return lowPriorityRecipes;
    }

    public List<Integer> getDomesticSlots() {
        List<Integer> slots = new LinkedList<>(Months.ALL);
        for (IngredientEntry ingredientEntry : ingredients) {
            List<Integer> removedSlots = new ArrayList<>();
            for (Integer i : slots) {
                if (!ingredientEntry.ingredient.domesticMonths.contains(i)) {
                    removedSlots.add(i);
                }
            }

            slots.removeAll(removedSlots);
        }
        return slots;
    }

    public List<Integer> getImportSlots() {
        List<Integer> slots = new LinkedList<>(Months.ALL);
        for (IngredientEntry ingredientEntry : ingredients) {
            List<Integer> removedSlots = new ArrayList<>();
            for (Integer i : slots) {
                if (!ingredientEntry.ingredient.importMonths.contains(i)) {
                    removedSlots.add(i);
                }
            }
            slots.removeAll(removedSlots);
        }
        return slots;
    }

    public boolean hasIngredient(Ingredient ingredient) {
        for (IngredientEntry ingredientEntry : ingredients) {
            if (ingredientEntry.ingredient == ingredient) return true;
        }
        return false;
    }

    public boolean hasIngredientsInCommon(Recipe recipe) {
        for (IngredientEntry ingredientEntry : ingredients) {
            if (recipe.hasIngredient(ingredientEntry.ingredient)) return true;
            for (Ingredient aka : ingredientEntry.ingredient.akas) {
                if (recipe.hasIngredient(aka)) return true;
            }
        }
        return false;
    }

    /** human month */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isInSeason(int month) {
        for (IngredientEntry ingredientEntry : ingredients) {
            if (!(ingredientEntry.ingredient.importMonths.contains(month)
                    || ingredientEntry.ingredient.domesticMonths.contains(month))) return false;
        }
        return true;
    }

    public String toString() {
        return name;
    }

    public String toStringMultiplicity() {
        switch (multiplicity) {
            case AtLeastOnce -> {
                if (limit != null) return "1-"+limit;
                return "1+";
            }
            case Once -> {
                return "1";
            }
            case AtMostOnce -> {
                return "0-1";
            }
            case Disabled -> {
                return "0";
            }
            case Optional -> {
                return "0+";
            }
        }
        return "Undefined case: "+multiplicity;
    }
}
