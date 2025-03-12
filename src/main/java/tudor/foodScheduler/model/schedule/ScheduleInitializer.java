package tudor.foodScheduler.model.schedule;

import tudor.foodScheduler.model.Recipe;

public class ScheduleInitializer {
    public static Schedule getSchedule(String input, boolean initialConstraint) {
        // determine weeks in calendar
        String[] rows = input.split("\n");

        int[] weeksInMonths = new int[12];
        int weekCounter = 0;
        int currentMonth = 1;
        for (String row : rows) {
            int csvMonth = Integer.parseInt(row.split("\t")[0]);
            if (csvMonth != currentMonth) {
                weeksInMonths[currentMonth-1] = weekCounter;
                weekCounter = 0;
                currentMonth = csvMonth;
            }
            weekCounter++;
        }
        weeksInMonths[currentMonth-1] = weekCounter;

        Schedule schedule = new Schedule(weeksInMonths);
        for (String row : rows) {
            String[] cells = row.split("\t");
            for (int i=2; i<8; i++) {
                if (cells.length > i && !cells[i].isBlank()) {
                    schedule.add(Integer.parseInt(cells[0]), Integer.parseInt(cells[1]), Recipe.get(cells[i]), initialConstraint);
                }
            }
        }

        return schedule;
    }
}
