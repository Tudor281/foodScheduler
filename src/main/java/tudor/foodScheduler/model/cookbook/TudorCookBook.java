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
                new IngredientEntry(Cartofi_Raw, 1000, gram),
                new IngredientEntry(Maioneza, 200, gram),
                new IngredientEntry(Ceapa_Rosie_Raw, 1, bucati),
                new IngredientEntry(Apio_Raw, 100, gram),
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3*6, bucati)),
                Rece, List.of(Mustar, Patrunjel, Piper, BoiaDulce)));
        cookbook.add(new Recipe("Ardei umpluți cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Ardei_Verde_Raw, 16, bucati),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Orez_Raw, 200, gram),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Rosii, 4, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Lapte_Acru, 3000, gram),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(FrunzeTelina, Piper, BoiaAfumata)));
        cookbook.add(new Recipe("Ardei umpluți cu carne", AtLeastOnce, List.of(
                new IngredientEntry(Ardei_Verde_Raw, 16, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Orez_Raw, 150, gram),
                new IngredientEntry(Ou_Raw, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Carne_Pui_Tocata_Raw, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Lapte_Acru, 3000, gram),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(FrunzeTelina, Piper)));
        cookbook.add(new Recipe("Budincă", AtLeastOnce, List.of(
                new IngredientEntry(Lapte, 3000, gram),
                new IngredientEntry(Zahar, 12, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Ciorbă de broccoli", AtLeastOnce, List.of(
                new IngredientEntry(Broccoli_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de cartofi cu smântână", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de cartofi roșie", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de conopidă", AtLeastOnce, List.of(
                new IngredientEntry(Conopida_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de dovlecei cu ciuperci", AtLeastOnce, List.of(
                new IngredientEntry(Dovlecei_Raw, 2, bucati),
                new IngredientEntry(Ciuperci_Raw, 400, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Telina_Raw, 250, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu chimen", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 800, gram ),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 5, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, BoiaAfumata, Iuteala, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu cimbru", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Cimbru, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu dafin", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Dafin, Piper)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu leuștean", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Leustean, Piper)));
        cookbook.add(new Recipe("Ciorbă de linte cu smântână", Once, List.of(
                new IngredientEntry(Linte_Galbena_Raw, 300, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 4, bucati),
                new IngredientEntry(Cartofi_Raw, 500, gram),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper, Leustean, Patrunjel)));
        cookbook.add(new Recipe("Ciorbă de frunze", Disabled, List.of(
                new IngredientEntry(Stevie, 500, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Taitei, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Marar, Leustean, Piper)));
        cookbook.add(new Recipe("Ciorbă de ghebe cu smântână", AtLeastOnce, List.of(
                new IngredientEntry(Ciuperci_Raw, 1400, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati))
                , F1, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de linte cu smântână", Once, List.of(
                new IngredientEntry(Linte_Galbena_Raw, 300, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Cartofi_Raw, 300, gram),
                new IngredientEntry(Ulei_Masline, 1, linguri),
                new IngredientEntry(Ulei_Floarea_Soarelui, 1, linguri),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Smantana_10, 150, gram),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Leustean, Patrunjel, Piper, SucLamaie, Otet)));
        cookbook.add(new Recipe("Ciorbă de năut cu afumătură", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept_Raw, 350, gram),
                new IngredientEntry(Naut_Raw, 500, gram),
                new IngredientEntry(Pappardelle, 125, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(BoiaDulce, Piper)));
        cookbook.add(new Recipe("Ciorbă de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Leustean, Piper), 3));
        cookbook.add(new Recipe("Ciorbă de păstăi fresh", Disabled, List.of(
                new IngredientEntry(PastaiFresh_Raw, 800, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Marar, Leustean, Piper)));
        cookbook.add(new Recipe("Ciorbă de perișoare", AtLeastOnce, List.of(
                new IngredientEntry(Carne_Vita_Tocata_Raw, 500, gram),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Ou_Raw, 1, bucati),
                new IngredientEntry(Orez_Raw, 50, gram),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Marar, Patrunjel, Piper)));
        cookbook.add(new Recipe("Ciorbă de pui a la Grec", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare_Raw, 700, gram),
                new IngredientEntry(Orez_Raw, 100, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(SucLamaie, Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciorbă de salată cu scrob", AtLeastOnce, List.of(
                new IngredientEntry(Salata_Raw, 1, bucati),
                new IngredientEntry(Ou_Raw, 7, bucati),
                new IngredientEntry(Bors, 500, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Orez_Raw, 50, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),  // de la omletă
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of()));
        cookbook.add(new Recipe("Ciorbă rădăuțeană", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare_Raw, 500, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Ou_Raw, 4, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Telina_Raw, 200, gram),
                new IngredientEntry(Usturoi_Raw, 5, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Otet, Patrunjel, Dafin, Piper)));
        cookbook.add(new Recipe("Ciuperci cu maioneză și usturoi", AtLeastOnce, List.of(
                new IngredientEntry(Ciuperci_Raw, 1500, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 200, gram),
                new IngredientEntry(Ou_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 12, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 2 * 6, bucati)),Rece, List.of()));
        cookbook.add(new Recipe("Clătite", Once, List.of(
                new IngredientEntry(Faina_Grau_65, 280, gram),
                new IngredientEntry(Lapte, 500, gram),
                new IngredientEntry(Zahar, 50, gram),
                new IngredientEntry(Ou_Raw, 2, bucati)),
                Desert, List.of())); // TODO
        cookbook.add(new Recipe("Cremă de avocado cu brânză și usturoi", Disabled, List.of(
                new IngredientEntry(Avocado_Hass_Raw, 1, bucati),
                new IngredientEntry(Branza_CottageFullFat, 150, gram),
                new IngredientEntry(Usturoi_Raw, 2, bucati),
                new IngredientEntry(Sare, 2, gram),
                new IngredientEntry(Paine, 4, bucati)),
                Aperitiv, List.of(SucLamaie, Piper, Iuteala)));
        cookbook.add(new Recipe("Fasole bătută", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 800, gram),
                new IngredientEntry(Usturoi_Raw, 5, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 2 * 6, bucati)),
                Rece, List.of()));
        cookbook.add(new Recipe("Fasole pasată cu ceapă", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 800, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 75, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 2 * 6, bucati)),
                Rece, List.of()));
        cookbook.add(new Recipe("Ghiveci", AtLeastOnce, List.of(
                new IngredientEntry(Conopida_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Dovlecei_Raw, 1, bucati),
                new IngredientEntry(Mazare_Raw, 200, gram),
                new IngredientEntry(Cartofi_Raw, 300, gram),
                new IngredientEntry(Fasole_Uscata_Raw, 400, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Gigantes Plaki", Once, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 900, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Usturoi_Raw, 6, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 550, gram),
                new IngredientEntry(Ulei_Masline, 4, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Patrunjel, Marar, FrunzeTelina)));
        cookbook.add(new Recipe("Gratin de cartofi cu broccoli și brânză", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 1500, gram),
                new IngredientEntry(Broccoli_Raw, 1, bucati),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Branza_Gorgonzola, 200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt_Sarat, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Gratin de cartofi cu roșii și brânză", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 1500, gram),
                new IngredientEntry(Rosii, 600, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Branza_Mozzarella, 300, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Busuioc, Piper)));
        cookbook.add(new Recipe("Griș cu lapte", Disabled, List.of(
                new IngredientEntry(Lapte, 3000, gram),
                new IngredientEntry(Gris, 24, linguri),
                new IngredientEntry(Zahar, 400, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Guacamole", Once, List.of(
                new IngredientEntry(Avocado_Hass_Raw, 2, bucati),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Ceapa_Rosie_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 1, bucati),
                new IngredientEntry(Sare, 2, gram),
                new IngredientEntry(Paine, 2 * 2, bucati)),
                Aperitiv, List.of(SucLamaie, Iuteala, Piper, Patrunjel)));
        cookbook.add(new Recipe("Gulaș", AtLeastOnce, List.of(
                new IngredientEntry(Carne_Vita_Chuck_Roast, 600, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram),
                new IngredientEntry(Cartofi_Raw, 600, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Telina_Raw, 200, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, Tarhon, FrunzeTelina, Piper)));
        cookbook.add(new Recipe("Humus", AtLeastOnce, List.of(
                new IngredientEntry(Naut_Raw, 600, gram),
                new IngredientEntry(Ulei_Masline, 5, linguri),
                new IngredientEntry(Tahini, 3, linguri),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(SucLamaie, BoiaAfumata), 2));
        cookbook.add(new Recipe("Humus cu pesto", AtLeastOnce, List.of(
                new IngredientEntry(Naut_Raw, 600, gram),
                new IngredientEntry(Ulei_Masline, 5, linguri),
                new IngredientEntry(Tahini, 3, linguri),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Sos_Pesto_Genovese, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                Rece, List.of(Busuioc, SucLamaie)));
        cookbook.add(new Recipe("Korozott", Once, List.of(
                new IngredientEntry(Branza_CottageFullFat, 1000, gram),
                new IngredientEntry(Unt_Sarat, 250, gram),
                new IngredientEntry(Ceapa_Rosie_Raw, 2, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Piper, BoiaDulce, Iuteala, Chimen)));
        cookbook.add(new Recipe("Lalele", Disabled, List.of(
                new IngredientEntry(Rosii, 4, bucati),
                new IngredientEntry(Ceapa_Verde_Raw, 4, bucati),
                new IngredientEntry(Branza_Fagaras, 400, gram),
                new IngredientEntry(Usturoi_Raw, 1, bucati)),
                Aperitiv, List.of(SucLamaie, Oregano)));
        cookbook.add(new Recipe("Lasagna cu spanac", AtLeastOnce, List.of(
                new IngredientEntry(Spanac_Raw, 900, gram),
                new IngredientEntry(Paste_Lasagna, 500, gram),
                new IngredientEntry(Branza_Mozzarella, 400, gram),
                new IngredientEntry(Branza_Grattugiato, 100, gram),
                new IngredientEntry(Usturoi_Raw, 2, bucati),
                new IngredientEntry(Unt_Sarat, 100, gram),
                new IngredientEntry(Faina_Grau_65, 75, gram),
                new IngredientEntry(Lapte, 1000, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Piper, Nucsoara)));
        cookbook.add(new Recipe("Lasagna bolognese", Once, List.of(
                new IngredientEntry(Carne_Vita_Tocata_Raw, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Apio_Raw, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram),
                new IngredientEntry(Unt_Sarat, 100, gram),
                new IngredientEntry(Faina_Grau_65, 75, gram),
                new IngredientEntry(Lapte, 1000, gram),
                new IngredientEntry(Paste_Lasagna, 500, gram),
                new IngredientEntry(Sare, 2, lingurite)), F2, List.of(VinAlb, Nucsoara)));
        cookbook.add(new Recipe("Lohikeitto", AtMostOnce, List.of(
                new IngredientEntry(Peste_Somon_Raw, 450, gram),
                new IngredientEntry(Cartofi_Raw, 700, gram),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Dafin, Marar, Piper)));
        cookbook.add(new Recipe("Mâncare de cartofi ardelenească", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 2500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 5, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Castraveti_Murati, 2 * 7, bucati),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Iuteala, BoiaDulce, BoiaIute, Dafin)));
        cookbook.add(new Recipe("Mâncare de cartofi cu pui", AtMostOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 1500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Carne_Pui_Picioare_Raw, 600, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Dafin, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Mâncare de cartofi cu soia", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 1500, gram),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Dafin, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Mâncare de cartofi moldovenească", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 2000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Castraveti_Murati, 2 * 7, bucati),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Marar, Iuteala)));
        cookbook.add(new Recipe("Fasole prăjită", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 1800, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati),
                new IngredientEntry(Castraveti_Murati, 2 * 7, bucati)),
                F2, List.of(Piper, Marar)));
        cookbook.add(new Recipe("Fasole prăjită - Fuchs remix", Once, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 1800, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Marar, FuchsFasole)));
        cookbook.add(new Recipe("Iahnie de fasole", AtLeastOnce, List.of(
                new IngredientEntry(Fasole_Uscata_Raw, 1600, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 6, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Telina_Raw, 200, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Dafin)));
        cookbook.add(new Recipe("Mazăre cu pui", AtLeastOnce, List.of(
                new IngredientEntry(Mazare_Raw, 1000, gram),
                new IngredientEntry(Carne_Pui_Piept_Raw, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Marar, BoiaDulce, Dafin)));
        cookbook.add(new Recipe("Mazăre cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Mazare_Raw, 1000, gram),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Marar, BoiaDulce, Dafin)));
        cookbook.add(new Recipe("Mazăre - Simplu", AtMostOnce, List.of(
                new IngredientEntry(Mazare_Raw, 1400, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Marar)));
        cookbook.add(new Recipe("Mâncare de linte", AtLeastOnce, List.of(
                new IngredientEntry(Linte_Galbena_Raw, 800, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 3, linguri),
                new IngredientEntry(Ulei_Masline, 3, linguri),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Usturoi_Raw, 12, bucati),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Chimen, BoiaDulce, Dafin)));
        cookbook.add(new Recipe("Mâncare de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate_Raw, 1400, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 250, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Patrunjel)));
        cookbook.add(new Recipe("Melanzane alla parmigiano", Once, List.of(
                new IngredientEntry(Vinete_Raw, 1100, gram),
                new IngredientEntry(Branza_Mozzarella, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram), // din toata prajeala
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Minestrone", AtLeastOnce, List.of(
                new IngredientEntry(Conopida_Raw, 250, gram),
                new IngredientEntry(Broccoli_Raw, 250, gram),
                new IngredientEntry(Morcov_Raw, 100, gram),
                new IngredientEntry(Orez_Raw, 100, gram),
                new IngredientEntry(Fasole_Uscata_Raw, 100, gram),
                new IngredientEntry(Mazare_Raw, 200, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F1, List.of(Piper, Busuioc, Rozmarin, Patrunjel)));
        cookbook.add(new Recipe("Musaca cu carne", Disabled, List.of(
                new IngredientEntry(Cartofi_Raw, 2000, gram),
                new IngredientEntry(Carne_Pui_Tocata_Raw, 500, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of()));
        cookbook.add(new Recipe("Musaca cu ciuperci", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 2000, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Ciuperci_Raw, 1600, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Piper), 2));
        cookbook.add(new Recipe("Musaca cu ragu", Disabled, List.of(
                new IngredientEntry(Cartofi_Raw, 2000, gram),
                new IngredientEntry(Carne_Vita_Tocata_Raw, 500, gram),
                new IngredientEntry(Lapte, 200, gram),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Apio_Raw, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(VinAlb)));
        cookbook.add(new Recipe("Musaca cu soia", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 2000, gram),
                new IngredientEntry(Lapte, 100, gram),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Apio_Raw, 50, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(VinAlb)));
        cookbook.add(new Recipe("Nakkikeitto", AtMostOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 900, gram),
                new IngredientEntry(Carne_Pui_Crenvurst, 700, gram),
                new IngredientEntry(Morcov_Raw, 450, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Pastarnac_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper, Dafin, Patrunjel, Rozmarin)));
        cookbook.add(new Recipe("Nasi Goreng", AtMostOnce, List.of(
                new IngredientEntry(Orez_Raw, 250, gram),
                new IngredientEntry(Carne_Pui_Picioare_Raw, 500, gram),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Mazare_Raw, 300, gram),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Ciuperci_Raw, 400, gram),
                new IngredientEntry(Usturoi_Raw, 2, bucati),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Curcuma, Ghimbir, Coriandru, Chimen, SucLamaie)));
        cookbook.add(new Recipe("Ouă umplute cu ficat", AtLeastOnce, List.of(
                new IngredientEntry(Carne_Pui_Ficat_Raw, 500, gram),
                new IngredientEntry(Ou_Raw, 9+1, bucati),
                new IngredientEntry(Pate_Ficat_Gaina, 200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Unt_Sarat, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 200, gram), // maioneza
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                Rece, List.of(Piper)));
        cookbook.add(new Recipe("Ouă umplute cu pate", AtLeastOnce, List.of(
                new IngredientEntry(Ou_Raw, 9+1, bucati),
                new IngredientEntry(Pate_Ficat_Gaina, 700, gram),
                new IngredientEntry(Unt_Sarat, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 200, gram),  // maioneza
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                Rece, List.of(Piper)));
        cookbook.add(new Recipe("Ouă umplute vegetariene", AtLeastOnce, List.of(
                new IngredientEntry(Ou_Raw, 9+1, bucati),
                new IngredientEntry(Ciuperci_Raw, 800, gram),
                new IngredientEntry(Linte_Rosie_Raw, 200, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 200, gram), // maioneza
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                Rece, List.of(Piper)));
        cookbook.add(new Recipe("Pilaf cu ciuperci", Once, List.of(
                new IngredientEntry(Orez_Raw, 400, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Ciuperci_Raw, 600, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Castraveti_Murati, 2 * 7, gram)),
                F2, List.of(Curcuma), 2));
        cookbook.add(new Recipe("Pilaf cu ciuperci și alte legume", AtLeastOnce, List.of(
                new IngredientEntry(Orez_Raw, 200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Ciuperci_Raw, 400, gram),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Dovlecei_Raw, 1, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Marar, Patrunjel)));
        cookbook.add(new Recipe("Pilaf cu dovlecei", AtLeastOnce, List.of(
                new IngredientEntry(Orez_Raw, 200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Dovlecei_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 250, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Patrunjel)));
        cookbook.add(new Recipe("Pilaf cu urzici", Disabled, List.of(
                new IngredientEntry(Orez_Raw, 300, gram),
                new IngredientEntry(Urzici_Blanched, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Patrunjel, Patrunjel)));
        cookbook.add(new Recipe("Paella", AtMostOnce, List.of(
                new IngredientEntry(Orez_Raw, 300, gram),
                new IngredientEntry(Carne_Pui_Picioare_Raw, 500, gram),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 6, bucati),
                new IngredientEntry(Mazare_Raw, 100, gram),
                new IngredientEntry(Fasole_Uscata_Raw, 200, gram),
                new IngredientEntry(Sare, 2, lingurite)),
                F2, List.of(Patrunjel, Curcuma, SucLamaie)));
        cookbook.add(new Recipe("Sarmale cu varză murată și carne", Disabled, List.of(
                new IngredientEntry(Carne_Pui_Tocata_Raw, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Orez_Raw, 100, gram),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(VarzaMurata, 1000, gram),
                new IngredientEntry(Lapte_Acru, 2000, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Cimbru, Marar)));
        cookbook.add(new Recipe("Sarmale viță de vie cu carne", Disabled, List.of(
                new IngredientEntry(Carne_Pui_Tocata_Raw, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Orez_Raw, 100, gram),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Lapte_Acru, 2000, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Cimbru, Marar)));
        cookbook.add(new Recipe("Sarmale viță de vie cu soia", Once, List.of(
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Orez_Raw, 100, gram),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Lapte_Acru, 2000, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper, Cimbru, Marar, BoiaAfumata)));
        cookbook.add(new Recipe("Pilaf - Simplu", Once, List.of(
                new IngredientEntry(Orez_Raw, 600, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 6, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Castraveti_Murati, 2 * 7, bucati)),
                F2, List.of(Curcuma), 2));
        cookbook.add(new Recipe("Plăcintă cu mere - Foietaj", AtLeastOnce, List.of(
                new IngredientEntry(Foietaj, 500, gram),
                new IngredientEntry(Mere_Red_Delicious, 500, gram),
                new IngredientEntry(Zahar, 2, linguri)),
                Desert, List.of(Scortisoara)));
        cookbook.add(new Recipe("Răcitură", Disabled, List.of(
                new IngredientEntry(Carne_Pui_Picioare_Raw, 500, gram),
                new IngredientEntry(Usturoi_Raw, 10, bucati)),
                Rece, List.of(Piper))); // TODO: Recipy
        cookbook.add(new Recipe("Riz au lait", Once, List.of(
                new IngredientEntry(Orez_Raw, 400, gram),
                new IngredientEntry(Lapte_Praf, 100, gram),
                new IngredientEntry(Zahar, 200, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Salată alla russe", Once, List.of(
                new IngredientEntry(Morcov_Raw, 4, bucati),
                new IngredientEntry(Radacina_Patrunjel, 2, bucati),
                new IngredientEntry(Pastarnac_Raw, 2, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Mazare_Raw, 100, gram),
                new IngredientEntry(Castraveti_Murati, 4, bucati),
                new IngredientEntry(Cartofi_Raw, 500, gram),
                new IngredientEntry(Maioneza, 500, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Mustar)));
        cookbook.add(new Recipe("Salată boeuf fără carne", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 450, gram),
                new IngredientEntry(Mazare_Raw, 150, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Maioneza, 300, gram),
                new IngredientEntry(Castraveti_Murati, 200, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Mustar)));
        cookbook.add(new Recipe("Salată boeuf cu vită", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 450, gram),
                new IngredientEntry(Mazare_Raw, 150, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Maioneza, 300, gram),
                new IngredientEntry(Carne_Vita_Chuck_Roast, 200, gram),
                new IngredientEntry(Castraveti_Murati, 200, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Mustar)));
        cookbook.add(new Recipe("Salată de pui", AtLeastOnce, List.of(
                new IngredientEntry(Carne_Pui_Piept_Raw, 300, gram),
                new IngredientEntry(Ciuperci_Raw, 800, gram),
                new IngredientEntry(Mais, 200, gram),
                new IngredientEntry(Maioneza, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Piper)));
        cookbook.add(new Recipe("Salată de pui cu ciuperci", Once, List.of(
                new IngredientEntry(Maioneza, 800, gram),
                new IngredientEntry(Ciuperci_Raw, 1200, gram),
                new IngredientEntry(Carne_Pui_Piept_Raw, 500, gram),
                new IngredientEntry(Paste, 200, gram),
                new IngredientEntry(Castraveti_Murati, 200, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Patrunjel, Mustar)));
        cookbook.add(new Recipe("Salată de pui cu legume", Once, List.of(
                new IngredientEntry(Cartofi_Raw, 400, gram),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Maioneza, 400, gram),
                new IngredientEntry(Carne_Pui_Piept_Raw, 150, gram),
                new IngredientEntry(Mais, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 6, bucati)),
                Rece, List.of(Mustar)));
        cookbook.add(new Recipe("Salată de vinete cu ceapă", Once, List.of(
                new IngredientEntry(Vinete_Raw, 1000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Maioneza, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                Rece, List.of(SucLamaie)));
        cookbook.add(new Recipe("Baba ganoush", AtLeastOnce, List.of(
                new IngredientEntry(Vinete_Raw, 700, gram),
                new IngredientEntry(Usturoi_Raw, 2, bucati),
                new IngredientEntry(Ulei_Masline, 30, gram),
                new IngredientEntry(Tahini, 2, linguri),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                Rece, List.of(SucLamaie)));
        cookbook.add(new Recipe("Salată de vinete cu usturoi", AtLeastOnce, List.of(
                new IngredientEntry(Vinete_Raw, 1000, gram),
                new IngredientEntry(Usturoi_Raw, 10, bucati),
                new IngredientEntry(Maioneza, 100, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                Rece, List.of(SucLamaie)));
        cookbook.add(new Recipe("Salată orientală", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 1000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ou_Raw, 4, bucati),
                new IngredientEntry(Masline, 50, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 2, linguri),
                new IngredientEntry(Sare, 1, lingurite)),
                Rece, List.of()));
        cookbook.add(new Recipe("Supă cremă de broccoli - Cu carne", AtLeastOnce, List.of(
                new IngredientEntry(Broccoli_Raw, 2, bucati),
                new IngredientEntry(Carne_Pui_Piept_Raw, 500, gram),
                new IngredientEntry(Cartofi_Raw, 400, gram),
                new IngredientEntry(Telina_Raw, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de broccoli - Soia", AtLeastOnce, List.of(
                new IngredientEntry(Broccoli_Raw, 2, bucati),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Cartofi_Raw, 400, gram),
                new IngredientEntry(Telina_Raw, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de conopidă", AtLeastOnce, List.of(
                new IngredientEntry(Conopida_Raw, 1, bucati),
                new IngredientEntry(Cartofi_Raw, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 3, bucati),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Piper)));
        cookbook.add(new Recipe("Supă cremă de dovleac", Once, List.of(
                new IngredientEntry(DovleacPlacintar_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Cartofi_Raw, 600, gram),
                new IngredientEntry(Telina_Raw, 100, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper, Rozmarin)));
        cookbook.add(new Recipe("Supă cremă de dovlecei", AtLeastOnce, List.of(
                new IngredientEntry(Dovlecei_Raw, 1200, gram),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Cartofi_Raw, 600, gram),
                new IngredientEntry(Telina_Raw, 100, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de linte galbenă", Once, List.of(
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Cartofi_Raw, 600, gram),
                new IngredientEntry(Linte_Galbena_Raw, 400, gram),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Iaurt_Grecesc_10, 600, gram),
                new IngredientEntry(Ulei_Masline, 6, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de linte roșie", Once, List.of(
                new IngredientEntry(Linte_Rosie_Raw, 500, gram),
                new IngredientEntry(Ceapa_Alba_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 8, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Ulei_Masline, 3, linguri),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Radacina_Patrunjel, 3, bucati),
                new IngredientEntry(Telina_Raw, 150, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, Chimen, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Supă cremă de mazăre", AtLeastOnce, List.of(
                new IngredientEntry(Mazare_Raw, 2000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de praz", Disabled, List.of(
                new IngredientEntry(Praz_Raw, 4, bucati),
                new IngredientEntry(Cartofi_Raw, 1000, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 4, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de spanac", AtLeastOnce, List.of(
                new IngredientEntry(Cartofi_Raw, 400, gram),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 5, bucati),
                new IngredientEntry(Spanac_Raw, 400, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Iuteala)));
        cookbook.add(new Recipe("Supă cremă de țelină - Cu praz și smântână", Once, List.of(
                new IngredientEntry(Telina_Raw, 1200, gram),
                new IngredientEntry(Pastarnac_Raw, 3, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Praz_Raw, 3, bucati),
                new IngredientEntry(Smantana_10, 600, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă cremă de țelină - Mama", AtLeastOnce, List.of(
                new IngredientEntry(Telina_Raw, 1200, gram),
                new IngredientEntry(Cartofi_Raw, 600, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F1, List.of(Piper)));
        cookbook.add(new Recipe("Supă de cartofi și mazăre", Once, List.of(
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 6, bucati),
                new IngredientEntry(Mazare_Raw, 400, gram),
                new IngredientEntry(Cartofi_Raw, 600, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Coriandru, Curry, Piper)));
        cookbook.add(new Recipe("Supă de conopidă", AtLeastOnce, List.of(
                new IngredientEntry(Conopida_Raw, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Faina_Grau_65, 2, linguri),
                new IngredientEntry(Lapte, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(SucLamaie, BoiaDulce)));
        cookbook.add(new Recipe("Supă de roșii", AtLeastOnce, List.of(
                new IngredientEntry(Rosii, 1000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Telina_Raw, 200, gram),
                new IngredientEntry(Radacina_Patrunjel, 1, bucati),
                new IngredientEntry(Pastarnac_Raw, 1, bucati),
                new IngredientEntry(Ardei_Verde_Raw, 1, bucati),
                new IngredientEntry(Fidea, 80, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Patrunjel, FrunzeTelina, Piper)));
        cookbook.add(new Recipe("Supă mexicană", Once, List.of(
                new IngredientEntry(Cartofi_Dulci_Raw, 500, gram),
                new IngredientEntry(Carne_Pui_Picioare_Raw, 500, gram),
                new IngredientEntry(Linte_Rosie_Raw, 75, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Morcov_Raw, 1, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Ulei_Masline, 1, linguri),
                new IngredientEntry(Ulei_Floarea_Soarelui, 1, linguri),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F1, List.of(Piper, BoiaDulce, Cimbru, Patrunjel, Leustean, Otet, SucLamaie)));
        cookbook.add(new Recipe("Tiramisu", AtLeastOnce, List.of(
                new IngredientEntry(Piscoturi, 200, gram),
                new IngredientEntry(Branza_Mascarpone, 500, gram),
                new IngredientEntry(Ou_Raw, 4, bucati),
                new IngredientEntry(Zahar, 250, gram)),
                Desert, List.of()));
        cookbook.add(new Recipe("Tocănița Malita", AtLeastOnce, List.of(
                new IngredientEntry(Soia_Flour, 200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Morcov_Raw, 3, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Ardei_Rosu_Raw, 6, bucati),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(BoiaIute, Marar, Coriandru)));
        cookbook.add(new Recipe("Tocăniță de ardei", AtMostOnce, List.of(
                new IngredientEntry(Ardei_Rosu_Raw, 6, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Dovlecei_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Tocăniță de ardei cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Ardei_Rosu_Raw, 5, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Dovlecei_Raw, 2, bucati),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 500, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of()));
        cookbook.add(new Recipe("Tocăniță de gogonele", AtLeastOnce, List.of(
                new IngredientEntry(Gogonele_Raw, 1200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 3, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 4, bucati),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Tocăniță de legume", AtLeastOnce, List.of(
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 5, bucati),
                new IngredientEntry(Morcov_Raw, 4, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 350, gram),
                new IngredientEntry(Orez_Raw, 100, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(FrunzeTelina, Piper)));
        cookbook.add(new Recipe("Tocăniță de praz", AtLeastOnce, List.of(
                new IngredientEntry(Praz_Raw, 1000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram),
                new IngredientEntry(Masline, 150, gram),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 5, bucati)),
                F2, List.of(Patrunjel, Dafin, SucLamaie)));
        cookbook.add(new Recipe("Tzatziki", AtLeastOnce, List.of(
                new IngredientEntry(Iaurt_Grecesc_10, 2000, gram),
                new IngredientEntry(Castraveti_Cornichon, 600, gram),
                new IngredientEntry(Ulei_Masline, 30, gram),
                new IngredientEntry(Usturoi_Raw, 10, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 5, bucati)),
                Rece, List.of(Marar)));
        cookbook.add(new Recipe("Țelină cu morcov", AtLeastOnce, List.of(
                new IngredientEntry(Telina_Raw, 900, gram),
                new IngredientEntry(Morcov_Raw, 900, gram),
                new IngredientEntry(Peste_Ton_Canned_In_Oil, 640, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 600, gram),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 5, bucati)),
                Rece, List.of(Mustar)));
        cookbook.add(new Recipe("Varză călită", Once, List.of(
                new IngredientEntry(VarzaMurata, 1500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 1, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(BoiaDulce, Dafin, Chimen, Piper)));
        cookbook.add(new Recipe("Varză cu soia", AtLeastOnce, List.of(
                new IngredientEntry(Varza_Raw, 2000, gram),
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Morcov_Raw, 2, bucati),
                new IngredientEntry(Ardei_Rosu_Raw, 2, bucati),
                new IngredientEntry(Suc_Rosii_Bulion, 300, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 8, bucati)),
                F2, List.of(Dafin)));
        cookbook.add(new Recipe("Varză la Cluj", Once, List.of(
                new IngredientEntry(VarzaMurata, 1000, gram),
                new IngredientEntry(Carne_Vita_Tocata_Raw, 500, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Orez_Raw, 150, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Varză la Cluj cu soia", Once, List.of(
                new IngredientEntry(VarzaMurata, 1000, gram),
                new IngredientEntry(Soia_Flour, 200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 4, bucati),
                new IngredientEntry(Orez_Raw, 150, gram),
                new IngredientEntry(Sare, 2, lingurite),
                new IngredientEntry(Paine, 3 * 7, bucati)),
                F2, List.of(Piper)));
        cookbook.add(new Recipe("Vitello tonnato", Once, List.of( // mănânci ditamai halca de carne într-o săptămână
                new IngredientEntry(Carne_Vita_Chuck_Roast, 500, gram), // 1Kg iese mai mult decât făcea mama la familia întreagă
                new IngredientEntry(Peste_Ton_Canned_In_Oil, 80, gram),
                new IngredientEntry(Ou_Raw, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 200, gram),
                new IngredientEntry(Sare, 1, gram),
                new IngredientEntry(Paine, 2 * 5, bucati)),
                Rece, List.of(SucLamaie, Mustar)));
        cookbook.add(new Recipe("Clătite cu vișine moldovenești", Once, List.of(
                new IngredientEntry(Faina_Grau_65, 350, gram),
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Lapte, 500, gram),
                new IngredientEntry(Sare, 1, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 4, linguri), // care se iau de pe tigaie la prăjeală
                new IngredientEntry(Visine_Frozen, 500, gram),
                new IngredientEntry(Zahar, 50, gram),
                new IngredientEntry(Smantana_Frisca, 500, gram),
                new IngredientEntry(Smantana_10, 300, gram)),
                Desert, List.of()));

        // Fast Food
        cookbook.add(new Recipe("Mămăligă", AtLeastOnce, List.of(
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_Fagaras, 200, gram),
                new IngredientEntry(Lapte, 300, gram),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Sare, 1, lingurite)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Găgău", AtLeastOnce, List.of(
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_Telemea, 200, gram),
                new IngredientEntry(Sare, 1, lingurite)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Mămăligă cu brânză", Disabled, List.of( // nu știi când găsești caș
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_Telemea, 300, gram),
                new IngredientEntry(Sare, 1, lingurite)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Mămăligă cu brânză cu smântână", AtLeastOnce, List.of(
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Branza_CottageFullFat, 200, gram),
                new IngredientEntry(Branza_Fagaras, 200, gram),
                new IngredientEntry(Lapte_Acru, 200, gram),
                new IngredientEntry(Sare, 1, lingurite)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Ciulama de ciuperci", AtLeastOnce, List.of(
                new IngredientEntry(Ciuperci_Raw, 1000, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 2, bucati),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Faina_Grau_65, 2, linguri),
                new IngredientEntry(Lapte, 600, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 2, bucati)),
                FastFood, List.of(Patrunjel, Marar, Piper)));
        cookbook.add(new Recipe("Ciuperci cu smântână și usturoi", AtMostOnce, List.of(
                new IngredientEntry(Ciuperci_Raw, 1000, gram),
                new IngredientEntry(Unt_Sarat, 50, gram),
                new IngredientEntry(Smantana_10, 300, gram),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 2, bucati)),
                FastFood, List.of(Patrunjel, Piper)));
        cookbook.add(new Recipe("Spanac cu smântână", AtLeastOnce, List.of(
                new IngredientEntry(Spanac_Raw, 500, gram),
                new IngredientEntry(Smantana_10, 200, gram),
                new IngredientEntry(Lapte, 120, gram),
                new IngredientEntry(Usturoi_Raw, 4, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 3, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Mâncărică de păstăi", AtLeastOnce, List.of(
                new IngredientEntry(PastaiCongelate_Raw, 700, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 2, bucati),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Paine, 3 * 2, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Microfoane", Once, List.of(
                new IngredientEntry(Carne_Pui_Picioare_Raw, 500, gram),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Usturoi_Raw, 10, bucati)),
                FastFood, List.of(Piper, BoiaDulce)));
        cookbook.add(new Recipe("Ficat de pui prăjit", Once, List.of(
                new IngredientEntry(Carne_Pui_Ficat_Raw, 500, gram),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Usturoi_Raw, 10, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Șnițel de soia", AtLeastOnce, List.of(
                new IngredientEntry(Soia_Flour, 100, gram),
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Usturoi_Raw, 10, bucati),
                new IngredientEntry(Cartofi_Raw, 800, gram),
                new IngredientEntry(Lapte, 50, gram),
                new IngredientEntry(Unt_Sarat, 25, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Castraveti_Murati, 2 * 2, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Șnițel de pui", Once, List.of(
                new IngredientEntry(Carne_Pui_Piept_Raw, 500, gram),
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Faina_Grau_65, 30, gram),
                new IngredientEntry(Cartofi_Raw, 800, gram),
                new IngredientEntry(Lapte, 50, gram),
                new IngredientEntry(Unt_Sarat, 25, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Castraveti_Murati, 2 * 2, gram)),
                FastFood, List.of(Piper)));
        cookbook.add(new Recipe("Somon prăjit", AtLeastOnce, List.of(
                new IngredientEntry(Peste_Somon_Raw, 250, gram),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Usturoi_Raw, 5, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pește prăjit", Once, List.of(
                new IngredientEntry(Peste_Cod_Raw, 500, gram),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Usturoi_Raw, 5, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Omletă cremă", Once, List.of(
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Lapte_Acru, 500, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Omletă cu roșii", AtLeastOnce, List.of(
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Ceapa_Verde_Raw, 1, bucati),
                new IngredientEntry(Branza_Mozzarella, 150, gram),
                new IngredientEntry(Paine, 4, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Omletă normală", AtLeastOnce, List.of(
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 1, lingurite),
                new IngredientEntry(Castraveti_Murati, 2, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Roșii cu brânză", Once, List.of(
                new IngredientEntry(Rosii, 500, gram),
                new IngredientEntry(Branza_Telemea, 200, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Salată de roșii - mama", AtLeastOnce, List.of(
                new IngredientEntry(Rosii, 3, bucati),
                new IngredientEntry(Castraveti_Cornichon, 1, bucati),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri),
                new IngredientEntry(Branza_Telemea, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Salată cu ton", AtLeastOnce, List.of(
                new IngredientEntry(Salata_Raw, 100, gram),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Mais, 50, gram),
                new IngredientEntry(Branza_Telemea, 100, gram),
                new IngredientEntry(Peste_Ton_Canned_In_Oil, 160, gram),
                new IngredientEntry(Ulei_Floarea_Soarelui, 2, linguri)), // de la ton
                FastFood, List.of(Otet_Balsamic)));
        cookbook.add(new Recipe("Salad Box", AtLeastOnce, List.of(
                new IngredientEntry(Salata_Raw, 200, gram),
                new IngredientEntry(Rosii, 1, bucati),
                new IngredientEntry(Branza_Telemea, 200, gram),
                new IngredientEntry(Mais, 200, gram),
                new IngredientEntry(Fasole_Uscata_Raw, 200, gram),
                new IngredientEntry(Ulei_Masline, 2, linguri)), FastFood, List.of()));
        cookbook.add(new Recipe("Cobb Salad", AtLeastOnce, List.of(
                new IngredientEntry(Salata_Raw, 200, gram),
                new IngredientEntry(Carne_Pui_Piept_Raw, 200, gram),
                new IngredientEntry(Ou_Raw, 3, bucati),
                new IngredientEntry(Rosii, 2, bucati),
                new IngredientEntry(Branza_Telemea, 200, gram),
                new IngredientEntry(Ceapa_Verde_Raw, 3, bucati),
                new IngredientEntry(Avocado_Hass_Raw, 1, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Facebook Salad", AtLeastOnce, List.of(
                new IngredientEntry(Avocado_Hass_Raw, 1, bucati),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Rosii, 1, bucati)), FastFood, List.of()));
        cookbook.add(new Recipe("Dovlecei prăjiți", Once, List.of(
                new IngredientEntry(Dovlecei_Raw, 1, bucati),
                new IngredientEntry(Ou_Raw, 2, bucati),
                new IngredientEntry(Pesmet, 100, gram), // oare?
                new IngredientEntry(Branza_Grattugiato, 100, gram   )),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta al pesto genovese (semi)", AtMostOnce, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Sos_Pesto_Genovese, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta al sugo di pomodoro", Once, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 100, gram),
                new IngredientEntry(Usturoi_Raw, 2, bucati)),
                FastFood, List.of(Busuioc)));
        cookbook.add(new Recipe("Pasta al salmone", Once, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Peste_Somon_Raw, 100, gram),
                new IngredientEntry(Unt_Sarat, 25, gram),
                new IngredientEntry(Faina_Grau_65, 20, gram),
                new IngredientEntry(Lapte, 200, gram)), FastFood, List.of()));
        cookbook.add(new Recipe("Pasta con tonno", Once, List.of(
                new IngredientEntry(Paste, 100, gram),
                new IngredientEntry(Peste_Ton_Canned_In_Oil, 160, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta con verdura (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta con ricotta (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Spaghetti alla napoletana (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta con olive (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta con basilico (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Paste ai funghi (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Penne quatro formaggi (semi)", AtMostOnce, List.of(
                new IngredientEntry(Paste, 200, gram),
                new IngredientEntry(Sos_Quattro_Formaggi, 370, gram),
                new IngredientEntry(Suc_Rosii_Bulion, 200, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Spaghetti alla carbonara (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 200, gram),
                new IngredientEntry(Sos_Carbonara, 370, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Pasta all'arrabbiata (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Spaghetti alla bolognese (semi)", Disabled, List.of(
                new IngredientEntry(Paste, 100, gram)),
                FastFood, List.of()));
        cookbook.add(new Recipe("Ciuperci prăjite", AtLeastOnce, List.of(
                new IngredientEntry(Ciuperci_Raw, 1200, gram),
                new IngredientEntry(Ceapa_Galbena_Raw, 1, bucati),
                new IngredientEntry(Usturoi_Raw, 2, bucati),
                new IngredientEntry(Malai, 100, gram),
                new IngredientEntry(Sare, 2, lingurite)), // una la mămăligă, una la ciuperci
                FastFood, List.of()));

        // Fruits
        cookbook.add(new Recipe("Banane", AtLeastOnce, List.of(
                new IngredientEntry(Banane, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Caise", AtLeastOnce, List.of(
                new IngredientEntry(Caise, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Capșuni", AtLeastOnce, List.of(
                new IngredientEntry(Capsuni, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Cireșe", Once, List.of(
                new IngredientEntry(Cirese, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Clementine", AtLeastOnce, List.of(
                new IngredientEntry(Clementine, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Grapefruit", Once, List.of(
                new IngredientEntry(Grapefruit, 300, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Kaki", AtLeastOnce, List.of(
                new IngredientEntry(Kaki, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Kiwi", AtLeastOnce, List.of(
                new IngredientEntry(Kiwi, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mandarine", Once, List.of(
                new IngredientEntry(Mandarine, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mango", AtMostOnce, List.of(
                new IngredientEntry(Mango_Tommy_Atkins, 200, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mere", AtLeastOnce, List.of(
                new IngredientEntry(Mere_Red_Delicious, 1500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Mineole", Once, List.of(
                new IngredientEntry(Mineole, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Nucă", Once, List.of(
                new IngredientEntry(Nuca, 500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Papaya", AtMostOnce, List.of(
                new IngredientEntry(Papaya, 200, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Pepene Galben", AtLeastOnce, List.of(
                new IngredientEntry(PepeneGalben, 1500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Pepene Roșu", AtLeastOnce, List.of(
                new IngredientEntry(PepeneRosu, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Pere", AtLeastOnce, List.of(
                new IngredientEntry(Pere, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Piersici", AtLeastOnce, List.of(
                new IngredientEntry(Piersici, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Portocale (1.5Kg)", AtLeastOnce, List.of(
                new IngredientEntry(Portocale, 1500, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Prune (1Kg)", AtLeastOnce, List.of(
                new IngredientEntry(Prune, 1000, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Rodii", AtMostOnce, List.of(
                new IngredientEntry(Rodii, 200, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Struguri Albi", Once, List.of(
                new IngredientEntry(Struguri_Albi, 250, gram)), Fruits, List.of()));
        cookbook.add(new Recipe("Struguri Negri", Once, List.of(
                new IngredientEntry(Struguri_Negri, 250, gram)), Fruits, List.of()));

        return cookbook;
    }
}
