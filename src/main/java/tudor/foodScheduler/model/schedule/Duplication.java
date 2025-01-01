package tudor.foodScheduler.model.schedule;

import tudor.foodScheduler.model.Recipe;

import java.util.Map;

/** I call duplication when you have ciorba de fasole cu leustean apoi ciorba de fasole cu chimen */
public class Duplication {
    public ScheduleSlot slot1;
    public Recipe recipe1;

    public ScheduleSlot slot2;
    public Recipe recipe2;

    public Duplication(ScheduleSlot slot1, Recipe recipe1, ScheduleSlot slot2, Recipe recipe2) {
        this.slot1 = slot1;
        this.recipe1 = recipe1;
        this.slot2 = slot2;
        this.recipe2 = recipe2;
    }

    public int getNumberOfConstraints() {
        int count = 0;
        if (slot1.hasConstraints) count ++;
        if (slot2.hasConstraints) count ++;
        return count;
    }
}
