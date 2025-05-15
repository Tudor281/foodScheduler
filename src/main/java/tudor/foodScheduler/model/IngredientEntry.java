package tudor.foodScheduler.model;

public class IngredientEntry {
    public Ingredient ingredient;
    int quantity;
    UnitOfMeasure unitOfMeasure;

    public IngredientEntry(Ingredient ingredient, int quantity, UnitOfMeasure unitOfMeasure) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
    }
}
