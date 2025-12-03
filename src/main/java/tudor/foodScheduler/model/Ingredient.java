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
    Ceapa_Alba_Raw(ALL, ALL, "170000"), // legacy yellow onion
    Ceapa_Galbena_Raw(ALL, ALL, "170000"), // legacy yellow onion
    Ceapa_Rosie_Raw(List.of(), List.of(3, 4, 5, 6, 7, 8, 9), "170000"), // legacy yellow onion
    Ceapa_Verde_Raw(ALL, ALL, "170005"), // interesting, mature onion has no vitamin A, a scallion does have 50ug, little but still
    Ciuperci_Raw(ALL, ALL, "169251"),
    Conopida_Raw(List.of(5,6,7,8,9,10,11,12), ALL, "169986"),
    DovleacPlacintar_Raw(List.of(9,10,11,12,1), List.of(2,3,4), "169295"), // Pe 8 Februarie n-am mai găsit nici în Carrefour nici Auchan
    Dovlecei_Raw(List.of(4,5,6,7,8,9), ALL, "169291"),
    Faina_Grau_65(ALL, List.of(), "169761"),
    Faina_Grau_150(ALL, ALL, "168944"), // copilot zice că e mai whole
    Fasole_Uscata_Raw(ALL, ALL, "175202"), // cannelini
    Fidea(ALL, ALL, "168927"), // pasta
    Foietaj(ALL, ALL, "172738"), // puff pastry
    Gogonele_Raw(List.of(9,10,11), List.of(), "170456"),
    Gris(ALL, List.of(), "168933"),
    Iaurt_Grecesc_10(ALL, ALL, "171304"),
    Lapte(ALL, List.of(), "171265"),
    Lapte_Acru(ALL, List.of(), "170904"), // kefir
    Lapte_Praf(ALL, ALL, "502460"),
    Linte_Galbena_Raw(ALL, ALL, "172420"),
    Linte_Rosie_Raw(ALL, ALL, "174284"),
    Maioneza(ALL, ALL, "2710204"),
    Mais(ALL, ALL, "170288"), // corn grain
    Malai(ALL, List.of(), "168039"), // cornmeal
    Masline(ALL, ALL, "169094"),
    Mazare_Raw(ALL, ALL, "170419"),
    Morcov_Raw(ALL, ALL, "170393"),
    Naut_Raw(ALL, ALL, "173756"),
    Orez_Raw(ALL, ALL, "169760"),
    Ou_Raw(ALL, ALL, "171287"),
    Paine(ALL, ALL, false, "172688"),
    Pappardelle(ALL, ALL, "168927"), // pasta
    PastaiCongelate_Raw(ALL, List.of(), "169961"),
    PastaiFresh_Raw(List.of(5), List.of(), "169961"), // pastai fresh doar prin Mai
    Pastarnac_Raw(ALL, ALL, "170417"),
    Paste(ALL, ALL, "168927"),
    Paste_Lasagna(ALL, ALL, "168927"), // lasagna sheets
    Pesmet(ALL, ALL, "1638229"), // breadcrumbs
    Peste_Cod_Raw(ALL, ALL, "171955"), // cod
    Peste_Somon_Raw(ALL, ALL, "175138"),
    Peste_Ton_Cooked(ALL, ALL, "175159"),
    Piscoturi(ALL, ALL, "509552"), // savoiardi
    Praz_Raw(List.of(10,11,12,1,2,3,4), List.of(2, 3, 4, 12), "169246"), // leek
    Salata_Raw(ALL, ALL, "169249"),
    Smantana(ALL, ALL, "171257"),
    Soia_Flour(ALL, ALL, "174275"),
    Sos_Carbonara(ALL, ALL, "378386"),
    Sos_Pesto_Genovese(ALL, ALL, "1972571"),
    Sos_Quattro_Formaggi(ALL, ALL, "1944558"), // feta
    Spanac_Raw(ALL, ALL, "168462"),
    Stevie(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
    Suc_Rosii_Bulion(ALL, ALL, "170054"), // tomato sauce
    Radacina_Patrunjel(ALL, ALL),
    Rosii(List.of(6,7,8,9,10,11), ALL, "170457"),
    Tahini(ALL, ALL, "168604"),
    Taitei(ALL, ALL, "168927"), // pasta
    Telina_Raw(ALL, ALL, "170400"),
    Ulei_Floarea_Soarelui(ALL, ALL, "1750349"),
    Ulei_Masline(ALL, ALL, "748608"),
    Unt_Sarat(ALL, ALL, "790508"),
    Unt_Nesarat(ALL, ALL, "790508"), // salted, is far more complete for now
    Urzici_Blanched(List.of(3,4,5), List.of(), "169819"),
    Usturoi_Raw(ALL, ALL, "169230"),
    Varza_Raw(List.of(4,5,6,7,8,9,10,11,12,1), ALL, "169975"),
    VarzaMurata(ALL, ALL, "2710075"),
    Vinete_Raw(List.of(5,6,7,8,9,10), ALL, "169228"), // vinetele coapte ies jumate din vinetele crude
    Zahar(ALL, List.of(), "169655"),
    Zucchini_Raw(List.of(6), ALL, "169291"),

    // fructe
    Banane(List.of(), ALL, "173944"),
    Caise(List.of(7,8,9), List.of(), "171697"),
    Capsuni(List.of(6,7,8,9), List.of(), "167762"),
    Cirese(List.of(6, 7), List.of(), "171719"),
    Clementine(List.of(), List.of(12, 1), "168195"),
    Grapefruit(List.of(), List.of(12,1,2,3,4,5,6), "174673"),
    Kaki(List.of(), List.of(10,11,12,1), "169941"),
    Kiwi(List.of(), List.of(10,11,12,1,2,3,4,5), "327046"),
    Mandarine(List.of(), List.of(11,12,1,2,3,4), "169105"),
    Mango_Tommy_Atkins(List.of(), ALL, "169910"),
    Mere_Red_Delicious(List.of(11, 12,1,2), ALL, "168201"),
    Mineole(List.of(), List.of(1), "2450365"),
    Papaya(List.of(), List.of(1), "169926"),
    PepeneGalben(List.of(7,8,9), List.of(), "169092"),
    PepeneRosu(List.of(7,8,9), List.of(), "167765"),
    Pere(List.of(), ALL, "169118"),
    Portocale(List.of(), List.of(11,12, 1, 2,3,4,5,6), "169097"),
    Prune(List.of(8,9,10,11), List.of(12, 1), "169949"),
    Rodii(List.of(), ALL, "169134"),
    Struguri_Negri(List.of(9,10,11), List.of(), "174683"),
    Struguri_Albi(List.of(9,10,11), List.of(), "174683")
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
