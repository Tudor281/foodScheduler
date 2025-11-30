package tudor.foodScheduler.foodDataCentral;

import tudor.foodScheduler.model.Ingredient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NutrientLoader {
    static final String fdcPath = "/Food Data Central/All/";

    public static void load() throws IOException {
        Map<String, Ingredient> fdcIngredientMap = new HashMap<>();

        for (Ingredient ingredient : Ingredient.values()) {
            fdcIngredientMap.put(ingredient.fdcCode, ingredient);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fdcPath+"FoodData_Central_csv_2025-04-24/food_nutrient.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] row = line.split(",");
                String fdc_id = row[1].replace("\"", "");
                Ingredient ingredient = fdcIngredientMap.get(fdc_id);
                if (ingredient == null) continue;

                String nutrientId = row[2].replace("\"", "");

                float quantity = Float.parseFloat(row[3].replace("\"", ""));
                switch (nutrientId) {
                    case "1008" : { // kcal legacy
                        ingredient.nutrients.kCalGeneral = quantity;
                        break;
                    }
                    case "2047" : { // kcal general
                        ingredient.nutrients.kCalGeneral = quantity;
                        break;
                    }
                    case "2048" : { // kcal specific
                        ingredient.nutrients.kCalSpecific = quantity;
                        break;
                    }
                }
            }
        }

        for (Ingredient ingredient : Ingredient.values()) {
            System.out.println(ingredient.name() + "\t"+ ingredient.nutrients);
        }
    }
}
