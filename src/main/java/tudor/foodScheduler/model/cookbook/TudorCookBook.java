package tudor.foodScheduler.model.cookbook;

import tudor.foodScheduler.model.*;

import java.util.List;

import static tudor.foodScheduler.model.Fel.*;
import static tudor.foodScheduler.model.Fel.Fruits;
import static tudor.foodScheduler.model.Ingredient.*;
import static tudor.foodScheduler.model.Multiplicity.*;
import static tudor.foodScheduler.model.Multiplicity.Once;
import static tudor.foodScheduler.model.Spice.*;
import static tudor.foodScheduler.model.UnitOfMeasure.*;

public class TudorCookBook {
    public static Cookbook buildCookbook() {
        Cookbook cookbook = new Cookbook();
        cookbook.nrChannels = 5;
        cookbook.add(new Recipe("American Pancakes", Once, List.of(
                new IngredientEntry(Faina_Grau_65, 300, gram),
                new IngredientEntry(Zahar, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 3, linguri)),
                Desert, List.of())); // TODO No recipy
        cookbook.add(new Recipe("American Potato Salad", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 1000, gram),
                new IngredientEntry(Maioneza, 200, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Apio, 100, gram),
                new IngredientEntry(Ou, 3, bucati)),
                F2, List.of(Mustar, Patrunjel, Sare, Piper, BoiaDulce)));
        cookbook.add(new Recipe("Apple Pie", Disabled, List.of(
                new IngredientEntry(Mere, 500, gram),
                new IngredientEntry(Zahar, 2, linguri)),
                Desert, List.of(Scortisoara))); // TODO No recipy, n-am contenitore, și nici aluat pentru Apple pie specific n-am
        cookbook.add(new Recipe("Ardei umpluți simplu", Once, List.of(
                new IngredientEntry(Ardei_Rosu, 6, bucati),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Orez, 250, gram),
                new IngredientEntry(Ou, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F2, List.of(FrunzeTelina, Sare, Piper)));
        cookbook.add(new Recipe("Ardei umpluți cu carne", Once, List.of(
                new IngredientEntry(Ardei_Rosu, 6, bucati),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Orez, 150, gram),
                new IngredientEntry(Ou, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Carne_Pui_Tocata, 500, gram)),
                F2, List.of(FrunzeTelina, Sare, Piper)));
        cookbook.add(new Recipe("Budincă", AtLeastOnce, List.of(
                new IngredientEntry(Lapte, 100, gram),
                new IngredientEntry(Zahar, 50, gram)),
                Desert, List.of())); // TODO No Recipy
        cookbook.add(new Recipe("Chiftele cu carne", Once, List.of(
                new IngredientEntry(Carne_Vita_Tocata, 500, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Ou, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Usturoi, 7, bucati)),
                Rece, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Chiftele de soia în suc de roșii", Once, List.of(
                new IngredientEntry(Soia, 200, gram)),
                Rece, List.of())); // TODO No recipy
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
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de cartofi cu smântână", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Bors, 500, gram)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de cartofi roșie", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de conopidă", AtLeastOnce, List.of(
                new IngredientEntry(Conopida, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de dovlecei cu ciuperci", AtLeastOnce, List.of(
                new IngredientEntry(Dovlecei, 2, bucati),
                new IngredientEntry(Ciuperci, 400, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Telina, 250, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
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
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, BoiaAfumata, Iuteala, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu dafin", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Dafin, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu cimbru", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)
                ),
                F1, List.of(Patrunjel, Marar, Cimbru, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu leuștean", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 400, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Leustean, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de frunze", Disabled, List.of(
                new IngredientEntry(Stevie, 500, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Taitei, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Bors, 500, gram)),
                F1, List.of(Marar, Leustean, Sare, Piper))); // nu găsești cantități industriale de frunze în București, doar la legătură.
        cookbook.add(new Recipe("Ciorbă de ghebe cu smântână", Once, List.of(
                new IngredientEntry(Ciuperci, 1000, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri))
                , F1, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de năut cu afumătură", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 350, gram),
                new IngredientEntry(Naut, 250, gram),
                new IngredientEntry(Pappardelle, 125, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(BoiaDulce, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Leustean, Sare, Piper), 3));
        cookbook.add(new Recipe("Ciorbă de păstăi fresh", Disabled, List.of(
                new IngredientEntry(PastaiFresh, 800, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F1, List.of(Patrunjel, Marar, Leustean, Sare, Piper)));
        cookbook.add(new Recipe("Ciorbă de perișoare", Once, List.of(
                new IngredientEntry(Carne_Pui_Tocata, 500, gram)),
                F1, List.of())); // TODO No recipy
        cookbook.add(new Recipe("Ciorbă de pui a la Grec", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare, 700, gram),
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
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri)), // de la omletă
                F1, List.of(Sare)));
        cookbook.add(new Recipe("Ciorbă rădăuțeană", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare, 500, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Ou, 4, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Telina, 200, gram),
                new IngredientEntry(Usturoi, 5, bucati)), F1, List.of(Otet, Patrunjel, Dafin, Sare, Piper)));
        cookbook.add(new Recipe("Ciuperci cu maioneză și usturoi", AtLeastOnce, List.of(
                new IngredientEntry(Ciuperci, 1500, gram),
                new IngredientEntry(Maioneza, 150, gram),
                new IngredientEntry(Usturoi, 12, gram)),
                Rece, List.of(Sare)));
        cookbook.add(new Recipe("Clătite", Once, List.of(
                new IngredientEntry(Faina_Grau_65, 280, gram),
                new IngredientEntry(Lapte, 500, gram),
                new IngredientEntry(Zahar, 50, gram),
                new IngredientEntry(Ou, 2, bucati)),
                Desert, List.of(Sare))); // TODO: Ia o rețetă, că ai făcut varză cu rețeta asta
        cookbook.add(new Recipe("Cozonac", Disabled, List.of(
                new IngredientEntry(Faina_Grau_65, 200, gram),
                new IngredientEntry(Zahar, 50, gram)),
                Desert, List.of())); // TODO: No recipy
        cookbook.add(new Recipe("Fasole bătută", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 500, gram)),
                Rece, List.of())); // TODO: No Recipy
        cookbook.add(new Recipe("Ghiveci", AtLeastOnce, List.of(
                new IngredientEntry(Conopida, 1, bucati),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Dovlecei, 1, bucati),
                new IngredientEntry(Mazare, 200, gram),
                new IngredientEntry(Cartofi, 300, gram),
                new IngredientEntry(Fasole_Uscata, 200, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Gigantes Plaki", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 900, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Usturoi, 6, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 550, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri)),
                F2, List.of(Patrunjel, Marar, FrunzeTelina)));
        cookbook.add(new Recipe("Gratin de cartofi cu broccoli și brânză", Once, List.of(
                new IngredientEntry(Cartofi, 1500, gram),
                new IngredientEntry(Broccoli, 1, bucati),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Branza_Gorgonzola, 200, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Usturoi, 3, bucati),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Gratin de cartofi cu roșii și brânză", Once, List.of(
                new IngredientEntry(Cartofi, 1500, gram),
                new IngredientEntry(Rosii, 600, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Branza_Mozzarella, 300, gram)),
                F2, List.of(Busuioc, Sare, Piper)));
        cookbook.add(new Recipe("Griș cu lapte", AtLeastOnce, List.of(
                new IngredientEntry(Lapte, 1500, gram),
                new IngredientEntry(Gris, 12, linguri),
                new IngredientEntry(Zahar, 150, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Gulaș", Once, List.of(
                new IngredientEntry(Carne_Vita_Chuck, 600, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram),
                new IngredientEntry(Cartofi, 600, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Usturoi, 4, bucati),
                new IngredientEntry(Telina, 200, gram)),
                F2, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, Tarhon, FrunzeTelina, Sare, Piper)));
        cookbook.add(new Recipe("Humus", AtLeastOnce, List.of(
                new IngredientEntry(Naut, 400, gram),
                new IngredientEntry(Ulei_Masline, 7, linguri),
                new IngredientEntry(Tahini, 2, linguri),
                new IngredientEntry(Usturoi, 2, bucati)),
                Rece, List.of(Sare, SucLamaie, BoiaAfumata), 2));
        cookbook.add(new Recipe("Humus cu pesto", AtLeastOnce, List.of(
                new IngredientEntry(Naut, 400, gram),
                new IngredientEntry(Ulei_Masline, 7, linguri),
                new IngredientEntry(Tahini, 2, linguri),
                new IngredientEntry(Usturoi, 2, bucati),
                new IngredientEntry(Sos_Pesto_Genovese, 100, gram)),
                Rece, List.of(Busuioc, Sare, SucLamaie)));
        cookbook.add(new Recipe("Lalele", Disabled, List.of( // ar fi aperitive, unde restul de la ceapă verde ar merge cu o ciorbă, nu ca al 3-lea dish
                new IngredientEntry(Rosii, 4, bucati),
                new IngredientEntry(Ceapa_Verde, 4, bucati),
                new IngredientEntry(Branza_Fagaras, 400, gram),
                new IngredientEntry(Usturoi, 1, bucati)),
                Rece, List.of(SucLamaie, Oregano)));
        cookbook.add(new Recipe("Lasagna bolognese", Once, List.of(
                new IngredientEntry(Carne_Vita_Tocata, 500, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Apio, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram),
                new IngredientEntry(Unt, 100, gram),
                new IngredientEntry(Faina_Grau_65, 75, gram),
                new IngredientEntry(Lapte, 1000, gram),
                new IngredientEntry(Paste_Lasagna, 500, gram)), F2, List.of(VinAlb, Sare)));
        cookbook.add(new Recipe("Lohikeitto", AtMostOnce, List.of(
                new IngredientEntry(Peste_Somon, 450, gram),
                new IngredientEntry(Cartofi, 700, gram),
                new IngredientEntry(Morcov, 1, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Smantana, 300, gram)),
                F1, List.of(Dafin, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Mâncare de cartofi - ardelenească", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 2500, gram),
                new IngredientEntry(Ceapa, 5, bucati)),
                F2, List.of(Iuteala, BoiaDulce, BoiaIute, Dafin)));
        cookbook.add(new Recipe("Mâncare de cartofi - Cu pui", AtMostOnce, List.of(
                new IngredientEntry(Cartofi, 1500, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Carne_Pui_Picioare, 600, gram)),
                F2, List.of(Sare, Piper, Dafin, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Mâncare de cartofi - Cu soia", Once, List.of(
                new IngredientEntry(Cartofi, 1500, gram),
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram)),
                F2, List.of(Sare, Piper, Dafin, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Mâncare de cartofi - moldovenească", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 2000, gram),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati)),
                F2, List.of(Sare, Piper, Marar, Iuteala)));
        cookbook.add(new Recipe("Mâncare de fasole - Fasole prăjită", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 900, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati)),
                F2, List.of(Sare, Piper, Marar)));
        cookbook.add(new Recipe("Mâncare de fasole - Fasole prăjită - Fuchs remix", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 900, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram)),
                F2, List.of(Sare, Piper, Marar, FuchsFasole)));
        cookbook.add(new Recipe("Mâncare de fasole - Iahnie de fasole", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata, 800, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Usturoi, 6, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Telina, 200, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)), F2, List.of(Sare, Piper, Dafin)));
        cookbook.add(new Recipe("Mâncare de mazăre - Cu pui", Disabled, List.of(
                new IngredientEntry(Mazare, 1000, gram),
                new IngredientEntry(Carne_Pui_Piept, 500, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Usturoi, 3, bucati)), F2, List.of(Sare, Piper, Marar, BoiaDulce, Dafin))); // mazărea cu soia e pur și simplu superioară
        cookbook.add(new Recipe("Mâncare de mazăre - Cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Mazare, 1000, gram),
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Usturoi, 3, bucati)), F2, List.of(Sare, Piper, Marar, BoiaDulce, Dafin)));
        cookbook.add(new Recipe("Mâncare de mazăre - Simplu", Once, List.of(
                new IngredientEntry(Mazare, 1400, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Morcov, 3, bucati)),
                F2, List.of(Sare, Piper, Marar)));
        cookbook.add(new Recipe("Mâncare de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate, 1400, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Ardei_Rosu, 3, bucati),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 250, gram)),
                F2, List.of(Sare, Piper, Patrunjel)));
        cookbook.add(new Recipe("Melanzane alla parmigiano", Once, List.of(
                new IngredientEntry(Vinete, 1100, gram),
                new IngredientEntry(Branza_Mozzarella, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram), // din toata prajeala
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Minestrone", AtLeastOnce, List.of(
                new IngredientEntry(Conopida, 250, gram),
                new IngredientEntry(Broccoli, 250, gram),
                new IngredientEntry(Morcov, 100, gram),
                new IngredientEntry(Orez, 100, gram),
                new IngredientEntry(Fasole_Uscata, 100, gram),
                new IngredientEntry(Mazare, 200, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                F1, List.of(Sare, Piper, Busuioc, Rozmarin, Patrunjel)));
        cookbook.add(new Recipe("Musaca cu carne", Once, List.of(
                new IngredientEntry(Cartofi, 2000, gram),
                new IngredientEntry(Carne_Pui_Tocata, 500, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt, 50, gram)), F2, List.of(Sare)));
        cookbook.add(new Recipe("Musaca cu ragu", AtMostOnce, List.of(
                new IngredientEntry(Cartofi, 2000, gram),
                new IngredientEntry(Carne_Vita_Tocata, 500, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt, 50, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Apio, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram)),
                F2, List.of(VinAlb)));
        cookbook.add(new Recipe("Musaca cu ciuperci", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 2000, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt, 50, gram),
                new IngredientEntry(Ciuperci, 1600, gram),
                new IngredientEntry(Ceapa, 4, bucati)),
                F2, List.of(Sare, Piper), 2));
        cookbook.add(new Recipe("Musaca cu soia", Once, List.of(
                new IngredientEntry(Cartofi, 2000, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt, 50, gram),
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Apio, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram)),
                F2, List.of(VinAlb)));
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
        cookbook.add(new Recipe("Nasi Goreng", AtMostOnce, List.of(
                new IngredientEntry(Orez, 250, gram),
                new IngredientEntry(Carne_Pui_Picioare, 500, gram),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Mazare, 300, gram),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Ciuperci, 400, gram),
                new IngredientEntry(Usturoi, 2, bucati)),
                F2, List.of(Sare, Curcuma, Ghimbir, Coriandru, Chimen, SucLamaie)));
        cookbook.add(new Recipe("Pilaf - Cu ciuperci și alte legume", AtLeastOnce, List.of(
                new IngredientEntry(Orez, 200, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 1, bucati),
                new IngredientEntry(Ciuperci, 400, gram),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Telina, 150, gram),
                new IngredientEntry(Dovlecei, 1, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati)),
                F2, List.of(Sare, Piper, Marar, Patrunjel)));
        cookbook.add(new Recipe("Pilaf - Cu dovlecei", AtLeastOnce, List.of(
                new IngredientEntry(Orez, 200, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Dovlecei, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 250, gram)),
                F2, List.of(Sare, Patrunjel)));
        cookbook.add(new Recipe("Pilaf - Cu urzici", Disabled, List.of(
                new IngredientEntry(Orez, 300, gram),
                new IngredientEntry(Urzici, 500, gram),
                new IngredientEntry(Ceapa, 4, bucati)),
                F2, List.of(Sare, Patrunjel, Patrunjel))); // faci când găsești, e un tiny window
        cookbook.add(new Recipe("Pilaf - Paella cu pui", AtMostOnce, List.of(
                new IngredientEntry(Orez, 300, gram),
                new IngredientEntry(Carne_Pui_Picioare, 500, gram),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Usturoi, 6, bucati),
                new IngredientEntry(Mazare, 100, gram),
                new IngredientEntry(Fasole_Uscata, 200, gram)),
                F2, List.of(Sare, Patrunjel, Curcuma, SucLamaie)));
        cookbook.add(new Recipe("Pilaf - Sarmale cu varză murată și carne", Disabled, List.of(
                new IngredientEntry(Orez, 200, gram),
                new IngredientEntry(VarzaMurata, 500, gram),
                new IngredientEntry(Carne_Pui_Tocata, 500, gram)),
                F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Pilaf - Sarmale viță de vie simplu", Disabled, List.of(
                new IngredientEntry(Orez, 300, gram)), F2,
                List.of())); // TODO no recipy
        cookbook.add(new Recipe("Pilaf - Sarmale viță de vie cu carne", Once, List.of(
                new IngredientEntry(Orez, 200, gram),
                new IngredientEntry(Carne_Pui_Tocata, 500, gram)),
                F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Pilaf - Simplu", AtLeastOnce, List.of(
                new IngredientEntry(Orez, 600, gram),
                new IngredientEntry(Ceapa, 6, bucati),
                new IngredientEntry(Morcov, 2, bucati)), F2, List.of(Curcuma), 2));
        cookbook.add(new Recipe("Pilaf - Cu ciuperci", Optional, List.of(
                new IngredientEntry(Orez, 400, gram),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Ciuperci, 600, gram)), F2, List.of(Curcuma), 2));
        cookbook.add(new Recipe("Plăcintă cu mere - Foietaj", AtLeastOnce, List.of(
                new IngredientEntry(Foietaj, 500, gram),
                new IngredientEntry(Mere, 500, gram),
                new IngredientEntry(Zahar, 2, linguri)),
                Desert, List.of(Scortisoara)));
        cookbook.add(new Recipe("Răcitură", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare, 500, gram),
                new IngredientEntry(Usturoi, 10, bucati)),
                F2, List.of(Sare, Piper))); // TODO: Recipy
        cookbook.add(new Recipe("Riz au lait", AtLeastOnce, List.of(
                new IngredientEntry(Orez, 400, gram),
                new IngredientEntry(Lapte_Praf, 100, gram),
                new IngredientEntry(Zahar, 200, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Salată boeuf", Once, List.of(
                new IngredientEntry(Cartofi, 450, gram),
                new IngredientEntry(Mazare, 150, gram),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Maioneza, 300, gram),
                new IngredientEntry(Carne_Pui_Piept, 200, gram),
                new IngredientEntry(Castraveti_Murati, 200, gram)),
                Rece, List.of(Sare, Mustar)));
        cookbook.add(new Recipe("Salată de pui", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 300, gram),
                new IngredientEntry(Ciuperci, 800, gram),
                new IngredientEntry(Mais, 200, gram),
                new IngredientEntry(Maioneza, 100, gram)),
                Rece, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Salată de pui cu legume", Once, List.of(
                new IngredientEntry(Cartofi, 400, gram),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Maioneza, 400, gram),
                new IngredientEntry(Carne_Pui_Piept, 150, gram),
                new IngredientEntry(Mais, 100, gram)),
                Rece, List.of(Sare, Mustar)));
        cookbook.add(new Recipe("Salată de pui cu ciuperci", Once, List.of(
                new IngredientEntry(Maioneza, 400, gram),
                new IngredientEntry(Ciuperci, 600, gram),
                new IngredientEntry(Carne_Pui_Piept, 250, gram),
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Castraveti_Murati, 100, gram)),
                Rece, List.of(Patrunjel, Mustar)));
        cookbook.add(new Recipe("Salată de vinete cu ceapă", Once, List.of(
                new IngredientEntry(Vinete, 1000, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Maioneza, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram)),
                Rece, List.of(Sare, SucLamaie)));
        cookbook.add(new Recipe("Salată de vinete cu usturoi", AtLeastOnce, List.of(
                new IngredientEntry(Vinete, 1000, gram),
                new IngredientEntry(Usturoi, 10, bucati),
                new IngredientEntry(Maioneza, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram)),
                Rece, List.of(Sare, SucLamaie)));
        cookbook.add(new Recipe("Salată de vinete cu tahini", Once, List.of(
                new IngredientEntry(Vinete, 1000, gram),
                new IngredientEntry(Maioneza, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram),
                new IngredientEntry(Tahini, 2, linguri)),
                Rece, List.of(Sare, SucLamaie)));
        cookbook.add(new Recipe("Salată orientală", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi, 1000, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ou, 4, bucati),
                new IngredientEntry(Masline, 50, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri)
                ), Rece, List.of(Sare)));
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
                new IngredientEntry(Rosii, 1000, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Telina, 200, gram),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Pastarnac, 1, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Fidea, 80, gram)), F1, List.of(Patrunjel, FrunzeTelina, Sare, Piper)));
        cookbook.add(new Recipe("Tiramisu", AtLeastOnce, List.of(
                new IngredientEntry(Piscoturi, 200, gram),
                new IngredientEntry(Branza_Mascarpone, 500, gram),
                new IngredientEntry(Ou, 4, bucati),
                new IngredientEntry(Zahar, 250, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Tocănița Malita", Once, List.of(
                new IngredientEntry(Soia, 200, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Morcov, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Ardei_Rosu, 6, bucati),
                new IngredientEntry(Usturoi, 4, bucati)),
                F2, List.of(BoiaIute, Marar, Coriandru)));
        cookbook.add(new Recipe("Tocăniță de ardei", AtMostOnce, List.of(
                new IngredientEntry(Ardei_Rosu, 6, bucati),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Dovlecei, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Tocăniță de ardei cu ton", Disabled, List.of(
                new IngredientEntry(Ardei_Rosu, 6, bucati),
                new IngredientEntry(Ton, 300, gram)),
                F2, List.of())); // mi s-a acrit după varză cu fish fingers. Vrei ton cu tocăniță de ardei, mănâncă separat, nu fă o întreagă oală cu asta
        cookbook.add(new Recipe("Tocăniță de ardei cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Ardei_Rosu, 5, bucati),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Dovlecei, 2, bucati),
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram)), F2, List.of()));
        cookbook.add(new Recipe("Tocăniță de gogonele", AtLeastOnce, List.of(
                new IngredientEntry(Gogonele, 1200, gram),
                new IngredientEntry(Ceapa, 3, bucati),
                new IngredientEntry(Ardei_Rosu, 4, bucati),
                new IngredientEntry(Usturoi, 4, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Tocăniță de legume", AtLeastOnce, List.of(
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Ardei_Rosu, 5, bucati),
                new IngredientEntry(Morcov, 4, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram),
                new IngredientEntry(Orez, 100, gram)),
                F2, List.of(FrunzeTelina, Sare, Piper)));
        cookbook.add(new Recipe("Tocăniță de praz", AtLeastOnce, List.of(
                new IngredientEntry(Praz, 1000, gram),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram),
                new IngredientEntry(Masline, 150, gram),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Usturoi, 4, bucati)),
                F2, List.of(Patrunjel, Dafin, SucLamaie, Sare)));
        cookbook.add(new Recipe("Tzatziki", AtLeastOnce, List.of(
                new IngredientEntry(Iaurt_Grecesc_10, 2000, gram),
                new IngredientEntry(Castraveti_Cornichon, 600, gram),
                new IngredientEntry(Ulei_Masline, 30, gram),
                new IngredientEntry(Usturoi, 10, bucati)),
                Rece, List.of(Marar, Sare)));
        cookbook.add(new Recipe("Țelină cu morcov", AtLeastOnce, List.of(
                new IngredientEntry(Telina, 900, gram),
                new IngredientEntry(Morcov, 900, gram),
                new IngredientEntry(Ton, 640, gram),
                new IngredientEntry(Maioneza, 400, gram)),
                Rece, List.of(Sare)));
        cookbook.add(new Recipe("Varză călită", Once, List.of(
                new IngredientEntry(VarzaMurata, 1500, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                F2, List.of(BoiaDulce, Dafin, Chimen, Piper, Sare)));
        cookbook.add(new Recipe("Varză fiartă", AtLeastOnce, List.of(
                new IngredientEntry(Varza, 2000, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram)),
                F2, List.of(Dafin, Sare)));
        cookbook.add(new Recipe("Varză cu fish fingers", Disabled, List.of(
                new IngredientEntry(Varza, 2000, gram),
                new IngredientEntry(Peste, 300, gram)), F2, List.of(Dafin))); // e o porcărie grasă și grețoasă
        cookbook.add(new Recipe("Varză cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Varza, 2000, gram),
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Morcov, 2, bucati),
                new IngredientEntry(Ardei_Rosu, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram)),
                F2, List.of(Dafin)));
        cookbook.add(new Recipe("Varză la Cluj", Once, List.of(
                new IngredientEntry(VarzaMurata, 1000, gram),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Orez, 150, gram),
                new IngredientEntry(Carne_Vita_Tocata, 500, gram)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Varză la Cluj cu soia", Once, List.of(
                new IngredientEntry(VarzaMurata, 1000, gram),
                new IngredientEntry(Soia, 200, gram),
                new IngredientEntry(Ceapa, 4, bucati),
                new IngredientEntry(Orez, 150, gram)),
                F2, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Vitello tonnato", AtMostOnce, List.of( // mănânci ditamai halca de carne într-o săptămână
                new IngredientEntry(Carne_Vita_Chuck, 500, gram),
                new IngredientEntry(Ton, 160, gram)),
                Rece, List.of(Sare))); // TODO no recipy

        // Fast Food
        cookbook.add(new Recipe("Mămăligă", AtLeastOnce, List.of(
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_Fagaras, 200, gram),
                new IngredientEntry(Lapte, 300, gram),
                new IngredientEntry(Ou, 2, bucati)),
                FastFood, List.of(Sare)));
        cookbook.add(new Recipe("Găgău", AtLeastOnce, List.of(
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_Telemea, 200, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Mămăligă cu brânză", Disabled, List.of(
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_Telemea, 300, gram)),
                FastFood, List.of(Sare)));
        cookbook.add(new Recipe("Mâncare de ciuperci - Ciulama de ciuperci", Once, List.of(
                new IngredientEntry(Ciuperci, 1000, gram),
                new IngredientEntry(Ceapa, 2, bucati),
                new IngredientEntry(Unt, 50, gram),
                new IngredientEntry(Faina_Grau_65, 2, linguri),
                new IngredientEntry(Lapte, 600, gram)),
                FastFood, List.of(Patrunjel, Marar, Sare, Piper)));
        cookbook.add(new Recipe("Mâncare de ciuperci - Ciuperci cu smântână și usturoi", AtMostOnce, List.of(
                new IngredientEntry(Ciuperci, 1000, gram),
                new IngredientEntry(Unt, 50, gram),
                new IngredientEntry(Smantana, 300, gram),
                new IngredientEntry(Usturoi, 4, bucati)),
                FastFood, List.of(Patrunjel, Sare, Piper)));
        cookbook.add(new Recipe("Spanac cu smântână", Once, List.of(
                new IngredientEntry(Spanac, 500, gram),
                new IngredientEntry(Smantana, 200, gram),
                new IngredientEntry(Lapte, 120, gram),
                new IngredientEntry(Usturoi, 4, bucati)),
                FastFood, List.of(Sare)));
        cookbook.add(new Recipe("Mâncărică de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate, 700, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Usturoi, 2, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Microfoane", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare, 500, gram),
                new IngredientEntry(Malai, 100, gram)),
                FastFood, List.of(Sare, Piper, BoiaDulce)));
        cookbook.add(new Recipe("Ficat de pui prăjit", Once, List.of(
                new IngredientEntry(Carne_Pui_Ficat, 500, gram),
                new IngredientEntry(Malai, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Fish fingers", Disabled, List.of(
                new IngredientEntry(Peste, 300, gram)),
                FastFood, List.of())); // sunt grase, sunt puturoase. Dacă ți se face poftă, ia 100g, nu 500g. Dar sunt uleioase, grețoase.
        cookbook.add(new Recipe("Șnițel de soia", AtLeastOnce, List.of(
                new IngredientEntry(Soia, 100, gram),
                new IngredientEntry(Usturoi, 5, bucati),
                new IngredientEntry(Malai, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Șnițel de pui", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept, 500, gram)),
                FastFood, List.of(Sare, Piper)));
        cookbook.add(new Recipe("Somon prăjit", Once, List.of(
                new IngredientEntry(Peste_Somon, 250, gram),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Usturoi, 5, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pește prăjit", Once, List.of(
                new IngredientEntry(Peste, 500, gram),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Usturoi, 5, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Omletă cremă", Once, List.of(
                new IngredientEntry(Ou, 3, bucati)),
                FastFood, List.of(Sare))); // e aproape ou crud, si are gust a ou, e mai buna omleta prajita
        cookbook.add(new Recipe("Omletă cu roșii", AtLeastOnce, List.of(
                new IngredientEntry(Ou, 3, bucati),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Ceapa_Verde, 1, bucati),
                new IngredientEntry(Branza_Mozzarella, 150, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Omletă normală", AtLeastOnce, List.of(
                new IngredientEntry(Ou, 3, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Roșii cu brânză", AtLeastOnce, List.of(
                new IngredientEntry(Rosii, 500, gram),
                new IngredientEntry(Branza_Telemea, 200, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Salată de roșii - mama", AtLeastOnce, List.of(
                new IngredientEntry(Rosii, 3, bucati),
                new IngredientEntry(Castraveti_Cornichon, 1, bucati),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Branza_Telemea, 100, gram)),
                FastFood, List.of(Sare)));
        cookbook.add(new Recipe("Salad Box", AtLeastOnce, List.of(
                new IngredientEntry(Salata, 200, gram),
                new IngredientEntry(Ulei_Masline, 2, linguri)), FastFood, List.of()));
        cookbook.add(new Recipe("Cobb Salad", AtLeastOnce, List.of(
                new IngredientEntry(Salata, 200, gram),
                new IngredientEntry(Carne_Pui_Piept, 200, gram),
                new IngredientEntry(Ou, 3, bucati),
                new IngredientEntry(Rosii, 2, bucati),
                new IngredientEntry(Branza_Telemea, 200, gram),
                new IngredientEntry(Ceapa_Verde, 3, bucati),
                new IngredientEntry(Avocado_Hass, 1, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Facebook Salad", AtLeastOnce, List.of(
                new IngredientEntry(Avocado_Hass, 1, bucati),
                new IngredientEntry(Ou, 2, bucati),
                new IngredientEntry(Rosii, 1, bucati)), FastFood, List.of()));
        cookbook.add(new Recipe("Dovlecei prăjiți", Once, List.of(
                new IngredientEntry(Dovlecei, 1, bucati),
                new IngredientEntry(Ou, 2, bucati),
                new IngredientEntry(Pesmet, 100, gram), // oare?
                new IngredientEntry(Branza_Grattugiato, 100, gram   )),
                FastFood, List.of(Sare)));
        cookbook.add(new Recipe("Paste - Pesto al Genovese (semi)", AtMostOnce, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Sos_Pesto_Genovese, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Al sugo di pomodoro", Once, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Usturoi, 2, bucati)),
                FastFood, List.of(Busuioc)));
        cookbook.add(new Recipe("Paste - cu somon", Once, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Peste_Somon, 100, gram),
                new IngredientEntry(Unt, 25, gram),
                new IngredientEntry(Faina_Grau_65, 20, gram),
                new IngredientEntry(Lapte, 200, gram)), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - cu ton", Once, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Ton, 160, gram),
                new IngredientEntry(Ceapa, 1, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Verdura (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Ricotta (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Napoletane (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Olive (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - cu Basilico (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Funghi (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Quattro Formaggi (semi)", AtMostOnce, List.of(
                new IngredientEntry(Paste, 200, gram),
                new IngredientEntry(Sos_Quattro_Formaggi, 370, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Carbonara (semi)", AtMostOnce, List.of(
                new IngredientEntry(Paste, 200, gram),
                new IngredientEntry(Sos_Carbonara, 370, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Arrabbiata (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Bolognese (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Ciuperci prăjite", Disabled, List.of(
                new IngredientEntry(Ciuperci, 1200, gram),
                new IngredientEntry(Ceapa, 1, bucati),
                new IngredientEntry(Usturoi, 2, bucati)),
                FastFood, List.of(Sare)));

        // Fruits
        cookbook.add(new Recipe("Banane", AtLeastOnce, List.of(
                new IngredientEntry(Banane, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Caise", AtLeastOnce, List.of(
                new IngredientEntry(Caise, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Capșuni", Once, List.of(
                new IngredientEntry(Capsuni, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Cireșe", Once, List.of(
                new IngredientEntry(Cirese, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Clementine", Once, List.of(
                new IngredientEntry(Clementine, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Grapefruit", AtMostOnce, List.of(
                new IngredientEntry(Grapefruit, 300, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Kaki", AtLeastOnce, List.of(
                new IngredientEntry(Kaki, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Kiwi", AtLeastOnce, List.of(
                new IngredientEntry(Kiwi, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mandarine", Once, List.of(
                new IngredientEntry(Mandarine, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mango", AtMostOnce, List.of(
                new IngredientEntry(Mango, 200, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mere", AtLeastOnce, List.of(
                new IngredientEntry(Mere, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mineole", Once, List.of(
                new IngredientEntry(Mineole, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Papaya", AtMostOnce, List.of(
                new IngredientEntry(Papaya, 200, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Pepene Galben", Once, List.of(
                new IngredientEntry(PepeneGalben, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Pepene Roșu", AtLeastOnce, List.of(
                new IngredientEntry(PepeneRosu, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Pere", AtLeastOnce, List.of(
                new IngredientEntry(Pere, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Portocale", AtLeastOnce, List.of(
                new IngredientEntry(Portocale, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Prune", AtLeastOnce, List.of(
                new IngredientEntry(Prune, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Rodii", AtMostOnce, List.of(
                new IngredientEntry(Rodii, 200, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Struguri", Once, List.of(
                new IngredientEntry(Struguri, 250, gram)), Fruits, List.of()));

        return cookbook;
    }
}
