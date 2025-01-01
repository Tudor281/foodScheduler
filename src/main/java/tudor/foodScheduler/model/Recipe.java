package tudor.foodScheduler.model;

import tudor.foodScheduler.model.schedule.Schedule;

import java.util.*;

import static tudor.foodScheduler.model.Fel.*;
import static tudor.foodScheduler.model.Ingredient.*;
import static tudor.foodScheduler.model.Multiplicity.*;
import static tudor.foodScheduler.model.Multiplicity.Once;
import static tudor.foodScheduler.model.Spice.*;
import static tudor.foodScheduler.model.Spice.Usturoi;

public class Recipe {
    public String name;
    public List<Ingredient> ingredients;
    public List<Spice> spices;
    public Multiplicity multiplicity;
    public Fel fel;
    public Integer limit = null;

    public static final Map<String, Recipe> all = new HashMap<>();
    static {
        add(new Recipe("American Potato Salad", List.of(Cartofi, Maioneza), Once, F2, List.of(Mustar, Apio, Patrunjel)));
        add(new Recipe("Apple Pie", List.of(Mere), Optional, Desert, List.of()));
        add(new Recipe("Ardei umpluți simplu", List.of(Ardei, Orez), Optional, F2, List.of(FrunzeTelina)));
        add(new Recipe("Ardei umpluți cu carne", List.of(Ardei, Orez, Carne), Once, F2, List.of(FrunzeTelina)));
        add(new Recipe("Chiftele cu carne", List.of(Carne), Once, Rece, List.of(Usturoi))); // binding to pilaf simplu
        add(new Recipe("Chiftele de soia în suc de roșii", List.of(Soia), Once, Rece, List.of())); // TODO No recipy
        add(new Recipe("Ciorbă de cartofi cu smântână", List.of(Cartofi, Smantana), AtLeastOnce, F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de cartofi roșie", List.of(Cartofi), AtLeastOnce, F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de conopidă", List.of(Conopida), AtLeastOnce, F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de dovlecei cu ciuperci", List.of(Dovlecei, Ciuperci, Telina), AtLeastOnce, F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de fasole - Cu chimen", List.of(Fasole), AtLeastOnce, F1, List.of(Pastarnac, Usturoi, Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, BoiaAfumata, Iuteala)));
        add(new Recipe("Ciorbă de fasole - Cu dafin", List.of(Fasole), AtLeastOnce, F1, List.of(Patrunjel, Marar, Dafin)));
        add(new Recipe("Ciorbă de fasole - Cu cimbru", List.of(Fasole), AtLeastOnce, F1, List.of(Patrunjel, Marar, Cimbru)));
        add(new Recipe("Ciorbă de fasole - Cu leuștean", List.of(Fasole), AtLeastOnce, F1, List.of(Patrunjel, Marar, Leustean)));
        add(new Recipe("Ciorbă de frunze", List.of(Frunze), AtLeastOnce, F1, List.of(Marar, Leustean)));
        add(new Recipe("Ciorbă de ghebe cu smântână", List.of(Ciuperci, Smantana), AtMostOnce, F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de năut cu afumătură", List.of(Carne, Naut), AtMostOnce, F1, List.of(BoiaDulce)));
        add(new Recipe("Ciorbă de păstăi", List.of(PastaiCongelate), AtLeastOnce, F1, List.of(Pastarnac, Patrunjel, Marar, Leustean), 3));
        add(new Recipe("Ciorbă de păstăi fresh", List.of(PastaiFresh), Once, F1, List.of(Pastarnac, Patrunjel, Marar, Leustean)));
        add(new Recipe("Ciorbă de perișoare", List.of(Carne), AtMostOnce, F1, List.of())); // TODO No recipy
        add(new Recipe("Ciorbă de pui a la Grec", List.of(Carne, Smantana), Once, F1, List.of(Pastarnac, SucLamaie, Patrunjel, Marar)));
        add(new Recipe("Ciorbă de salată cu scrob", List.of(Salata, Smantana), AtLeastOnce, F1, List.of()));
        add(new Recipe("Ciorbă rădăuțeană", List.of(Carne, Smantana), Once, F1, List.of())); // TODO no recipy
        add(new Recipe("Ciuperci cu maioneză și usturoi", List.of(Ciuperci, Maioneza), AtLeastOnce, Rece, List.of()));
        add(new Recipe("Clătite", List.of(), Optional, Desert, List.of()));
        add(new Recipe("Cozonac", List.of(), Once, Desert, List.of()));
        add(new Recipe("Fasole bătută", List.of(Fasole), Optional, Rece, List.of()));
        add(new Recipe("Gigantes Plaki", List.of(Fasole), AtLeastOnce, F2, List.of(Usturoi, Patrunjel, Marar)));
        add(new Recipe("Gratin de cartofi cu broccoli și brânză", List.of(Cartofi, Broccoli, Smantana, Branza), Optional, F2, List.of(Usturoi)));
        add(new Recipe("Gratin de cartofi cu roșii și brânză", List.of(Cartofi, Rosii, Smantana, Branza), Optional, F2, List.of(Busuioc)));
        add(new Recipe("Griș cu lapte", List.of(), AtLeastOnce, Desert, List.of()));
        add(new Recipe("Gulaș", List.of(Cartofi, Carne), Once, F2, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Usturoi, Patrunjel, Tarhon)));
        add(new Recipe("Humus", List.of(Naut), AtLeastOnce, Rece, List.of()));
        add(new Recipe("Lasagna bolognese", List.of(Carne), Once, F2, List.of(Apio, VinAlb)));
        add(new Recipe("Mâncare de cartofi - ardelenească", List.of(Cartofi), AtLeastOnce, F2, List.of(Iuteala, BoiaDulce, BoiaIute, Dafin)));
        add(new Recipe("Mâncare de cartofi - Cu pui", List.of(Cartofi, Carne), Optional, F2, List.of(Dafin, BoiaDulce, Iuteala)));
        add(new Recipe("Mâncare de cartofi - Cu soia", List.of(Cartofi, Soia), Once, F2, List.of(Dafin, BoiaDulce, Iuteala)));
        add(new Recipe("Mâncare de cartofi - moldovenească", List.of(Cartofi), AtLeastOnce, F2, List.of(Patrunjel, Marar, Iuteala)));
        add(new Recipe("Mâncare de ciuperci - Ciulama de ciuperci", List.of(Ciuperci), Optional, FastFood, List.of(Patrunjel, Marar)));
        add(new Recipe("Mâncare de ciuperci - Ciuperci cu smântână și usturoi", List.of(Ciuperci, Smantana), Optional, FastFood, List.of(Patrunjel, Usturoi)));
        add(new Recipe("Mâncare de fasole - Fasole prăjită", List.of(Fasole), AtLeastOnce, F2, List.of(Marar)));
        add(new Recipe("Măncare de fasole - Fasole prăjită - Fuchs remix", List.of(Fasole), AtLeastOnce, F2, List.of(Marar, FuchsFasole)));
        add(new Recipe("Mâncare de fasole - Iahnie de fasole", List.of(Fasole), AtLeastOnce, F2, List.of(Usturoi, Pastarnac, Dafin)));
        add(new Recipe("Mâncare de mazăre - Cu pui", List.of(Mazare, Carne), Disabled, F2, List.of(Marar, BoiaDulce, Dafin, Usturoi))); // mazărea cu soia e pur și simplu superioară
        add(new Recipe("Mâncare de mazăre - Cu soia", List.of(Mazare, Soia), AtLeastOnce, F2, List.of(Marar, BoiaDulce, Dafin, Usturoi)));
        add(new Recipe("Mâncare de mazăre - Simplu", List.of(Mazare), AtLeastOnce, F2, List.of(Marar), 4));
        add(new Recipe("Melanzane alla parmigiano", List.of(Vinete, Branza), Once, F2, List.of()));
        add(new Recipe("Musaca cu carne", List.of(Cartofi, Carne), Once, F2, List.of(Apio, VinAlb)));
        add(new Recipe("Musaca cu ciuperci", List.of(Cartofi, Ciuperci), AtLeastOnce, F2, List.of())); // TODO no recipy
        add(new Recipe("Nakkikeitto", List.of(Carne, Cartofi), Optional, F1, List.of(Pastarnac, Usturoi, Dafin, Patrunjel, Rozmarin)));
        add(new Recipe("Nakkikeitto - V", List.of(Cartofi, Soia), AtLeastOnce, F1, List.of(Pastarnac, Usturoi, Dafin, Patrunjel, Rozmarin)));
        add(new Recipe("Pilaf - Cu ciuperci și alte legume", List.of(Orez, Ciuperci), AtLeastOnce, F2, List.of(Marar, Patrunjel, Pastarnac)));
        add(new Recipe("Pilaf - Cu urzici", List.of(Orez, Urzici), Once, F2, List.of(Patrunjel)));
        add(new Recipe("Pilaf - Paella cu pui", List.of(Orez, Carne), Once, F2, List.of(Usturoi, Patrunjel, Curcuma, SucLamaie)));
        add(new Recipe("Pilaf - Sarmale cu varză murată și carne", List.of(Orez, VarzaMurata, Carne), Disabled, F2, List.of())); // TODO no recipy
        add(new Recipe("Pilaf - Sarmale viță de vie simplu", List.of(Orez), Disabled, F2, List.of())); // TODO no recipy
        add(new Recipe("Pilaf - Sarmale viță de vie cu carne", List.of(Orez, Carne), AtMostOnce, F2, List.of())); // TODO no recipy
        add(new Recipe("Pilaf - Simplu", List.of(Orez), AtLeastOnce, F2, List.of(Curcuma)));
        add(new Recipe("Răcitură", List.of(Carne), Once, F2, List.of(Usturoi)));
        add(new Recipe("Riz au lait", List.of(Orez), AtLeastOnce, Desert, List.of()));
        add(new Recipe("Salată boeuf", List.of(Cartofi, Maioneza), Optional, Rece, List.of(Mustar)));
        add(new Recipe("Salată de pui", List.of(Carne, Maioneza), Once, Rece, List.of()));
        add(new Recipe("Salată orientală", List.of(Cartofi), AtLeastOnce, Rece, List.of()));
        add(new Recipe("Supă cremă de broccoli - Cu carne", List.of(Broccoli, Carne), Optional, F1, List.of(Usturoi)));
        add(new Recipe("Supă cremă de broccoli - Simplu", List.of(Broccoli), AtLeastOnce, F1, List.of(Usturoi)));
        add(new Recipe("Supă cremă de broccoli - Soia", List.of(Broccoli, Soia), Once, F1, List.of(Usturoi)));
        add(new Recipe("Supă cremă de conopidă", List.of(Conopida, Smantana), Optional, F1, List.of(Usturoi, Patrunjel)));
        add(new Recipe("Supă cremă de dovlecei", List.of(Dovlecei), Once, F1, List.of())); // TODO no recipy
        add(new Recipe("Supă cremă de mazăre", List.of(Mazare), AtLeastOnce, F1, List.of()));
        add(new Recipe("Supă cremă de țelină - Cu praz și smântână", List.of(Telina, Praz, Smantana), Once, F1, List.of(Pastarnac)));
        add(new Recipe("Supă cremă de țelină - Mama", List.of(Telina), AtLeastOnce, F1, List.of(Pastarnac)));
        add(new Recipe("Supă de conopidă", List.of(Conopida), Once, F1, List.of(SucLamaie)));
        add(new Recipe("Supă de roșii", List.of(Rosii), AtLeastOnce, F1, List.of(Pastarnac, Patrunjel)));
        add(new Recipe("Tiramisu", List.of(), AtLeastOnce, Desert, List.of()));
        add(new Recipe("Tocăniță de ardei", List.of(Ardei), AtLeastOnce, F2, List.of()));
        add(new Recipe("Tocăniță de gogonele", List.of(Gogonele), AtLeastOnce, F2, List.of()));
        add(new Recipe("Tocăniță de legume", List.of(Ardei), AtLeastOnce, F2, List.of(Patrunjel, FrunzeTelina)));
        add(new Recipe("Tocăniță de praz", List.of(Praz), AtLeastOnce, F2, List.of(Patrunjel, Dafin, Usturoi, SucLamaie)));
        add(new Recipe("Tzatziki", List.of(Iaurt, Castraveti), AtLeastOnce, Rece, List.of(Marar, Usturoi)));
        add(new Recipe("Țelină cu morcov", List.of(Telina, Maioneza, Peste), AtLeastOnce, Rece, List.of()));
        add(new Recipe("Varză călită", List.of(VarzaMurata), Once, F2, List.of())); // TODO no recipy, goes with chiftele
        add(new Recipe("Varză fiartă", List.of(Varza), AtLeastOnce, F2, List.of(Dafin)));
        add(new Recipe("Varză la Cluj", List.of(VarzaMurata, Carne), Once, F2, List.of())); // TODO no recipy
        add(new Recipe("Vitel tonne", List.of(Carne, Peste), Once, Rece, List.of())); // TODO no recipy
    }

    public static Recipe get(String name) {
        Recipe recipe = all.get(name);
        if (recipe == null) throw new RuntimeException("Recipe not found: "+name);
        return recipe;
    }

    public static List<Recipe> getAtLeastOnceRecipes(Schedule schedule) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : all.values()) {
            if (!(recipe.multiplicity == AtLeastOnce || recipe.multiplicity == Once)) continue;

            if (schedule.isRecipePresent(recipe)) continue;

            result.add(recipe);
        }
        return result;
    }

    public static List<Recipe> getSupplementalRecipes(Schedule schedule) {
        List<Recipe> result = new LinkedList<>();
        for (Recipe recipe : all.values()) {
            if (recipe.multiplicity == Disabled || recipe.multiplicity == Once) continue;

            if (recipe.multiplicity == AtMostOnce) {
                if (schedule.isRecipePresent(recipe)) continue;
            }

            //also if (recipe.multiplicity == AtLeastOnce || recipe.multiplicity == Optional)
            result.add(recipe);
        }

        return result;
    }

    public int getSeasonalityScore() {
        int smallestScore = Integer.MAX_VALUE;
        for (Ingredient ingredient : ingredients) {
            int score = ingredient.getSeasonalityScore();
            if (score < smallestScore) smallestScore = score;
        }
        return smallestScore;
    }

    static void add(Recipe recipe) {
        all.put(recipe.getName(), recipe);
    }

    public Recipe(String name, List<Ingredient> ingredients, Multiplicity multiplicity, Fel fel, List<Spice> spices) {
        this.name = name;
        this.ingredients = ingredients;
        this.multiplicity = multiplicity;
        this.fel = fel;
        this.spices = spices;
    }

    public Recipe(String name, List<Ingredient> ingredients, Multiplicity multiplicity, Fel fel, List<Spice> spices, int limit) {
        this(name, ingredients, multiplicity, fel, spices);
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public static List<Recipe> extractLowPriorityRecipes(List<Recipe> input) {
        List<Recipe> lowPriorityRecipes = new LinkedList<>();
        for (Recipe recipe : input) {
            if (recipe.getSeasonalityScore() == Integer.MAX_VALUE) {
                lowPriorityRecipes.add(recipe);
            }
        }
        input.removeAll(lowPriorityRecipes);
        return lowPriorityRecipes;
    }

    public List<Integer> getDomesticSlots() {
        List<Integer> slots = new LinkedList<>(Months.ALL);
        for (Ingredient ingredient : ingredients) {
            List<Integer> removedSlots = new ArrayList<>();
            for (Integer i : slots) {
                if (!ingredient.domesticMonths.contains(i)) {
                    removedSlots.add(i);
                }
            }
            if (!removedSlots.isEmpty()) {
                slots.removeAll(removedSlots);
            }
        }
        return slots;
    }

    public List<Integer> getImportSlots() {
        List<Integer> slots = new LinkedList<>(Months.ALL);
        for (Ingredient ingredient : ingredients) {
            List<Integer> removedSlots = new ArrayList<>();
            for (Integer i : slots) {
                if (!ingredient.importMonths.contains(i)) {
                    removedSlots.add(i);
                }
            }
            if (!removedSlots.isEmpty()) {
                slots.removeAll(removedSlots);
            }
        }
        return slots;
    }

    public boolean hasIngredientsInCommon(Recipe recipe) {
        for (Ingredient ingredient : ingredients) {
            if (recipe.ingredients.contains(ingredient)) return true;
        }
        return false;
    }

    /** human month */
    public boolean isInSeason(int month) {
        for (Ingredient ingredient : ingredients) {
            if (!(ingredient.importMonths.contains(month) || ingredient.domesticMonths.contains(month))) return false;
        }
        return true;
    }

    public String toString() {
        return name;
    }
}
