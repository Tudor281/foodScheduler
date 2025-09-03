package tudor.foodScheduler.model;

import java.util.ArrayList;
import java.util.List;

import static tudor.foodScheduler.model.Months.ALL;

/** Ingredients have the characteristic of being nutritious */
public enum Ingredient {
    Ardei_Rosu(List.of(6,7,8,9), ALL),
    // sort of spice, sort of ingredient. But it's pointless to have it as spice, if it's not available
    Apio (List.of(5, 6, 7, 8, 9, 10), List.of(11, 12, 1, 3, 4, 5 , 6), false),
    Avocado_Hass(List.of(), ALL), // coaja aspra, neagra la maturitate
    // mostly water, deci n-ar trebui să fie cine știe ce la capitolul nutrienți
    Bors(ALL, ALL),
    Branza_CottageFullFat(ALL, ALL),
    Branza_Fagaras(ALL, ALL),
    Branza_Gorgonzola(ALL, ALL),
    Branza_Mascarpone(ALL, ALL),
    Branza_Mozzarella(ALL, ALL),
    Branza_Telemea(ALL, ALL),
    Broccoli(List.of(5,6,7,8,9,10,11), ALL),
    Carne_Pui(ALL, ALL),
    Carne_Pui_Ficat(ALL, ALL),
    Carne_Vita(ALL, ALL),
    Cartofi(ALL, ALL),
    Castraveti(List.of(3,4,5,6,7,8,9), ALL),
    Castraveti_Murati(ALL, ALL),
    Ceapa(ALL, ALL),
    Ceapa_Verde(ALL, ALL),
    Ciuperci(ALL, ALL),
    Conopida(List.of(5,6,7,8,9,10,11,12), ALL),
    DovleacPlacintar(List.of(9,10,11,12,1), List.of(2,3,4)), // Pe 8 Februarie n-am mai găsit nici în Carrefour nici Auchan
    Dovlecei(List.of(4,5,6,7,8,9), ALL),
    Faina(ALL, List.of()),
    Fasole_Uscata(ALL, ALL),
    Fidea(ALL, ALL),
    Foietaj(ALL, ALL),
    Frunze(List.of(4,5,6), List.of()), // lobodă sau ștevie. Problema e că dacă ai ști că poți obține lobodă sau ștevie la comandă, le-ai separa, dar eu cred că o să fiu norocos dacă găsesc una sau alta
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
    Peste(ALL, ALL),
    Peste_Somon(ALL, ALL),
    Piscoturi(ALL, ALL),
    Praz(List.of(10,11,12,1,2,3,4), List.of(2, 3, 4, 12)),
    Salata(ALL, ALL),
    Smantana(ALL, ALL),
    Soia(ALL, ALL),
    Spanac(ALL, ALL),
    Sos_Carbonara(ALL, ALL),
    Sos_Pesto_Genovese(ALL, ALL),
    Sos_Quattro_Formaggi(ALL, ALL),
    Suc_Rosii_Bulion(ALL, ALL),
    Radacina_Patrunjel(ALL, ALL),
    Rosii(List.of(6,7,8,9,10,11), ALL),
    Tahini(ALL, ALL),
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
        Branza_CottageFullFat.akas.add(Branza_Fagaras);
        Branza_CottageFullFat.akas.add(Branza_Gorgonzola);
        Branza_CottageFullFat.akas.add(Branza_Mascarpone);
        Branza_CottageFullFat.akas.add(Branza_Mozzarella);
        Branza_CottageFullFat.akas.add(Branza_Telemea);
        Branza_Fagaras.akas.add(Branza_CottageFullFat);
        Branza_Fagaras.akas.add(Branza_Gorgonzola);
        Branza_Fagaras.akas.add(Branza_Mascarpone);
        Branza_Fagaras.akas.add(Branza_Mozzarella);
        Branza_Fagaras.akas.add(Branza_Telemea);
        Branza_Gorgonzola.akas.add(Branza_CottageFullFat);
        Branza_Gorgonzola.akas.add(Branza_Fagaras);
        Branza_Gorgonzola.akas.add(Branza_Mascarpone);
        Branza_Gorgonzola.akas.add(Branza_Mozzarella);
        Branza_Gorgonzola.akas.add(Branza_Telemea);
        Branza_Mascarpone.akas.add(Branza_CottageFullFat);
        Branza_Mascarpone.akas.add(Branza_Fagaras);
        Branza_Mascarpone.akas.add(Branza_Gorgonzola);
        Branza_Mascarpone.akas.add(Branza_Mozzarella);
        Branza_Mascarpone.akas.add(Branza_Telemea);
        Branza_Mozzarella.akas.add(Branza_CottageFullFat);
        Branza_Mozzarella.akas.add(Branza_Fagaras);
        Branza_Mozzarella.akas.add(Branza_Gorgonzola);
        Branza_Mozzarella.akas.add(Branza_Mascarpone);
        Branza_Mozzarella.akas.add(Branza_Telemea);
        Branza_Telemea.akas.add(Branza_CottageFullFat);
        Branza_Telemea.akas.add(Branza_Fagaras);
        Branza_Telemea.akas.add(Branza_Gorgonzola);
        Branza_Telemea.akas.add(Branza_Mascarpone);
        Branza_Telemea.akas.add(Branza_Mozzarella);
        Branza_Telemea.akas.add(Branza_Telemea);

