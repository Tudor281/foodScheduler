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
                nfs.vitaminARaeWB = sum(nfs.vitaminARaeWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminARAE());
                nfs.vitaminCWB = sum(nfs.vitaminCWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminC());
                nfs.vitaminB6WB = sum(nfs.vitaminB6WB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB6());
                nfs.vitaminB12WB = sum(nfs.vitaminB12WB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB12());
            }
            nfs.kCal = sum(nfs.kCal, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
            nfs.kCalProtein = sum(nfs.kCalProtein, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein() * 4);
            nfs.kCalFat = sum(nfs.kCalFat, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFat() * 9);
            nfs.kCalCarbs = sum(nfs.kCalCarbs, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCarbs() * 4);
            nfs.gProtein = sum(nfs.gProtein, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein());
            nfs.vitaminARae = sum(nfs.vitaminARae, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminARAE());
            nfs.vitaminC = sum(nfs.vitaminC, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminC());
            nfs.vitaminB6 = sum(nfs.vitaminB6, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB6());
            nfs.vitaminB12 = sum(nfs.vitaminB12, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB12());
        }
    }

    float sum(float existing, float quantity, Float addend) {
        if (addend == null) return existing;
        return existing + (quantity / 100) * addend;
    }

    public String toString(int row, int start) {
        String result = "=";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCal/7 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalWB /7+";0))";
        }

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCalProtein + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalProteinWB +";0))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCalFat + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalFatWB+";0))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCalCarbs + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalCarbsWB+";0))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().gProtein + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().gProteinWB +";0))";
        }
        // Minimum official US RDA
        result += ")/(0.8 * 115 *7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminARae + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminARaeWB +";0))";
        }
        result += ")/(900*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminC + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminCWB +";0))";
        }
        result += ")/(90*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminB6 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminB6WB +";0))";
        }
        result += ")/(1.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminB12 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminB12WB +";0))";
        }
        result += ")/(2,4*7)";

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

        float vitaminARaeWB;
        float vitaminARae;

        float vitaminCWB;
        float vitaminC;

        float vitaminB6WB;
        float vitaminB6;

        float vitaminB12WB;
        float vitaminB12;
    }
}
