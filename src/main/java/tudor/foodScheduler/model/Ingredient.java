package tudor.foodScheduler.model;

import java.util.ArrayList;
import java.util.List;

import static tudor.foodScheduler.model.Months.ALL;

/** Ingredients have the characteristic of being nutritious */
public enum Ingredient {
    Ardei_Rosu(List.of(6,7,8,9), ALL, "2258590"),
    // sort of spice, sort of ingredient. But it's pointless to have it as spice, if it's not available
    Apio(List.of(5, 6, 7, 8, 9, 10), List.of(11, 12, 1, 3, 4, 5 , 6), false, "2346405"), //https://en.wikipedia.org/wiki/Celery
    Avocado_Hass(List.of(), ALL, "2710824"), // coaja aspra, neagra la maturitate
    // mostly water, deci n-ar trebui să fie cine știe ce la capitolul nutrienți
    Bors(ALL, ALL),
    Branza_CottageFullFat(ALL, ALL, "2346384"),
    Branza_Fagaras(ALL, ALL, "2346384"),
    Branza_Feta(ALL, ALL, "2259796"),
    Branza_Gorgonzola(ALL, ALL, "328208"), // cheddar
    Branza_Grattugiato(ALL, ALL, "2259795"),
    Branza_Mascarpone(ALL, ALL, "328208"),
    Branza_Mozzarella(ALL, ALL, "328842"),
    Branza_Telemea(ALL, ALL, "2259796"),
    Broccoli(List.of(), ALL, "321612"),
    Carne_Pui_Picioare(ALL,ALL, "2727566"),
    Carne_Pui_Piept(ALL, ALL, "2646170"),
    Carne_Pui_Ficat(ALL, ALL, "2514746"), //ground
    Carne_Pui_Tocata(ALL, ALL, "2514746"),
    Carne_Vita_Chuck(ALL, ALL, "2646174,"), // carne gulas
    Carne_Vita_Tocata(ALL, ALL, "2514743"), // 10% fat
    Cartofi(ALL, ALL, "2346403"),
    Cartofi_Dulci(List.of(), List.of(3,4,5,6,7,8,9), "2346404"),
    Castraveti_Cornichon(List.of(3,4,5,6,7,8,9), ALL, "2346406"),
    Castraveti_Murati(ALL, ALL, "324653"),
    Ceapa(ALL, ALL, "790646"),
    Ceapa_Rosie(List.of(), List.of(3, 4, 5, 6, 7, 8, 9), "790577"),
    Ceapa_Verde(ALL, ALL, "2727585"),
    Ciuperci_Raw(ALL, ALL, "1750347"),
    Conopida(List.of(5,6,7,8,9,10,11,12), ALL, "2685573"),
    DovleacPlacintar(List.of(9,10,11,12,1), List.of(2,3,4), "2727578"), // Pe 8 Februarie n-am mai găsit nici în Carrefour nici Auchan
    Dovlecei(List.of(4,5,6,7,8,9), ALL, "2685568"),
    Faina_Grau_65(ALL, List.of(), "790018"),
    Faina_Grau_150(ALL, ALL, "790018"),
    Fasole_Uscata(ALL, ALL, "2644281"),
    Fidea(ALL, ALL, "790018"),
    Foietaj(ALL, ALL, "790018"),
    Gogonele(List.of(9,10,11), List.of()),
    Gris(ALL, List.of(), "2003589"),
    Iaurt_Grecesc_10(ALL, ALL, "2259794"),
    Lapte(ALL, List.of(), "322892"),
    Lapte_Acru(ALL, List.of(), "322892"), // same as milk, no data on sour milk
    Lapte_Praf(ALL, ALL, "322892"),
    Linte_Galbena(ALL, ALL, "2644283"),
    Linte_Rosie(ALL, ALL, "2644283"),
    Maioneza(ALL, ALL), //TODO switch to oil and eggs
    Mais(ALL, ALL, "2710826"),
    Malai(ALL, List.of(), "790276"),
    Masline(ALL, ALL, "332791"),
    Mazare(ALL, ALL, "2644291"),
    Morcov(ALL, ALL, "2258586"),
    Naut(ALL, ALL, "2644282"),
    Orez(ALL, ALL, "2512381"),
    Ou(ALL, ALL, "748967"),
    Pappardelle(ALL, ALL, "790018"),
    // bookmark, to do the top
    PastaiCongelate(ALL, List.of(), "2709769"),
    PastaiFresh(List.of(5), List.of(), "2709769"), // pastai fresh doar prin Mai
    Pastarnac(ALL, ALL, "170417"),
    Paste(ALL, ALL, "2708357"),
    Paste_Lasagna(ALL, ALL, "2656773"), // lasagna sheets
    Pesmet(ALL, ALL, "1638229"), // breadcrumbs
    Peste(ALL, ALL, "2684444"), // cod
    Peste_Somon(ALL, ALL, "2684440"),
    Peste_Ton(ALL, ALL, "334194"),
    Piscoturi(ALL, ALL, "509552"), // savoiardi
    Praz(List.of(10,11,12,1,2,3,4), List.of(2, 3, 4, 12), "2727584"),
    Salata(ALL, ALL, "2346391"),
    Smantana(ALL, ALL, "2705614"),
    Soia(ALL, ALL, "174275"),
    Sos_Carbonara(ALL, ALL, "378386"),
    Sos_Pesto_Genovese(ALL, ALL, "1972571"),
    Sos_Quattro_Formaggi(ALL, ALL, "1944558"), // feta
    Spanac(ALL, ALL, "1999633"),
    Stevie(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
    Suc_Rosii_Bulion(ALL, ALL, "2685579"),
    Radacina_Patrunjel(ALL, ALL),
    Rosii(List.of(6,7,8,9,10,11), ALL, "1999634"),
    Tahini(ALL, ALL, "2707587"),
    Taitei(ALL, ALL, "2708357"),
    Telina(ALL, ALL, "170400"),
    Ulei_Floarea_Soarelui(ALL, ALL, "2710192"),
    Ulei_Masline(ALL, ALL, "2710186"),
    Unt_Sarat(ALL, ALL, "790508"),
    Unt_Nesarat(ALL, ALL, "789828"),
    Urzici(List.of(3,4,5), List.of(), "169819"),
    Usturoi(ALL, ALL, "1104647"),
    Varza(List.of(4,5,6,7,8,9,10,11,12,1), ALL, "2346407"),
    VarzaMurata(ALL, ALL, "2710075"),
    Vinete_Crude(List.of(5,6,7,8,9,10), ALL, "2685577"), // vinetele coapte ies jumate din vinetele crude
    Zahar(ALL, List.of(), "746784"),
    Zucchini(List.of(6), ALL, "1956289"),

    // fructe
    Banane(List.of(), ALL, "1105314"),
    Caise(List.of(7,8,9), List.of(), "2710815"),
    Capsuni(List.of(6,7,8,9), List.of(), "747448"),
    Cirese(List.of(6, 7), List.of(), "2346399"),
    Clementine(List.of(), List.of(12, 1), "168195"),
    Grapefruit(List.of(), List.of(12,1,2,3,4,5,6), "2709165"),
    Kaki(List.of(), List.of(10,11,12,1), "2709259"),
    Kiwi(List.of(), List.of(10,11,12,1,2,3,4,5), "327046"),
    Mandarine(List.of(), List.of(11,12,1,2,3,4), "2609797"),
    Mango_Tommy_Atkins(List.of(), ALL, "2710833"),
    Mere_Red_Delicious(List.of(11, 12,1,2), ALL, "1750339"),
    Mineole(List.of(), List.of(1), "2450365"),
    Papaya(List.of(), List.of(1), "2709246"),
    PepeneGalben(List.of(7,8,9), List.of(), "746770"),
    PepeneRosu(List.of(7,8,9), List.of(), "2709270"),
    Pere(List.of(), ALL, "746773"),
    Portocale(List.of(), List.of(11,12, 1, 2,3,4,5,6), "746771"),
    Prune(List.of(8,9,10,11), List.of(12, 1), "169949"),
    Rodii(List.of(), ALL, "2709267"),
    Struguri_Negri(List.of(9,10,11), List.of(), "2263890"),
    Struguri_Albi(List.of(9,10,11), List.of(), "2263891")
    ;

    static { // akas
        aka(Branza_CottageFullFat, Branza_Fagaras, Branza_Feta, Branza_Grattugiato, Branza_Gorgonzola, Branza_Mascarpone, Branza_Mozzarella, Branza_Telemea);
        aka(Carne_Pui_Picioare, Carne_Pui_Piept, Carne_Pui_Tocata, Carne_Pui_Ficat, Carne_Vita_Chuck, Carne_Vita_Tocata);
        aka(Lapte, Lapte_Praf);
        aka(PastaiCongelate, PastaiFresh);
        aka(Fidea, Paste, Paste_Lasagna);
        aka(Peste, Peste_Somon, Peste_Ton);
        aka(Ulei_Floarea_Soarelui, Ulei_Masline);
        aka(Varza, VarzaMurata);
    }

    static void aka(Ingredient... ingredients) {
        for (int i=0; i<ingredients.length; i++) {
            for (int j=0; j<ingredients.length; j++) {
                if (i==j) continue;
                ingredients[i].akas.add(ingredients[j]);
            }
        }
    }

    final List<Integer> domesticMonths;
    final List<Integer> importMonths;
    public final List<Ingredient> akas = new ArrayList<>();
    public boolean score = true; // recipes with less of this ingredient get better scores, by disabling I hope I get more of these
    final String usdaCode;

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths) {
        this.domesticMonths = domesticMonths;
        this.importMonths = importMonths;
        this.usdaCode = null;
    }

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, String usdaCode) {
        this.domesticMonths = domesticMonths;
        this.importMonths = importMonths;
        this.usdaCode = usdaCode;
    }

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, boolean score) {
        this(domesticMonths, importMonths);
        this.score = score;
    }

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, boolean score, String usdaCode) {
        this(domesticMonths, importMonths, usdaCode);
        this.score = score;
    }

    public int getSeasonalityScore() {
        if (domesticMonths.size() == 12 && importMonths.size() == 12) return Integer.MAX_VALUE;
        return domesticMonths.size() + importMonths.size() * 12;
    }
}
