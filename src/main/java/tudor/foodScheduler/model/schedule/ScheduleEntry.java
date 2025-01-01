package tudor.foodScheduler.model.schedule;

import tudor.foodScheduler.model.Recipe;

public class ScheduleEntry {
    Recipe recipe;
    boolean initialConstraint = false;

    public ScheduleEntry(Recipe recipe, boolean initialConstraint) {
        this.recipe = recipe;
        this.initialConstraint = initialConstraint;
    }
}
