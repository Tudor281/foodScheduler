package tudor.foodScheduler.model.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.Stats;
import tudor.foodScheduler.model.*;

import java.util.*;

@SuppressWarnings("StringConcatenationInLoop")
public class Schedule {
    private static final Logger logger = LoggerFactory.getLogger(Schedule.class);

    // month -> week -> channel -> Recipe
    // channels: 0 F1, 1 F2, 3, AUX
    Map<Integer, Map<Integer, Map<Integer, ScheduleEntry>>> recipes = new HashMap<>();
    int[] weeksInMonth;
    int numberOfWeeks;

    public Schedule(int[] weeksInMonth) {
        this.weeksInMonth = weeksInMonth;
        calculateNumberOfWeeks();
        for (int month=0; month<12; month++) {
            Map<Integer, Map<Integer, ScheduleEntry>> monthContainer = new HashMap<>();
            recipes.put(month, monthContainer);
            for (int week=0; week<weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> weekContainer = new HashMap<>();
                monthContainer.put(week, weekContainer);
            }
        }
    }

    private Schedule(int[] weeksInMonth, Map<Integer, Map<Integer, Map<Integer, ScheduleEntry>>> recipes) {
        this.weeksInMonth = weeksInMonth;
        calculateNumberOfWeeks();
        for (int month=0; month<12; month++) {
            Map<Integer, Map<Integer, ScheduleEntry>> monthContainer = new HashMap<>();
            this.recipes.put(month, monthContainer);
            for (int week=0; week<weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> weekContainer = new HashMap<>();
                monthContainer.put(week, weekContainer);

                Map<Integer, ScheduleEntry> otherWeekContainer = recipes.get(month).get(week);

                weekContainer.putAll(otherWeekContainer);
                for (ScheduleEntry entry : otherWeekContainer.values()) {
                    count(entry.recipe);
                }
            }
        }
    }

    private void calculateNumberOfWeeks() {
        for (int i=0; i<12; i++) {
            numberOfWeeks += weeksInMonth[i];
        }
    }

    /** Real month and week numbers, starting from 1 */
    public void add(int month, int week, Recipe recipe, boolean initialConstraint) {
        ScheduleEntry oldEntry = recipes.get(month-1).get(week-1).put(getChannel(recipe), new ScheduleEntry(recipe, initialConstraint));
        count(recipe);
        if (oldEntry != null) dec(oldEntry.recipe);
    }

    public void add(ScheduleSlot slot, Recipe recipe) {
        ScheduleEntry oldEntry = recipes.get(slot.month).get(slot.week).put(getChannel(recipe), new ScheduleEntry(recipe, false));
        count(recipe);
        if (oldEntry != null) dec(oldEntry.recipe);
    }

    private int getChannel(Recipe recipe) {
        if (recipe.fel == Fel.F1) return 0;
        if (recipe.fel == Fel.F2) return 1;
        return 2;
    }

    public boolean isRecipePresent(Recipe recipe) {
        return recipeCounts.containsKey(recipe);
    }

