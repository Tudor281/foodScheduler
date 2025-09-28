package tudor.foodScheduler.model;

import java.util.ArrayList;
import java.util.List;

import static tudor.foodScheduler.model.Months.ALL;

/** Ingredients have the characteristic of being nutritious */
public enum Ingredient {
    Ardei_Rosu(List.of(6,7,8,9), ALL),
    // sort of spice, sort of ingredient. But it's pointless to have it as spice, if it's not available
    Apio (List.of(5, 6, 7, 8, 9, 10), List.of(11, 12, 1, 3, 4, 5 , 6), false), //https://en.wikipedia.org/wiki/Celery
    Avocado_Hass(List.of(), ALL), // coaja aspra, neagra la maturitate
    // mostly water, deci n-ar trebui să fie cine știe ce la capitolul nutrienți
    Bors(ALL, ALL),
    Branza_CottageFullFat(ALL, ALL),
    Branza_Fagaras(ALL, ALL),
    Branza_Feta(ALL, ALL),
    Branza_Gorgonzola(ALL, ALL),
    Branza_Grattugiato(ALL, ALL),
    Branza_Mascarpone(ALL, ALL),
    Branza_Mozzarella(ALL, ALL),
    Branza_Telemea(ALL, ALL),
    Broccoli(List.of(5,6,7,8,9,10,11), ALL),
    Carne_Pui_Picioare(ALL,ALL),
    Carne_Pui_Piept(ALL, ALL),
    Carne_Pui_Ficat(ALL, ALL),
    Carne_Pui_Tocata(ALL, ALL),
    Carne_Vita_Chuck(ALL, ALL), // carne gulas
    Carne_Vita_Tocata(ALL, ALL),
    Cartofi(ALL, ALL),
    Castraveti_Cornichon(List.of(3,4,5,6,7,8,9), ALL),
    Castraveti_Murati(ALL, ALL),
    Ceapa(ALL, ALL),
    Ceapa_Verde(ALL, ALL),
    Ciuperci(ALL, ALL),
    Conopida(List.of(5,6,7,8,9,10,11,12), ALL),
    DovleacPlacintar(List.of(9,10,11,12,1), List.of(2,3,4)), // Pe 8 Februarie n-am mai găsit nici în Carrefour nici Auchan
    Dovlecei(List.of(4,5,6,7,8,9), ALL),
    Faina_Grau_65(ALL, List.of()),
    Faina_Grau_150(ALL, ALL),
    Fasole_Uscata(ALL, ALL),
    Fidea(ALL, ALL),
    Foietaj(ALL, ALL),
    Gogonele(List.of(6,7,8,9,10,11), List.of()),
    Gris(ALL, List.of()),
    Iaurt_Grecesc_10(ALL, ALL),
    Lapte(ALL, List.of()),
    Lapte_Praf(ALL, ALL),
    Maioneza(ALL, ALL),
    Mais(ALL, ALL),
    Malai(ALL, List.of()),
    Masline(ALL, ALL),
    Mazare(ALL, ALL),
    Morcov(ALL, ALL),
    Naut(ALL, ALL),
    Orez(ALL, ALL),
    Ou(ALL, ALL),
    Pappardelle(ALL, ALL),
    PastaiCongelate(ALL, List.of()),
    PastaiFresh(List.of(5), List.of()), // pastai fresh doar prin Mai
    Pastarnac(ALL, ALL),
    Paste(ALL, ALL),
    Paste_Lasagna(ALL, ALL),
    Pesmet(ALL, ALL),
    Peste(ALL, ALL),
    Peste_Somon(ALL, ALL),
    Piscoturi(ALL, ALL),
    Praz(List.of(10,11,12,1,2,3,4), List.of(2, 3, 4, 12)),
    Salata(ALL, ALL),
    Smantana(ALL, ALL),
    Soia(ALL, ALL),
    Sos_Carbonara(ALL, ALL),
    Sos_Pesto_Genovese(ALL, ALL),
    Sos_Quattro_Formaggi(ALL, ALL),
    Spanac(ALL, ALL),
    Stevie(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
    Suc_Rosii_Bulion(ALL, ALL),
    Radacina_Patrunjel(ALL, ALL),
    Rosii(List.of(6,7,8,9,10,11), ALL),
    Tahini(ALL, ALL),
    Taitei(ALL, ALL),
    Telina(ALL, ALL),
    Ton(ALL, ALL),
    Ulei_Floarea_Soarelui(ALL, ALL),
    Ulei_Masline(ALL, ALL),
    Unt(ALL, ALL),
    Urzici(List.of(3,4,5), List.of()),
    Usturoi(ALL, ALL),
    Varza(List.of(4,5,6,7,8,9,10,11,12,1), ALL),
    VarzaMurata(ALL, ALL),
    Vinete(List.of(5,6,7,8,9,10), ALL),
    Zahar(ALL, List.of()),
    Zucchini(List.of(6), ALL),

    // fructe
    Banane(List.of(), ALL),
    Caise(List.of(7,8,9), List.of()),
    Capsuni(List.of(6,7,8,9), List.of()),
    Cirese(List.of(6, 7), List.of()),
    Clementine(List.of(), List.of(12, 1)),
    Grapefruit(List.of(), List.of(12,1,2,3,4,5,6)),
    Kaki(List.of(), List.of(10,11,12,1)),
    Kiwi(List.of(), List.of(10,11,12,1,2,3,4,5)),
    Mandarine(List.of(), List.of(11,12,1,2,3,4)),
    Mango(List.of(), ALL),
    Mere(List.of(11, 12,1,2), ALL),
    Mineole(List.of(), List.of(1)),
    Papaya(List.of(), List.of(1)),
    PepeneGalben(List.of(7,8,9), List.of()),
    PepeneRosu(List.of(7,8,9), List.of()),
    Pere(List.of(), ALL),
    Portocale(List.of(), List.of(11,12, 1, 2,3,4,5,6)),
    Prune(List.of(8,9,10,11), List.of(12, 1)),
    Rodii(List.of(), ALL),
    Struguri(List.of(9,10,11), List.of())
    ;

    static { // akas
        aka(Branza_CottageFullFat, Branza_Fagaras, Branza_Feta, Branza_Grattugiato, Branza_Gorgonzola, Branza_Mascarpone, Branza_Mozzarella, Branza_Telemea);
        aka(Carne_Pui_Picioare, Carne_Pui_Piept, Carne_Pui_Tocata, Carne_Pui_Ficat, Carne_Vita_Chuck, Carne_Vita_Tocata);
        aka(Lapte, Lapte_Praf);
        aka(PastaiCongelate, PastaiFresh);
        aka(Fidea, Paste, Paste_Lasagna);
        aka(Peste, Peste_Somon);
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

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths) {
        this.domesticMonths = domesticMonths;
        this.importMonths = importMonths;
    }

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, boolean score) {
        this(domesticMonths, importMonths);
        this.score = score;
    }

    public int getSeasonalityScore() {
        if (domesticMonths.size() == 12 && importMonths.size() == 12) return Integer.MAX_VALUE;
        return domesticMonths.size() + importMonths.size() * 12;
    }
}
