package tudor.foodScheduler.utils;

public class EggsCalculator {
    public static int getExtraEggs(int eggsCount) {
        return switch (eggsCount) {
            case 0 -> 0;
            case 1, 2, 3, 4, 5, 6 -> 6 - eggsCount;
            case 7, 8, 9, 10 -> 10 - eggsCount;
            case 11, 12 -> 12 - eggsCount;
            case 13, 14, 15, 16, 17, 18 -> 18 - eggsCount;
            case 19, 20 -> 20 - eggsCount;
            default -> throw new RuntimeException("Unforseen " + eggsCount + " eggs");
        };
    }
}
