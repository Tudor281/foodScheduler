package tudor.foodScheduler.foodDataCentral;

import tudor.foodScheduler.model.Ingredient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NutrientLoader {
    static final String fdcPath = "/Food Data Central/All/";

    public static void load() throws IOException {
        Map<String, List<Ingredient>> fdcIngredientMap = new HashMap<>(); // multiple ingredients may have the same code

        for (Ingredient ingredient : Ingredient.values()) {
            fdcIngredientMap.computeIfAbsent(ingredient.fdcCode, k -> new ArrayList<>()).add(ingredient);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fdcPath+"FoodData_Central_csv_2025-04-24/food_nutrient.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] row = line.split(",");
                String fdc_id = row[1].replace("\"", "");
                List<Ingredient> ingredients = fdcIngredientMap.get(fdc_id);
                if (ingredients == null) continue;

                for (Ingredient ingredient : ingredients) {
                    ingredient.nutrients.loadNutrient(row[2], row[3]);
                }
            }
        }

        System.out.println("Ingredient \tkCal\tsource\tprotein\tfat\tcarbs\tA RAE 900 ug\tC 90 mg\tB6 1.3mg\tB12 2.4ug\tE 15mg\tK 120mcg");
        for (Ingredient ingredient : Ingredient.values()) {
            System.out.println(ingredient.name() + "\t"+ ingredient.nutrients);
        }

        System.out.println();
        System.out.println();
    }
}
