package tudor.foodScheduler;

import tudor.foodScheduler.model.Recipe;

public class Inspector {
    final static Recipe recipe = Recipe.get("American Potato Salad");

    public static void check(Recipe candidate) {
        if (candidate == recipe) throw new RuntimeException("We got it");
    }
}
