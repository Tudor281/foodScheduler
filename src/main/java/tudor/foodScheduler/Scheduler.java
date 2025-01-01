package tudor.foodScheduler;

import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleSlot;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Scheduler {
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

    public void fillInOtherRecipes(Schedule schedule) {
        int counter = 0;
        while(schedule.hasFreeSlots()) {
            List<Recipe> supplementalRecipes = Recipe.getSupplementalRecipes(schedule);

            Recipe recipe = supplementalRecipes.remove(random.nextInt(supplementalRecipes.size()));

            try {
                add(recipe, schedule);
            } catch (Exception ignored) {
            }
            counter ++;
            if (counter>1000) throw new RuntimeException("Run out of attempts, wtf");
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

    public void eliminateDuplicates(Schedule schedule) {
        boolean hasDuplicates = true;

        do {

            schedule.countRecipes();
        } while (hasDuplicates);
    }
}
