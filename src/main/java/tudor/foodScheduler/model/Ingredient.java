package tudor.foodScheduler.model;

import java.util.ArrayList;
import java.util.List;

import static tudor.foodScheduler.model.Months.ALL;

/** Ingredients have the characteristic of being nutritious */
public enum Ingredient {
    Ardei_Rosu_Raw(List.of(6,7,8,9), ALL, "170108"),
    Ardei_Verde_Raw(List.of(6,7,8,9), ALL, "170427"),
    // sort of spice, sort of ingredient. But it's pointless to have it as spice, if it's not available
    Apio_Raw(List.of(5, 6, 7, 8, 9, 10), List.of(11, 12, 1, 3, 4, 5 , 6), false, "169988"), //https://en.wikipedia.org/wiki/Celery
    Avocado_Hass_Raw(List.of(), ALL, "171705"), // coaja aspra, neagra la maturitate
    // mostly water, deci n-ar trebui să fie cine știe ce la capitolul nutrienți
    Bors(ALL, ALL),
    Branza_CottageFullFat(ALL, ALL, "328841"),
    Branza_Fagaras(ALL, ALL, "328841"),
    Branza_Feta(ALL, ALL, "173420"),
    Branza_Gorgonzola(ALL, ALL, "2554287"), // All have vitamin A 0 (in fact it only has minerals)
    Branza_Grattugiato(ALL, ALL, "325036"), // parmesan
    Branza_Mascarpone(ALL, ALL, "506462"), // All have vitamin A 0 (in fact it only has minerals)
    Branza_Mozzarella(ALL, ALL, "329370"),
    Branza_Telemea(ALL, ALL, "2259796"),
    Broccoli_Raw(List.of(), ALL, "747447"),
    Carne_Pui_Crenvurst(ALL, ALL, "171624"), // frankfurter // has some nutrients, but not Vitamin A
    Carne_Pui_Picioare_Raw(ALL,ALL, "331897"),
    Carne_Pui_Piept_Raw(ALL, ALL, "2646170"), // does not have vitamins
    Carne_Pui_Ficat_Raw(ALL, ALL, "2706154"),
    Carne_Pui_Tocata_Raw(ALL, ALL, "171116"), // has some vitamins but not Vitamin A
    Carne_Vita_Chuck_Roast(ALL, ALL, "2646174"), // carne gulas has minerals, not vitamins
    Carne_Vita_Tocata_Raw(ALL, ALL, "2514743"), // 10% fat has minerals, not vitamins
    Cartofi_Raw(ALL, ALL, "2346403"),
    Cartofi_Dulci_Raw(List.of(), List.of(3,4,5,6,7,8,9), "2346404"),
    Castraveti_Cornichon(List.of(3,4,5,6,7,8,9), ALL, "168409"),
    Castraveti_Murati(ALL, ALL, "324653"),
    // bookmark
    Ceapa_Alba_Raw(ALL, ALL, "1104962"),
    Ceapa_Galbena_Raw(ALL, ALL, "790646"),
    Ceapa_Rosie_Raw(List.of(), List.of(3, 4, 5, 6, 7, 8, 9), "790577"),
    Ceapa_Verde_Raw(ALL, ALL, "2727585"),
    Ciuperci_Raw(ALL, ALL, "1999629"),
    Conopida_Raw(List.of(5,6,7,8,9,10,11,12), ALL, "2685573"),
    DovleacPlacintar_Raw(List.of(9,10,11,12,1), List.of(2,3,4), "1936070"), // Pe 8 Februarie n-am mai găsit nici în Carrefour nici Auchan
    Dovlecei_Raw(List.of(4,5,6,7,8,9), ALL, "1956289"),
    Faina_Grau_65(ALL, List.of(), "790018"),
    Faina_Grau_150(ALL, ALL, "790018"),
    Fasole_Uscata_Raw(ALL, ALL, "2644281"), // cannelini
    Fidea(ALL, ALL, "1944267"),
    Foietaj(ALL, ALL, "172738"), // puff pastry
    Gogonele_Raw(List.of(9,10,11), List.of(), "1856405"),
    Gris(ALL, List.of(), "2003589"),
    Iaurt_Grecesc_10(ALL, ALL, "375754"),
    Lapte(ALL, List.of(), "746782"),
    Lapte_Acru(ALL, List.of(), "2705394"), // kefir
    Lapte_Praf(ALL, ALL, "502460"),
    Linte_Galbena_Raw(ALL, ALL, "2644283"),
    Linte_Rosie_Raw(ALL, ALL, "2644283"),
    Maioneza(ALL, ALL, "2710204"),
    Mais(ALL, ALL, "488861"), // corn kernels
    Malai(ALL, List.of(), "2601092"), // cornmeal
    Masline(ALL, ALL, "332791"),
    Mazare_Raw(ALL, ALL, "2644291"),
    Morcov_Raw(ALL, ALL, "2258586"),
    Naut_Raw(ALL, ALL, "2644282"),
    Orez_Raw(ALL, ALL, "790214"),
    Ou_Raw(ALL, ALL, "323604"),
    Paine(ALL, ALL, false, "335240"),
    Pappardelle(ALL, ALL, "1118839"),
    PastaiCongelate_Raw(ALL, List.of(), "2709769"),
    PastaiFresh_Raw(List.of(5), List.of(), "2709769"), // pastai fresh doar prin Mai
    Pastarnac_Raw(ALL, ALL, "170417"),
    Paste(ALL, ALL, "2708357"),
    Paste_Lasagna(ALL, ALL, "2656773"), // lasagna sheets
    Pesmet(ALL, ALL, "1638229"), // breadcrumbs
    Peste_Cod_Raw(ALL, ALL, "2684444"), // cod
    Peste_Somon_Raw(ALL, ALL, "2684441"),
    Peste_Ton_Cooked(ALL, ALL, "2706310"),
    Piscoturi(ALL, ALL, "509552"), // savoiardi
    Praz_Raw(List.of(10,11,12,1,2,3,4), List.of(2, 3, 4, 12), "2727584"), // leek
    Salata_Raw(ALL, ALL, "2346391"),
    Smantana(ALL, ALL, "2705614"),
    Soia_Flour(ALL, ALL, "174275"),
    Sos_Carbonara(ALL, ALL, "378386"),
    Sos_Pesto_Genovese(ALL, ALL, "1972571"),
    Sos_Quattro_Formaggi(ALL, ALL, "1944558"), // feta
    Spanac_Raw(ALL, ALL, "1999633"),
    Stevie(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
    Suc_Rosii_Bulion(ALL, ALL, "2685579"), // tomato sauce
    Radacina_Patrunjel(ALL, ALL),
    Rosii(List.of(6,7,8,9,10,11), ALL, "1999634"),
    Tahini(ALL, ALL, "2707587"),
    Taitei(ALL, ALL, "2708357"),
    Telina_Raw(ALL, ALL, "170400"),
    Ulei_Floarea_Soarelui(ALL, ALL, "1750349"),
    Ulei_Masline(ALL, ALL, "748608"),
    Unt_Sarat(ALL, ALL, "790508"),
    Unt_Nesarat(ALL, ALL, "789828"),
    Urzici_Blanched(List.of(3,4,5), List.of(), "169819"),
    Usturoi_Raw(ALL, ALL, "1104647"),
    Varza_Raw(List.of(4,5,6,7,8,9,10,11,12,1), ALL, "2346407"),
    VarzaMurata(ALL, ALL, "2710075"),
    Vinete_Raw(List.of(5,6,7,8,9,10), ALL, "2685577"), // vinetele coapte ies jumate din vinetele crude
    Zahar(ALL, List.of(), "746784"),
    Zucchini_Raw(List.of(6), ALL, "1956289"),

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
        aka(Ardei_Rosu_Raw, Ardei_Verde_Raw);
        aka(Branza_CottageFullFat, Branza_Fagaras, Branza_Feta, Branza_Grattugiato, Branza_Gorgonzola, Branza_Mascarpone, Branza_Mozzarella, Branza_Telemea);
        aka(Carne_Pui_Piept_Raw, Carne_Pui_Tocata_Raw, Carne_Pui_Ficat_Raw, Carne_Vita_Chuck_Roast, Carne_Vita_Tocata_Raw);
        aka(Ceapa_Alba_Raw, Ceapa_Verde_Raw, Ceapa_Rosie_Raw, Ceapa_Galbena_Raw);
        aka(Dovlecei_Raw, Zucchini_Raw);
        aka(Faina_Grau_65, Faina_Grau_150);
        aka(Lapte, Lapte_Praf);
        aka(Linte_Galbena_Raw, Linte_Rosie_Raw);
        aka(PastaiCongelate_Raw, PastaiFresh_Raw);
        aka(Fidea, Paste, Paste_Lasagna);
        aka(Peste_Cod_Raw, Peste_Somon_Raw, Peste_Ton_Cooked);
        aka(Ulei_Floarea_Soarelui, Ulei_Masline);
        aka(Unt_Sarat, Unt_Nesarat);
        aka(Varza_Raw, VarzaMurata);
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
    public final String fdcCode;
    public final Nutrients nutrients = new Nutrients();

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths) {
        this.domesticMonths = domesticMonths;
        this.importMonths = importMonths;
        this.fdcCode = null;
    }

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, String fdcCode) {
        this.domesticMonths = domesticMonths;
        this.importMonths = importMonths;
        this.fdcCode = fdcCode;
    }

    @SuppressWarnings("unused")
    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, boolean score) {
        this(domesticMonths, importMonths);
        this.score = score;
    }

    Ingredient(List<Integer> domesticMonths, List<Integer> importMonths, boolean score, String fdcCode) {
        this(domesticMonths, importMonths, fdcCode);
        this.score = score;
    }

    public int getSeasonalityScore() {
        if (domesticMonths.size() == 12 && importMonths.size() == 12) return Integer.MAX_VALUE;
        return domesticMonths.size() + importMonths.size() * 12;
    }
}
