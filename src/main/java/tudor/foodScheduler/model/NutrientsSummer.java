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
                nfs.kCalWB = sum(nfs.kCalWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
                nfs.kCalProteinWB = sum(nfs.kCalProteinWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein() * 4);
                nfs.kCalFatWB = sum(nfs.kCalFatWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFat() * 9);
                nfs.kCalCarbsWB = sum(nfs.kCalCarbsWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCarbs() * 4);
                nfs.gProteinWB = sum(nfs.gProteinWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein());
            }
            nfs.kCal = sum(nfs.kCal, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
            nfs.kCalProtein = sum(nfs.kCalProtein, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein() * 4);
            nfs.kCalFat = sum(nfs.kCalFat, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFat() * 9);
            nfs.kCalCarbs = sum(nfs.kCalCarbs, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCarbs() * 4);
            nfs.gProtein = sum(nfs.gProtein, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein());
        }
    }

    float sum(float existing, float quantity, Float addend) {
        if (addend == null) return existing;
        return existing + (quantity / 100) * addend;
    }

    public String toString(int row, int start) {
        String result = "=";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += " + IF ( "+entry.getKey()+row+" = \"B\" ; "+entry.getValue().kCal/7 + " ; IF ( "+entry.getKey() + row + " = \"Y\" ; "+entry.getValue().kCalWB /7+" ; 0 ))";
        }

        result += "\t = (";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += " + IF ( "+entry.getKey()+row+" = \"B\" ; "+entry.getValue().kCalProtein + " ; IF ( "+entry.getKey() + row + " = \"Y\" ; "+entry.getValue().kCalProteinWB +" ; 0 ))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t = (";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += " + IF ( "+entry.getKey()+row+" = \"B\" ; "+entry.getValue().kCalFat + " ; IF ( "+entry.getKey() + row + " = \"Y\" ; "+entry.getValue().kCalFatWB+" ; 0 ))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t = (";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += " + IF ( "+entry.getKey()+row+" = \"B\" ; "+entry.getValue().kCalCarbs + " ; IF ( "+entry.getKey() + row + " = \"Y\" ; "+entry.getValue().kCalCarbsWB+" ; 0 ))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t = (";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += " + IF ( "+entry.getKey()+row+" = \"B\" ; "+entry.getValue().gProtein + " ; IF ( "+entry.getKey() + row + " = \"Y\" ; "+entry.getValue().gProteinWB +" ; 0 ))";
        }
        // Minimum official US RDA
        result += ")/("+0.8 * 115 +"*7)";

        return result.replace(".", ",");
    }

    static class NutrientsForSum {
        float kCal = 0;
        float kCalWB = 0; // without bread

        float kCalProteinWB;
        float kCalFatWB;
        float kCalCarbsWB;
        float kCalProtein;
        float kCalFat;
        float kCalCarbs;

        float gProtein;
        float gProteinWB;
    }
}
