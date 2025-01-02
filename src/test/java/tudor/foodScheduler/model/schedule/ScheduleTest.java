package tudor.foodScheduler.model.schedule;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tudor.foodScheduler.Scheduler;
import tudor.foodScheduler.model.Recipe;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    @Test
    void shouldCopyContents() {
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

        Recipe applePie = Recipe.get("Apple Pie");
        schedule.add(1, 1, applePie, false);

        assertTrue(schedule.isRecipePresent(applePie));
        assertSame(applePie, schedule.recipes.get(0).get(0).get(2).recipe);

        Schedule copy = schedule.copy();

        assertTrue(copy.isRecipePresent(applePie));
        assertSame(applePie, copy.recipes.get(0).get(0).get(2).recipe);

        Recipe ardei = Recipe.get("Ardei umpluți simplu");
        copy.add(1, 1, ardei, false);

        assertTrue(copy.isRecipePresent(ardei));
        assertFalse(schedule.isRecipePresent(ardei));

        assertSame(ardei, copy.recipes.get(0).get(0).get(1).recipe);
        assertNull(schedule.recipes.get(0).get(0).get(1));
    }

    @Test
    void shouldDetectDuplicates() {
        Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});
        Recipe fasoleCuChimen = Recipe.get("Ciorbă de fasole - Cu chimen");
        Recipe fasoleCuDafin = Recipe.get("Ciorbă de fasole - Cu dafin");
        schedule.add(12, 4, fasoleCuChimen, false);
        schedule.add(1, 1, fasoleCuDafin, false);

        Duplication duplication = schedule.getIngredientDuplicate();
        assertNotNull(duplication);
        assertSame(fasoleCuChimen, duplication.recipe1);
        assertSame(fasoleCuDafin, duplication.recipe2);
    }

    @Test
    void shouldIdentifyReplacements() {
        Schedule schedule = new Schedule(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

        Recipe fasoleCuDafin = Recipe.get("Ciorbă de fasole - Cu dafin");
        Recipe cartofiArdelenesti = Recipe.get("Mâncare de cartofi - ardelenească");
        for (int i=1; i<13; i++) {
            schedule.add(i, 1, fasoleCuDafin, false);
            schedule.add(i, 1, cartofiArdelenesti, false);
        }

        List<Recipe> candidates = schedule.getSuitableReplacements(new ScheduleSlot(0,0), fasoleCuDafin);
        System.out.println("Hello");
    }

    @Nested
    class getDistance {
        @Test
        void shouldDetectCorrectDistanceByAka() {
            Schedule schedule = new Schedule(new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4});

            Recipe cPastai = Recipe.get("Ciorbă de păstăi");
            Recipe cPastaiFresh = Recipe.get("Ciorbă de păstăi fresh");

            schedule.add(2, 2, cPastai, true);
            int distance = schedule.getDistance(new ScheduleSlot(0,0), cPastaiFresh.ingredients, 0);
            assertEquals(4, distance);
        }
    }

    @Test
    void shouldIdentifySuitableReplacement2() {
        String input = """
                1	1	Ciorbă de salată cu scrob	Pilaf - Simplu	
                1	2	Ciorbă de cartofi roșie	Musaca cu carne	Riz au lait
                1	3	Ciorbă de fasole - Cu dafin	Varză călită	
                1	4	Supă cremă de broccoli - Simplu	Tocăniță de ardei	Salată orientală
                2	1	Supă cremă de mazăre	Gratin de cartofi cu roșii și brânză	Riz au lait
                2	2	Supă de roșii	Mâncare de fasole - Fasole prăjită	Griș cu lapte
                2	3	Ciorbă de fasole - Cu dafin	Mâncare de cartofi - Cu pui	Vitel tonne
                2	4	Ciorbă rădăuțeană	Mâncare de mazăre - Cu soia	Chiftele de soia în suc de roșii
                3	1	Supă cremă de țelină - Cu praz și smântână	Mâncare de cartofi - Cu soia	
                3	2	Ciorbă de cartofi cu smântână	Mâncare de mazăre - Cu soia	Salată boeuf
                3	3	Ciorbă de păstăi	Mâncare de fasole - Iahnie de fasole	
                3	4	Supă cremă de țelină - Mama	Varză fiartă	Țelină cu morcov
                3	5	Supă cremă de mazăre	Pilaf - Cu ciuperci și alte legume	Griș cu lapte
                4	1	Ciorbă de fasole - Cu leuștean	Mâncare de cartofi - moldovenească	
                4	2	Ciorbă de frunze	Măncare de fasole - Fasole prăjită - Fuchs remix	Riz au lait
                4	3	Ciorbă de fasole - Cu leuștean	Gigantes Plaki	Cozonac
                4	4	Ciorbă de fasole - Cu chimen	Pilaf - Cu urzici	
                5	1	Supă cremă de broccoli - Soia	Mâncare de cartofi - ardelenească	
                5	2	Ciorbă de păstăi fresh	Gigantes Plaki	Salată de pui
                5	3	Nakkikeitto - V	Tocăniță de legume	
                5	4	Ciorbă de fasole - Cu cimbru	Mâncare de cartofi - ardelenească	Ciuperci cu maioneză și usturoi
                6	1	Ciorbă de cartofi roșie	Melanzane alla parmigiano	Tiramisu
                6	2	Ciorbă de dovlecei cu ciuperci	Ardei umpluți simplu	Tzatziki
                6	3	Ciorbă de conopidă	Tocăniță de legume	
                6	4	Ciorbă de frunze	Mâncare de cartofi - ardelenească	Tzatziki
                6	5	Supă de roșii	Mâncare de cartofi - moldovenească	Tzatziki
                7	1	Ciorbă de dovlecei cu ciuperci	American Potato Salad	Apple Pie
                7	2	Supă cremă de broccoli - Simplu	Gratin de cartofi cu broccoli și brânză	
                7	3	Ciorbă de năut cu afumătură	Tocăniță de legume	Humus
                7	4	Supă cremă de dovlecei	Gigantes Plaki	Mâncare de ciuperci - Ciulama de ciuperci
                8	1	Ciorbă de cartofi cu smântână	Tocăniță de legume	Chiftele cu carne
                8	2	Ciorbă de dovlecei cu ciuperci	Mâncare de fasole - Iahnie de fasole	Tzatziki
                8	3	Supă cremă de conopidă	Gulaș	Tzatziki
                8	4	Nakkikeitto	Tocăniță de ardei	Țelină cu morcov
                8	5	Ciorbă de cartofi roșie	Varză fiartă	
                9	1	Ciorbă de fasole - Cu dafin	Varză fiartă	Riz au lait
                9	2	Ciorbă de fasole - Cu cimbru	Varză călită	
                9	3	Supă cremă de mazăre	Tocăniță de gogonele	
                9	4	Supă cremă de țelină - Mama	Mâncare de mazăre - Simplu	Țelină cu morcov
                10	1	Supă de roșii	Varză la Cluj	
                10	2	Supă cremă de țelină - Mama	Pilaf - Paella cu pui	Țelină cu morcov
                10	3	Supă cremă de broccoli - Simplu	Varză fiartă	
                10	4	Ciorbă de conopidă	Pilaf - Sarmale viță de vie cu carne	Salată orientală
                11	1	Ciorbă de fasole - Cu dafin	Pilaf - Simplu	Apple Pie
                11	2	Ciorbă de salată cu scrob	Musaca cu ciuperci	Apple Pie
                11	3	Supă cremă de mazăre	Tocăniță de praz	
                11	4	Supă de conopidă	Tocăniță de gogonele	Țelină cu morcov
                11	5	Supă cremă de broccoli - Simplu	Mâncare de fasole - Iahnie de fasole	
                12	1	Nakkikeitto - V	Mâncare de mazăre - Cu soia	
                12	2	Ciorbă de cartofi roșie	Lasagna bolognese	Fasole bătută
                12	3	Supă cremă de conopidă	Răcitură	
                12	4	Supă cremă de broccoli - Simplu	Măncare de fasole - Fasole prăjită - Fuchs remix	
                """;

        Schedule schedule = ScheduleInitializer.getSchedule(input);

        schedule.countRecipes();

        List<Recipe> suitableReplacements = schedule.getSuitableReplacements(new ScheduleSlot(1, 3), Recipe.get("Ciorbă rădăuțeană"));

        assertFalse(suitableReplacements.isEmpty());
    }

    @Test
    void shouldNotIdentify2ConstraintsWhereThereIsOnlyOne() {
        String input = """
                1	1	Ciorbă de fasole - Cu dafin	Mâncare de mazăre - Cu soia	Clătite
                1	2	Ciorbă de cartofi cu smântână	Musaca cu carne	Humus
                1	3	Supă cremă de mazăre	Varză călită	Vitel tonne
                1	4	Ciorbă de ghebe cu smântână	Tocăniță de praz	Griș cu lapte
                2	1	Supă cremă de mazăre	Mâncare de cartofi - moldovenească	Fasole bătută
                2	2	Supă cremă de broccoli - Simplu	Mâncare de mazăre - Simplu	Țelină cu morcov
                2	3	Ciorbă de cartofi roșie	Musaca cu ciuperci	
                2	4	Ciorbă de conopidă	Varză fiartă	Țelină cu morcov
                3	1	Supă cremă de țelină - Mama	Tocăniță de ardei	Chiftele cu carne
                3	2	Supă de roșii	Măncare de fasole - Fasole prăjită - Fuchs remix	
                3	3	Ciorbă de cartofi cu smântână	Mâncare de mazăre - Cu soia	
                3	4	Ciorbă de fasole - Cu dafin	Musaca cu ciuperci	Salată orientală
                3	5	Supă cremă de mazăre	Pilaf - Cu urzici	Tiramisu
                4	1	Ciorbă de frunze	Mâncare de cartofi - ardelenească	
                4	2	Ciorbă rădăuțeană	Pilaf - Cu ciuperci și alte legume	
                4	3	Ciorbă de păstăi	Varză fiartă	Cozonac
                4	4	Supă cremă de broccoli - Simplu	Mâncare de fasole - Fasole prăjită	Mâncare de ciuperci - Ciulama de ciuperci
                5	1	Supă cremă de mazăre	Tocăniță de legume	Humus
                5	2	Ciorbă de păstăi fresh	Mâncare de cartofi - Cu soia	
                5	3	Supă cremă de mazăre	Mâncare de mazăre - Simplu	Clătite
                5	4	Supă de roșii	Pilaf - Cu ciuperci și alte legume	
                6	1	Ciorbă de fasole - Cu chimen	Melanzane alla parmigiano	Chiftele de soia în suc de roșii
                6	2	Supă de conopidă	Mâncare de cartofi - moldovenească	
                6	3	Ciorbă de dovlecei cu ciuperci	Varză fiartă	
                6	4	Ciorbă de frunze	Gratin de cartofi cu broccoli și brânză	Salată orientală
                6	5	Supă cremă de mazăre	Tocăniță de gogonele	
                7	1	Ciorbă de dovlecei cu ciuperci	American Potato Salad	Apple Pie
                7	2	Nakkikeitto	Gratin de cartofi cu broccoli și brânză	Fasole bătută
                7	3	Supă cremă de dovlecei	Lasagna bolognese	Humus
                7	4	Ciorbă de salată cu scrob	Tocăniță de ardei	Tiramisu
                8	1	Supă cremă de broccoli - Simplu	Măncare de fasole - Fasole prăjită - Fuchs remix	
                8	2	Supă cremă de broccoli - Soia	Ardei umpluți cu carne	Tzatziki
                8	3	Ciorbă de fasole - Cu dafin	Gulaș	
                8	4	Ciorbă de păstăi	Ardei umpluți simplu	Riz au lait
                8	5	Ciorbă de păstăi	Tocăniță de legume	
                9	1	Supă cremă de broccoli - Simplu	Varză fiartă	Salată orientală
                9	2	Ciorbă de fasole - Cu cimbru	Mâncare de fasole - Iahnie de fasole	
                9	3	Ciorbă de dovlecei cu ciuperci	Varză la Cluj	Salată de pui
                9	4	Supă cremă de țelină - Mama	Musaca cu ciuperci	Riz au lait
                10	1	Supă cremă de broccoli - Cu carne	Tocăniță de gogonele	
                10	2	Supă cremă de conopidă	Pilaf - Paella cu pui	Griș cu lapte
                10	3	Ciorbă de fasole - Cu leuștean	Mâncare de mazăre - Simplu	
                10	4	Ciorbă de conopidă	Pilaf - Sarmale viță de vie cu carne	Fasole bătută
                11	1	Supă cremă de mazăre	Tocăniță de gogonele	Țelină cu morcov
                11	2	Ciorbă de fasole - Cu leuștean	Tocăniță de praz	Apple Pie
                11	3	Supă cremă de țelină - Cu praz și smântână	Mâncare de fasole - Iahnie de fasole	
                11	4	Ciorbă de perișoare	Tocăniță de gogonele	Țelină cu morcov
                11	5	Supă de roșii	Mâncare de fasole - Iahnie de fasole	
                12	1	Nakkikeitto - V	Pilaf - Simplu	
                12	2	Supă cremă de mazăre	Gigantes Plaki	Apple Pie
                12	3	Supă cremă de mazăre	Răcitură	Salată orientală
                12	4	Ciorbă de păstăi	Măncare de fasole - Fasole prăjită - Fuchs remix	
                """;

        Schedule schedule = ScheduleInitializer.getSchedule(input);

        schedule.countRecipes();

        Duplication duplication = schedule.getIngredientDuplicate();

        System.out.println("Hello");
    }
}