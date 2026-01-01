package tudor.foodScheduler.foodDataCentral;

import org.junit.jupiter.api.Test;
import tudor.foodScheduler.model.IngredientEntry;
import tudor.foodScheduler.model.MinRDA;
import tudor.foodScheduler.model.nutrients.Nutrients;
import tudor.foodScheduler.model.Recipe;
import tudor.foodScheduler.model.cookbook.TudorCookBook;
import tudor.foodScheduler.model.nutrients.NutrientsSummer;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static tudor.foodScheduler.foodDataCentral.NutrientLoader.fdcPath;
import static tudor.foodScheduler.model.nutrients.Nutrients.doubleDigitFormatter;

@SuppressWarnings({"NewClassNamingConvention", "resource", "CallToPrintStackTrace"})
public class Stats {
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

    @Test
    void loadNutrients() throws IOException {
        NutrientLoader.load();
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
            float nutriciousness = process (summer.vitaminARae, summer.kCal, MinRDA.VA) +
                    process (summer.vitaminC, summer.kCal, MinRDA.VC) +
                    process (summer.vitaminB6, summer.kCal, MinRDA.VB6) +
                    process (summer.vitaminE, summer.kCal, MinRDA.VE) +
                    process (summer.vitaminK, summer.kCal, MinRDA.VK) +
                    process (summer.thiamin, summer.kCal, MinRDA.thiamin) +
                    process (summer.vitaminB12, summer.kCal, MinRDA.VB12) +
                    process (summer.riboflavin, summer.kCal, MinRDA.riboflavin) +
                    process (summer.folate, summer.kCal, MinRDA.folate) +
                    process (summer.niacin, summer.kCal, MinRDA.niacin) +
                    process (summer.choline, summer.kCal, MinRDA.choline) +
                    process (summer.pantothenicAcid, summer.kCal, MinRDA.panthotenicAcid) +
                    process (summer.calcium, summer.kCal, MinRDA.calcium) +
                    process (summer.copper, summer.kCal, MinRDA.copper) +
                    process (summer.iodine, summer.kCal, MinRDA.iodine) +
                    process (summer.iron, summer.kCal, MinRDA.iron) +
                    process (summer.magnesium, summer.kCal, MinRDA.magnesium) +
                    process (summer.manganese, summer.kCal, MinRDA.manganese) +
                    process (summer.phosphorus, summer.kCal, MinRDA.phophorus) +
                    process (summer.potassium, summer.kCal, MinRDA.potassium) +
                    process (summer.selenium, summer.kCal, MinRDA.selenium) +
                    process (summer.zinc, summer.kCal, MinRDA.zinc);
            ingredientEntry += "\t" + doubleDigitFormatter.format(nutriciousness);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCalProtein/summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCalFat/summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(summer.kCalCarbs/summer.kCal);
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.gProtein, summer.kCal, MinRDA.proteins));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.vitaminARae, summer.kCal, MinRDA.VA));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.vitaminC, summer.kCal, MinRDA.VC));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.vitaminB6, summer.kCal, MinRDA.VB6));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.vitaminE, summer.kCal, MinRDA.VE));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.vitaminK, summer.kCal, MinRDA.VK));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.thiamin, summer.kCal, MinRDA.thiamin));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.vitaminB12, summer.kCal, MinRDA.VB12));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.riboflavin, summer.kCal, MinRDA.riboflavin));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.folate, summer.kCal, MinRDA.folate));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.niacin, summer.kCal, MinRDA.niacin));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.choline, summer.kCal, MinRDA.choline));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.pantothenicAcid, summer.kCal, MinRDA.panthotenicAcid));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.calcium, summer.kCal, MinRDA.calcium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.chloride, summer.kCal, MinRDA.chloride));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.copper, summer.kCal, MinRDA.copper));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.iodine, summer.kCal, MinRDA.iodine));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.iron, summer.kCal, MinRDA.iron));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.magnesium, summer.kCal, MinRDA.magnesium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.manganese, summer.kCal, MinRDA.manganese));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.phosphorus, summer.kCal, MinRDA.phophorus));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.potassium, summer.kCal, MinRDA.potassium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.selenium, summer.kCal, MinRDA.selenium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.sodium, summer.kCal, MinRDA.sodium));
            ingredientEntry += "\t" + doubleDigitFormatter.format(process (summer.zinc, summer.kCal, MinRDA.zinc));

            System.out.println(ingredientEntry);
        }
    }

    private float process(float micronutrient, float kCal, float rda) {
        return (micronutrient / kCal) / (rda / 2000);
    }
}
