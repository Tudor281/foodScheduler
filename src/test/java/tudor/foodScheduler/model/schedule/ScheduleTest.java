package tudor.foodScheduler.model.schedule;

import org.junit.jupiter.api.Test;
import tudor.foodScheduler.Scheduler;
import tudor.foodScheduler.model.Recipe;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    @Test
    void shouldCopyContents() {
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

        Recipe applePie = Recipe.get("Apple Pie");
        schedule.add(1, 1, applePie);

        assertTrue(schedule.isRecipePresent(applePie));
        assertSame(applePie, schedule.recipes.get(0).get(0).get(2).recipe);

        Schedule copy = schedule.copy();

        assertTrue(copy.isRecipePresent(applePie));
        assertSame(applePie, copy.recipes.get(0).get(0).get(2).recipe);

        Recipe ardei = Recipe.get("Ardei umpluți simplu");
        copy.add(1, 1, ardei);

        assertTrue(copy.isRecipePresent(ardei));
        assertFalse(schedule.isRecipePresent(ardei));

        assertSame(ardei, copy.recipes.get(0).get(0).get(1).recipe);
        assertNull(schedule.recipes.get(0).get(0).get(1));
    }

    @Test
    void shouldDetectDuplicates() {
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});
        Recipe fasoleCuChimen = Recipe.get("Ciorbă de fasole - Cu chimen");
        Recipe fasoleCuDafin = Recipe.get("Ciorbă de fasole - Cu dafin");
        schedule.add(12, 4, fasoleCuChimen);
        schedule.add(1, 1, fasoleCuDafin);

        Duplication duplication = schedule.getIngredientDuplicate();
        assertNotNull(duplication);
        assertSame(fasoleCuChimen, duplication.recipe1);
        assertSame(fasoleCuDafin, duplication.recipe2);
    }
}