package tudor.foodScheduler.foodDataCentral;

import org.junit.jupiter.api.Test;
import tudor.foodScheduler.model.IngredientEntry;
import tudor.foodScheduler.model.nutrients.Nutrients;
import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.cookbook.TudorCookBook;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static tudor.foodScheduler.foodDataCentral.NutrientLoader.fdcPath;
import static tudor.foodScheduler.model.nutrients.Nutrients.doubleDigitFormatter;

@SuppressWarnings({"NewClassNamingConvention", "resource", "CallToPrintStackTrace"})
public class StatsFoodDataCentral {
    List<String> order = List.of("experimental_food", "foundation_food", "agricultural_acquisition", "sample_food", "survey_fndds_food", "market_acquistion", "sr_legacy_food", "sub_sample_food", "branded_food");

    @Test
    void foodSearcher() throws IOException {
        String query = "milk";
        List<FoodEntry> results = new ArrayList<>();

        Map<String, FoodEntry> foodByFdc_id = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fdcPath+"FoodData_Central_csv_2025-04-24/food.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] row = line.split(",");
                FoodEntry foodEntry = new FoodEntry(row);
                if (foodEntry.description.toLowerCase().contains(query.toLowerCase())
                    || (foodEntry.food_category_id != null && foodEntry.food_category_id.toLowerCase().contains(query.toLowerCase()))) {
                    results.add(foodEntry);
                    foodByFdc_id.put(foodEntry.fdc_id, foodEntry);
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fdcPath+"FoodData_Central_csv_2025-04-24/food_nutrient.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] row = line.split(",");
                String fdc_id = row[1].replace("\"", "");
                FoodEntry foodEntry = foodByFdc_id.get(fdc_id);
                if (foodEntry == null) continue;
                foodEntry.nutrientCount++;
                foodEntry.nutrients.loadNutrient(row[2], row[3]);
            }
        }

        results.removeIf(foodEntry -> foodEntry.nutrientCount == 0);

        //noinspection Convert2Lambda
        results.sort(new Comparator<>() {
            @Override
            public int compare(FoodEntry o1, FoodEntry o2) {
                int dataTypeComparison = Integer.compare(order.indexOf(o1.data_type), order.indexOf(o2.data_type));
                if (dataTypeComparison != 0) return dataTypeComparison;
                String queryRemainder1 = o1.description.toLowerCase().replace(query.toLowerCase(), "");
                String queryRemainder2 = o2.description.toLowerCase().replace(query.toLowerCase(), "");
                int remainderComparison = Integer.compare(queryRemainder1.length(), queryRemainder2.length());
                if (remainderComparison != 0) return remainderComparison;
                return -Integer.compare(o1.nutrientCount, o2.nutrientCount);
            }
        });

        for (FoodEntry foodEntry : results) {
            foodEntry.print();
        }
    }

    @Test
    void detailRecipe() throws IOException {
        NutrientLoader.load();

        List<IngredientNutrients> ingredientNutrients = new ArrayList<>();
        Recipe recipe = TudorCookBook.buildCookbook().get("Mâncare de linte");
        for (IngredientEntry ingredientEntry : recipe.ingredients) {
            IngredientNutrients in = new IngredientNutrients(ingredientEntry.ingredient.name());

            in.kCal = (ingredientEntry.getIngredientInGrams() / 100) * (ingredientEntry.ingredient.nutrients.getKCal().b != null ? ingredientEntry.ingredient.nutrients.getKCal().b : 0);
            ingredientNutrients.add(in);
        }

        //noinspection Convert2Lambda
        ingredientNutrients.sort(new Comparator<>() {
            @Override
            public int compare(IngredientNutrients o1, IngredientNutrients o2) {
                return -Float.compare(o1.kCal, o2.kCal);
            }
        });

        System.out.println();
        System.out.println(recipe.getName());
        for (IngredientNutrients in : ingredientNutrients) {
            System.out.println(in.toString());
        }
    }

    @Test
    void listAllFoodCategories() throws IOException {
        printCurrentDir();
        Map<String, Integer> rowCounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fdcPath+"FoodData_Central_csv_2025-04-24/food.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] row = line.split(",");
                String type = row[1].replace("\"", "");
                Integer count = rowCounts.computeIfAbsent(type, k -> 0);
                rowCounts.put(type, ++count);
            }
        }

        List<Map.Entry<String, Integer>> topEntries = new ArrayList<>();
        int alreadyProcessed = Integer.MAX_VALUE;

        do {
            int maxFound = 0;
            topEntries.clear();
            for (Map.Entry<String, Integer> entry : rowCounts.entrySet()) {
                int counts = entry.getValue();
                if (counts < alreadyProcessed && counts > maxFound) {
                    maxFound = counts;
                    topEntries.clear();
                }
                if (counts == maxFound) {
                    topEntries.add(entry);
                }
            }
            alreadyProcessed = maxFound;
            for (Map.Entry<String, Integer> entry : topEntries) {
                System.out.println(entry.getKey() + "\t\t"+entry.getValue());
            }
        } while (alreadyProcessed != 0);
    }

    private void printCurrentDir() {
        Path dir = Paths.get("/");
        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(dir);
            for (Path entry: ds) {
                System.out.println(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FoodEntry {
        String fdc_id;
        String data_type;
        String description;
        String food_category_id;
        String publication_date;
        int nutrientCount = 0;
        Nutrients nutrients = new Nutrients();

        FoodEntry(String[] row) {
            try {
                fdc_id = row[0].replace("\"","");
                data_type = row[1].replace("\"","");
                description = row[2].replace("\"","");
                food_category_id = row[3].replace("\"","");
                publication_date = row[4].replace("\"","");
            } catch (Exception e) {
                System.err.println("Failed complete read for "+fdc_id);
            }

        }

        public void print() {
            System.out.println(fdc_id + "\t" + data_type + "\t" + nutrientCount+ "\t"+description+"\t"+food_category_id+"\t"+publication_date + "\t" + nutrients);
        }
    }
    static class IngredientNutrients {
        float kCal;
        String name;

        public IngredientNutrients(String name) {
            this.name = name;
        }

        public String toString() {
            return name + "\t" + doubleDigitFormatter.format(kCal);
        }
    }
}
