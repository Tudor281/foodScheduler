package tudor.foodScheduler.model;

import java.util.List;

public class Recipy {
    String name;
    List<Ingredient> ingredients;
    Multiplicity multiplicity;
    Fel fel;

    public Recipy(String name, List<Ingredient> ingredients, Multiplicity multiplicity, Fel fel) {
        this.name = name;
        this.ingredients = ingredients;
        this.multiplicity = multiplicity;
        this.fel = fel;
    }

    public String getName() {
        return name;
    }
}
