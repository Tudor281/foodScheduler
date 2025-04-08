package tudor.foodScheduler;

import tudor.foodScheduler.model.Fel;
import tudor.foodScheduler.model.Multiplicity;
import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.cookbook.TudorCookBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stats {
    public static void main(String[] args) {
        Fel fel = Fel.F2;

        List<Recipe> recipes = TudorCookBook.getCookbook().getAll();
        recipes.sort(new Comparator<Recipe>() {
            @Override
            public int compare(Recipe o1, Recipe o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        int atLeastOnce = 0;
        int once = 0;
        System.out.println("At least once");
        for (Recipe recipe : recipes) {
            if (recipe.fel != fel) continue;
            if (!(recipe.multiplicity == Multiplicity.Once || recipe.multiplicity == Multiplicity.AtLeastOnce)) continue;
            System.out.println(recipe.toStringMultiplicity() + " " + recipe);
            if (recipe.multiplicity == Multiplicity.Once) once++;
            if (recipe.multiplicity == Multiplicity.AtLeastOnce) atLeastOnce++;
        }

        int atMostOnce = 0;
        int optional = 0;
        System.out.println();
        System.out.println("Extra");
        for (Recipe recipe : recipes) {
            if (recipe.fel != fel) continue;
            if (!(recipe.multiplicity == Multiplicity.AtMostOnce || recipe.multiplicity == Multiplicity.Optional)) continue;
            System.out.println(recipe.toStringMultiplicity() + " " + recipe);
            if (recipe.multiplicity == Multiplicity.AtMostOnce) atMostOnce++;
            if (recipe.multiplicity == Multiplicity.Optional) optional++;
        }

        System.out.println();
        System.out.println();
        System.out.println("At least once: "+atLeastOnce);
        System.out.println("Once: "+once);
        System.out.println("Optional: "+optional);
        System.out.println("At most once: "+atMostOnce);
    }
}
