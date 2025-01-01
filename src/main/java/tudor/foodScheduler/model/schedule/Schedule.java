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
    Set<Recipe> recipesPresent = new HashSet<>();

    public Schedule(int[] weeksInMonth) {
        this.weeksInMonth = weeksInMonth;
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
        for (int month=0; month<12; month++) {
            Map<Integer, Map<Integer, ScheduleEntry>> monthContainer = new HashMap<>();
            this.recipes.put(month, monthContainer);
            for (int week=0; week<weeksInMonth[month]; week++) {
                Map<Integer, ScheduleEntry> weekContainer = new HashMap<>();
                monthContainer.put(week, weekContainer);

                Map<Integer, ScheduleEntry> otherWeekContainer = recipes.get(month).get(week);

                weekContainer.putAll(otherWeekContainer);
                for (ScheduleEntry entry : otherWeekContainer.values()) {
                    recipesPresent.add(entry.recipe);
                }
            }
        }
    }

    /** Real month and week numbers, starting from 1 */
    public void add(int month, int week, Recipe recipe) {
        recipes.get(month-1).get(week-1).put(getChannel(recipe), new ScheduleEntry(recipe, true));
        recipesPresent.add(recipe);
    }

    public void add(ScheduleSlot slot, Recipe recipe) {
        ScheduleEntry oldRecipe = recipes.get(slot.month).get(slot.week).put(getChannel(recipe), new ScheduleEntry(recipe, false));
        if (oldRecipe != null) throw new RuntimeException("Overwrite detected");
    }

    private int getChannel(Recipe recipe) {
        if (recipe.fel == Fel.F1) return 0;
        if (recipe.fel == Fel.F2) return 1;
        return 2;
    }

    public boolean isRecipePresent(Recipe recipe) {
        return recipesPresent.contains(recipe);
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
        double minIngredientDuplicates = 0;
        List<Ingredient> minIngredientsList = new ArrayList<>();
        for (Ingredient ingredient : Ingredient.values()) {
            List<ScheduleSlot> slots = getSlots(ingredient);
            double score = ScheduleSlot.computeDistanceHybrid(slots, weeksInMonth);
            if (score < minIngredientScore) {
                minIngredientScore = score;
                minIngredientDuplicates = score;
                minIngredientsList.clear();
                minIngredientsList.add(ingredient);
            } else if (score == minIngredientScore) {
                minIngredientDuplicates += minIngredientScore;
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
        return minIngredientDuplicates * (2 * avgIngredients + avgSpices);
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
}
