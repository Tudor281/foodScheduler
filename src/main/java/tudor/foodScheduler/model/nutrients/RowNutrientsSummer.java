package tudor.foodScheduler.model.nutrients;

import tudor.foodScheduler.model.Recipe;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("StringConcatenationInLoop")
public class RowNutrientsSummer {

    Map<Character, NutrientsSummer> nutrientsPerChannel = new HashMap<>();

    public void sum(Recipe recipe, int controlColumn) {
        NutrientsSummer ns = new NutrientsSummer();
        nutrientsPerChannel.put((char) ('A' + (controlColumn - 1)), ns);

        ns.sum(recipe);
    }

    public String toString(int row, int start) {
        String result = "=";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCal/7 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalNB /7+";0))";
        }

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCalProtein + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalProteinNB +";0))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCalFat + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalFatNB +";0))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().kCalCarbs + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().kCalCarbsNB +";0))";
        }
        result += ")/("+((char) ('A' + (start - 1)))+row+"*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().gProtein + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().gProteinNB +";0))";
        }
        // Minimum official US RDA
        result += ")/(0.8 * 115 *7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminARae + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminARaeNB +";0))";
        }
        result += ")/(900*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminB6 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminB6NB +";0))";
        }
        result += ")/(1.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminB12 + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminB12NB +";0))";
        }
        result += ")/(2,4*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminC + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminCNB +";0))";
        }
        result += ")/(90*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminE + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminENB +";0))";
        }
        result += ")/(15*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().vitaminK + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().vitaminKNB +";0))";
        }
        result += ")/(120*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().thiamin + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().thiaminNB +";0))";
        }
        result += ")/(1.2*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().riboflavin + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().riboflavinNB +";0))";
        }
        result += ")/(1.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().folate + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().folateNB +";0))";
        }
        result += ")/(400*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().niacin + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().niacinNB +";0))";
        }
        result += ")/(16*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().choline + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().cholineNB +";0))";
        }
        result += ")/(550*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().pantothenicAcid + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().pantothenicAcidNB +";0))";
        }
        result += ")/(5*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().calcium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().calciumNB +";0))";
        }
        result += ")/(1000*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().chloride + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().chlorideNB +";0))";
        }
        result += ")/(2.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().copper + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().copperNB +";0))";
        }
        result += ")/(0.9*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().iodine + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().iodineNB +";0))";
        }
        result += ")/(150*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().iron + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().ironNB +";0))";
        }
        result += ")/(8*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().magnesium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().magnesiumNB +";0))";
        }
        result += ")/(420*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().manganese + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().manganese +";0))";
        }
        result += ")/(2.3*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().phosphorus + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().phosphorusNB +";0))";
        }
        result += ")/(700*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().potassium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().potassiumNB +";0))";
        }
        result += ")/(3400*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().selenium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().seleniumNB +";0))";
        }
        result += ")/(55*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().sodium + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().sodiumNB +";0))";
        }
        result += ")/(1500*7)";

        result += "\t=(";
        for (Map.Entry<Character, NutrientsSummer> entry : nutrientsPerChannel.entrySet()) {
            result += "+IF("+entry.getKey()+row+"=\"B\";"+entry.getValue().zinc + ";IF("+entry.getKey() + row + "=\"Y\";"+entry.getValue().zincNB +";0))";
        }
        result += ")/(11*7)";

        return result.replace(".", ",");
    }
}
