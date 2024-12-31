package tudor.foodScheduler.model;

import java.util.*;

@SuppressWarnings("StringConcatenationInLoop")
public class Schedule {

    // month -> week -> channel -> Recipe
    // channels: 0 F1, 1 F2, 3, AUX
    Map<Integer, Map<Integer, Map<Integer, Recipe>>> recipes = new HashMap<>();
    int[] weeksInMonth;
    Set<Recipe> recipesPresent = new HashSet<>();

    public Schedule(int[] weeksInMonth) {
        this.weeksInMonth = weeksInMonth;
        for (int i=0; i<12; i++) {
            Map<Integer, Map<Integer, Recipe>> month = new HashMap<>();
            recipes.put(i, month);
            for (int j=0; j<weeksInMonth[i]; j++) {
                Map<Integer, Recipe> week = new HashMap<>();
                month.put(j, week);
            }
        }
    }

    /** Real month and week numbers, starting from 1 */
    public void add(int month, int week, Recipe recipe) {
        recipes.get(month-1).get(week-1).put(getChannel(recipe), recipe);
        recipesPresent.add(recipe);
    }

    public void add(ScheduleSlot slot, Recipe recipe) {
        Recipe oldRecipe = recipes.get(slot.month).get(slot.week).put(getChannel(recipe), recipe);
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
        for (int i=0; i<12; i++) {
            for (int j=0; j<weeksInMonth[i]; j++) {
                result += toString(i, j);
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
        Recipe recipe = recipes.get(month).get(week).get(channel);
        if (recipe == null) return "";
        return recipe.name;
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
}
