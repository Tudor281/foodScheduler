package tudor.foodScheduler.model;

public class NutrientsSummer {
    public float kCal = 0;
    public float kCalWithoutBread = 0;

    public void sum(Recipe recipe) {
        for (IngredientEntry ingredientEntry : recipe.ingredients) {
            Ingredient ingredient = ingredientEntry.ingredient;
            if (ingredient != Ingredient.Paine) {
                kCalWithoutBread = sum(kCalWithoutBread, ingredient.nutrients.getKCal().b);
            }
            kCal = sum(kCal, ingredient.nutrients.getKCal().b);
        }
    }

    float sum(float existing, Float addend) {
        if (addend == null) return existing;
        return existing + addend;
    }

    public String toString() {
        return Nutrients.zeroDigitFormatter.format(kCal / 7) + "\t" + Nutrients.zeroDigitFormatter.format(kCalWithoutBread / 7);
    }
}
