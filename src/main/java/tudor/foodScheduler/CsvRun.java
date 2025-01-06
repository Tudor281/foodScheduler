package tudor.foodScheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleInitializer;

public class CsvRun {
    private static final Logger logger = LoggerFactory.getLogger(CsvRun.class);
    public static void main(String[] args) {
        String input = """
                1	1	Ciorbă de fasole - Cu leuștean	Tocăniță de ardei	
                1	2	Supă de roșii	Musaca cu carne	
                1	3	Supă cremă de mazăre	Tocăniță de praz	
                1	4	Ciorbă de salată cu scrob	Mâncare de cartofi - Cu pui	
                2	1	Supă cremă de broccoli - Simplu	Mâncare de mazăre - Cu soia	
                2	2	Ciorbă de păstăi	Varză călită	Salată orientală
                2	3	Nakkikeitto	Gigantes Plaki	Chiftele de soia în suc de roșii
                2	4	Ciorbă de fasole - Cu dafin	Gratin de cartofi cu roșii și brânză	
                3	1	Ciorbă de dovlecei cu ciuperci	Ardei umpluți cu carne	
                3	2	Supă cremă de broccoli - Simplu	Măncare de fasole - Fasole prăjită - Fuchs remix	Tiramisu
                3	3	Supă cremă de țelină - Cu praz și smântână	Mâncare de cartofi - ardelenească	Riz au lait
                3	4	Nakkikeitto - V	Mâncare de fasole - Fasole prăjită	
                3	5	Ciorbă de fasole - Cu leuștean	Ardei umpluți simplu	
                4	1	Ciorbă de conopidă	Măncare de fasole - Fasole prăjită - Fuchs remix	Clătite
                4	2	Ciorbă de cartofi cu smântână	Mâncare de cartofi - Cu pui	Chiftele cu carne
                4	3	Supă cremă de broccoli - Simplu	Mâncare de mazăre - Cu soia	Cozonac
                4	4	Supă cremă de mazăre	Musaca cu ciuperci	
                5	1	Ciorbă de fasole - Cu chimen	Mâncare de fasole - Iahnie de fasole	
                5	2	Ciorbă de cartofi cu smântână	Pilaf - Cu urzici	
                5	3	Ciorbă de frunze	Varză la Cluj	
                5	4	Ciorbă de păstăi fresh	Mâncare de cartofi - moldovenească	Griș cu lapte
                6	1	Supă cremă de broccoli - Simplu	Melanzane alla parmigiano	Ciuperci cu maioneză și usturoi
                6	2	Ciorbă de perișoare	Mâncare de mazăre - Cu soia	Tzatziki
                6	3	Ciorbă de cartofi roșie	Tocăniță de ardei	
                6	4	Ciorbă de fasole - Cu dafin	Lasagna bolognese	
                6	5	Supă cremă de broccoli - Simplu	Măncare de fasole - Fasole prăjită - Fuchs remix	
                7	1	Ciorbă de frunze	American Potato Salad	Apple Pie
                7	2	Ciorbă de dovlecei cu ciuperci	Gratin de cartofi cu broccoli și brânză	
                7	3	Ciorbă de fasole - Cu cimbru	Tocăniță de legume	Humus
                7	4	Supă de roșii	Varză fiartă	
                8	1	Supă cremă de broccoli - Cu carne	Mâncare de fasole - Fasole prăjită	Clătite
                8	2	Supă de conopidă	Mâncare de mazăre - Cu soia	
                8	3	Supă cremă de țelină - Mama	Gulaș	Tiramisu
                8	4	Ciorbă de cartofi roșie	Pilaf - Cu ciuperci și alte legume	Humus
                8	5	Supă cremă de broccoli - Soia	Gigantes Plaki	Vitel tonne
                9	1	Ciorbă de fasole - Cu leuștean	Tocăniță de ardei	
                9	2	Ciorbă de pui a la Grec	Mâncare de cartofi - Cu soia	
                9	3	Supă cremă de dovlecei	Măncare de fasole - Fasole prăjită - Fuchs remix	
                9	4	Ciorbă de fasole - Cu chimen	Tocăniță de gogonele	
                10	1	Supă cremă de broccoli - Simplu	Mâncare de mazăre - Simplu	
                10	2	Ciorbă de cartofi roșie	Pilaf - Paella cu pui	
                10	3	Supă cremă de mazăre	Musaca cu ciuperci	Tiramisu
                10	4	Ciorbă rădăuțeană	Pilaf - Sarmale viță de vie cu carne	Fasole bătută
                11	1	Ciorbă de fasole - Cu leuștean	Tocăniță de ardei	Salată de pui
                11	2	Ciorbă de conopidă	Măncare de fasole - Fasole prăjită - Fuchs remix	
                11	3	Supă cremă de broccoli - Simplu	Musaca cu ciuperci	
                11	4	Ciorbă de dovlecei cu ciuperci	Tocăniță de praz	Humus
                11	5	Supă cremă de țelină - Mama	Mâncare de fasole - Fasole prăjită	
                12	1	Nakkikeitto - V	Varză fiartă	
                12	2	Ciorbă de fasole - Cu leuștean	Musaca cu ciuperci	Clătite
                12	3	Nakkikeitto - V	Răcitură	
                12	4	Supă cremă de broccoli - Cu carne	Pilaf - Simplu	Țelină cu morcov
                """;

        Schedule schedule = ScheduleInitializer.getSchedule(input, true);

        InitialRun.addConstraints(schedule);

        schedule.optimize();

        logger.info("Schedule: ");
        logger.info(schedule.toString());
    }
}
