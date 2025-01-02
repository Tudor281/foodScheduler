package tudor.foodScheduler.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Nested
    class hasIngredientsInCommon {
        @Test
        void shouldCheckAkaPastai() {
            Recipe r1 = Recipe.get("Ciorbă de păstăi");
            Recipe r2 = Recipe.get("Ciorbă de păstăi fresh");

            assertTrue(r1.hasIngredientsInCommon(r2));
            assertTrue(r2.hasIngredientsInCommon(r1));

            Recipe outsider = Recipe.get("Ciorbă de ghebe cu smântână");
            assertFalse(r1.hasIngredientsInCommon(outsider));
            assertFalse(outsider.hasIngredientsInCommon(r1));
            assertFalse(r2.hasIngredientsInCommon(outsider));
            assertFalse(outsider.hasIngredientsInCommon(r2));
        }

        @Test
        void shouldCheckAkaVarza() {
            Recipe r1 = Recipe.get("Varză călită");
            Recipe r2 = Recipe.get("Varză fiartă");
            Recipe r3 = Recipe.get("Varză la Cluj");

            assertTrue(r1.hasIngredientsInCommon(r2));
            assertTrue(r2.hasIngredientsInCommon(r1));

            assertTrue(r2.hasIngredientsInCommon(r3));
            assertTrue(r3.hasIngredientsInCommon(r2));

            Recipe outsider = Recipe.get("Ciorbă de ghebe cu smântână");
            assertFalse(r1.hasIngredientsInCommon(outsider));
            assertFalse(outsider.hasIngredientsInCommon(r1));
            assertFalse(r2.hasIngredientsInCommon(outsider));
            assertFalse(outsider.hasIngredientsInCommon(r2));
        }
    }
}