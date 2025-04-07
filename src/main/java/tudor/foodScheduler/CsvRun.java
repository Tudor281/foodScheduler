package tudor.foodScheduler;

import tudor.foodScheduler.model.schedule.Schedule;
import tudor.foodScheduler.model.schedule.ScheduleInitializer;

public class CsvRun {
    public static void main(String[] args) throws Exception {
        String input = """
                1	1	Ciorbă de fasole - Cu chimen	Tocăniță de ardei	Omletă cremă	Mineole	Ciuperci cu maioneză și usturoi
                1	2	Nakkikeitto	Musaca cu carne	Mâncare de ciuperci - Ciuperci cu smântână și usturoi	Kiwi	Humus
                1	3	Ciorbă de dovlecei cu ciuperci	Mâncare de mazăre - Cu soia	Roșii cu brânză	Clementine	Apple Pie
                1	4	Supă cremă de țelină - Cu praz și smântână	Tocăniță de legume	Paste - cu Basilico (semi)	Papaya	Salată boeuf
                2	1	Supă de conopidă	Musaca cu ciuperci	Omletă cremă	Grapefruit	Clătite
                2	2	Supă cremă de dovleac	Varză fiartă	Fish fingers	Mandarine	Griș cu lapte
                2	3	Ciorbă de salată cu scrob	Ghiveci	Paste - Napoletane (semi)	Kiwi	Ciuperci cu maioneză și usturoi
                2	4	Supă cremă de broccoli - Simplu	Tocănița Malita	Mâncărică de păstăi	Portocale	Riz au lait
                3	1	Ciorbă de fasole - Cu leuștean	Mâncare de cartofi - ardelenească	Găgău	Mere	Griș cu lapte
                3	2	Supă cremă de țelină - Mama	Tocăniță de ardei cu soia	Paste - con Ricotta (semi)	Pere	Humus cu pesto
                3	3	Ciorbă de fasole - Cu chimen	Mâncare de cartofi - ardelenească	Roșii cu brânză	Banane	Ciuperci cu maioneză și usturoi
                3	4	Ciorbă de pui a la Grec	Gigantes Plaki	Mămăligă	Mere	Tzatziki
                3	5	Ciorbă de frunze	Mâncare de cartofi - Cu pui	Facebook Salad	Banane	Salată de vienete cu usturoi
                4	1	Ciorbă de cartofi roșie	Tocăniță de praz	Omletă cremă	Mere	Chiftele cu carne
                4	2	Supă cremă de mazăre	Mâncare de fasole - Fasole prăjită - Fuchs remix	Omletă normală	Pere	
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
