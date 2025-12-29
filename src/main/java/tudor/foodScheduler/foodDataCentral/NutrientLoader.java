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

        postTreatment();

        System.out.println("Ingredient \tkCal\tsource\tprotein\tfat\tcarbs\tA RAE 900 ug\tC 90 mg\tB6 1.3mg\tB12 2.4ug\tE 15mg\tK 120mcg\tThiamin 1.2mg\tRiboflavin 1.3mg\tFolate 400mcg\tNiacin 16mg\tCholine 550g\tPantothenic acid 5mg\tBiotin 30mcg\t" +
                "Calcium 1000mg\tChloride 2.3g\tCopper 900mcg\tIodine 150mcg\tIron 8mg\tMagnesium 420mg\tManganese 2.3mg\tMolybdenum 45mcg\tPhosphorus 700mg\tPotassium 3400mg\tSelenium 55mcg\tSodium 1500mg\tZinc 11mg\t" +
                "Omega 6 17g\tOmega 3 1.6g");
        for (Ingredient ingredient : Ingredient.values()) {
            System.out.println(ingredient.name() + "\t"+ ingredient.nutrients);
        }

        System.out.println();
        System.out.println();
    }

    private static void postTreatment() {
        // 5000 mcg / 100g
        // 40mg / kg => 4 mg / 100g => 4000 mcg / 1000g so Iodine is good
    }
}
