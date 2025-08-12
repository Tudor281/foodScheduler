package tudor.foodScheduler.model.cookbook;

import tudor.foodScheduler.model.Recipe;

import java.util.HashMap;
import java.util.Map;

/**
 * Total amount of slots - slot for (AtLeastOnce, Once) = # Free Slots (Optionals, AtMostOnce)
 */
public class FreeSlotsComputation {
    // channel -> nr of free slots
    final Map<Integer, Integer> freeSlots = new HashMap();

    // channel -> nr of free recipes (recipes that are made AtLeastOnce or Optional)
    final Map<Integer, Integer> freeRecipes = new HashMap<>();

    // channel -> nr of occupied slots
    final Map<Integer, Integer> occupiedSlots = new HashMap<>();

    // channel -> avg nr of slots per free recipe
    final Map<Integer, Float> slotsPerFreeRecipes = new HashMap<>();

    public int totalSlots = 0;

    public void computeFreeSlots() {
        for(Map.Entry<Integer, Integer> occupiedEntry : occupiedSlots.entrySet()) {
            freeSlots.put(occupiedEntry.getKey(), totalSlots - occupiedEntry.getValue());
        }

        for (Map.Entry<Integer, Integer> freeSlotEntry : freeSlots.entrySet()) {
            slotsPerFreeRecipes.put(freeSlotEntry.getKey(), (float) freeSlotEntry.getValue() / (float) freeRecipes.get(freeSlotEntry.getKey()));
        }
    }

    public void incrementOccupiedForChannel(int channel) {
        Integer count = occupiedSlots.computeIfAbsent(channel, k -> 0);
        occupiedSlots.put(channel, count + 1);
    }

    public void incrementFreeRecipesForChannel(int channel) {
        Integer count = freeRecipes.computeIfAbsent(channel, k->0);
        freeRecipes.put(channel, count + 1);
    }
}
