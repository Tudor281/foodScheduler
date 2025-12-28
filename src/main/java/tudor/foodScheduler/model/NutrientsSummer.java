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
                nfs.vitaminEWB = sum(nfs.vitaminEWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminE());
                nfs.vitaminKWB = sum(nfs.vitaminKWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminK());
                nfs.thiaminWB = sum(nfs.thiaminWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getThiamin());
                nfs.riboflavinWB = sum(nfs.riboflavinWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getRiboflavin());
                nfs.folateWB = sum(nfs.folateWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFolate());
                nfs.niacinWB = sum(nfs.niacinWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getNiacin());
                nfs.cholineWB = sum(nfs.cholineWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCholine());
                nfs.pantothenicAcidWB = sum(nfs.pantothenicAcidWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPantothenicAcid());
                nfs.calciumWB = sum(nfs.calciumWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCalcium());
                nfs.copperWB = sum(nfs.copperWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCopper());
                nfs.ironWB = sum(nfs.ironWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getIron());
                nfs.magnesiumWB = sum(nfs.magnesiumWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getMagnesium());
                nfs.manganeseWB = sum(nfs.manganeseWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getManganese());
                nfs.phosphorusWB = sum(nfs.phosphorusWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPhosphorus());
                nfs.potassiumWB = sum(nfs.potassiumWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPotassium());
                nfs.seleniumWB = sum(nfs.seleniumWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSelenium());
                nfs.sodiumWB = sum(nfs.sodiumWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSodium());
                nfs.zincWB = sum(nfs.zincWB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getZinc());
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
            nfs.vitaminE = sum(nfs.vitaminE, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminE());
            nfs.vitaminK = sum(nfs.vitaminK, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminK());
            nfs.thiamin = sum(nfs.thiamin, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getThiamin());
            nfs.riboflavin = sum(nfs.riboflavin, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getRiboflavin());
            nfs.folate = sum(nfs.folate, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFolate());
            nfs.niacin = sum(nfs.niacin, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getNiacin());
            nfs.choline = sum(nfs.choline, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCholine());
            nfs.pantothenicAcid = sum(nfs.pantothenicAcid, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPantothenicAcid());
            nfs.calcium = sum(nfs.calcium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCalcium());
            nfs.copper = sum(nfs.copper, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCopper());
            nfs.iron = sum(nfs.iron, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getIron());
            nfs.magnesium = sum(nfs.magnesium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getMagnesium());
            nfs.manganese = sum(nfs.manganese, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getManganese());
            nfs.phosphorus = sum(nfs.phosphorus, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPhosphorus());
            nfs.potassium = sum(nfs.potassium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPotassium());
            nfs.selenium = sum(nfs.selenium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSelenium());
            nfs.sodium = sum(nfs.sodium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSodium());
            nfs.zinc = sum(nfs.zinc, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getZinc());
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
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminB6 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminB6WB +";0))";
        }
        result += ")/(1.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminB12 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminB12WB +";0))";
        }
        result += ")/(2,4*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminC + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminCWB +";0))";
        }
        result += ")/(90*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminE + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminEWB +";0))";
        }
        result += ")/(15*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminK + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminKWB +";0))";
        }
        result += ")/(120*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().thiamin + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().thiaminWB +";0))";
        }
        result += ")/(1.2*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().riboflavin + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().riboflavinWB +";0))";
        }
        result += ")/(1.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().folate + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().folateWB +";0))";
        }
        result += ")/(400*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().niacin + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().niacinWB +";0))";
        }
        result += ")/(16*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().choline + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().cholineWB +";0))";
        }
        result += ")/(550*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().pantothenicAcid + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().pantothenicAcidWB +";0))";
        }
        result += ")/(5*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().calcium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().calciumWB +";0))";
        }
        result += ")/(1000*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().copper + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().copperWB +";0))";
        }
        result += ")/(0.9*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().iron + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().ironWB +";0))";
        }
        result += ")/(8*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().magnesium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().magnesiumWB +";0))";
        }
        result += ")/(420*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().manganese + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().manganese +";0))";
        }
        result += ")/(2.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().phosphorus + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().phosphorusWB +";0))";
        }
        result += ")/(700*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().potassium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().potassiumWB +";0))";
        }
        result += ")/(3400*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().selenium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().seleniumWB +";0))";
        }
        result += ")/(55*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().sodium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().sodiumWB +";0))";
        }
        result += ")/(1500*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsForSum> entry : nutrients.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().zinc + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().zincWB +";0))";
        }
        result += ")/(11*7)";

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

        float vitaminEWB;
        float vitaminE;

        float vitaminKWB;
        float vitaminK;

        float thiaminWB;
        float thiamin;

        float riboflavinWB;
        float riboflavin;

        float folateWB;
        float folate;

        float niacinWB;
        float niacin;

        float cholineWB;
        float choline;

        float pantothenicAcidWB;
        float pantothenicAcid;

        float calciumWB;
        float calcium;

        float copperWB;
        float copper;

        float ironWB;
        float iron;

        float magnesiumWB;
        float magnesium;

        float manganeseWB;
        float manganese;

        float phosphorusWB;
        float phosphorus;

        float potassiumWB;
        float potassium;

        float seleniumWB;
        float selenium;

        float sodiumWB;
        float sodium;

        float zincWB;
        float zinc;
    }
}
