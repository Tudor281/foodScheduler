package tudor.foodScheduler.model.cookbook;

import tudor.foodScheduler.model.Ingredient;
import tudor.foodScheduler.model.Recipe;

import java.util.List;

import static tudor.foodScheduler.model.Fel.*;
import static tudor.foodScheduler.model.Fel.Fruits;
import static tudor.foodScheduler.model.Ingredient.*;
import static tudor.foodScheduler.model.Multiplicity.*;
import static tudor.foodScheduler.model.Multiplicity.Once;
import static tudor.foodScheduler.model.Spice.*;
import static tudor.foodScheduler.model.Spice.BoiaDulce;
import static tudor.foodScheduler.model.Spice.Telina;

public class TudorCookBook {
    public static Cookbook getCookbook() {
        Cookbook cookbook = new Cookbook();
        cookbook.add(new Recipe("American Pancakes", Once, List.of(Faina, Zahar), Desert, List.of()));
        cookbook.add(new Recipe("American Potato Salad", AtLeastOnce, List.of(Cartofi, Maioneza, Apio), Rece, List.of(Mustar, Patrunjel)));
        cookbook.add(new Recipe("Apple Pie", Disabled, List.of(Mere), Desert, List.of())); // n-am contenitore, și nici aluat pentru Apple pie specific n-am
        cookbook.add(new Recipe("Ardei umpluți simplu", Once, List.of(Ardei, Orez), F2, List.of(FrunzeTelina)));
        cookbook.add(new Recipe("Ardei umpluți cu carne", Once, List.of(Ardei, Orez, Carne), F2, List.of(FrunzeTelina)));
        cookbook.add(new Recipe("Bundincă", AtLeastOnce, List.of(Lapte, Zahar), Desert, List.of()));
        cookbook.add(new Recipe("Chiftele cu carne", Once, List.of(Carne), Rece, List.of(Usturoi))); // binding to pilaf simplu
        cookbook.add(new Recipe("Chiftele de soia în suc de roșii", Once, List.of(Soia), Rece, List.of())); // TODO No recipy
        cookbook.add(new Recipe("Ciorbă congelată", Disabled, List.of(Broccoli, Conopida), F1, List.of(Patrunjel, Marar))); // ia chestii congelate, vezi cum e. E fain ca sunt chestii mixate in loc sa cumperi un broccoli / o conopida. Dar la Lidl, deci non si sa mai, și congelate de la auchan bagi la minestrone.
        cookbook.add(new Recipe("Ciorbă de broccoli", AtLeastOnce, List.of(Broccoli), F1, List.of(Patrunjel, Marar)));
        cookbook.add(new Recipe("Ciorbă de cartofi cu smântână", AtLeastOnce, List.of(Cartofi, Smantana), F1, List.of(Patrunjel, Marar)));
        cookbook.add(new Recipe("Ciorbă de cartofi roșie", AtLeastOnce, List.of(Cartofi), F1, List.of(Patrunjel, Marar)));
        cookbook.add(new Recipe("Ciorbă de conopidă", AtLeastOnce, List.of(Conopida), F1, List.of(Patrunjel, Marar)));
        cookbook.add(new Recipe("Ciorbă de dovlecei cu ciuperci", AtLeastOnce, List.of(Dovlecei, Ciuperci), F1, List.of(Patrunjel, Marar, Telina)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu chimen", AtLeastOnce, List.of(Fasole), F1, List.of(Pastarnac, Usturoi, Chimen, BoiaDulce, BoiaIute, Dafin, Patrunjel, BoiaAfumata, Iuteala, Telina)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu dafin", AtLeastOnce, List.of(Fasole), F1, List.of(Patrunjel, Marar, Dafin)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu cimbru", AtLeastOnce, List.of(Fasole), F1, List.of(Patrunjel, Marar, Cimbru)));
        cookbook.add(new Recipe("Ciorbă de fasole - Cu leuștean", AtLeastOnce, List.of(Fasole), F1, List.of(Patrunjel, Marar, Leustean)));
        cookbook.add(new Recipe("Ciorbă de frunze", Disabled, List.of(Frunze), F1, List.of(Marar, Leustean))); // nu găsești cantități industriale de frunze în București, doar la legătură.
        cookbook.add(new Recipe("Ciorbă de ghebe cu smântână", Once, List.of(Ciuperci, Smantana), F1, List.of(Patrunjel, Marar)));
        cookbook.add(new Recipe("Ciorbă de năut cu afumătură", Once, List.of(Carne, Naut), F1, List.of(BoiaDulce)));
        cookbook.add(new Recipe("Ciorbă de păstăi", AtLeastOnce, List.of(PastaiCongelate), F1, List.of(Pastarnac, Patrunjel, Marar, Leustean, Telina), 3));
        cookbook.add(new Recipe("Ciorbă de păstăi fresh", Disabled, List.of(PastaiFresh), F1, List.of(Pastarnac, Patrunjel, Marar, Leustean, Telina)));
        cookbook.add(new Recipe("Ciorbă de perișoare", Once, List.of(Carne), F1, List.of())); // TODO No recipy
        cookbook.add(new Recipe("Ciorbă de pui a la Grec", Once, List.of(Carne, Smantana), F1, List.of(Pastarnac, SucLamaie, Patrunjel, Marar, Telina)));
        cookbook.add(new Recipe("Ciorbă de salată cu scrob", AtLeastOnce, List.of(Salata, Smantana), F1, List.of()));
        cookbook.add(new Recipe("Ciorbă rădăuțeană", Once, List.of(Carne, Smantana), F1, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Ciuperci cu maioneză și usturoi", AtLeastOnce, List.of(Ciuperci, Maioneza), Rece, List.of()));
        cookbook.add(new Recipe("Clătite", Once, List.of(Faina, Zahar), Desert, List.of()));
        cookbook.add(new Recipe("Cozonac", Disabled, List.of(Faina, Zahar), Desert, List.of()));
        cookbook.add(new Recipe("Fasole bătută", AtLeastOnce, List.of(Fasole), Rece, List.of()));
        cookbook.add(new Recipe("Ghiveci", AtLeastOnce, List.of(Conopida), F2, List.of()));
        cookbook.add(new Recipe("Gigantes Plaki", AtLeastOnce, List.of(Fasole), F2, List.of(Usturoi, Patrunjel, Marar, FrunzeTelina)));
        cookbook.add(new Recipe("Gratin de cartofi cu broccoli și brânză", Once, List.of(Cartofi, Broccoli, Smantana, Branza), F2, List.of(Usturoi)));
        cookbook.add(new Recipe("Gratin de cartofi cu roșii și brânză", Once, List.of(Cartofi, Rosii, Smantana, Branza), F2, List.of(Busuioc)));
        cookbook.add(new Recipe("Griș cu lapte", AtLeastOnce, List.of(Lapte, Gris), Desert, List.of()));
        cookbook.add(new Recipe("Gulaș", Once, List.of(Cartofi, Carne), F2, List.of(Chimen, BoiaDulce, BoiaIute, Dafin, Usturoi, Patrunjel, Tarhon, FrunzeTelina)));
        cookbook.add(new Recipe("Humus", AtLeastOnce, List.of(Naut), Rece, List.of()));
        cookbook.add(new Recipe("Humus cu pesto", AtLeastOnce, List.of(Naut), Rece, List.of(Usturoi, Busuioc)));
        cookbook.add(new Recipe("Lalele", AtLeastOnce, List.of(Rosii, Branza), Rece, List.of(Usturoi, SucLamaie, Oregano)));
        cookbook.add(new Recipe("Lasagna bolognese", Once, List.of(Carne, Apio), F2, List.of(VinAlb)));
        cookbook.add(new Recipe("Lohikeitto", AtMostOnce, List.of(Peste, Smantana), F1, List.of(Dafin)));
        cookbook.add(new Recipe("Mâncare de cartofi - ardelenească", AtLeastOnce, List.of(Cartofi), F2, List.of(Iuteala, BoiaDulce, BoiaIute, Dafin)));
        cookbook.add(new Recipe("Mâncare de cartofi - Cu pui", AtMostOnce, List.of(Cartofi, Carne), F2, List.of(Dafin, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Mâncare de cartofi - Cu soia", Once, List.of(Cartofi, Soia), F2, List.of(Dafin, BoiaDulce, Iuteala)));
        cookbook.add(new Recipe("Mâncare de cartofi - moldovenească", AtLeastOnce, List.of(Cartofi), F2, List.of(Patrunjel, Marar, Iuteala)));
        cookbook.add(new Recipe("Mâncare de fasole - Fasole prăjită", AtLeastOnce, List.of(Fasole), F2, List.of(Marar)));
        cookbook.add(new Recipe("Mâncare de fasole - Fasole prăjită - Fuchs remix", AtLeastOnce, List.of(Fasole), F2, List.of(Marar, FuchsFasole)));
        cookbook.add(new Recipe("Mâncare de fasole - Iahnie de fasole", AtLeastOnce, List.of(Fasole), F2, List.of(Usturoi, Pastarnac, Dafin, Telina)));
        cookbook.add(new Recipe("Mâncare de mazăre - Cu pui", Disabled, List.of(Mazare, Carne), F2, List.of(Marar, BoiaDulce, Dafin, Usturoi))); // mazărea cu soia e pur și simplu superioară
        cookbook.add(new Recipe("Mâncare de mazăre - Cu soia", AtLeastOnce, List.of(Mazare, Soia), F2, List.of(Marar, BoiaDulce, Dafin, Usturoi)));
        cookbook.add(new Recipe("Mâncare de mazăre - Simplu", Once, List.of(Mazare), F2, List.of(Marar)));
        cookbook.add(new Recipe("Mâncare de păstăi", AtLeastOnce, List.of(PastaiCongelate), F2, List.of(Patrunjel)));
        cookbook.add(new Recipe("Melanzane alla parmigiano", Once, List.of(Vinete, Branza), F2, List.of()));
        cookbook.add(new Recipe("Minestrone", AtLeastOnce, List.of(Mazare, Orez, Conopida, Broccoli), F1, List.of(Busuioc, Rozmarin, Patrunjel)));
        cookbook.add(new Recipe("Musaca cu carne", Once, List.of(Cartofi, Carne), F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Musaca cu ragu", AtMostOnce, List.of(Cartofi, Carne, Apio), F2, List.of(VinAlb)));
        cookbook.add(new Recipe("Musaca cu ciuperci", AtLeastOnce, List.of(Cartofi, Ciuperci), F2, List.of(), 2)); // TODO no recipy
        cookbook.add(new Recipe("Musaca cu soia", Once, List.of(Cartofi, Soia, Apio), F2, List.of(VinAlb))); // TODO no recipy
        cookbook.add(new Recipe("Nakkikeitto", AtMostOnce, List.of(Carne, Cartofi), F1, List.of(Pastarnac, Usturoi, Dafin, Patrunjel, Rozmarin)));
        cookbook.add(new Recipe("Nakkikeitto - V", AtLeastOnce, List.of(Cartofi, Soia), F1, List.of(Pastarnac, Usturoi, Dafin, Patrunjel, Rozmarin), 2));
        cookbook.add(new Recipe("Nasi Goreng", AtMostOnce, List.of(Orez, Carne), F2, List.of(Usturoi, Curcuma, Ghimbir, Coriandru, Chimen, SucLamaie)));
        cookbook.add(new Recipe("Pilaf - Cu ciuperci și alte legume", AtLeastOnce, List.of(Orez, Ciuperci), F2, List.of(Marar, Patrunjel, Pastarnac, Telina)));
        cookbook.add(new Recipe("Pilaf - Cu urzici", Disabled, List.of(Orez, Urzici), F2, List.of(Patrunjel))); // faci când găsești, e un tiny window
        cookbook.add(new Recipe("Pilaf - Paella cu pui", AtMostOnce, List.of(Orez, Carne), F2, List.of(Usturoi, Patrunjel, Curcuma, SucLamaie)));
        cookbook.add(new Recipe("Pilaf - Sarmale cu varză murată și carne", Disabled, List.of(Orez, VarzaMurata, Carne), F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Pilaf - Sarmale viță de vie simplu", Disabled, List.of(Orez), F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Pilaf - Sarmale viță de vie cu carne", Once, List.of(Orez, Carne), F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Pilaf - Simplu", AtLeastOnce, List.of(Orez), F2, List.of(Curcuma), 2));
        cookbook.add(new Recipe("Plăcintă cu mere - Foietaj", AtLeastOnce, List.of(Mere, Zahar), Desert, List.of(Scortisoara)));
        cookbook.add(new Recipe("Răcitură", Once, List.of(Carne), F2, List.of(Usturoi)));
        cookbook.add(new Recipe("Riz au lait", AtLeastOnce, List.of(Orez, Lapte), Desert, List.of()));
        cookbook.add(new Recipe("Salată boeuf", AtLeastOnce, List.of(Cartofi, Maioneza), Rece, List.of(Mustar)));
        cookbook.add(new Recipe("Salată de pui", Once, List.of(Carne, Maioneza), Rece, List.of()));
        cookbook.add(new Recipe("Salată de pui cu legume", Once, List.of(Cartofi, Carne, Maioneza), Rece, List.of()));
        cookbook.add(new Recipe("Salată de pui cu ciuperci", Once, List.of(Ciuperci, Carne, Maioneza), Rece, List.of(Patrunjel)));
        cookbook.add(new Recipe("Salată de vienete cu usturoi", AtLeastOnce, List.of(Vinete, Maioneza), Rece, List.of(Usturoi)));
        cookbook.add(new Recipe("Salată orientală", AtLeastOnce, List.of(Cartofi), Rece, List.of()));
        cookbook.add(new Recipe("Supă cremă de broccoli - Cu carne", AtMostOnce, List.of(Broccoli, Carne), F1, List.of(Usturoi, Telina)));
        cookbook.add(new Recipe("Supă cremă de broccoli - Simplu", AtLeastOnce, List.of(Broccoli), F1, List.of(Usturoi, Telina)));
        cookbook.add(new Recipe("Supă cremă de broccoli - Soia", Once, List.of(Broccoli, Soia), F1, List.of(Usturoi, Telina)));
        cookbook.add(new Recipe("Supă cremă de conopidă", AtMostOnce, List.of(Conopida, Smantana), F1, List.of(Usturoi, Patrunjel)));
        cookbook.add(new Recipe("Supă cremă de dovleac", Once, List.of(DovleacPlacintar), F1, List.of(Telina)));
        cookbook.add(new Recipe("Supă cremă de dovlecei", Once, List.of(Dovlecei), F1, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Supă cremă de mazăre", AtLeastOnce, List.of(Mazare), F1, List.of()));
        cookbook.add(new Recipe("Supă cremă de țelină - Cu praz și smântână", Once, List.of(Ingredient.Telina, Praz, Smantana), F1, List.of(Pastarnac)));
        cookbook.add(new Recipe("Supă cremă de țelină - Mama", AtLeastOnce, List.of(Ingredient.Telina), F1, List.of(Pastarnac)));
        cookbook.add(new Recipe("Supă de cartofi și mazăre", Once, List.of(Cartofi, Mazare), F1, List.of(Usturoi, Coriandru, Curry)));
        cookbook.add(new Recipe("Supă de conopidă", Once, List.of(Conopida), F1, List.of(SucLamaie)));
        cookbook.add(new Recipe("Supă de roșii", AtLeastOnce, List.of(Rosii), F1, List.of(Pastarnac, Patrunjel, Telina, FrunzeTelina)));
        cookbook.add(new Recipe("Tiramisu", AtLeastOnce, List.of(Branza, Ou, Zahar), Desert, List.of()));
        cookbook.add(new Recipe("Tocănița Malita", Once, List.of(Soia, Ardei), F2, List.of(Usturoi, BoiaIute, Coriandru)));
        cookbook.add(new Recipe("Tocăniță de ardei", AtMostOnce, List.of(Ardei), F2, List.of()));
        cookbook.add(new Recipe("Tocăniță de ardei cu ton", Disabled, List.of(Ardei, Ton), F2, List.of())); // mi s-a acrit după varză cu fish fingers. Vrei ton cu tocăniță de ardei, mănâncă separat, nu fă o întreagă oală cu asta
        cookbook.add(new Recipe("Tocăniță de ardei cu soia", AtLeastOnce, List.of(Ardei, Soia), F2, List.of()));
        cookbook.add(new Recipe("Tocăniță de gogonele", AtLeastOnce, List.of(Gogonele), F2, List.of()));
        cookbook.add(new Recipe("Tocăniță de legume", AtLeastOnce, List.of(Ardei), F2, List.of(Patrunjel, FrunzeTelina)));
        cookbook.add(new Recipe("Tocăniță de praz", AtLeastOnce, List.of(Praz), F2, List.of(Patrunjel, Dafin, Usturoi, SucLamaie)));
        cookbook.add(new Recipe("Tzatziki", AtLeastOnce, List.of(Iaurt, Castraveti), Rece, List.of(Marar, Usturoi)));
        cookbook.add(new Recipe("Țelină cu morcov", AtLeastOnce, List.of(Ingredient.Telina, Maioneza, Ton), Rece, List.of()));
        cookbook.add(new Recipe("Varză călită", Once, List.of(VarzaMurata), F2, List.of(Dafin, Chimen)));
        cookbook.add(new Recipe("Varză fiartă", AtLeastOnce, List.of(Varza), F2, List.of(Dafin)));
        cookbook.add(new Recipe("Varză cu fish fingers", Disabled, List.of(Varza, Peste), F2, List.of(Dafin))); // e o porcărie grasă și grețoasă
        cookbook.add(new Recipe("Varză cu soia", AtLeastOnce, List.of(Varza, Soia), F2, List.of(Dafin)));
        cookbook.add(new Recipe("Varză la Cluj", Once, List.of(VarzaMurata, Carne, Orez), F2, List.of()));
        cookbook.add(new Recipe("Varză la Cluj cu soia", Once, List.of(VarzaMurata, Soia), F2, List.of())); // TODO no recipy
        cookbook.add(new Recipe("Vitel tonne", Once, List.of(Carne, Ton), Rece, List.of())); // TODO no recipy

        // Fast Food
        cookbook.add(new Recipe("Mămăligă", AtLeastOnce, List.of(Malai, Branza, Lapte), FastFood, List.of()));
        cookbook.add(new Recipe("Găgău", AtLeastOnce, List.of(Malai, Branza), FastFood, List.of()));
        cookbook.add(new Recipe("Mâncare de ciuperci - Ciulama de ciuperci", Once, List.of(Ciuperci), FastFood, List.of(Patrunjel, Marar)));
        cookbook.add(new Recipe("Mâncare de ciuperci - Ciuperci cu smântână și usturoi", AtMostOnce, List.of(Ciuperci, Smantana), FastFood, List.of(Patrunjel, Usturoi)));
        cookbook.add(new Recipe("Spanac cu smântână", Once, List.of(Spanac, Smantana), FastFood, List.of(Usturoi)));
        cookbook.add(new Recipe("Mâncărică de păstăi", AtLeastOnce, List.of(PastaiCongelate), FastFood, List.of(Patrunjel)));
        cookbook.add(new Recipe("Microfoane", Once, List.of(Carne), FastFood, List.of(BoiaDulce)));
        cookbook.add(new Recipe("Ficat de pui prăjit", Once, List.of(Carne), FastFood, List.of()));
        cookbook.add(new Recipe("Fish fingers", Disabled, List.of(Carne), FastFood, List.of())); // sunt grase, sunt puturoase. Dacă ți se face poftă, ia 100g, nu 500g. Dar sunt uleioase, grețoase.
        cookbook.add(new Recipe("Șnițel de soia", AtLeastOnce, List.of(Soia), FastFood, List.of()));
        cookbook.add(new Recipe("Șnițel de pui", Once, List.of(Carne), FastFood, List.of()));
        cookbook.add(new Recipe("Somon prăjit", Once, List.of(Carne), FastFood, List.of()));
        cookbook.add(new Recipe("Pește prăjit", Once, List.of(Carne), FastFood, List.of()));
        cookbook.add(new Recipe("Omletă cremă", Once, List.of(Ou), FastFood, List.of())); // e aproape ou crud, si are gust a ou, e mai buna omleta prajita
        cookbook.add(new Recipe("Omletă cu roșii", AtLeastOnce, List.of(Ou, Rosii, Branza), FastFood, List.of()));
        cookbook.add(new Recipe("Omletă normală", AtLeastOnce, List.of(Ou), FastFood, List.of()));
        cookbook.add(new Recipe("Roșii cu brânză", AtLeastOnce, List.of(Rosii, Branza), FastFood, List.of()));
        cookbook.add(new Recipe("Salad Box", AtLeastOnce, List.of(Salata), FastFood, List.of()));
        cookbook.add(new Recipe("Cobb Salad", AtLeastOnce, List.of(Salata, Carne, Ou, Rosii, Avocado), FastFood, List.of()));
        cookbook.add(new Recipe("Facebook Salad", AtLeastOnce, List.of(Avocado, Ou, Rosii), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Pesto al Genovese (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Al sugo di pomodoro", Once, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - cu somon", Once, List.of(Paste, Carne), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - cu ton", Once, List.of(Paste, Ton), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Verdura (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Ricotta (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Napoletane (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Olive (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - cu Basilico (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - con Funghi (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Quattro Formaggi (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Carbonara (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Arrabbiata (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));
        cookbook.add(new Recipe("Paste - Bolognese (semi)", AtMostOnce, List.of(Paste), FastFood, List.of()));

        // Fruits
        cookbook.add(new Recipe("Banane", AtLeastOnce, List.of(Banane), Fruits, List.of()));
        cookbook.add(new Recipe("Caise", AtLeastOnce, List.of(Caise), Fruits, List.of()));
        cookbook.add(new Recipe("Capșuni", Once, List.of(Capsuni), Fruits, List.of()));
        cookbook.add(new Recipe("Cireșe", Once, List.of(Cirese), Fruits, List.of()));
        cookbook.add(new Recipe("Clementine", Once, List.of(Clementine), Fruits, List.of()));
        cookbook.add(new Recipe("Grapefruit", AtMostOnce, List.of(Grapefruit), Fruits, List.of()));
        cookbook.add(new Recipe("Kaki", AtLeastOnce, List.of(Kaki), Fruits, List.of()));
        cookbook.add(new Recipe("Kiwi", AtLeastOnce, List.of(Kiwi), Fruits, List.of()));
        cookbook.add(new Recipe("Mandarine", Once, List.of(Mandarine), Fruits, List.of()));
        cookbook.add(new Recipe("Mango", AtMostOnce, List.of(Mango), Fruits, List.of()));
        cookbook.add(new Recipe("Mere", AtLeastOnce, List.of(Mere), Fruits, List.of()));
        cookbook.add(new Recipe("Mineole", Once, List.of(Mineole), Fruits, List.of()));
        cookbook.add(new Recipe("Papaya", AtMostOnce, List.of(Papaya), Fruits, List.of()));
        cookbook.add(new Recipe("Pepene Galben", Once, List.of(PepeneGalben), Fruits, List.of()));
        cookbook.add(new Recipe("Pepene Roșu", AtLeastOnce, List.of(PepeneRosu), Fruits, List.of()));
        cookbook.add(new Recipe("Pere", AtLeastOnce, List.of(Pere), Fruits, List.of()));
        cookbook.add(new Recipe("Portocale", AtLeastOnce, List.of(Portocale), Fruits, List.of()));
        cookbook.add(new Recipe("Prune", AtLeastOnce, List.of(Prune), Fruits, List.of()));
        cookbook.add(new Recipe("Rodii", AtMostOnce, List.of(Prune), Fruits, List.of()));
        cookbook.add(new Recipe("Struguri", Once, List.of(Struguri), Fruits, List.of()));

        return cookbook;
    }
}
