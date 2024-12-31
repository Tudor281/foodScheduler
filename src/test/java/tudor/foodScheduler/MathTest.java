package tudor.foodScheduler;

import org.junit.jupiter.api.Test;

class MathTest {

    @Test
    void testExponential() {
        for (int i=0; i<55; i++) {
            System.out.println(Math.exp(i));
        }
    }

}