package tudor.foodScheduler;

import tudor.foodScheduler.model.Fel;
import tudor.foodScheduler.model.Multiplicity;
import tudor.foodScheduler.model.Recipy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tudor.foodScheduler.model.Fel.*;
import static tudor.foodScheduler.model.Ingredient.*;
import static tudor.foodScheduler.model.Multiplicity.*;

public class Menu {
    static final Map<String, Recipy> recipies = new HashMap<>();
    static {
        add(new Recipy("American Potato Salad", List.of(Cartofi), Optional, Rece));
        add(new Recipy("Apple Pie", List.of(Mere), Optional, Desert));
        add(new Recipy("Ardei umpluți", List.of(Ardei, Orez), AtLeastOnce, F2));
        add(new Recipy("Ardei umpluți cu carne", List.of(Ardei, Orez, Carne), AtMostOnce, F2));
        add(new Recipy("Chiftele", List.of(Carne), AtMostOnce, Rece));
        add(new Recipy("Chiftele de soia în suc de roșii", List.of(Soia), Optional, Rece));
        add(new Recipy("Ciorbă de cartofi cu smântână", List.of(Cartofi, Smantana), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de cartofi roșie", List.of(Cartofi), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de conopidă", List.of(Conopida), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de dovlecei cu ciuperci", List.of(Dovlecei, Ciuperci), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de fasole - Cu chimen", List.of(Fasole), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de fasole - Cu dafin", List.of(Fasole), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de fasole - Mama", List.of(Fasole), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de frunze", List.of(Frunze), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de ghebe cu smântână", List.of(Ciuperci, Smantana), AtMostOnce, F1));
        add(new Recipy("Ciorbă de năut cu afumătură", List.of(Carne, Naut), AtMostOnce, F1));
        add(new Recipy("Ciorbă de păstăi", List.of(Pastai), AtLeastOnce, F1));
        add(new Recipy("Ciorbă de perișoare", List.of(Carne), AtMostOnce, F1));
        add(new Recipy("Ciorbă de pui a la Grec", List.of(Carne, Smantana), AtMostOnce, F1));
        add(new Recipy("Ciorbă de salată cu scrob", List.of(Salata, Smantana), AtLeastOnce, F1));
        add(new Recipy("Ciorbă rădăuțeană", List.of(Carne, Smantana), AtMostOnce, F1));
        add(new Recipy("Ciuperci cu maioneză și usturoi", List.of(Ciuperci), Optional, Rece));
        add(new Recipy("Clătite", List.of(), Optional, Desert));
        add(new Recipy("Fasole bătută", List.of(Fasole), Optional, Rece));
        add(new Recipy("Gigantes Plaki", List.of(Fasole), AtLeastOnce, F2));
        add(new Recipy("Tocăniță de ardei", List.of(Ardei), AtLeastOnce, F2));
        add(new Recipy("Tocăniță de legume", List.of(Ardei), AtLeastOnce, F2));
        add(new Recipy("Supă cremă de broccoli - Cu carne", List.of(Broccoli, Carne), Optional, F1));
        add(new Recipy("Supă cremă de broccoli - Soia", List.of(Broccoli, Soia), AtLeastOnce, F1));
        add(new Recipy("Supă cremă de broccoli - Simplu", List.of(Broccoli), AtLeastOnce, F1));


    }

    static void add(Recipy recipy) {
        recipies.put(recipy.getName(), recipy);
    }
}