    public String toString() {
        String result = "";
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                result += toString(month, week);
            }
        }
        return result;
    }

    String toString(int month, int week) {
        return (month + 1) + "\t" + (week + 1)
                + '\t' + getName(month, week, 0)
                + '\t' + getName(month, week, 1)
                + '\t' + getName(month, week, 2)
                + '\n';
    }

    String getName(int month, int week, int channel) {
        ScheduleEntry entry = recipes.get(month).get(week).get(channel);
        if (entry == null) return "";
        return entry.recipe.name;
    }

    public List<ScheduleSlot> getDomesticSlots(Recipe recipe) {
        return getSlotsForMonths(recipe.getDomesticSlots(), getChannel(recipe));
    }

    public List<ScheduleSlot> getImportSlots(Recipe recipe) {
        return getSlotsForMonths(recipe.getImportSlots(), getChannel(recipe));
    }

    private List<ScheduleSlot> getSlotsForMonths(List<Integer> months, int channel) {
        List<ScheduleSlot> slots = new ArrayList<>();

        for (Integer month : months) {
            for (int week = 0; week < weeksInMonth[month-1]; week++) {
                if (recipes.get(month-1).get(week).get(channel) == null) {
                    slots.add(new ScheduleSlot(month-1, week));
                }
            }
        }

        return slots;
    }

    public boolean hasFreeSlots() {
        for (int month=0; month<12; month++) {
            for (int week=0; week<weeksInMonth[month]; week++) {
                if (recipes.get(month).get(week).get(0) == null) return true;
                if (recipes.get(month).get(week).get(1) == null) return true;
            }
        }
        return false;
    }

    /** The higher the score, the higher the distance between various ingredients */
    public double getScoreExp() {
        double score = 0;
        for (Ingredient ingredient : Ingredient.values()) {
            List<ScheduleSlot> slots = getSlots(ingredient);
            score += ScheduleSlot.computeDistanceExp(slots, weeksInMonth);
        }
        for (Spice spice : Spice.values()) {
            List<ScheduleSlot> slots = getSlots(spice);
            score += ScheduleSlot.computeDistanceExp(slots, weeksInMonth);
        }
        return score;
    }

    /** The higher the score, the higher the distance between various ingredients */
    public double getScore() {

        double ingredientSum = 0;
        double minIngredientScore = Integer.MAX_VALUE;
        List<Ingredient> minIngredientsList = new ArrayList<>();
        for (Ingredient ingredient : Ingredient.values()) {
            List<ScheduleSlot> slots = getSlots(ingredient);
            double score = ScheduleSlot.computeDistanceHybrid(slots, weeksInMonth);
            if (score < minIngredientScore) {
                minIngredientScore = score;
                minIngredientsList.clear();
                minIngredientsList.add(ingredient);
            } else if (score == minIngredientScore) {
                minIngredientsList.add(ingredient);
            }
            ingredientSum += score;
        }

        for (Ingredient ingredient : minIngredientsList) {
            Stats.add(ingredient);
        }

        double spiceSum = 0;
        for (Spice spice : Spice.values()) {
            List<ScheduleSlot> slots = getSlots(spice);
            spiceSum += ScheduleSlot.computeDistanceHybrid(slots, weeksInMonth);
        }
        double avgIngredients = ingredientSum / Ingredient.values().length;
        double avgSpices = spiceSum / Spice.values().length;
//        logger.info("MinDupliates {} \t avgIngredients {} \t avgSpices {} \t", minIngredientDuplicates, avgIngredients, avgSpices);
        return 2 * avgIngredients + avgSpices;
    }

    List<ScheduleSlot> getSlots(Ingredient ingredient) {
        List<ScheduleSlot> slots = new ArrayList<>();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> channelsContainer = recipes.get(month).get(week);
                if (channelsContainer == null) throw new RuntimeException("Schedule is not filled");

                for (ScheduleEntry entry : channelsContainer.values()) {
                    if (entry.recipe.ingredients.contains(ingredient)) {
                        slots.add(new ScheduleSlot(month, week));
                    }
                }
            }
        }
        return slots;
    }

    List<ScheduleSlot> getSlots(Spice spice) {
        List<ScheduleSlot> slots = new ArrayList<>();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> channelsContainer = recipes.get(month).get(week);
                if (channelsContainer == null) throw new RuntimeException("Schedule is not filled");

                for (ScheduleEntry entry : channelsContainer.values()) {
                    if (entry.recipe.spices.contains(spice)) {
                        slots.add(new ScheduleSlot(month, week));
                    }
                }
            }
        }
        return slots;
    }

    public Schedule copy() {
        return new Schedule(weeksInMonth, recipes);
    }

    public Map<Recipe, Integer> recipeCounts = new HashMap<>();
    public void countRecipes() {
        recipeCounts.clear();
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                for (int channel = 0; channel < 3; channel ++) {
                    ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                    if (entry == null) continue; // especially channel 3 recipes are optional
                    Integer count = recipeCounts.get(entry.recipe);
                    //noinspection Java8MapApi
                    if (count == null) {
                        recipeCounts.put(entry.recipe, 1);
                    } else {
                        recipeCounts.put(entry.recipe, count + 1);
                    }
                }
            }
        }
    }

    void count(Recipe recipe) {
        Integer count = recipeCounts.get(recipe);
        //noinspection Java8MapApi
        if (count == null) {
            recipeCounts.put(recipe, 1);
        } else {
            recipeCounts.put(recipe, count+1);
        }
    }

    void dec(Recipe recipe) {
        Integer count = recipeCounts.get(recipe);
        if (count == null || count <= 0) {
            throw new RuntimeException("Removing a recipe that has not been counted");
        }
        recipeCounts.put(recipe, count - 1);
    }

    public Duplication getIngredientDuplicate() {
        int prevMonth = 11;
        int prevWeek = weeksInMonth[11]-1;
        Map<Integer, ScheduleEntry> prevRow = recipes.get(prevMonth).get(prevWeek); // december 31st
        for (int month=0; month<12; month++) {
            for (int week = 0; week < weeksInMonth[month]; week++) {
                for (int channel = 0; channel < 3; channel++) {
                    ScheduleEntry prevEntry = prevRow.get(channel);
                    ScheduleEntry entry = recipes.get(month).get(week).get(channel);
                    if (prevEntry == null || entry == null) continue; // we could have empty slots, especially on channel 3
                    if (prevEntry.recipe.hasIngredientsInCommon(entry.recipe) && !(prevEntry.initialConstraint && entry.initialConstraint)) {
                        return new Duplication(
                                new ScheduleSlot(prevMonth, prevWeek, hasConstraints(prevEntry)),
                                prevEntry.recipe,
                                new ScheduleSlot(month, week, hasConstraints(entry)),
                                entry.recipe);
                    }
                }
                prevMonth = month;
                prevWeek = week;
                prevRow = recipes.get(month).get(week);
            }
        }
        return null;
    }

    boolean hasConstraints(ScheduleEntry entry) {
        if (entry.initialConstraint) {
//            logger.debug("{} is initial constraint", entry.recipe);
            return true;
        }

        Recipe recipe = entry.recipe;

        if (recipe.multiplicity == Multiplicity.AtLeastOnce && recipeCounts.get(recipe) < 2) {
//            logger.debug("{} at least once and exists", recipe);
            return true;
        }

        //noinspection RedundantIfStatement
        if (recipe.multiplicity == Multiplicity.Once) {
//            logger.debug("{} is at least once", recipe);
            return true;
        }

        return false;
    }

    public List<Recipe> getSuitableReplacements(ScheduleSlot slot, Recipe recipe) {
        int greatestDistance = Integer.MIN_VALUE;
        List<Recipe> bestRecipes = new ArrayList<>();
        for (Recipe candidate : Recipe.all.values()) {
            if (candidate.fel != recipe.fel) continue;

            if (!canAdd(candidate)) continue;

            if (!candidate.isInSeason(slot.getHumanMonth())) continue;

            int distance = getDistance(slot, candidate.ingredients, getChannel(recipe));
            if (distance>greatestDistance) {
                greatestDistance = distance;
                bestRecipes.clear();
                bestRecipes.add(candidate);
            } else if (distance == greatestDistance) {
                bestRecipes.add(candidate);
            }
        }
        return bestRecipes;
    }

    private boolean canAdd(Recipe recipe) {
        switch (recipe.multiplicity) {
            case AtLeastOnce -> {
                //noinspection RedundantIfStatement
                if (recipe.limit != null && recipeCounts.get(recipe) != null && recipe.limit >= recipeCounts.get(recipe)) return false;
                return true;
            }
            case AtMostOnce, Once -> {
                return !recipeCounts.containsKey(recipe);
            }
            case Disabled -> {
                return false;
            }
            case Optional -> {
                return true;
            }
        }
        throw new RuntimeException("Stupid java");
    }

    int getDistance(ScheduleSlot slot, List<Ingredient> ingredients, int channel) {
        ScheduleSlot forwardIterator = slot.copy();
        ScheduleSlot backwardIterator = slot.copy();
        int counter = 0;
        do {
            forwardIterator.increment(weeksInMonth);
            if (hasCommonIngredients(forwardIterator, ingredients, channel)) return counter;
            backwardIterator.decrement(weeksInMonth);
            if (hasCommonIngredients(backwardIterator, ingredients, channel)) return counter;

            counter++;
        } while (counter<numberOfWeeks);
        return counter;
    }

    boolean hasCommonIngredients(ScheduleSlot slot, List<Ingredient> ingredients, int channel) {
        ScheduleEntry entry = recipes.get(slot.month).get(slot.week).get(channel);
        if (entry == null) return false;
        for (Ingredient ingredient : ingredients) {
            if (entry.recipe.ingredients.contains(ingredient)) return true;
        }
        return false;
    }
}