        Carne_Pui.akas.add(Carne_Vita);
        Carne_Pui.akas.add(Carne_Pui_Ficat);
        Carne_Pui_Ficat.akas.add(Carne_Pui);
        Carne_Pui_Ficat.akas.add(Carne_Vita);
        Carne_Vita.akas.add(Carne_Pui);
        Carne_Vita.akas.add(Carne_Pui_Ficat);

        Lapte.akas.add(Lapte_Praf);
        Lapte_Praf.akas.add(Lapte);

        PastaiCongelate.akas.add(PastaiFresh);
        PastaiFresh.akas.add(PastaiCongelate);

        Fidea.akas.add(Paste);
        Fidea.akas.add(Paste_Lasagna);
        Paste.akas.add(Fidea);
        Paste.akas.add(Paste_Lasagna);
        Paste_Lasagna.akas.add(Fidea);
        Paste_Lasagna.akas.add(Paste);


        Peste.akas.add(Peste_Somon);
        Peste_Somon.akas.add(Peste);

        Ulei.akas.add(Ulei_Masline);
        Ulei_Masline.akas.add(Ulei);

        Varza.akas.add(VarzaMurata);
        VarzaMurata.akas.add(Varza);
    }

    final List<Integer> domesticMonths;
    final List<Integer> importMonths;
    public final List<Ingredient> akas = new ArrayList<>();
    public boolean score = true; // recipes with less of this ingredient get better scores, by disabling I hope I get more of these

    int calories = 0;
    double fatTotal = 0;
    double saturatedFat = 0;
    double carbohydratesNonSugarNonFiber = 0;
    double sugars = 0;
    double fibers = 0;
    double proteins = 0;
    double salt = 0;

    double calciumMg = 0;
    double ironMg = 0;
    double magnesiumMg = 0;
    double phosphorusMg = 0;
    double potassiumMg = 0;
    double sodiumMg = 0;
    double zincMg = 0;
    double copperMg = 0;
    double manganeseMg = 0;
    double seleniumMug = 0;
    double molybdenumMug = 0;
    double iodineMug = 0;

    double cMg = 0;
    double b1thiaminMg = 0;
    double b2riboflavinMg = 0;
    double b3niacinMg = 0;
    double b5pantothenicAcidMg=0;
    double b6Mg = 0;
    double b9folateMug = 0;
    double b12Mug = 0;
    double biotinMug = 0;
    double retinolMug = 0;
    double betaCaroteneMug = 0;
    double dMug = 0;
    double eMg = 0;
    double k1PhylloquinoneMug = 0; // aka Phytomenadione
    double kDihydrophylloquinoneMug = 0; // synthetic vitamin K
    double k2Menaquinone4Mug = 0; // Subtypes: MK-4 to MK-13

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

    // fill in micronutrients
    static {
        // https://fdc.nal.usda.gov/food-details/2258590/nutrients
        Ardei_Rosu.calories = 31;
        Ardei_Rosu.proteins = 0.9;
        Ardei_Rosu.fatTotal = 0.13;
        Ardei_Rosu.carbohydratesNonSugarNonFiber = 5.45;
        Ardei_Rosu.fibers = 1.2;
        Ardei_Rosu.calciumMg = 6;
        Ardei_Rosu.ironMg = 0.35;
        Ardei_Rosu.magnesiumMg = 11;
        Ardei_Rosu.phosphorusMg = 27;
        Ardei_Rosu.potassiumMg = 213;
        Ardei_Rosu.zincMg = 0.2;
        Ardei_Rosu.copperMg = 0.04;
        Ardei_Rosu.manganeseMg = 0.133;
        Ardei_Rosu.cMg = 142;
        Ardei_Rosu.b1thiaminMg = 0.055;
        Ardei_Rosu.b2riboflavinMg = 0.142;
        Ardei_Rosu.b3niacinMg = 1.02;
        Ardei_Rosu.b6Mg = 0.303;
        Ardei_Rosu.biotinMug = 0.427;
        Ardei_Rosu.b9folateMug = 47;

        // https://fdc.nal.usda.gov/food-details/2346405/nutrients
        Apio.calories = 17;
        Apio.proteins = 0.49;
        Apio.fatTotal = 0.16;
        Apio.carbohydratesNonSugarNonFiber = 3.32;
        Apio.calciumMg = 46;
        Apio.magnesiumMg = 10.9;
        Apio.phosphorusMg = 22;
        Apio.potassiumMg = 265;
        Apio.sodiumMg = 97;
        Apio.zincMg = 0.09;
        Apio.manganeseMg = 0.076;
        Apio.b6Mg = 0.052;

        // https://fdc.nal.usda.gov/food-details/2710824/nutrients
        Avocado_Hass.calories = 223;
        Avocado_Hass.proteins = 1.81;
        Avocado_Hass.fatTotal = 20.3;
        Avocado_Hass.carbohydratesNonSugarNonFiber = 8.32;
        Avocado_Hass.calciumMg = 14;
        Avocado_Hass.ironMg = 0.61;
        Avocado_Hass.magnesiumMg = 32.8;
        Avocado_Hass.phosphorusMg = 42;
        Avocado_Hass.potassiumMg = 576;
        Avocado_Hass.zincMg = 0.46;
        Avocado_Hass.copperMg = 0.285;
        Avocado_Hass.manganeseMg = 0.197;
        Avocado_Hass.b6Mg = 0.167;
        Avocado_Hass.b9folateMug = 129;

        // https://fdc.nal.usda.gov/food-details/2346384/nutrients
        // TODO full lipidic profile
        Branza_CottageFullFat.calories = 103;
        Branza_CottageFullFat.proteins = 11.6;
        Branza_CottageFullFat.fatTotal = 4.22;
        Branza_CottageFullFat.saturatedFat = 2.6;
        Branza_CottageFullFat.carbohydratesNonSugarNonFiber = 4.6;
        Branza_CottageFullFat.calciumMg = 88;
        Branza_CottageFullFat.magnesiumMg = 9.2;
        Branza_CottageFullFat.phosphorusMg = 154;
        Branza_CottageFullFat.potassiumMg = 124;
        Branza_CottageFullFat.sodiumMg = 350;
        Branza_CottageFullFat.zincMg = 0.45;
        Branza_CottageFullFat.iodineMug = 45.7;
        Branza_CottageFullFat.b1thiaminMg = 0.052;
        Branza_CottageFullFat.b3niacinMg = 0.138;
        Branza_CottageFullFat.b6Mg = 0.047;
        Branza_CottageFullFat.biotinMug = 2.28;
        Branza_CottageFullFat.b12Mug = 0.66;
        Branza_CottageFullFat.retinolMug = 36;
        Branza_CottageFullFat.k1PhylloquinoneMug = 0.2;
        Branza_CottageFullFat.k2Menaquinone4Mug = 1.3;

        Branza_Fagaras.calories =  Branza_CottageFullFat.calories;
        Branza_Fagaras.proteins = Branza_CottageFullFat.proteins;
        Branza_Fagaras.fatTotal = Branza_CottageFullFat.fatTotal;
        Branza_Fagaras.saturatedFat = Branza_CottageFullFat.saturatedFat;
        Branza_Fagaras.carbohydratesNonSugarNonFiber = Branza_CottageFullFat.carbohydratesNonSugarNonFiber;
        Branza_Fagaras.calciumMg = Branza_CottageFullFat.calciumMg;
        Branza_Fagaras.magnesiumMg = Branza_CottageFullFat.magnesiumMg;
        Branza_Fagaras.phosphorusMg = Branza_CottageFullFat.phosphorusMg;
        Branza_Fagaras.potassiumMg = Branza_CottageFullFat.potassiumMg;
        Branza_Fagaras.sodiumMg = Branza_CottageFullFat.sodiumMg;
        Branza_Fagaras.zincMg = Branza_CottageFullFat.zincMg;
        Branza_Fagaras.iodineMug = Branza_CottageFullFat.iodineMug;
        Branza_Fagaras.b1thiaminMg = Branza_CottageFullFat.b1thiaminMg;
        Branza_Fagaras.b3niacinMg = Branza_CottageFullFat.b3niacinMg;
        Branza_Fagaras.b6Mg = Branza_CottageFullFat.b6Mg;
        Branza_Fagaras.biotinMug = Branza_CottageFullFat.biotinMug;
        Branza_Fagaras.b12Mug = Branza_CottageFullFat.b12Mug;
        Branza_Fagaras.retinolMug = Branza_CottageFullFat.retinolMug;
        Branza_Fagaras.k1PhylloquinoneMug = Branza_CottageFullFat.k1PhylloquinoneMug;
        Branza_Fagaras.k2Menaquinone4Mug = Branza_CottageFullFat.k2Menaquinone4Mug;

        // Ciqual
        Branza_Gorgonzola.calories = 312;
        Branza_Gorgonzola.proteins = 19;
        Branza_Gorgonzola.fatTotal = 26.4;
        Branza_Gorgonzola.saturatedFat = 16.9;
        Branza_Gorgonzola.salt = 1.77;
        Branza_Gorgonzola.calciumMg = 390;
        Branza_Gorgonzola.copperMg = 0.02;
        Branza_Gorgonzola.ironMg = 0.08;
        Branza_Gorgonzola.iodineMug = 70;
        Branza_Gorgonzola.magnesiumMg = 18;
        Branza_Gorgonzola.manganeseMg = 0.01;
        Branza_Gorgonzola.phosphorusMg = 310;
        Branza_Gorgonzola.potassiumMg = 110;
        Branza_Gorgonzola.sodiumMg = 710;
        Branza_Gorgonzola.zincMg = 2.1;
        Branza_Gorgonzola.retinolMug = 286;
        Branza_Gorgonzola.betaCaroteneMug = 168;
        Branza_Gorgonzola.dMug = 0.24;
        Branza_Gorgonzola.eMg = 0.16;
        Branza_Gorgonzola.k1PhylloquinoneMug = 0.9;
        Branza_Gorgonzola.b1thiaminMg = 0.07;
        Branza_Gorgonzola.b2riboflavinMg = 0.32;
        Branza_Gorgonzola.b3niacinMg = 2.93;
        Branza_Gorgonzola.b5pantothenicAcidMg = 0.81;
        Branza_Gorgonzola.b6Mg = 0.13;
        Branza_Gorgonzola.b9folateMug = 41.2;
        Branza_Gorgonzola.b12Mug = 0.73;

        // Ciqual
        Branza_Mascarpone.proteins = 4.38;
        Branza_Mascarpone.sugars = 4;
        Branza_Mascarpone.fatTotal = 39;
        Branza_Mascarpone.saturatedFat = 25.7;
        Branza_Mascarpone.salt = 0.081;
        Branza_Mascarpone.calciumMg = 130;
        Branza_Mascarpone.ironMg = 0.06;
        Branza_Mascarpone.iodineMug = 21;
        Branza_Mascarpone.magnesiumMg = 13;
        Branza_Mascarpone.phosphorusMg = 110;
        Branza_Mascarpone.potassiumMg = 120;
        Branza_Mascarpone.sodiumMg = 32.2;
        Branza_Mascarpone.zincMg = 0.53;
        Branza_Mascarpone.retinolMug = 345;
        Branza_Mascarpone.betaCaroteneMug = 258;
        Branza_Mascarpone.eMg = 1;
        Branza_Mascarpone.k1PhylloquinoneMug = 1.17;
        Branza_Mascarpone.b1thiaminMg = 0.028;
        Branza_Mascarpone.b2riboflavinMg = 0.15;
        Branza_Mascarpone.b3niacinMg = 0.13;
        Branza_Mascarpone.b5pantothenicAcidMg = 0.31;
        Branza_Mascarpone.b6Mg = 0.028;
        Branza_Mascarpone.b12Mug = 0.48;

        // Ciqual
        Branza_Mozzarella.calories = 227;
        Branza_Mozzarella.proteins = 16.5;
        Branza_Mozzarella.sugars = 0.7;
        Branza_Mozzarella.carbohydratesNonSugarNonFiber = 0.75 - Branza_Mozzarella.sugars;
        Branza_Mozzarella.fatTotal = 17.7;
        Branza_Mozzarella.saturatedFat = 11.7;
        Branza_Mozzarella.salt = 0.6;
        Branza_Mozzarella.calciumMg = 545;
        Branza_Mozzarella.copperMg = 0.011;
        Branza_Mozzarella.ironMg = 0.44;
        Branza_Mozzarella.iodineMug = 37.2;
        Branza_Mozzarella.magnesiumMg = 20;
        Branza_Mozzarella.manganeseMg = 0.03;
        Branza_Mozzarella.phosphorusMg = 354;
        Branza_Mozzarella.potassiumMg = 76;
        Branza_Mozzarella.seleniumMug = 16.3;
        Branza_Mozzarella.sodiumMg = 240;
        Branza_Mozzarella.zincMg = 2.92;
        Branza_Mozzarella.retinolMug = 174;
        Branza_Mozzarella.betaCaroteneMug = 57;
        Branza_Mozzarella.dMug = 0.4;
        Branza_Mozzarella.eMg = 0.19;
        Branza_Mozzarella.k1PhylloquinoneMug = 2.3;
        Branza_Mozzarella.b1thiaminMg = 0.03;
        Branza_Mozzarella.b2riboflavinMg = 0.28;
        Branza_Mozzarella.b3niacinMg = 0.1;
        Branza_Mozzarella.b5pantothenicAcidMg = 0.14;
        Branza_Mozzarella.b6Mg = 0.037;
        Branza_Mozzarella.b9folateMug = 7;
        Branza_Mozzarella.b12Mug = 2.28;
        
    }
}
