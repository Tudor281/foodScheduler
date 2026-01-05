package tudor.foodScheduler.model.nutrients;

import tudor.foodScheduler.model.Ingredient;
import tudor.foodScheduler.model.IngredientEntry;
import tudor.foodScheduler.model.Recipe;

public class NutrientsSummer {
    public float kCal = 0;
    public float kCalNB = 0; // without bread

    public float kCalProteinNB;
    public float kCalFatNB;
    public float kCalCarbsNB;
    public float kCalProtein;
    public float kCalFat;
    public float kCalCarbs;

    public float gProtein;
    public float gProteinNB;

    public float vitaminARaeNB;
    public float vitaminARae;

    public float vitaminCNB;
    public float vitaminC;

    public float vitaminB6NB;
    public float vitaminB6;

    public float vitaminB12NB;
    public float vitaminB12;

    public float vitaminENB;
    public float vitaminE;

    public float vitaminKNB;
    public float vitaminK;

    public float thiaminNB;
    public float thiamin;

    public float riboflavinNB;
    public float riboflavin;

    public float folateNB;
    public float folate;

    public float niacinNB;
    public float niacin;

    public float cholineNB;
    public float choline;

    public float pantothenicAcidNB;
    public float pantothenicAcid;

    public float calciumNB;
    public float calcium;

    public float chlorideNB;
    public float chloride;

    public float copperNB;
    public float copper;

    public float iodineNB;
    public float iodine;

    public float ironNB;
    public float iron;

    public float magnesiumNB;
    public float magnesium;

    public float manganeseNB;
    public float manganese;

    public float phosphorusNB;
    public float phosphorus;

    public float potassiumNB;
    public float potassium;

    public float seleniumNB;
    public float selenium;

    public float sodiumNB;
    public float sodium;

    public float zincNB;
    public float zinc;

    public void sum(Recipe recipe) {
        for (IngredientEntry ingredientEntry : recipe.ingredients) {
            sum(ingredientEntry);
        }
    }

    public void sum(IngredientEntry ingredientEntry) {
        Ingredient ingredient = ingredientEntry.ingredient;

        if (ingredient != Ingredient.Paine) {
            kCalNB = sum(kCalNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
            kCalProteinNB = sum(kCalProteinNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein() * 4);
            kCalFatNB = sum(kCalFatNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFat() * 9);
            kCalCarbsNB = sum(kCalCarbsNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCarbs() * 4);
            gProteinNB = sum(gProteinNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein());
            vitaminARaeNB = sum(vitaminARaeNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminARAE());
            vitaminCNB = sum(vitaminCNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminC());
            vitaminB6NB = sum(vitaminB6NB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB6());
            vitaminB12NB = sum(vitaminB12NB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB12());
            vitaminENB = sum(vitaminENB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminE());
            vitaminKNB = sum(vitaminKNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminK());
            thiaminNB = sum(thiaminNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getThiamin());
            riboflavinNB = sum(riboflavinNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getRiboflavin());
            folateNB = sum(folateNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFolate());
            niacinNB = sum(niacinNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getNiacin());
            cholineNB = sum(cholineNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCholine());
            pantothenicAcidNB = sum(pantothenicAcidNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPantothenicAcid());
            calciumNB = sum(calciumNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCalcium());
            chlorideNB = sum(chlorideNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getChloride());
            copperNB = sum(copperNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCopper());
            iodineNB = sum(iodineNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getIodine());
            ironNB = sum(ironNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getIron());
            magnesiumNB = sum(magnesiumNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getMagnesium());
            manganeseNB = sum(manganeseNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getManganese());
            phosphorusNB = sum(phosphorusNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPhosphorus());
            potassiumNB = sum(potassiumNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPotassium());
            seleniumNB = sum(seleniumNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSelenium());
            sodiumNB = sum(sodiumNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSodium());
            zincNB = sum(zincNB, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getZinc());
        }
        kCal = sum(kCal, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getKCal().b);
        kCalProtein = sum(kCalProtein, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein() * 4);
        kCalFat = sum(kCalFat, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFat() * 9);
        kCalCarbs = sum(kCalCarbs, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCarbs() * 4);
        gProtein = sum(gProtein, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getProtein());
        vitaminARae = sum(vitaminARae, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminARAE());
        vitaminC = sum(vitaminC, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminC());
        vitaminB6 = sum(vitaminB6, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB6());
        vitaminB12 = sum(vitaminB12, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminB12());
        vitaminE = sum(vitaminE, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminE());
        vitaminK = sum(vitaminK, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getVitaminK());
        thiamin = sum(thiamin, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getThiamin());
        riboflavin = sum(riboflavin, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getRiboflavin());
        folate = sum(folate, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getFolate());
        niacin = sum(niacin, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getNiacin());
        choline = sum(choline, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCholine());
        pantothenicAcid = sum(pantothenicAcid, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPantothenicAcid());
        calcium = sum(calcium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCalcium());
        chloride = sum(chloride, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getChloride());
        copper = sum(copper, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getCopper());
        iodine = sum(iodine, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getIodine());
        iron = sum(iron, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getIron());
        magnesium = sum(magnesium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getMagnesium());
        manganese = sum(manganese, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getManganese());
        phosphorus = sum(phosphorus, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPhosphorus());
        potassium = sum(potassium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getPotassium());
        selenium = sum(selenium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSelenium());
        sodium = sum(sodium, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getSodium());
        zinc = sum(zinc, ingredientEntry.getIngredientInGrams(), ingredient.nutrients.getZinc());
    }

    float sum(float existing, float quantity, Float addend) {
        if (addend == null) return existing;
        return existing + (quantity / 100) * addend;
    }
}
