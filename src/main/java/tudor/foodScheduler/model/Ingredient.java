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
    Branza_Feta(ALL, ALL),
    Branza_Gorgonzola(ALL, ALL),
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

    static { // akas
        aka(Branza_CottageFullFat, Branza_Fagaras, Branza_Feta, Branza_Gorgonzola, Branza_Mascarpone, Branza_Mozzarella, Branza_Telemea);
        aka(Carne_Pui_Picioare, Carne_Pui_Piept, Carne_Pui_Tocata, Carne_Pui_Ficat, Carne_Vita_Chuck, Carne_Vita_Tocata);
        aka(Lapte, Lapte_Praf);
        aka(PastaiCongelate, PastaiFresh);
        aka(Fidea, Paste, Paste_Lasagna);
        aka(Peste, Peste_Somon);
        aka(Ulei, Ulei_Masline);
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

    int calories = 0;
    double fatTotal = 0;
    double saturatedFat = 0;
    double starch = 0; // total carbs - sugars - fibers (in ciqual carbs have sugars but not fibers, see Castraveti Murati)
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
    double luteinZeaxanthinMug = 0;

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
        Ardei_Rosu.starch = 5.45;
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
        Apio.starch = 3.32;
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
        Avocado_Hass.starch = 8.32;
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
        Branza_CottageFullFat.starch = 4.6;
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
        Branza_Fagaras.starch = Branza_CottageFullFat.starch;
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

        // Ciqual 12060
        Branza_Feta.calories = 270;
        Branza_Feta.proteins = 16.4;
        Branza_Feta.sugars = 1.42;
        Branza_Feta.fatTotal = 21.7;
        Branza_Feta.saturatedFat = 14.6;
        Branza_Feta.salt = 1.94;
        Branza_Feta.calciumMg = 557;
        Branza_Feta.copperMg = 0.051;
        Branza_Feta.ironMg = 0.42;
        Branza_Feta.iodineMug = 13.8;
        Branza_Feta.magnesiumMg = 19.5;
        Branza_Feta.manganeseMg = 0.044;
        Branza_Feta.phosphorusMg = 349;
        Branza_Feta.potassiumMg = 125;
        Branza_Feta.seleniumMug = 6.2;
        Branza_Feta.sodiumMg = 917;
        Branza_Feta.zincMg = 2.63;
        Branza_Feta.retinolMug = 157;
        Branza_Feta.betaCaroteneMug = 3;
        Branza_Feta.dMug = 0.32;
        Branza_Feta.eMg = 0.37;
        Branza_Feta.k1PhylloquinoneMug = 1.8;
        Branza_Feta.b1thiaminMg = 0.1;
        Branza_Feta.b2riboflavinMg = 0.65;
        Branza_Feta.b3niacinMg = 1.4;
        Branza_Feta.b5pantothenicAcidMg = 1.16;
        Branza_Feta.b6Mg = 0.34;
        Branza_Feta.b9folateMug = 47;
        Branza_Feta.b12Mug = 1.41;

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
        Branza_Mozzarella.starch = 0.75 - Branza_Mozzarella.sugars;
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

        Branza_Telemea.calories = Branza_Feta.calories;
        Branza_Telemea.proteins = Branza_Feta.proteins;
        Branza_Telemea.sugars = Branza_Feta.sugars;
        Branza_Telemea.fatTotal = Branza_Feta.fatTotal;
        Branza_Telemea.saturatedFat = Branza_Feta.saturatedFat;
        Branza_Telemea.salt = Branza_Feta.salt;
        Branza_Telemea.calciumMg = Branza_Feta.calciumMg;
        Branza_Telemea.copperMg = Branza_Feta.copperMg;
        Branza_Telemea.ironMg = Branza_Feta.ironMg;
        Branza_Telemea.iodineMug = Branza_Feta.iodineMug;
        Branza_Telemea.magnesiumMg = Branza_Feta.magnesiumMg;
        Branza_Telemea.manganeseMg = Branza_Feta.manganeseMg;
        Branza_Telemea.phosphorusMg = Branza_Feta.phosphorusMg;
        Branza_Telemea.potassiumMg = Branza_Feta.potassiumMg;
        Branza_Telemea.seleniumMug = Branza_Feta.seleniumMug;
        Branza_Telemea.sodiumMg = Branza_Feta.sodiumMg;
        Branza_Telemea.zincMg = Branza_Feta.zincMg;
        Branza_Telemea.retinolMug = Branza_Feta.retinolMug;
        Branza_Telemea.betaCaroteneMug = Branza_Feta.betaCaroteneMug;
        Branza_Telemea.dMug = Branza_Feta.dMug;
        Branza_Telemea.eMg = Branza_Feta.eMg;
        Branza_Telemea.k1PhylloquinoneMug = Branza_Feta.k1PhylloquinoneMug;
        Branza_Telemea.b1thiaminMg = Branza_Feta.b1thiaminMg;
        Branza_Telemea.b2riboflavinMg = Branza_Feta.b2riboflavinMg;
        Branza_Telemea.b3niacinMg = Branza_Feta.b3niacinMg;
        Branza_Telemea.b5pantothenicAcidMg = Branza_Feta.b5pantothenicAcidMg;
        Branza_Telemea.b6Mg = Branza_Feta.b6Mg;
        Branza_Telemea.b9folateMug = Branza_Feta.b9folateMug;
        Branza_Telemea.b12Mug = Branza_Feta.b12Mug;

        // https://fdc.nal.usda.gov/food-details/747447/nutrients
        Broccoli.calories = 39;
        Broccoli.proteins = 2.57;
        Broccoli.fatTotal = 0.34;
        Broccoli.saturatedFat = 0.039;
        Broccoli.sugars = 1.4;
        Broccoli.fibers = 2.4;
        Broccoli.calciumMg = 46;
        Broccoli.ironMg = 0.69;
        Broccoli.magnesiumMg = 21;
        Broccoli.phosphorusMg = 67;
        Broccoli.potassiumMg = 303;
        Broccoli.sodiumMg = 36;
        Broccoli.zincMg = 0.42;
        Broccoli.copperMg = 0.059;
        Broccoli.manganeseMg = 0.197;
        Broccoli.seleniumMug = 1.6;
        Broccoli.cMg = 91.3;
        Broccoli.b1thiaminMg = 0.077;
        Broccoli.b2riboflavinMg = 0.114;
        Broccoli.b3niacinMg = 0.639;
        Broccoli.b5pantothenicAcidMg = 0.61;
        Broccoli.b6Mg = 0.191;
        Broccoli.b9folateMug = 65;
        Broccoli.betaCaroteneMug = 93;
        Broccoli.luteinZeaxanthinMug = 745;
        Broccoli.eMg = 0.15;
        Broccoli.k1PhylloquinoneMug = 102;

        // Ciqual 36030
        Carne_Pui_Picioare.calories = 188;
        Carne_Pui_Picioare.proteins = 24.8;
        Carne_Pui_Picioare.starch = 0.7;
        Carne_Pui_Picioare.fatTotal = 9.52;
        Carne_Pui_Picioare.saturatedFat = 2; // from others
        Carne_Pui_Picioare.salt = 0.23;
        Carne_Pui_Picioare.calciumMg = 5.8;
        Carne_Pui_Picioare.ironMg = 1.2;
        Carne_Pui_Picioare.iodineMug = 3;
        Carne_Pui_Picioare.magnesiumMg = 26.2;
        Carne_Pui_Picioare.phosphorusMg = 164;
        Carne_Pui_Picioare.potassiumMg = 262;
        Carne_Pui_Picioare.sodiumMg = 90;
        Carne_Pui_Picioare.zincMg = 2.4;
        Carne_Pui_Picioare.retinolMug = 10;
        Carne_Pui_Picioare.eMg = 0.27;
        Carne_Pui_Picioare.k1PhylloquinoneMug = 3.55;
        Carne_Pui_Picioare.cMg = 2.2;
        Carne_Pui_Picioare.b1thiaminMg = 0.059;
        Carne_Pui_Picioare.b2riboflavinMg = 0.15;
        Carne_Pui_Picioare.b3niacinMg = 4.9;
        Carne_Pui_Picioare.b5pantothenicAcidMg = 0.64;
        Carne_Pui_Picioare.b6Mg = 0.2;
        Carne_Pui_Picioare.b9folateMug = 7.5;
        Carne_Pui_Picioare.b12Mug = 0.49;

        // Ciqual 36018
        // TODO: Unele retete folosesc picioare
        Carne_Pui_Piept.calories = 141;
        Carne_Pui_Piept.proteins = 30.1;
        Carne_Pui_Piept.fatTotal = 2;
        Carne_Pui_Piept.saturatedFat = 0.58;
        Carne_Pui_Piept.salt = 0.14;
        Carne_Pui_Piept.calciumMg = 4.7;
        Carne_Pui_Piept.copperMg = 0.03;
        Carne_Pui_Piept.ironMg = 0.39;
        Carne_Pui_Piept.magnesiumMg = 37;
        Carne_Pui_Piept.phosphorusMg = 270;
        Carne_Pui_Piept.potassiumMg = 440;
        Carne_Pui_Piept.sodiumMg = 56;
        Carne_Pui_Piept.zincMg = 0.72;
        Carne_Pui_Piept.eMg = 0.11;
        Carne_Pui_Piept.cMg = 1.43;
        Carne_Pui_Piept.b1thiaminMg = 0.087;
        Carne_Pui_Piept.b2riboflavinMg = 0.049;
        Carne_Pui_Piept.b3niacinMg = 11.8;
        Carne_Pui_Piept.b5pantothenicAcidMg = 1.74;
        Carne_Pui_Piept.b6Mg = 0.19;
        Carne_Pui_Piept.b9folateMug = 9.55;
        Carne_Pui_Piept.b12Mug = 0.18;

        // https://fdc.nal.usda.gov/food-details/2514746/nutrients
        Carne_Pui_Tocata.calories = 133;
        Carne_Pui_Tocata.proteins = 17.9;
        Carne_Pui_Tocata.fatTotal = 7.16;
        Carne_Pui_Tocata.saturatedFat = 1.56;
        Carne_Pui_Tocata.calciumMg = 6;
        Carne_Pui_Tocata.magnesiumMg = 20.5;
        Carne_Pui_Tocata.phosphorusMg = 166;
        Carne_Pui_Tocata.potassiumMg = 302;
        Carne_Pui_Tocata.sodiumMg = 63;
        Carne_Pui_Tocata.zincMg = 1.18;
        Carne_Pui_Tocata.copperMg = 0.036;
        Carne_Pui_Tocata.manganeseMg = 0.005;

        // Ciqual 40116
        Carne_Pui_Ficat.calories = 160;
        Carne_Pui_Ficat.proteins = 24.5;
        Carne_Pui_Ficat.starch = 0.8;
        Carne_Pui_Ficat.fatTotal = 6.51;
        Carne_Pui_Ficat.saturatedFat = 2.06;
        Carne_Pui_Ficat.salt = 0.19;
        Carne_Pui_Ficat.calciumMg = 11;
        Carne_Pui_Ficat.copperMg = 0.5;
        Carne_Pui_Ficat.ironMg = 11.6;
        Carne_Pui_Ficat.iodineMug = 5;
        Carne_Pui_Ficat.magnesiumMg = 25;
        Carne_Pui_Ficat.manganeseMg = 0.36;
        Carne_Pui_Ficat.phosphorusMg = 405;
        Carne_Pui_Ficat.potassiumMg = 263;
        Carne_Pui_Ficat.sodiumMg = 76;
        Carne_Pui_Ficat.zincMg = 3.98;
        Carne_Pui_Ficat.retinolMug = 3980;
        Carne_Pui_Ficat.betaCaroteneMug = 30;
        Carne_Pui_Ficat.eMg = 0.82;
        Carne_Pui_Ficat.cMg = 27.9;
        Carne_Pui_Ficat.b1thiaminMg = 0.29;
        Carne_Pui_Ficat.b2riboflavinMg = 1.99;
        Carne_Pui_Ficat.b3niacinMg = 11;
        Carne_Pui_Ficat.b5pantothenicAcidMg = 6.67;
        Carne_Pui_Ficat.b6Mg = 0.76;
        Carne_Pui_Ficat.b9folateMug = 578;
        Carne_Pui_Ficat.b12Mug = 16.9;

        // Ciqual 6270
        Carne_Vita_Chuck.calories = 144;
        Carne_Vita_Chuck.proteins = 21.2;
        Carne_Vita_Chuck.fatTotal = 6.54;
        Carne_Vita_Chuck.saturatedFat = 2.59;
        Carne_Vita_Chuck.salt = 0.12;
        Carne_Vita_Chuck.calciumMg = 7.45;
        Carne_Vita_Chuck.copperMg = 0.087;
        Carne_Vita_Chuck.ironMg = 2.5;
        Carne_Vita_Chuck.magnesiumMg = 25;
        Carne_Vita_Chuck.manganeseMg = 0.012;
        Carne_Vita_Chuck.phosphorusMg = 223;
        Carne_Vita_Chuck.potassiumMg = 343;
        Carne_Vita_Chuck.seleniumMug = 10.2;
        Carne_Vita_Chuck.sodiumMg = 49;
        Carne_Vita_Chuck.zincMg = 5.51;
        Carne_Vita_Chuck.retinolMug = 3;
        Carne_Vita_Chuck.dMug = 0.1;
        Carne_Vita_Chuck.eMg = 0.2;
        Carne_Vita_Chuck.k1PhylloquinoneMug = 1.5;
        Carne_Vita_Chuck.b1thiaminMg = 0.08;
        Carne_Vita_Chuck.b2riboflavinMg = 0.21;
        Carne_Vita_Chuck.b3niacinMg = 3.67;
        Carne_Vita_Chuck.b5pantothenicAcidMg = 0.86;
        Carne_Vita_Chuck.b6Mg = 0.27;
        Carne_Vita_Chuck.b9folateMug = 3;
        Carne_Vita_Chuck.b12Mug = 2.77;

        //Ciqual 6255
        Carne_Vita_Tocata.calories = 239;
        Carne_Vita_Tocata.proteins = 23.6;
        Carne_Vita_Tocata.fatTotal = 16.1;
        Carne_Vita_Tocata.saturatedFat = 7.08;
        Carne_Vita_Tocata.salt = 0.21;
        Carne_Vita_Tocata.calciumMg = 15;
        Carne_Vita_Tocata.copperMg = 0.078;
        Carne_Vita_Tocata.ironMg = 2.6;
        Carne_Vita_Tocata.iodineMug = 6.1;
        Carne_Vita_Tocata.magnesiumMg = 29.5;
        Carne_Vita_Tocata.manganeseMg = 0.06;
        Carne_Vita_Tocata.phosphorusMg = 198;
        Carne_Vita_Tocata.potassiumMg = 318;
        Carne_Vita_Tocata.sodiumMg = 84.3;
        Carne_Vita_Tocata.zincMg = 4.9;
        Carne_Vita_Tocata.retinolMug = 3;
        Carne_Vita_Tocata.eMg = 0.12;
        Carne_Vita_Tocata.k1PhylloquinoneMug = 1.2;
        Carne_Vita_Tocata.b1thiaminMg = 0.046;
        Carne_Vita_Tocata.b2riboflavinMg = 0.18;
        Carne_Vita_Tocata.b3niacinMg = 5.2;
        Carne_Vita_Tocata.b5pantothenicAcidMg = 0.66;
        Carne_Vita_Tocata.b6Mg = 0.29;
        Carne_Vita_Tocata.b9folateMug = 9;
        Carne_Vita_Tocata.b12Mug = 2.3;

        // ciqual 4003
        Cartofi.calories = 81;
        Cartofi.proteins = 1.8;
        Cartofi.sugars = 0.86;
        Cartofi.fibers = 1.8;
        Cartofi.starch = 16.7 - Cartofi.sugars;
        Cartofi.fatTotal = 0.34;
        Cartofi.saturatedFat = 0.094;
        Cartofi.salt = 0.052;
        Cartofi.calciumMg = 5.83;
        Cartofi.copperMg = 0.076;
        Cartofi.ironMg = 0.27;
        Cartofi.magnesiumMg = 17.3;
        Cartofi.manganeseMg = 0.074;
        Cartofi.phosphorusMg = 37.2;
        Cartofi.potassiumMg = 363;
        Cartofi.sodiumMg = 20.6;
        Cartofi.zincMg = 0.15;
        Cartofi.betaCaroteneMug = 2;
        Cartofi.eMg = 0.01;
        Cartofi.k1PhylloquinoneMug = 2.1;
        Cartofi.cMg = 2.92;
        Cartofi.b1thiaminMg = 0.079;
        Cartofi.b3niacinMg = 1.73;
        Cartofi.b5pantothenicAcidMg = 0.57;
        Cartofi.b6Mg = 0.34;
        Cartofi.b9folateMug = 31.1;

        // Ciqual 20210
        Castraveti.calories = 15;
        Castraveti.proteins = 0.56;
        Castraveti.sugars = 1.8;
        Castraveti.fibers = 0.8;
        Castraveti.starch = 2.23 - Castraveti.sugars;
        Castraveti.calciumMg = 16;
        Castraveti.copperMg = 0.02;
        Castraveti.ironMg = 0.14;
        Castraveti.magnesiumMg = 8.9;
        Castraveti.manganeseMg = 0.11;
        Castraveti.phosphorusMg = 25;
        Castraveti.potassiumMg = 140;
        Castraveti.zincMg = 0.13;
        Castraveti.betaCaroteneMug = 24.3;
        Castraveti.k1PhylloquinoneMug = 2.75;
        Castraveti.cMg = 3.52;
        Castraveti.b5pantothenicAcidMg = 0.15;
        Castraveti.b6Mg = 0.042;
        Castraveti.b9folateMug = 7.2;

        // Ciqual 11004
        Castraveti_Murati.calories = 19;
        Castraveti_Murati.proteins = 1.06; // how can they have more proteins in vinegar?
        Castraveti_Murati.sugars = 0.6;
        Castraveti_Murati.fibers = 1.5;
        Castraveti_Murati.starch = 0.78 - Castraveti_Murati.sugars;
        Castraveti_Murati.salt = 1.72;
        Castraveti_Murati.calciumMg = 65;
        Castraveti_Murati.copperMg = 0.05;
        Castraveti_Murati.ironMg = 0.25;
        Castraveti_Murati.magnesiumMg = 23;
        Castraveti_Murati.manganeseMg = 0.06;
        Castraveti_Murati.phosphorusMg = 26;
        Castraveti_Murati.potassiumMg = 120;
        Castraveti_Murati.sodiumMg = 689;
        Castraveti_Murati.zincMg = 0.13;
        Castraveti_Murati.betaCaroteneMug = 369;
        Castraveti_Murati.eMg = 0.48;
        Castraveti_Murati.k1PhylloquinoneMug = 42.8;
        Castraveti_Murati.b1thiaminMg = 0.13;
        Castraveti_Murati.b3niacinMg = 0.2;
        Castraveti_Murati.b5pantothenicAcidMg = 0.11;
        Castraveti_Murati.b9folateMug = 11.5;
        
    }
}
