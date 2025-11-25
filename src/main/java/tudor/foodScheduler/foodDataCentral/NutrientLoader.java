package tudor.foodScheduler.foodDataCentral;

import tudor.foodScheduler.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class NutrientLoader {
    static final String fdcPath = "/Food Data Central/All/";

    public void load() {
        Map<String, Ingredient> fdcIngredientMap = new HashMap<>();

        for (Ingredient ingredient : Ingredient.values()) {
            fdcIngredientMap.put(ingredient.fdcCode, ingredient);
        }


    }
}
