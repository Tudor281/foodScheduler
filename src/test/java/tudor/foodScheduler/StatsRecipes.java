package tudor.foodScheduler;

import org.junit.jupiter.api.Test;
import tudor.foodScheduler.foodDataCentral.NutrientLoader;
import tudor.foodScheduler.model.IngredientEntry;
import tudor.foodScheduler.model.MinRDA;
import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.cookbook.TudorCookBook;
import tudor.foodScheduler.model.nutrients.NutrientsSummer;

import java.io.IOException;

import static tudor.foodScheduler.model.nutrients.Nutrients.doubleDigitFormatter;

@SuppressWarnings("NewClassNamingConvention")
public class StatsRecipes {
    @Test
    void loadNutrients() throws IOException {
        NutrientLoader.load();
    }

    @Test
    void printRecipesNutrientDetails() throws IOException {
        NutrientLoader.load();

        System.out.println("Name\tIngredient\tkCal\tkCalProtein\tkCalFat\tkCalCarbs\tgProteins\t" +
                "A\tC\tB6\tE\tK\tThiamin\tB12\tRiboflavin\tFolate\tNiacin\tCholine\tPanthotenicAcid\t" +
                "Calcium\tChloride\tCopper\tIodine\tIron\tMagnesium\tManganese\tPhosphorus\tPotassium\tSelenium\tSodium\tZinc");

        for (Recipe recipe : TudorCookBook.buildCookbook().getAll()) {
            for (IngredientEntry ingredientEntry : recipe.ingredients) {
                NutrientsSummer summer = new NutrientsSummer();
                summer.sum(ingredientEntry);

                String ingredientRow = recipe.name +"\t"+ingredientEntry.ingredient.name();
                ingredientRow += "\t" + doubleDigitFormatter.format(summer.kCal);
                ingredientRow += "\t" + doubleDigitFormatter.format(summer.kCalProtein/summer.kCal);
                ingredientRow += "\t" + doubleDigitFormatter.format(summer.kCalFat/summer.kCal);
                ingredientRow += "\t" + doubleDigitFormatter.format(summer.kCalCarbs/summer.kCal);
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.gProtein, MinRDA.proteins));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.vitaminARae, MinRDA.VA));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.vitaminC, MinRDA.VC));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.vitaminB6, MinRDA.VB6));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.vitaminE, MinRDA.VE));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.vitaminK, MinRDA.VK));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.thiamin, MinRDA.thiamin));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.vitaminB12, MinRDA.VB12));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.riboflavin, MinRDA.riboflavin));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.folate, MinRDA.folate));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.niacin, MinRDA.niacin));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.choline, MinRDA.choline));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.pantothenicAcid, MinRDA.panthotenicAcid));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.calcium, MinRDA.calcium));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.chloride, MinRDA.chloride));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.copper, MinRDA.copper));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.iodine, MinRDA.iodine));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.iron, MinRDA.iron));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.magnesium, MinRDA.magnesium));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.manganese, MinRDA.manganese));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.phosphorus, MinRDA.phophorus));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.potassium, MinRDA.potassium));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.selenium, MinRDA.selenium));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.sodium, MinRDA.sodium));
                ingredientRow += "\t" + doubleDigitFormatter.format(processPerRDARatio(summer.zinc, MinRDA.zinc));

                System.out.println(ingredientRow);
            }
        }
    }

    private float processPerRDARatio(float micronutrient, float rda) {
        return micronutrient / rda;
    }

    @Test
    void printRecipeNutrients() throws IOException {
        NutrientLoader.load();

        System.out.println("Name\tM\tF\tNutriciousness\tkCal\tkCalProtein\tkCalFat\tkCalCarbs\tgProteins\t" +
                "A\tC\tB6\tE\tK\tThiamin\tB12\tRiboflavin\tFolate\tNiacin\tCholine\tPanthotenicAcid\t" +
                "Calcium\tChloride\tCopper\tIodine\tIron\tMagnesium\tManganese\tPhosphorus\tPotassium\tSelenium\tSodium\tZinc");

        for (Recipe recipe : TudorCookBook.buildCookbook().getAll()) {
            NutrientsSummer summer = new NutrientsSummer();
            summer.sum(recipe);

            String ingredientEntry = recipe.name + "\t" + recipe.multiplicity.shortName +"\t"+ recipe.fel;
            float nutriciousness = processPerCalorieRatio(summer.vitaminARae, summer.kCal, MinRDA.VA) +
                    processPerCalorieRatio(summer.vitaminC, summer.kCal, MinRDA.VC) +
                    processPerCalorieRatio(summer.vitaminB6, summer.kCal, MinRDA.VB6) +
                    processPerCalorieRatio(summer.vitaminE, summer.kCal, MinRDA.VE) +
                    processPerCalorieRatio(summer.vitaminK, summer.kCal, MinRDA.VK) +
                    processPerCalorieRatio(summer.thiamin, summer.kCal, MinRDA.thiamin) +
                    processPerCalorieRatio(summer.vitaminB12, summer.kCal, MinRDA.VB12) +
                    processPerCalorieRatio(summer.riboflavin, summer.kCal, MinRDA.riboflavin) +
                    processPerCalorieRatio(summer.folate, summer.kCal, MinRDA.folate) +
                    processPerCalorieRatio(summer.niacin, summer.kCal, MinRDA.niacin) +
                    processPerCalorieRatio(summer.choline, summer.kCal, MinRDA.choline) +
                    processPerCalorieRatio(summer.pantothenicAcid, summer.kCal, MinRDA.panthotenicAcid) +
                    processPerCalorieRatio(summer.calcium, summer.kCal, MinRDA.calcium) +
                    processPerCalorieRatio(summer.copper, summer.kCal, MinRDA.copper) +
                    processPerCalorieRatio(summer.iodine, summer.kCal, MinRDA.iodine) +
                    processPerCalorieRatio(summer.iron, summer.kCal, MinRDA.iron) +
                    processPerCalorieRatio(summer.magnesium, summer.kCal, MinRDA.magnesium) +
                    processPerCalorieRatio(summer.manganese, summer.kCal, MinRDA.manganese) +
                    processPerCalorieRatio(summer.phosphorus, summer.kCal, MinRDA.phophorus) +
                    processPerCalorieRatio(summer.potassium, summer.kCal, MinRDA.potassium) +
                    processPerCalorieRatio(summer.selenium, summer.kCal, MinRDA.selenium) +
                    processPerCalorieRatio(summer.zinc, summer.kCal, MinRDA.zinc);
            ingredientEntry += "\t" + doubleDigitFormatter.format(nutriciousness);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCalProtein/summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCalFat/summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCalCarbs/summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.gProtein, summer.kCal, MinRDA.proteins));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.vitaminARae, summer.kCal, MinRDA.VA));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.vitaminC, summer.kCal, MinRDA.VC));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.vitaminB6, summer.kCal, MinRDA.VB6));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.vitaminE, summer.kCal, MinRDA.VE));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.vitaminK, summer.kCal, MinRDA.VK));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.thiamin, summer.kCal, MinRDA.thiamin));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.vitaminB12, summer.kCal, MinRDA.VB12));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.riboflavin, summer.kCal, MinRDA.riboflavin));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.folate, summer.kCal, MinRDA.folate));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.niacin, summer.kCal, MinRDA.niacin));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.choline, summer.kCal, MinRDA.choline));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.pantothenicAcid, summer.kCal, MinRDA.panthotenicAcid));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.calcium, summer.kCal, MinRDA.calcium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.chloride, summer.kCal, MinRDA.chloride));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.copper, summer.kCal, MinRDA.copper));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.iodine, summer.kCal, MinRDA.iodine));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.iron, summer.kCal, MinRDA.iron));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.magnesium, summer.kCal, MinRDA.magnesium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.manganese, summer.kCal, MinRDA.manganese));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.phosphorus, summer.kCal, MinRDA.phophorus));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.potassium, summer.kCal, MinRDA.potassium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.selenium, summer.kCal, MinRDA.selenium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.sodium, summer.kCal, MinRDA.sodium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(processPerCalorieRatio(summer.zinc, summer.kCal, MinRDA.zinc));

            System.out.println(ingredientEntry);
        }
    }

    private float processPerCalorieRatio(float micronutrient, float kCal, float rda) {
        return (micronutrient / kCal) / (rda / 2000);
    }
}
