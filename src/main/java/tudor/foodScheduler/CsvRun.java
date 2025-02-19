package tudor.foodScheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleInitializer;

public class CsvRun {
    private static final Logger logger = LoggerFactory.getLogger(CsvRun.class);
    public static void main(String[] args) throws Exception {
        String input = """
                1	1	Ciorbă de fasole - Cu chimen	Tocăniță de ardei	Omletă cremă	Mineole	Țelină cu morcov
                1	2	Nakkikeitto	Musaca cu carne	Mâncare de ciuperci - Ciuperci cu smântână și usturoi	Portocale	Tiramisu
                1	3	Ciorbă de dovlecei cu ciuperci	Mâncare de mazăre - Cu soia	Roșii cu brânză	Mandarine	Tiramisu
                1	4	Supă cremă de țelină - Cu praz și smântână	Tocăniță de legume	Paste - cu Basilico (semi)	Papaya	Clătite
                2	1	Supă de conopidă	Musaca cu ciuperci	Omletă cremă	Mere	Salată orientală
                2	2	Supă cremă de dovleac	Varză fiartă	Fish fingers	Kiwi	Salată de pui
                2	3	Ciorbă de salată cu scrob	Ghiveci	Paste - Napoletane (semi)	Grapefruit	Apple Pie
                2	4					
                3	1					
                3	2					
                3	3					
                3	4					
                3	5					
                4	1					
                4	2					
                4	3					
                4	4					
                5	1					
                5	2					
                5	3					
                5	4					
                6	1					
                6	2					
                6	3					
                6	4					
                6	5					
                7	1					
                7	2					
                7	3					
                7	4					
                8	1					
                8	2					
                8	3					
                8	4					
                8	5					
                9	1					
                9	2					
                9	3					
                9	4					
                10	1					
                10	2					
                10	3					
                10	4					
                11	1					
                11	2					
                11	3					
                11	4					
                11	5					
                12	1					
                12	2					
                12	3					
                12	4					
                """;

        Schedule schedule = ScheduleInitializer.getSchedule(input, true);

        InitialRun.addConstraints(schedule);

        InitialRun.completeRecipe(schedule);
    }
}
