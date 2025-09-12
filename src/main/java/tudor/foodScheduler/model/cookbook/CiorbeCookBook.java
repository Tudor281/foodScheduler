package tudor.foodScheduler.model.cookbook;

import tudor.foodScheduler.model.IngredientEntry;
import tudor.foodScheduler.model.Recipe;

import java.util.List;

import static tudor.foodScheduler.model.Fel.*;
import static tudor.foodScheduler.model.Ingredient.*;
import static tudor.foodScheduler.model.Multiplicity.*;
import static tudor.foodScheduler.model.Spice.*;
import static tudor.foodScheduler.model.UnitOfMeasure.*;

public class CiorbeCookBook {
    public static Cookbook buildCookbook() {
        Cookbook cookbook = new Cookbook();
        cookbook.nrChannels = 1;
        cookbook.add(new Recipe("Ciorbă congelată", Disabled, List.of(
                new IngredientEntry(Broccoli, 250, gram),
                new IngredientEntry(Conopida, 250, gram)),
                F1, List.of(Patrunjel, Marar, Sare, Piper))); // ia chestii congelate, vezi cum e. E fain ca sunt chestii mixate in loc sa cumperi un broccoli / o conopida. Dar la Lidl, deci non si sa mai, și congelate de la auchan bagi la minestrone.
        cookbook.add(new Recipe("Ciorbă de broccoli", AtLeastOnce, List.of(
                new IngredientEntry(Broccoli, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de cartofi cu smântână", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri),
                new IngredientEntry(Bors, 500, gram)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de cartofi roșie", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de conopidă", AtLeastOnce, List.of(
                new IngredientEntry(Conopida, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de dovlecei cu ciuperci", AtLeastOnce, List.of(
                new IngredientEntry(Dovlecei, 2, bucati),
                new IngredientEntry(Ciuperci, 400, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Telina, 250, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu chimen", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram ),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Usturoi, 5, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, BoiaAfumata, Iuteala, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu dafin", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Dafin, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu cimbru", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Cimbru, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu leuștean", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Leustean, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de frunze", Disabled, List.of(
                new IngredientEntry(Stevie, 500, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Taitei, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri),
                new IngredientEntry(Bors, 500, gram)),
                F1, List.of(Marar, Leustean, Sare, Piper))); // nu găsești cantități industriale de frunze în București, doar la legătură.
        cookbook.add(new Recipe("Ciorbă de ghebe cu smântână", Once, List.of(
                new IngredientEntry(Ciuperci, 1000, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri))
                , F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de năut cu afumătură", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 350, gram),
                new IngredientEntry(Naut, 250, gram),
                new IngredientEntry(Pappardelle, 125, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(BoiaDulce, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Leustean, Sare, Piper), 3));
        cookbook.add(new Recipe("Ciorbă de păstăi fresh", Disabled, List.of(
                new IngredientEntry(PastaiFresh, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F1, List.of(Patrunjel, Marar, Leustean, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de perișoare", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 500, gram)),
                F1, List.of())); // TODO No recipy
        cookbook.add(new Recipe("Ciorbă de pui a la Grec", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 700, gram),
                new IngredientEntry(Orez, 100, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(SucLamaie, Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de salată cu scrob", AtLeastOnce, List.of(
                new IngredientEntry(Salata, 1, bucati),
                new IngredientEntry(Ou, 7, bucati),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Morcov, 1, bucati),
                new IngredientEntry(Orez, 50, gram),
                new IngredientEntry(Ulei_Masline, 2, linguri)), // de la omletă
                F1, List.of(Sare)));
        cookbook.add(new Recipe("Ciorbă rădăuțeană", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 500, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Ou, 4, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Telina, 200, gram),
                new IngredientEntry(Usturoi, 5, bucati)), F1, List.of(Otet, Patrunjel, Dafin, Sare, Piper)));
        cookbook.add(new Recipe("Lohikeitto", AtMostOnce, List.of(
                new IngredientEntry(Peste_Somon, 450, gram),
                new IngredientEntry(Cartofi, 700, gram),
                new IngredientEntry(Morcov, 1, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Smantana, 300, gram)),
                F1, List.of(Dafin, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Minestrone", AtLeastOnce, List.of(
                new IngredientEntry(Conopida, 250, gram),
                new IngredientEntry(Broccoli, 250, gram),
                new IngredientEntry(Morcov, 100, gram),
                new IngredientEntry(Orez, 100, gram),
                new IngredientEntry(Fasole_Uscata, 100, gram),
                new IngredientEntry(Mazare, 200, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                F1, List.of(Sare, Piper, Busuioc, Rozmarin, Patrunjel)));
        cookbook.add(new Recipe("Nakkikeitto", AtMostOnce, List.of(
                new IngredientEntry(Cartofi, 900, gram),
                new IngredientEntry(Carne_Pui_Piept, 700, gram),
                new IngredientEntry(Morcov, 450, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Pastarnac, 2, bucati),
                new IngredientEntry(Usturoi, 3, bucati)),
                F1, List.of(Sare, Piper, Dafin, Patrunjel, Rozmarin)));
        cookbook.add(new Recipe("Nakkikeitto - V", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 900, gram),
                new IngredientEntry(Soia, 200, gram),
                new IngredientEntry(Morcov, 450, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Pastarnac, 2, bucati),
                new IngredientEntry(Usturoi, 3, bucati)),
                F1, List.of(Sare, Piper, Dafin, Patrunjel, Rozmarin), 2));
        cookbook.add(new Recipe("Supă cremă de broccoli - Cu carne", AtMostOnce, List.of(
                new IngredientEntry(Broccoli, 2, bucati),
                new IngredientEntry(Carne_Pui_Piept, 500, gram),
                new IngredientEntry(Cartofi, 400, gram),
                new IngredientEntry(Telina, 100, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Usturoi, 4, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati)),
                F1, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Supă cremă de broccoli - Simplu", AtLeastOnce, List.of(
                new IngredientEntry(Broccoli, 2, bucati),
                new IngredientEntry(Cartofi, 400, gram),
                new IngredientEntry(Telina, 100, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Usturoi, 4, bucati)),
                F1, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Supă cremă de broccoli - Soia", Once, List.of(
                new IngredientEntry(Broccoli, 2, bucati),
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Cartofi, 400, gram),
                new IngredientEntry(Telina, 100, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Usturoi, 4, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati)),
                F1, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Supă cremă de conopidă", AtMostOnce, List.of(
                new IngredientEntry(Conopida, 1, bucati),
                new IngredientEntry(Cartofi, 500, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Usturoi, 3, bucati),
                new IngredientEntry(Smantana, 300, gram)),
                F1, List.of(Patrunjel, Sare, Piper)));
        cookbook.add(new Recipe("Supă cremă de dovleac", Once, List.of(
                new IngredientEntry(DovleacPlacintar, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Cartofi, 600, gram),
                new IngredientEntry(Telina, 100, gram)),
                F1, List.of(Sare, Piper, Rozmarin)));
        cookbook.add(new Recipe("Supă cremă de dovlecei", Once, List.of(
                new IngredientEntry(Dovlecei, 2000, gram)), F1, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Supă cremă de mazăre", AtLeastOnce, List.of(
                new IngredientEntry(Mazare, 2000, gram),
                new IngredientEntry(Ceapa, 4, bucati)),
                F1, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Supă cremă de țelină - Cu praz și smântână", Once, List.of(
                new IngredientEntry(Telina, 1200, gram),
                new IngredientEntry(Pastarnac, 3, bucati),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Praz, 3, bucati),
                new IngredientEntry(Smantana, 600, gram)),
                F1, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Supă cremă de țelină - Mama", AtLeastOnce, List.of(
                new IngredientEntry(Telina, 1200, gram),
                new IngredientEntry(Cartofi, 600, gram),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Morcov, 1, bucati),
                new IngredientEntry(Pastarnac, 1, bucati)),
                F1, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Supă de cartofi și mazăre", Once, List.of(
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Usturoi, 6, bucati),
                new IngredientEntry(Mazare, 400, gram),
                new IngredientEntry(Cartofi, 600, gram)),
                F1, List.of(Coriandru, Curry, Sare, Piper)));
        cookbook.add(new Recipe("Supă de conopidă", Once, List.of(
                new IngredientEntry(Conopida, 1, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Faina_Grau_65, 2, linguri),
                new IngredientEntry(Lapte, 500, gram)),
                F1, List.of(SucLamaie, BoiaDulce, Sare)));
        cookbook.add(new Recipe("Supă de roșii", AtLeastOnce, List.of(
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Telina, 200, gram),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Fidea, 80, gram)), F1, List.of(Patrunjel, FrunzeTelina, Sare, Piper)));
        return cookbook;
    }
}
