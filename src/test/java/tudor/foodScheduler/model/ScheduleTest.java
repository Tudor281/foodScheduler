package tudor.foodScheduler.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    @Test
    void shouldCopyContents() {
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

        Recipe applePie = Recipe.get("Apple Pie");
        schedule.add(1, 1, applePie);

        assertTrue(schedule.isRecipePresent(applePie));
        assertSame(applePie, schedule.recipes.get(0).get(0).get(2));

        Schedule copy = schedule.copy();

        assertTrue(copy.isRecipePresent(applePie));
        assertSame(applePie, copy.recipes.get(0).get(0).get(2));

        Recipe ardei = Recipe.get("Ardei umpluți simplu");
        copy.add(1, 1, ardei);

        assertTrue(copy.isRecipePresent(ardei));
        assertFalse(schedule.isRecipePresent(ardei));

        assertSame(ardei, copy.recipes.get(0).get(0).get(1));
        assertNull(schedule.recipes.get(0).get(0).get(1));
    }
}