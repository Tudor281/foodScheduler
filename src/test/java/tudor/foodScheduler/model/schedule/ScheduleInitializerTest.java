package tudor.foodScheduler.model.schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleInitializerTest {
    @Test
    void shouldSeparateEmptyTabs() {
        String test = "\t\t\t";
        assertEquals(0, test.split("\t").length);

        test = "\t \t \t";

        assertEquals(3, test.split("\t").length);

        test = "\t \t\t";
        assertEquals(2, test.split("\t").length);

        assertEquals(3, "ababa".split("a").length);
    }
}