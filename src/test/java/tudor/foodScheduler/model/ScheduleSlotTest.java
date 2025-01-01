package tudor.foodScheduler.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleSlotTest {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleSlotTest.class);

    @Nested
    class computeDistance {
        @Test
        void twoRecipesShouldBeBiggerThanThreeRecipes() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(1, 1);
            ScheduleSlot finish = new ScheduleSlot(7, 2);

            double twoScore = ScheduleSlot.computeDistance(List.of(origin, finish), weeksInMonth);

            logger.info("2 score: {}", twoScore);

            ScheduleSlot intermediary = new ScheduleSlot(3, 0);
            double threeScore = ScheduleSlot.computeDistance(List.of(origin, intermediary, finish), weeksInMonth);

            logger.info("3 score: {}", threeScore);

            assertTrue(threeScore < twoScore);
        }
    }

    @Nested
    class weekDistance {
        @Test
        void shouldGiveDistanceForSameMonth() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(0, 0);
            ScheduleSlot finish = new ScheduleSlot(0, 2);

            assertEquals(1, origin.getWeeksDistance(finish, weeksInMonth));
        }

        @Test
        void shouldGiveDistanceForSameMonth2() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(8, 1);
            ScheduleSlot finish = new ScheduleSlot(8, 3);

            assertEquals(1, origin.getWeeksDistance(finish, weeksInMonth));
        }

        @Test
        void shouldComputeDistanceInNearMonths() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(1, 1);
            ScheduleSlot finish = new ScheduleSlot(2, 3);

            assertEquals(5, origin.getWeeksDistance(finish, weeksInMonth));
        }

        @Test
        void shouldComputeDistanceInNearMonths2() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(2, 1);
            ScheduleSlot finish = new ScheduleSlot(3, 3);

            assertEquals(6, origin.getWeeksDistance(finish, weeksInMonth));
        }

        @Test
        void shouldComputeDistanceInFarMonths1() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(1, 1);
            ScheduleSlot finish = new ScheduleSlot(3, 3);

            assertEquals(10, origin.getWeeksDistance(finish, weeksInMonth));
        }
    }

    @Nested
    class OutsideWeeksDistance {
        @Test
        void shouldGive0ForWeek0AndLastWeek() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(0, 0);
            ScheduleSlot finish = new ScheduleSlot(11, 3);

            assertEquals(0, origin.getOutsideWeeksDistance(finish, weeksInMonth));
        }

        @Test
        void shouldComputeOutsideDistance() {
            int[] weeksInMonth = new int[]{4, 4, 5, 4, 4, 5, 4, 5, 4, 4, 5, 4};

            ScheduleSlot origin = new ScheduleSlot(1, 2); //2+4= 6
            ScheduleSlot finish = new ScheduleSlot(10, 2); //2+4= 6

            assertEquals(12, origin.getOutsideWeeksDistance(finish, weeksInMonth));
        }
    }

}