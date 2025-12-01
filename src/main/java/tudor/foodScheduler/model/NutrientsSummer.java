package tudor.foodScheduler.model;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("StringConcatenationInLoop")
public class NutrientsSummer {

    Map<Character, NutrientsForSum> nutrients = new HashMap<>();

    public void sum(Recipe recipe, int i) {
        NutrientsForSum nfs = new NutrientsForSum();
        nutrients.put((char) ('A' + (i - 1)), nfs);

        for (IngredientEntry ingredientEntry : recipe.ingredients) {
            Ingredient ingredient = ingredientEntry.ingredient;
            if (ingredient != Ingredient.Paine) {
                nfs.kCalWithoutBread = sum(nfs.kCalWithoutBread, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
            }
            nfs.kCal = sum(nfs.kCal, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
        }
    }

    float sum(float existing, float quantity, Float addend) {
        if (addend == null) return existing;
        return existing + (quantity / 100) * addend;
    }

    public String toString(int row) {
        String result = "=";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += " + IF ( "+entry.getKey()+row+" = \"B\" ; "+entry.getValue().kCal/7 + " ; IF ( "+entry.getKey() + row + " = \"Y\" ; "+entry.getValue().kCalWithoutBread/7+" ; 0 ))";
        }

        return result.replace(".", ",");
    }

    static class NutrientsForSum {
        public float kCal = 0;
        public float kCalWithoutBread = 0;
    }
}
