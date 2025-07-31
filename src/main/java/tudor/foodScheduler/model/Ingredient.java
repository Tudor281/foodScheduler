package tudor.foodScheduler.model;

import java.util.ArrayList;
import java.util.List;

import static tudor.foodScheduler.model.Months.ALL;

/** Ingredients have the characteristic of being nutritious */
public enum Ingredient {
    Ardei(List.of(6,7,8,9), ALL),
    Apio (List.of(5, 6, 7, 8, 9, 10), List.of(11, 12, 1, 3, 4, 5 , 6), false), // sort of spice, sort of ingredient. But it's pointless to have it as spice, if it's not available
    Avocado(List.of(), ALL),
    Bors(ALL, ALL),
    Branza(ALL, ALL),
    Branza_Gorgonzola(ALL, ALL),
    Broccoli(List.of(5,6,7,8,9,10,11), ALL),
    Carne_Pui(ALL, ALL),
    Carne_Vita(ALL, ALL),
    Cartofi(ALL, ALL),
    Castraveti(List.of(3,4,5,6,7,8,9), ALL),
    Ceapa(ALL, ALL),
    Ciuperci(ALL, ALL),
    Conopida(List.of(5,6,7,8,9,10,11,12), ALL),
    DovleacPlacintar(List.of(9,10,11,12,1), List.of(2,3,4)), // Pe 8 Februarie n-am mai găsit nici în Carrefour nici Auchan
    Dovlecei(List.of(4,5,6,7,8,9), ALL),
    Faina(ALL, List.of()),
    Fasole_Uscata(ALL, ALL),
    Frunze(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
    Gogonele(List.of(6,7,8,9,10,11), List.of()),
    Gris(ALL, List.of()),
    Iaurt(ALL, ALL),
    Lapte(ALL, List.of()),
    Maioneza(ALL, ALL),
    Malai(ALL, List.of()),
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
    Peste(ALL, ALL),
    Praz(List.of(10,11,12,1,2,3,4), List.of(2, 3, 4, 12)),
    Salata(ALL, ALL),
    Smantana(ALL, ALL),
    Soia(ALL, ALL, false),
    Spanac(ALL, ALL),
    Suc_Rosii_Bulion(ALL, ALL),
    Radacina_Patrunjel(ALL, ALL),
    Rosii(List.of(6,7,8,9,10,11), ALL),
    Taitei(ALL, ALL),
    Telina(ALL, ALL),
    Ton(ALL, ALL),
    Ulei(ALL, ALL),
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

    static {
        Branza.akas.add(Branza_Gorgonzola);
        Branza_Gorgonzola.akas.add(Branza);

        Carne_Pui.akas.add(Carne_Vita);
        Carne_Vita.akas.add(Carne_Pui);

        PastaiCongelate.akas.add(PastaiFresh);
        PastaiFresh.akas.add(PastaiCongelate);

        Ulei.akas.add(Ulei_Masline);
        Ulei_Masline.akas.add(Ulei);

        Varza.akas.add(VarzaMurata);
        VarzaMurata.akas.add(Varza);
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
