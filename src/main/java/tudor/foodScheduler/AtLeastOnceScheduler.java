package tudor.foodScheduler;

import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.Schedule;
import tudor.foodScheduler.model.ScheduleSlot;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class AtLeastOnceScheduler {
    Random random = new Random();

    public void addAtLeastOnceRecipes(Schedule schedule) throws Exception {
        // get at least once recipes

        List<Recipe> atLeastOnceRecipes = Recipe.getAtLeastOnceRecipes(schedule);

        List<Recipe> lowPriorityRecipes = Recipe.extractLowPriorityRecipes(atLeastOnceRecipes);

        atLeastOnceRecipes.sort(Comparator.comparingInt(Recipe::getSeasonalityScore));

        for (Recipe recipe : atLeastOnceRecipes) {
            add(recipe, schedule);
        }

        while(!lowPriorityRecipes.isEmpty()) {
            Recipe recipe = lowPriorityRecipes.remove(random.nextInt(lowPriorityRecipes.size()));
            add(recipe, schedule);
        }
    }

    private void add(Recipe recipe, Schedule schedule) throws Exception {
        List<ScheduleSlot> slots = schedule.getDomesticSlots(recipe);

        if (slots.isEmpty()) {
            slots = schedule.getImportSlots(recipe);
        }

        if (slots.isEmpty()) {
            throw new Exception("Can't find a slot");
        }

        schedule.add(slots.get(random.nextInt(slots.size())), recipe);
    }
}
