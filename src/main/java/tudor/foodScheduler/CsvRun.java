package tudor.foodScheduler;

import tudor.foodScheduler.foodDataCentral.NutrientLoader;
import tudor.foodScheduler.model.cookbook.TudorCookBook;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleInitializer;

public class CsvRun {
    public static boolean fillRemainingSlots = false; // e bun ca la sfarsitul anului incarci un calendar existent si el vrea sa umple cu retete noi

    public static void main(String[] args) throws Exception {
        String input = """
                1	1	Minestrone	Mazăre cu soia	Șnițel de soia	Kaki	Ouă umplute cu ficat
                1	2	Supă de conopidă ardelenească	Tocănița Malita	Găgău	Mineole	Salată boeuf cu vită
                1	3	Lohikeitto	Mâncare de cartofi ardelenească	Ciuperci prăjite	Clementine	Ciuperci cu maioneză și usturoi
                1	4	Supă cremă de spanac	Musaca cu ciuperci	Ciulama de ciuperci	Grapefruit	Ciorbă de fasole - Cu chimen
                2	1	Supă cremă de linte roșie	Pilaf - Simplu	Spanac cu smântână	Pere	Clătite cu vișine moldovenești
                2	2	Nakkikeitto	Tocăniță de ardei	Ciulama de ciuperci	Mere	Ciorbă de cartofi cu castraveți murați
                2	3	Supă cremă de mazăre	Pilaf cu dovlecei	Facebook Salad	Pepene Galben	Ciuperci cu maioneză și usturoi
                2	4	Ciorbă de perișoare	Varză la Cluj cu soia	Penne quatro formaggi (semi)	Mere	Salată de pui cu legume
                3	1	Ciorbă de conopidă	Mazăre - Simplu	Spanac cu smântână	Pepene Galben	Ouă umplute vegetariene
                3	2	Supă cremă de broccoli - Soia	Lasagna cu spanac	Ciuperci cu smântână și usturoi	Kiwi	Fasole bătută
                3	3	Supă cremă de conopidă	Ghiveci	Pasta al salmone	Portocale (1.5Kg)	Salată de pui
                3	4	Supă cremă de dovlecei	Iahnie de fasole	Ficat de pui prăjit	Kiwi	Humus
                3	5	Ciorbă de fasole - Cu cimbru	Lasagna cu spanac	Pește prăjit	Mandarine	Tzatziki
                4	1	Ciorbă de salată cu scrob	Mazăre cu pui	Somon prăjit	Pepene Galben	Vitello tonnato
                4	2	Ciorbă de fasole - Cu dafin	Gigantes Plaki	Cobb Salad	Mango	Fasole bătută
                4	3	Supă cremă de mazăre	Tocăniță de praz	Găgău	Pepene Galben	Salată de pui
                4	4	Supă cremă de conopidă	Pilaf cu dovlecei	Cobb Salad	Portocale (1.5Kg)	Humus cu pesto
                5	1	Supă de roșii	Mâncare de cartofi moldovenească	Găgău	Rodii	American Pancakes
                5	2	Supă de cartofi și mazăre	Gulaș	Cobb Salad	Banane	Korozott
                5	3	Ciorbă de salată cu scrob	Melanzane alla parmigiano	Omletă cremă	Pere	Fasole pasată cu ceapă
                5	4	Supă de conopidă ardelenească	Fasole prăjită	Omletă normală	Kiwi	American Potato Salad
                5	5	Supă cremă de conopidă	Lasagna bolognese	Cobb Salad	Nucă	Fasole pasată cu ceapă
                6	1	Ciorbă de năut cu afumătură	Pilaf cu dovlecei	Facebook Salad	Capșuni	Salată de vinete cu ceapă
                6	2	Ciorbă rădăuțeană	Varză călită	Salată cu ton	Piersici	Tzatziki
                6	3	Ciorbă de conopidă	Ardei umpluți cu carne	Dovlecei prăjiți	Capșuni	Salată de vinete cu usturoi
                6	4	Ciorbă de fasole - Cu cimbru	Ardei umpluți cu soia	Salată de roșii - mama	Portocale (1.5Kg)	Tzatziki
                7	1	Supă cremă de conopidă	Mâncare de cartofi moldovenească	Omletă cu roșii	Cireșe	Tiramisu
                7	2	Ciorbă de cartofi roșie	Varză cu soia	Șnițel de soia	Pepene Roșu	Salată de pui cu ciuperci
                7	3	Supă de roșii	Musaca cu soia	Omletă cu roșii	Caise	Baba ganoush
                7	4	Ciorbă de fasole - Cu dafin	Tocănița Malita	Ciulama de ciuperci	Capșuni	Țelină cu morcov
                8	1	Ciorbă de dovlecei cu ciuperci	Mâncare de cartofi moldovenească	Facebook Salad	Pepene Galben	Clătite
                8	2	Ciorbă de fasole - Cu cimbru	Gulaș	Ciuperci prăjite	Prune (1Kg)	Salată de pui
                8	3	Supă cremă de linte galbenă	Tocăniță de ardei cu soia	Omletă cu roșii	Pepene Galben	Ouă umplute cu ficat
                8	4	Ciorbă de cartofi cu smântână	Fasole prăjită	Șnițel de soia	Capșuni	Salată alla russe
                8	5	Ciorbă de perișoare	Pilaf cu ciuperci și alte legume	Omletă cu roșii	Piersici	Ouă umplute vegetariene
                9	1	Ciorbă de fasole - Cu leuștean	Tocăniță de legume	Spanac cu smântână	Pepene Roșu	Salată orientală
                9	2	Supă mexicană	Sarmale viță de vie cu soia	Mămăligă cu brânză cu smântână	Struguri Albi	Baba ganoush
                9	3	Ciorbă de linte cu smântână	Fasole prăjită - Fuchs remix	Salad Box	Pere	Budincă
                9	4	Ciorbă de fasole - Cu chimen	Nasi Goreng	Ciuperci prăjite	Struguri Negri	Salată boeuf fără carne
                10	1	Ciorbă de ghebe cu smântână	Tocăniță de gogonele	Salată cu ton	Banane	Salată orientală
                10	2	Supă cremă de dovlecei	Mâncare de linte	Mămăligă	Prune (1Kg)	Baba ganoush
                10	3	Supă cremă de țelină - Cu praz și smântână	Mâncare de păstăi	Roșii cu brânză	Banane	Salată de vinete cu usturoi
                10	4	Ciorbă de pui a la Grec	Ghiveci	Salad Box	Mere	Ciuperci cu maioneză și usturoi
                11	1	Ciorbă de broccoli	Gratin de cartofi cu broccoli și brânză	Ciuperci prăjite	Kaki	Budincă
                11	2	Supă cremă de dovleac	Varză la Cluj	Mămăligă cu brânză cu smântână	Clementine	Ouă umplute cu pate
                11	3	Minestrone	Mâncare de linte	Microfoane	Prune (1Kg)	Fasole bătută
                11	4	Supă cremă de broccoli - Soia	Tocăniță de praz	Mâncărică de păstăi	Clementine	Riz au lait
                11	5	Ciorbă de păstăi	Pilaf cu ciuperci	Guacamole	Clementine	Fasole bătută
                12	1	Supă cremă de țelină - Mama	Fasole prăjită	Șnițel de pui	Mere	Tiramisu
                12	2	Supă cremă de broccoli - Cu carne	Gratin de cartofi cu roșii și brânză	Pasta con tonno	Kaki	Salată de vinete cu usturoi
                12	3	Supă cremă de țelină - Mama	Mâncare de cartofi cu soia	Mâncărică de păstăi	Mere	Ouă umplute vegetariene
                12	4	Supă cremă de spanac	Tocăniță de legume	Pasta al sugo di pomodoro	Mere	American Potato Salad
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
