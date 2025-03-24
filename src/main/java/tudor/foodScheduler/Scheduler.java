package tudor.foodScheduler;

import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.schedule.Duplication;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleSlot;
import tudor.foodScheduler.model.schedule.SchedulingException;
import tudor.foodScheduler.utils.Roulette;
import tudor.foodScheduler.utils.Stats;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Scheduler {
    public void addAtLeastOnceRecipes(Schedule schedule) throws Exception {
        // get at least once recipes

        List<Recipe> atLeastOnceRecipes = Recipe.getAtLeastOnceRecipes(schedule);

        List<Recipe> lowPriorityRecipes = Recipe.extractLowPriorityRecipes(atLeastOnceRecipes);

        atLeastOnceRecipes.sort(Comparator.comparingInt(Recipe::getSeasonalityScore));

        for (Recipe recipe : atLeastOnceRecipes) {
            add(recipe, schedule);
        }

        while(!lowPriorityRecipes.isEmpty()) {
            Recipe recipe = lowPriorityRecipes.remove(InitialRun.random.nextInt(lowPriorityRecipes.size()));
            add(recipe, schedule);
        }
    }

    public void fillInOtherRecipes(Schedule schedule) {
        int counter = 0;
        while(schedule.hasFreeSlots()) {
            Roulette<Recipe> supplementalRecipes = Recipe.getSupplementalRecipes(schedule);

            Recipe recipe = supplementalRecipes.getRandom();

            try {
                add(recipe, schedule);
            } catch (Exception ignored) {} // we might have filled up certain categories
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
            throw new Exception("Can't find a slot for "+recipe.getName());
        }

        schedule.add(slots.get(InitialRun.random.nextInt(slots.size())), recipe);
    }

    public void eliminateDuplicates(Schedule schedule) throws SchedulingException {
        int count = 0;
        do {
            Duplication duplication = schedule.getIngredientDuplicate();
            if (duplication == null) return;

            int constraintCount = duplication.getNumberOfConstraints();
            if (constraintCount == 2) {
                Stats.countOptimalInsertsConstrained();
                throw new SchedulingException("Can't deduplicate constrained recipies");
            }

            ScheduleSlot targetSlot;
            Recipe targetRecipe;

            if (constraintCount == 1) {
                if (duplication.slot1.hasConstraints()) {
                    targetSlot = duplication.slot2;
                    targetRecipe = duplication.recipe2;
                } else {
                    targetSlot = duplication.slot1;
                    targetRecipe = duplication.recipe1;
                }
            } else { // constraint 0
                if (InitialRun.random.nextBoolean()) {
                    targetSlot = duplication.slot2;
                    targetRecipe = duplication.recipe2;
                } else {
                    targetSlot = duplication.slot1;
                    targetRecipe = duplication.recipe1;
                }
            }

            List<Recipe> suitableReplacements = schedule.getSuitableReplacements(0, targetSlot, targetRecipe);

            if (suitableReplacements.isEmpty()) {
                Stats.countSuitableReplacementsNotFound();
                throw new SchedulingException("No suitable replacements exist");
            }

            schedule.add(targetSlot, suitableReplacements.get(InitialRun.random.nextInt(suitableReplacements.size())));
        } while (count++ < 100);
        Stats.countRunOutOfOptimalInsertsAttempts();
        throw new SchedulingException("Run out of attempts to deduplicate schedule");
    }
}
