package tudor.foodScheduler;

import tudor.foodScheduler.foodDataCentral.NutrientLoader;
import tudor.foodScheduler.model.cookbook.TudorCookBook;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleInitializer;

public class CsvRun {
    public static boolean fillRemainingSlots = false; // e bun ca la sfarsitul anului incarci un calendar existent si el vrea sa umple cu retete noi

    public static void main(String[] args) throws Exception {
        String input = """
                1	1	Ciorbă de fasole - Cu chimen	Tocăniță de ardei	Omletă cremă	Mineole	Ciuperci cu maioneză și usturoi
                1	2	Nakkikeitto	Musaca cu carne	Ciuperci cu smântână și usturoi	Kiwi	Humus
                1	3	Ciorbă de dovlecei cu ciuperci	Mazăre cu soia	Roșii cu brânză	Clementine	Apple Pie
                1	4	Supă cremă de țelină - Cu praz și smântână	Tocăniță de legume	Somon prăjit	Papaya	Salată boeuf cu vită
                2	1	Supă de conopidă	Musaca cu ciuperci	Omletă cremă	Grapefruit	Clătite
                2	2	Supă cremă de dovleac	Varză fiartă	Fish fingers	Mandarine	Griș cu lapte
                2	3	Ciorbă de salată cu scrob	Ghiveci	Șnițel de pui	Kiwi	Ciuperci cu maioneză și usturoi
                2	4	Supă cremă de broccoli - Simplu	Tocănița Malita	Mâncărică de păstăi	Portocale (1.5Kg)	Riz au lait
                3	1	Ciorbă de fasole - Cu leuștean	Mâncare de cartofi ardelenească	Găgău	Mere	Griș cu lapte
                3	2	Supă cremă de țelină - Mama	Tocăniță de ardei cu soia	Găgău	Pere	Humus cu pesto
                3	3	Ciorbă de fasole - Cu chimen	Mâncare de cartofi ardelenească	Roșii cu brânză	Banane	Ciuperci cu maioneză și usturoi
                3	4	Ciorbă de pui a la Grec	Gigantes Plaki	Mămăligă	Mere	Tzatziki
                3	5	Ciorbă de frunze	Mâncare de cartofi cu pui	Facebook Salad	Banane	Salată de vinete cu usturoi
                4	1	Ciorbă de cartofi roșie	Tocăniță de praz	Omletă cremă	Mere	Chiftele cu carne
                4	2	Supă cremă de mazăre	Pilaf cu ciuperci și alte legume	Omletă normală	Pere	Humus cu pesto
                4	3	Supă de roșii	Varză călită	Salad Box	Banane	Salată orientală
                4	4	Ciorbă de conopidă	Fasole prăjită	Mâncărică de păstăi	Pere	Humus
                5	1	Ciorbă de păstăi	Lasagna bolognese	Găgău	Banane	Salată boeuf cu vită
                5	2	Ciorbă de dovlecei cu ciuperci	Mâncare de păstăi	Microfoane	Pere	Fasole bătută
                5	3	Supă cremă de broccoli - Cu carne	Ardei umpluți cu carne	Mâncărică de păstăi	Mere	Salată orientală
                5	4	Ciorbă de fasole - Cu leuștean	Fasole prăjită - Fuchs remix	Omletă normală	Pere	Fasole bătută
                6	1	Supă cremă de țelină - Mama	Melanzane alla parmigiano	Roșii cu brânză	Cireșe	Humus cu pesto
                6	2	Ciorbă de perișoare	Tocăniță de gogonele	Ciuperci prăjite	Mango	Salată de vinete cu usturoi
                6	3	Ciorbă de broccoli	Mâncare de cartofi moldovenească	Mămăligă cu brânză	Mere	Tzatziki
                6	4	Supă de roșii	Varză la Cluj	Omletă normală	Caise	Fasole bătută
                6	5	Supă cremă de țelină - Mama	Pilaf cu ciuperci și alte legume	Cobb Salad	Banane	Salată orientală
                7	1	Minestrone	American Potato Salad	Mâncărică de păstăi	Caise	Plăcintă cu mere - Foietaj
                7	2	Supă de roșii	Fasole prăjită	Ciulama de ciuperci	Mere	Salată de vinete cu ceapă
                7	3	Ciorbă rădăuțeană	Gratin de cartofi cu broccoli și brânză	Penne quatro formaggi (semi)	Pepene Roșu	Humus
                7	4	Ciorbă de fasole - Cu dafin	Mazăre - Simplu	Mămăligă cu brânză	Mere	Salată de vinete cu usturoi
                8	1	Ciorbă de salată cu scrob	Varză fiartă	Spanac cu smântână	Rodii	Tzatziki
                8	2	Supă cremă de dovlecei	Mâncare de cartofi cu soia	Pasta al sugo di pomodoro	Capșuni	Țelină cu morcov
                8	3	Ciorbă de cartofi cu smântână	Gulaș	Mâncărică de păstăi	Pere	Humus cu pesto
                8	4	Minestrone	Ghiveci	Mâncărică de păstăi	Caise	Salată de vinete cu usturoi
                8	5	Supă de cartofi și mazăre	Mâncare de cartofi moldovenească	Șnițel de soia	Banane	Salată de pui cu legume
                9	1	Supă cremă de broccoli - Simplu	Tocăniță de ardei cu soia	Salad Box	Pepene Roșu	Salată orientală
                9	2	Ciorbă de năut cu afumătură	Mâncare de cartofi ardelenească	Spaghetti alla carbonara (semi)	Pepene Galben	Fasole bătută
                9	3	Ciorbă de fasole - Cu leuștean	Tocăniță de legume	Omletă cu roșii	Struguri Albi	Tiramisu
                9	4	Supă de roșii	Pilaf cu dovlecei	Pasta al salmone	Pere	Fasole bătută
                10	1	Ciorbă de fasole - Cu cimbru	Musaca cu soia	Șnițel de soia	Prune (1Kg)	Vitello tonnato
                10	2	Ciorbă de cartofi roșie	Pilaf cu ciuperci	Ficat de pui prăjit	Kiwi	American Pancakes
                10	3	Supă cremă de broccoli - Soia	Varză cu soia	Șnițel de soia	Banane	Salată de vinete cu usturoi
                10	4	Supă de roșii	Sarmale viță de vie cu carne	Facebook Salad	Kaki	Fasole pasată cu ceapă
                11	1	Ciorbă de păstăi	Varză la Cluj cu soia	Găgău	Portocale (1.5Kg)	Budincă
                11	2	Minestrone	Gratin de cartofi cu roșii și brânză	Mâncărică de păstăi	Kaki	Humus cu pesto
                11	3	Ciorbă de conopidă	Varză fiartă	Pasta con tonno	Mere	Plăcintă cu mere - Foietaj
                11	4	Supă cremă de mazăre	Ardei umpluți simplu	Șnițel de soia	Kaki	Salată de pui cu ciuperci
                11	5	Ciorbă de ghebe cu smântână	Mâncare de linte	Salad Box	Prune (1Kg)	Humus
                12	1	Supă de cartofi și mazăre	Sarmale viță de vie cu soia	Pește prăjit	Banane	Chiftele de soia în suc de roșii
                12	2	Țelină cu morcov	Ciuperci cu maioneză și usturoi	Găgău	Portocale (1.5Kg)	Tzatziki
                12	3	Supă cremă de spanac	Ghiveci	Pasta al pesto genovese (semi)	Mere	Guacamole
                12	4	Supă mexicană	Pilaf - Simplu	Salad Box	Portocale (1.5Kg)	Cremă de avocado cu brânză și usturoi
                """;
        System.out.println("Loading nutrients...");
        NutrientLoader.load();
        Schedule schedule = ScheduleInitializer.getSchedule(input, true, TudorCookBook.buildCookbook());

        InitialRun.addConstraints(schedule);

//        String input = """
//1	1	Supă cremă de țelină - Cu praz și smântână
//1	2	Ciorbă de conopidă
//1	3	Supă cremă de țelină - Mama
//1	4	Ciorbă de dovlecei cu ciuperci
//2	1	Nakkikeitto
//2	2	Ciorbă de broccoli
//2	3	Supă cremă de mazăre
//2	4	Ciorbă de fasole - Cu dafin
//3	1	Supă cremă de broccoli - Simplu
//3	2	Ciorbă de ghebe cu smântână
//3	3	Supă cremă de țelină - Mama
//3	4	Ciorbă de salată cu scrob
//3	5	Ciorbă de conopidă
//4	1	Lohikeitto
//4	2	Ciorbă de cartofi cu smântână
//4	3	Supă de cartofi și mazăre
//4	4	Ciorbă de fasole - Cu leuștean
//5	1	Supă cremă de țelină - Mama
//5	2	Ciorbă de salată cu scrob
//5	3	Ciorbă de perișoare
//5	4	Ciorbă de salată cu scrob
//6	1	Ciorbă de fasole - Cu dafin
//6	2	Ciorbă de fasole - Cu chimen
//6	3	Ciorbă de fasole - Cu cimbru
//6	4	Supă cremă de broccoli - Simplu
//6	5	Supă cremă de mazăre
//7	1	Nakkikeitto - V
//7	2	Supă de conopidă
//7	3	Supă cremă de broccoli - Simplu
//7	4	Ciorbă de conopidă
//8	1	Supă cremă de broccoli - Soia
//8	2	Ciorbă de dovlecei cu ciuperci
//8	3	Ciorbă de cartofi roșie
//8	4	Ciorbă rădăuțeană
//8	5	Ciorbă de păstăi
//9	1	Supă cremă de mazăre
//9	2	Supă de roșii
//9	3	Ciorbă de pui a la Grec
//9	4	Supă cremă de dovlecei
//10	1	Ciorbă de broccoli
//10	2	Supă cremă de țelină - Mama
//10	3	Minestrone
//10	4	Supă cremă de broccoli - Simplu
//11	1	Supă cremă de dovleac
//11	2	Ciorbă de cartofi cu smântână
//11	3	Minestrone
//11	4	Supă cremă de broccoli - Simplu
//11	5	Ciorbă de năut cu afumătură
//12	1	Supă cremă de broccoli - Simplu
//12	2	Minestrone
//12	3	Supă cremă de broccoli - Cu carne
//12	4	Supă cremă de conopidă
//                """;
//        Schedule schedule = ScheduleInitializer.getSchedule(input, false, CiorbeCookBook.buildCookbook());

        InitialRun.completeRecipe(schedule);
    }
}
