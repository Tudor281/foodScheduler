package tudor.foodScheduler.model;

import java.util.ArrayList;
import java.util.List;

import static tudor.foodScheduler.model.Months.ALL;

/** Ingredients have the characteristic of being nutritious */
public enum Ingredient {
    Ardei(List.of(6,7,8,9), ALL),
    Branza(ALL, ALL),
    Broccoli(List.of(5,6,7,8,9,10,11), ALL),
    Carne(ALL, ALL),
    Cartofi(ALL, ALL),
    Castraveti(List.of(6,7,8,9), List.of(10,11,12)),
    Ciuperci(ALL, ALL),
    Conopida(List.of(4,5,6,7,8,9,10,11,12), ALL),
    Dovlecei(List.of(6,7,8,9), ALL),
    Fasole(ALL, ALL),
    Frunze(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
    Gogonele(List.of(6,7,8,9,10,11), List.of()),
    Iaurt(ALL, ALL),
    Maioneza(ALL, ALL),
    Mazare(ALL, ALL),
    Naut(ALL, ALL),
    Orez(ALL, ALL),
    Ou(ALL, ALL),
    PastaiCongelate(ALL, List.of()),
    PastaiFresh(List.of(5), List.of()), // pastai fresh doar prin Mai
    Paste(ALL, ALL),
    Praz(List.of(10,11,12,1,2,3), List.of()),
    Salata(ALL, ALL),
    Smantana(ALL, ALL),
    Soia(ALL, ALL, false),
    Rosii(List.of(6,7,8,9,10,11), ALL),
    Telina(ALL, ALL),
    Ton(ALL, ALL),
    Urzici(List.of(3,4,5), List.of()),
    Varza(List.of(7,8,9,10,11,12), ALL),
    VarzaMurata(ALL, ALL),
    Vinete(List.of(7,8,9,10), ALL),
    Zahar(ALL, List.of()),
    Zucchini(List.of(), ALL),

    // fructe
    Banane(List.of(), ALL),
    Caise(List.of(6,7,8,9), List.of()),
    Capsuni(List.of(6,7,8,9), List.of()),
    Cirese(List.of(6, 7), List.of()),
    Clementine(List.of(), List.of(12, 1, 2)),
    Grapefruit(List.of(), List.of(12, 1, 2)),
    Kaki(List.of(), List.of(10, 11, 12, 1, 2)),
    Kiwi(List.of(), List.of(10, 11, 12, 1, 2)),
    Mandarine(List.of(), List.of(12, 1, 2)),
    Mango(List.of(), ALL),
    Mere(List.of(11, 12), ALL),
    Mineole(List.of(1), List.of()),
    Papaya(List.of(), List.of(1)),
    PepeneGalben(List.of(7,8,9), List.of()),
    PepeneRosu(List.of(7,8,9), List.of()),
    Pere(List.of(), ALL),
    Portocale(List.of(), List.of(12, 1, 2)),
    Prune(List.of(8,9,10,11), List.of(12, 1)),
    Rodii(List.of(), ALL),
    Struguri(List.of(9,10,11), List.of())
    ;

    static {
        Varza.akas.add(VarzaMurata);
        VarzaMurata.akas.add(Varza);

        PastaiCongelate.akas.add(PastaiFresh);
        PastaiFresh.akas.add(PastaiCongelate);
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
