package tudor.foodScheduler;

import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleInitializer;

public class CsvRun {
    public static void main(String[] args) {
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

        ScheduleInitializer.getSchedule(input);
    }
}
