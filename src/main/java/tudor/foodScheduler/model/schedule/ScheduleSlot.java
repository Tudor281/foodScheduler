package tudor.foodScheduler.model.schedule;

import java.util.List;

public class ScheduleSlot {
    int computerMonth;
    int computerWeek;
    boolean hasConstraints = false;

    public ScheduleSlot(int computerMonth, int computerWeek) {
        this.computerMonth = computerMonth;
        this.computerWeek = computerWeek;
    }

    public ScheduleSlot(int computerMonth, int computerWeek, boolean hasConstraints) {
        this(computerMonth, computerWeek);
        this.hasConstraints = hasConstraints;
    }

    /** Assumes slots are ordered */
    public static double computeDistanceHybrid(List<ScheduleSlot> scheduleSlotList, int[] weeksInMonth) {
        if (scheduleSlotList.isEmpty()) {
            return 0; // we want many ingredients used throughout the year. Since we're maximizing distance between them, 0 is bad for a schedule
        }
        if (scheduleSlotList.size() == 1) {
            return math(getSum(weeksInMonth));
        }
        double minScore = Double.MAX_VALUE;
        ScheduleSlot prevSlot = scheduleSlotList.getFirst();
        for (int i = 1; i< scheduleSlotList.size(); i ++) {
            ScheduleSlot currentSlot = scheduleSlotList.get(i);
            double score = math(prevSlot.getWeeksDistance(currentSlot, weeksInMonth));
            if (score < minScore) minScore = score;
            prevSlot = currentSlot;
        }
        double outsideScore = math(scheduleSlotList.getFirst().getOutsideWeeksDistance(scheduleSlotList.getLast(), weeksInMonth));
        if (outsideScore < minScore) minScore = outsideScore;
        return minScore;
    }

    private static double math(double input) {
        if (input-3 < 0) {
            return -(input-3)*(input-3) + 10;
        }
        return Math.sqrt(input-3) + 10;
    }

    static int getSum(int[] weeksInMonth) {
        int sum = 0;
        for (int month = 0; month < 12; month ++) {
            sum += weeksInMonth[month];
        }
        return sum;
    }

    /** Assumes other is greater than this
     * The distance between week and week+1 is 0 */
    int getWeeksDistance(ScheduleSlot other, int[] weeksInMonth) {
        if (other.computerMonth == computerMonth) {
            return other.computerWeek - computerWeek - 1;
        }
        int sum = 0;
        sum += weeksInMonth[computerMonth] - computerWeek - 1;
        sum += other.computerWeek;
        for (int i = computerMonth + 1; i<other.computerMonth; i++) {
            sum += weeksInMonth[i];
        }
        return sum;
    }

    int getOutsideWeeksDistance(ScheduleSlot other, int[] weeksInMonth) {
        ScheduleSlot origin = new ScheduleSlot(0, 0);
        ScheduleSlot finalWeek = new ScheduleSlot(11, weeksInMonth[11]-1);

        return origin.getWeeksDistance(this, weeksInMonth) + other.getWeeksDistance(finalWeek, weeksInMonth) + 2;
    }

    public boolean hasConstraints() {
        return hasConstraints;
    }

    public int getHumanMonth() {
        return computerMonth + 1;
    }

    public ScheduleSlot copy() {
        return new ScheduleSlot(computerMonth, computerWeek);
    }

    void increment(int[] weeksInMonth) {
        computerWeek++;
        if (computerWeek >= weeksInMonth[computerMonth]) {
            computerWeek = 0;
            computerMonth++;

            if (computerMonth >= 11) {
                computerMonth = 0;
            }
        }
    }

    void decrement(int[] weeksInMonth) {
        computerWeek--;
        if (computerWeek < 0) {
            computerMonth--;

            if (computerMonth < 0) {
                computerMonth = 11;
            }

            computerWeek = weeksInMonth[computerMonth] -1;
        }
    }
}
