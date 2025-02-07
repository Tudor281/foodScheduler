package tudor.foodScheduler.model;

import tudor.foodScheduler.model.schedule.Schedule;

import java.util.*;

import static tudor.foodScheduler.model.Fel.*;
import static tudor.foodScheduler.model.Ingredient.*;
import static tudor.foodScheduler.model.Multiplicity.*;
import static tudor.foodScheduler.model.Multiplicity.Once;
import static tudor.foodScheduler.model.Spice.*;
import static tudor.foodScheduler.model.Spice.Telina;
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
        add(new Recipe("American Potato Salad", Once, List.of(Cartofi, Maioneza), F2, List.of(Mustar, Apio, Patrunjel)));
        add(new Recipe("Apple Pie", Optional, List.of(Mere), Desert, List.of()));
        add(new Recipe("Ardei umpluți simplu", Once, List.of(Ardei, Orez), F2, List.of(FrunzeTelina)));
        add(new Recipe("Ardei umpluți cu carne", Once, List.of(Ardei, Orez, Carne), F2, List.of(FrunzeTelina)));
        add(new Recipe("Chiftele cu carne", Once, List.of(Carne), Rece, List.of(Usturoi))); // binding to pilaf simplu
        add(new Recipe("Chiftele de soia în suc de roșii", Once, List.of(Soia), Rece, List.of())); // TODO No recipy
        add(new Recipe("Ciorbă de cartofi cu smântână", AtLeastOnce, List.of(Cartofi, Smantana), F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de cartofi roșie", AtLeastOnce, List.of(Cartofi), F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de conopidă", AtLeastOnce, List.of(Conopida), F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de dovlecei cu ciuperci", AtLeastOnce, List.of(Dovlecei, Ciuperci), F1, List.of(Patrunjel, Marar, Telina)));
        add(new Recipe("Ciorbă de fasole - Cu chimen", AtLeastOnce, List.of(Fasole), F1, List.of(Pastarnac, Usturoi, Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, BoiaAfumata, Iuteala, Telina)));
        add(new Recipe("Ciorbă de fasole - Cu dafin", AtLeastOnce, List.of(Fasole), F1, List.of(Patrunjel, Marar, Dafin)));
        add(new Recipe("Ciorbă de fasole - Cu cimbru", AtLeastOnce, List.of(Fasole), F1, List.of(Patrunjel, Marar, Cimbru)));
        add(new Recipe("Ciorbă de fasole - Cu leuștean", AtLeastOnce, List.of(Fasole), F1, List.of(Patrunjel, Marar, Leustean)));
        add(new Recipe("Ciorbă de frunze", AtLeastOnce, List.of(Frunze), F1, List.of(Marar, Leustean)));
        add(new Recipe("Ciorbă de ghebe cu smântână", Once, List.of(Ciuperci, Smantana), F1, List.of(Patrunjel, Marar)));
        add(new Recipe("Ciorbă de năut cu afumătură", Once, List.of(Carne, Naut), F1, List.of(BoiaDulce)));
        add(new Recipe("Ciorbă de păstăi", AtLeastOnce, List.of(PastaiCongelate), F1, List.of(Pastarnac, Patrunjel, Marar, Leustean, Telina), 3));
        add(new Recipe("Ciorbă de păstăi fresh", Once, List.of(PastaiFresh), F1, List.of(Pastarnac, Patrunjel, Marar, Leustean, Telina)));
        add(new Recipe("Ciorbă de perișoare", Once, List.of(Carne), F1, List.of())); // TODO No recipy
        add(new Recipe("Ciorbă de pui a la Grec", Once, List.of(Carne, Smantana), F1, List.of(Pastarnac, SucLamaie, Patrunjel, Marar, Telina)));
        add(new Recipe("Ciorbă de salată cu scrob", AtLeastOnce, List.of(Salata, Smantana), F1, List.of()));
        add(new Recipe("Ciorbă rădăuțeană", Once, List.of(Carne, Smantana), F1, List.of())); // TODO no recipy
        add(new Recipe("Ciuperci cu maioneză și usturoi", AtLeastOnce, List.of(Ciuperci, Maioneza), Rece, List.of()));
        add(new Recipe("Clătite", Optional, List.of(), Desert, List.of()));
        add(new Recipe("Cozonac", Once, List.of(), Desert, List.of()));
        add(new Recipe("Fasole bătută", Optional, List.of(Fasole), Rece, List.of()));
        add(new Recipe("Gigantes Plaki", AtLeastOnce, List.of(Fasole), F2, List.of(Usturoi, Patrunjel, Marar, Apio, FrunzeTelina)));
        add(new Recipe("Gratin de cartofi cu broccoli și brânză", Once, List.of(Cartofi, Broccoli, Smantana, Branza), F2, List.of(Usturoi)));
        add(new Recipe("Gratin de cartofi cu roșii și brânză", Once, List.of(Cartofi, Rosii, Smantana, Branza), F2, List.of(Busuioc)));
        add(new Recipe("Griș cu lapte", AtLeastOnce, List.of(), Desert, List.of()));
        add(new Recipe("Gulaș", Once, List.of(Cartofi, Carne), F2, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Usturoi, Patrunjel, Tarhon, FrunzeTelina)));
        add(new Recipe("Humus", AtLeastOnce, List.of(Naut), Rece, List.of()));
        add(new Recipe("Lasagna bolognese", Once, List.of(Carne), F2, List.of(Apio, VinAlb)));
        add(new Recipe("Lohikeitto", AtMostOnce, List.of(Peste, Smantana), F1, List.of(Dafin)));
        add(new Recipe("Mâncare de cartofi - ardelenească", AtLeastOnce, List.of(Cartofi), F2, List.of(Iuteala, BoiaDulce, BoiaIute, Dafin)));
        add(new Recipe("Mâncare de cartofi - Cu pui", AtMostOnce, List.of(Cartofi, Carne), F2, List.of(Dafin, BoiaDulce, Iuteala)));
        add(new Recipe("Mâncare de cartofi - Cu soia", Once, List.of(Cartofi, Soia), F2, List.of(Dafin, BoiaDulce, Iuteala)));
        add(new Recipe("Mâncare de cartofi - moldovenească", AtLeastOnce, List.of(Cartofi), F2, List.of(Patrunjel, Marar, Iuteala)));
        add(new Recipe("Mâncare de fasole - Fasole prăjită", AtLeastOnce, List.of(Fasole), F2, List.of(Marar)));
        add(new Recipe("Mâncare de fasole - Fasole prăjită - Fuchs remix", AtLeastOnce, List.of(Fasole), F2, List.of(Marar, FuchsFasole)));
        add(new Recipe("Mâncare de fasole - Iahnie de fasole", AtLeastOnce, List.of(Fasole), F2, List.of(Usturoi, Pastarnac, Dafin, Telina)));
        add(new Recipe("Mâncare de mazăre - Cu pui", Disabled, List.of(Mazare, Carne), F2, List.of(Marar, BoiaDulce, Dafin, Usturoi))); // mazărea cu soia e pur și simplu superioară
        add(new Recipe("Mâncare de mazăre - Cu soia", AtLeastOnce, List.of(Mazare, Soia), F2, List.of(Marar, BoiaDulce, Dafin, Usturoi)));
        add(new Recipe("Mâncare de mazăre - Simplu", Once, List.of(Mazare), F2, List.of(Marar)));
        add(new Recipe("Melanzane alla parmigiano", Once, List.of(Vinete, Branza), F2, List.of()));
        add(new Recipe("Minestrone", Once, List.of(), F1, List.of())); // TODO no recipy
        add(new Recipe("Musaca cu carne", Once, List.of(Cartofi, Carne), F2, List.of())); // TODO no recipy
        add(new Recipe("Musaca cu ragu", AtMostOnce, List.of(Cartofi, Carne), F2, List.of(Apio, VinAlb)));
        add(new Recipe("Musaca cu ciuperci", AtLeastOnce, List.of(Cartofi, Ciuperci), F2, List.of(), 2)); // TODO no recipy
        add(new Recipe("Musaca cu soia", Once, List.of(Cartofi, Soia), F2, List.of(Apio, VinAlb))); // TODO no recipy
        add(new Recipe("Nakkikeitto", AtMostOnce, List.of(Carne, Cartofi), F1, List.of(Pastarnac, Usturoi, Dafin, Patrunjel, Rozmarin)));
        add(new Recipe("Nakkikeitto - V", AtLeastOnce, List.of(Cartofi, Soia), F1, List.of(Pastarnac, Usturoi, Dafin, Patrunjel, Rozmarin), 2));
        add(new Recipe("Pilaf - Cu ciuperci și alte legume", AtLeastOnce, List.of(Orez, Ciuperci), F2, List.of(Marar, Patrunjel, Pastarnac, Telina)));
        add(new Recipe("Pilaf - Cu urzici", Once, List.of(Orez, Urzici), F2, List.of(Patrunjel)));
        add(new Recipe("Pilaf - Paella cu pui", Once, List.of(Orez, Carne), F2, List.of(Usturoi, Patrunjel, Curcuma, SucLamaie)));
        add(new Recipe("Pilaf - Sarmale cu varză murată și carne", Disabled, List.of(Orez, VarzaMurata, Carne), F2, List.of())); // TODO no recipy
        add(new Recipe("Pilaf - Sarmale viță de vie simplu", Disabled, List.of(Orez), F2, List.of())); // TODO no recipy
        add(new Recipe("Pilaf - Sarmale viță de vie cu carne", Once, List.of(Orez, Carne), F2, List.of())); // TODO no recipy
        add(new Recipe("Pilaf - Simplu", AtLeastOnce, List.of(Orez), F2, List.of(Curcuma), 2));
        add(new Recipe("Răcitură", Once, List.of(Carne), F2, List.of(Usturoi)));
        add(new Recipe("Riz au lait", AtLeastOnce, List.of(Orez), Desert, List.of()));
        add(new Recipe("Salată boeuf", Optional, List.of(Cartofi, Maioneza), Rece, List.of(Mustar)));
        add(new Recipe("Salată de pui", Once, List.of(Carne, Maioneza), Rece, List.of()));
        add(new Recipe("Salată de vienete cu usturoi", AtLeastOnce, List.of(Vinete, Maioneza), Rece, List.of(Usturoi)));
        add(new Recipe("Salată orientală", AtLeastOnce, List.of(Cartofi), Rece, List.of()));
        add(new Recipe("Supă cremă de broccoli - Cu carne", AtMostOnce, List.of(Broccoli, Carne), F1, List.of(Usturoi, Telina)));
        add(new Recipe("Supă cremă de broccoli - Simplu", AtLeastOnce, List.of(Broccoli), F1, List.of(Usturoi, Telina)));
        add(new Recipe("Supă cremă de broccoli - Soia", Once, List.of(Broccoli, Soia), F1, List.of(Usturoi, Telina)));
        add(new Recipe("Supă cremă de conopidă", AtMostOnce, List.of(Conopida, Smantana), F1, List.of(Usturoi, Patrunjel)));
        add(new Recipe("Supă cremă de dovleac", Once, List.of(DovlecPlacintar), F1, List.of(Telina)));
        add(new Recipe("Supă cremă de dovlecei", Once, List.of(Dovlecei), F1, List.of())); // TODO no recipy
        add(new Recipe("Supă cremă de mazăre", AtLeastOnce, List.of(Mazare), F1, List.of()));
        add(new Recipe("Supă cremă de țelină - Cu praz și smântână", Once, List.of(Ingredient.Telina, Praz, Smantana), F1, List.of(Pastarnac)));
        add(new Recipe("Supă cremă de țelină - Mama", AtLeastOnce, List.of(Ingredient.Telina), F1, List.of(Pastarnac)));
        add(new Recipe("Supă de cartofi și mazăre", Once, List.of(Cartofi, Mazare), F1, List.of(Usturoi, Coriandru, Curry)));
        add(new Recipe("Supă de conopidă", Once, List.of(Conopida), F1, List.of(SucLamaie)));
        add(new Recipe("Supă de roșii", AtLeastOnce, List.of(Rosii), F1, List.of(Pastarnac, Patrunjel, Apio, Telina, FrunzeTelina)));
        add(new Recipe("Tiramisu", AtLeastOnce, List.of(), Desert, List.of()));
        add(new Recipe("Tocănița Malita", Once, List.of(Soia, Ardei), F2, List.of(Usturoi, BoiaIute, Coriandru)));
        add(new Recipe("Tocăniță de ardei", Once, List.of(Ardei), F2, List.of()));
        add(new Recipe("Tocăniță de ardei cu ton", Once, List.of(Ardei, Ton), F2, List.of()));
        add(new Recipe("Tocăniță de ardei cu soia", AtLeastOnce, List.of(Ardei, Soia), F2, List.of()));
        add(new Recipe("Tocăniță de gogonele", AtLeastOnce, List.of(Gogonele), F2, List.of()));
        add(new Recipe("Tocăniță de legume", AtLeastOnce, List.of(Ardei), F2, List.of(Patrunjel, FrunzeTelina)));
        add(new Recipe("Tocăniță de praz", AtLeastOnce, List.of(Praz), F2, List.of(Patrunjel, Dafin, Usturoi, SucLamaie)));
        add(new Recipe("Tzatziki", AtLeastOnce, List.of(Iaurt, Castraveti), Rece, List.of(Marar, Usturoi)));
        add(new Recipe("Țelină cu morcov", AtLeastOnce, List.of(Ingredient.Telina, Maioneza, Ton), Rece, List.of()));
        add(new Recipe("Varză călită", Once, List.of(VarzaMurata), F2, List.of())); // TODO no recipy, goes with chiftele
        add(new Recipe("Varză fiartă", AtLeastOnce, List.of(Varza), F2, List.of(Dafin)));
        add(new Recipe("Varză fiartă cu fish fingers", Once, List.of(Varza, Peste), F2, List.of(Dafin)));
        add(new Recipe("Varză fiartă cu soia", AtLeastOnce, List.of(Varza, Soia), F2, List.of(Dafin)));
        add(new Recipe("Varză la Cluj", Once, List.of(VarzaMurata, Carne), F2, List.of())); // TODO no recipy
        add(new Recipe("Varză la Cluj cu soia", Once, List.of(VarzaMurata, Soia), F2, List.of())); // TODO no recipy
        add(new Recipe("Vitel tonne", Once, List.of(Carne, Ton), Rece, List.of())); // TODO no recipy

        // Fast Food
        add(new Recipe("Mămăligă", AtLeastOnce, List.of(), FastFood, List.of()));
        add(new Recipe("Găgău", AtLeastOnce, List.of(), FastFood, List.of()));
        add(new Recipe("Mâncare de ciuperci - Ciulama de ciuperci", Once, List.of(Ciuperci), FastFood, List.of(Patrunjel, Marar)));
        add(new Recipe("Mâncare de ciuperci - Ciuperci cu smântână și usturoi", AtMostOnce, List.of(Ciuperci, Smantana), FastFood, List.of(Patrunjel, Usturoi)));
        add(new Recipe("Spanac cu smântână", Once, List.of(Spanac, Smantana), FastFood, List.of(Usturoi)));
        add(new Recipe("Mâncărică de păstăi", AtLeastOnce, List.of(PastaiCongelate), FastFood, List.of(Patrunjel)));
        add(new Recipe("Microfoane", Once, List.of(Carne), FastFood, List.of(BoiaDulce)));
        add(new Recipe("Ficat de pui prăjit", Once, List.of(Carne), FastFood, List.of()));
        add(new Recipe("Fish fingers", Once, List.of(Carne), FastFood, List.of()));
        add(new Recipe("Șnițel de soia", AtLeastOnce, List.of(Soia), FastFood, List.of()));
        add(new Recipe("Șnițel de pui", Once, List.of(Carne), FastFood, List.of()));
        add(new Recipe("Somon prăjit", Once, List.of(Carne), FastFood, List.of()));
        add(new Recipe("Pește prăjit", Once, List.of(Carne), FastFood, List.of()));
        add(new Recipe("Omletă cremă", AtLeastOnce, List.of(Ou), FastFood, List.of()));
        add(new Recipe("Omletă normală", AtLeastOnce, List.of(Ou), FastFood, List.of()));
        add(new Recipe("Roșii cu brânză", AtLeastOnce, List.of(), FastFood, List.of()));
        add(new Recipe("Salad Box", AtLeastOnce, List.of(), FastFood, List.of()));
        add(new Recipe("Cobb Salad", AtLeastOnce, List.of(), FastFood, List.of()));
        add(new Recipe("Facebook Salad", AtLeastOnce, List.of(), FastFood, List.of()));
        add(new Recipe("Paste - Pesto al Genovese (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - Al sugo di pomodoro", Once, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - cu somon", Once, List.of(Paste, Carne), FastFood, List.of()));
        add(new Recipe("Paste - cu ton", Once, List.of(Paste, Ton), FastFood, List.of()));
        add(new Recipe("Paste - con Verdura (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - con Ricotta (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - Napoletane (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - con Olive (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - cu Basilico (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - con Funghi (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - Quattro Formaggi (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - Carbonara (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - Arrabbiata (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        add(new Recipe("Paste - Bolognese (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));

        // Fruits
        add(new Recipe("Banane", AtLeastOnce, List.of(Banane), Fruits, List.of()));
        add(new Recipe("Caise", AtLeastOnce, List.of(Caise), Fruits, List.of()));
        add(new Recipe("Capșuni", Once, List.of(Capsuni), Fruits, List.of()));
        add(new Recipe("Cireșe", Once, List.of(Cirese), Fruits, List.of()));
        add(new Recipe("Clementine", Once, List.of(Clementine), Fruits, List.of()));
        add(new Recipe("Grapefruit", AtMostOnce, List.of(Grapefruit), Fruits, List.of()));
        add(new Recipe("Kaki", AtLeastOnce, List.of(Kaki), Fruits, List.of()));
        add(new Recipe("Kiwi", AtLeastOnce, List.of(Kiwi), Fruits, List.of()));
        add(new Recipe("Mandarine", Once, List.of(Mandarine), Fruits, List.of()));
        add(new Recipe("Mango", AtMostOnce, List.of(Mango), Fruits, List.of()));
        add(new Recipe("Mere", AtLeastOnce, List.of(Mere), Fruits, List.of()));
        add(new Recipe("Mineole", Once, List.of(Mineole), Fruits, List.of()));
        add(new Recipe("Papaya", AtMostOnce, List.of(Papaya), Fruits, List.of()));
        add(new Recipe("Pepene Galben", Once, List.of(PepeneGalben), Fruits, List.of()));
        add(new Recipe("Pepene Roșu", AtLeastOnce, List.of(PepeneRosu), Fruits, List.of()));
        add(new Recipe("Pere", AtLeastOnce, List.of(Pere), Fruits, List.of()));
        add(new Recipe("Portocale", AtLeastOnce, List.of(Portocale), Fruits, List.of()));
        add(new Recipe("Prune", AtLeastOnce, List.of(Prune), Fruits, List.of()));
        add(new Recipe("Rodii", AtMostOnce, List.of(Prune), Fruits, List.of()));
        add(new Recipe("Struguri", Once, List.of(Struguri), Fruits, List.of()));
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

            if (schedule.reachedLimit(recipe)) continue;

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

    public Recipe(String name, Multiplicity multiplicity, List<Ingredient> ingredients, Fel fel, List<Spice> spices) {
        this.name = name;
        this.ingredients = ingredients;
        this.multiplicity = multiplicity;
        this.fel = fel;
        this.spices = spices;
    }

    public Recipe(String name, Multiplicity multiplicity, List<Ingredient> ingredients, Fel fel, List<Spice> spices, int limit) {
        this(name, multiplicity, ingredients, fel, spices);
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
            for (Ingredient aka : ingredient.akas) {
                if (recipe.ingredients.contains(aka)) return true;
            }
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
