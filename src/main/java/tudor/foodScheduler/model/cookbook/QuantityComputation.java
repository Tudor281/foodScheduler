package tudor.foodScheduler.model.cookbook;

import tudor.foodScheduler.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class QuantityComputation {
    // channel -> ingredient -> quantity
    Map<Integer, Map<Ingredient, Float>> quantities = new HashMap<>();
    // channel -> count
    Map<Integer, Integer> recipeCountPerChannel =  new HashMap<>();

    void countRecipe(int channel) {
        Integer count = recipeCountPerChannel.computeIfAbsent(channel, k -> 0);
        recipeCountPerChannel.put(channel, count + 1);
    }

    void sumIngredient(int channel, Ingredient ingredient, float quantity) {
        Map<Ingredient, Float> ingredientQuantities = quantities.computeIfAbsent(channel, k -> new HashMap<>());

        float existingQuantity = ingredientQuantities.computeIfAbsent(ingredient, k -> 0f);
        existingQuantity += quantity;
        ingredientQuantities.put(ingredient, existingQuantity);
    }

    float getAvgQuantity(int channel, Ingredient ingredient) {
        return quantities.get(channel).get(ingredient) / recipeCountPerChannel.get(channel);
    }
}
