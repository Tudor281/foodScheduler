package tudor.foodScheduler;

import tudor.foodScheduler.model.cookbook.Cookbook;
import tudor.foodScheduler.model.cookbook.FreeSlotsComputation;
import tudor.foodScheduler.model.cookbook.TudorCookBook;

public class DistinguishIngredientsRun {
    public static void main(String[] args) {
        Cookbook cookbook = TudorCookBook.getCookbook();

        FreeSlotsComputation freeSlotsComputation = cookbook.getOccupiedSlots();

        freeSlotsComputation.totalSlots = 52;

        freeSlotsComputation.computeFreeSlots();

        System.out.println("Tadaa");

        cookbook.calculateDistinguishedIngredients();
    }
}
