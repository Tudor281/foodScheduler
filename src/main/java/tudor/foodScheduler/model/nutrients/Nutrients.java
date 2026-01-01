package tudor.foodScheduler.model.nutrients;

import tudor.foodScheduler.model.Tuple;

import java.text.DecimalFormat;

public class Nutrients {
    public Float kCalSpecific;
    public Float kCalGeneral;
    public Float kCalLegacy;

    public Float protein;

    public Float carbohydrateByDifference;
    public Float sugarsTotal;

    public Float totalLipidFat;
    public Float totalFatNLEA; // nutrition-labeling value defined by U.S. law (Nutrition Labeling and Education Act), which may be calculated differently to match FDA labeling rules. (E mai mic decat totalFat)

    /*
     * True vitamin A is retinol coming from animal sources.
     *
     */
    public Float vitaminARAE;
    public Float vitaminCTotalAscorbicAcid;
    public Float vitaminB6;
    public Float vitaminB12;
    public Float vitaminE;
    public Float vitaminKMena;
    public Float vitaminKDihy;
    public Float vitaminKPhyllo;

    public Float thiamin;
    public Float riboflavin;
    public Float folate;
    public Float niacin;
    public Float choline;
    public Float pantothenicAcid;
    public Float biotin;

    public Float calcium;
    public Float chloride; // Food Data Central does not track chloride. Is dependent on the agricultural means. A defficiency is extremely rare since it's covered abundently by salt.
    public Float copper;
    public Float iodine;
    public Float iron;
    public Float magnesium;
    public Float manganese;
    public Float molybdenum;
    public Float phosphorus;
    public Float potassium;
    public Float selenium;
    public Float sodium;
    public Float zinc;

    // omega 6
    public Float PUFA18c2o6;
    public Float PUFA18c3o6;
    public Float PUFA20c2o6;
    public Float PUFA20c3o6;
    public Float PUFA20c4o6;

    // omega 3
    public Float PUFA18c3o3;
    public Float PUFA20c3o3;
    public Float PUFA20c4o3;
    public Float PUFA20c5o3;
    public Float PUFA22c5o3;
    public Float PUFA22c6o3;


    public static DecimalFormat doubleDigitFormatter = new DecimalFormat("#.##");

    public void loadNutrient(String nutrientIdUnparsed, String quantityUnparsed) {
        String nutrientIdParsed = nutrientIdUnparsed.replace("\"", "");

        float quantity = Float.parseFloat(quantityUnparsed.replace("\"", ""));

        switch (nutrientIdParsed) {
            case "1003" : {protein = quantity; break;}
            case "1004" : {totalLipidFat = quantity; break;}
            case "1005" : {carbohydrateByDifference = quantity; break;}
            case "1008" : {kCalLegacy = quantity;break;}
            case "1063" : {sugarsTotal = quantity;break;}
            case "1085" : {totalFatNLEA = quantity; break;}
            case "1087" : {calcium = quantity; break;}
            case "1089" : {iron = quantity; break;}
            case "1090" : {magnesium = quantity; break;}
            case "1091" : {phosphorus = quantity; break;}
            case "1092" : {potassium = quantity; break;}
            case "1093" : {sodium = quantity; break;}
            case "1095" : {zinc = quantity; break;}
            case "1098" : {copper = quantity; break;}
            case "1100" : {iodine = quantity; break;}
            case "1101" : {manganese = quantity; break;}
            case "1102" : {molybdenum = quantity; break;}
            case "1103" : {selenium = quantity; break;}
            case "1106" : {vitaminARAE = quantity; break;}
            case "1109" : {vitaminE = quantity; break;}
            case "1162" : {vitaminCTotalAscorbicAcid = quantity; break;}
            case "1165" : {thiamin = quantity; break;}
            case "1166" : {riboflavin = quantity; break;}
            case "1167" : {niacin = quantity; break;}
            case "1170" : {pantothenicAcid = quantity; break;}
            case "1175" : {vitaminB6 = quantity; break;}
            case "1176" : {biotin = quantity; break;}
            case "1177" : {folate = quantity; break;}
            case "1178" : {vitaminB12 = quantity; break; }
            case "1180" : {choline = quantity; break;}
            case "1183" : {vitaminKMena = quantity; break;}
            case "1184" : {vitaminKDihy = quantity; break;}
            case "1185" : {vitaminKPhyllo = quantity; break;}
            case "1272" : {PUFA22c6o3 = quantity; break;}
            case "1278" : {PUFA20c5o3 = quantity; break;}
            case "1280" : {PUFA22c5o3 = quantity; break;}
            case "1313" : {PUFA20c2o6 = quantity; break;}
            case "1316" : {PUFA18c2o6 = quantity; break;}
            case "1321" : {PUFA18c3o6 = quantity; break;}
            case "1404" : {PUFA18c3o3 = quantity; break;}
            case "1405" : {PUFA20c3o3 = quantity; break;}
            case "1406" : {PUFA20c3o6 = quantity; break;}
            case "1407" : {PUFA20c4o3 = quantity; break;}
            case "1408" : {PUFA20c4o6 = quantity; break;}
            case "2047" : {kCalGeneral = quantity;break;}
            case "2048" : {kCalSpecific = quantity;break;}
        }
    }

    public String toString() {
        Tuple<String, Float> kCal = getKCal();
        return (kCal.b != null ? doubleDigitFormatter.format(kCal.b) : "null") + "\t" + kCal.a + "\t" +
                doubleDigitFormatter.format(getProtein()) + "%\t" + //g
                doubleDigitFormatter.format(getFat()) + "%\t" + //g
                doubleDigitFormatter.format(getCarbs()) + "%\t" + //g
                doubleDigitFormatter.format(getVitaminARAE()) + "\t"+ //RAE UG
                doubleDigitFormatter.format(getVitaminC()) + "\t"+  //mg
                doubleDigitFormatter.format(getVitaminB6()) + "\t" + //mg
                doubleDigitFormatter.format(getVitaminB12()) + "\t" + // mcg
                doubleDigitFormatter.format(getVitaminE()) + "\t" + // mg
                doubleDigitFormatter.format(getVitaminK()) + "\t" + // mcg
                doubleDigitFormatter.format(getThiamin()) + "\t" + // mg;
                doubleDigitFormatter.format(getRiboflavin()) + "\t" + //mg
                doubleDigitFormatter.format(getFolate()) + "\t" + // mcg
                doubleDigitFormatter.format(getNiacin()) + "\t" + // mg
                doubleDigitFormatter.format(getCholine()) + "\t" + // mg
                doubleDigitFormatter.format(getPantothenicAcid()) + "\t" + // mg
                doubleDigitFormatter.format(getBiotin()) + "\t" + //mcg
                doubleDigitFormatter.format(getCalcium()) + "\t" + // mg
                doubleDigitFormatter.format(getChloride()) + "\t" + // g
                doubleDigitFormatter.format(getCopper()) + "\t" + // mcg
                doubleDigitFormatter.format(getIodine()) + "\t" + // mcg
                doubleDigitFormatter.format(getIron()) + "\t" + // mg
                doubleDigitFormatter.format(getMagnesium()) + "\t" + // mg
                doubleDigitFormatter.format(getManganese()) + "\t" + // mg
                doubleDigitFormatter.format(getMolybdenum()) + "\t" + // mcg
                doubleDigitFormatter.format(getPhosphorus()) + "\t" + // mg
                doubleDigitFormatter.format(getPotassium()) + "\t" + // mg
                doubleDigitFormatter.format(getSelenium()) + "\t" + // mcg
                doubleDigitFormatter.format(getSodium()) + "\t" + // mg
                doubleDigitFormatter.format(getZinc()) + "\t" + // mg
                doubleDigitFormatter.format(getOmega6()) + "\t" + // g
                doubleDigitFormatter.format(getOmega3()) // g
                ;
    }

    public Tuple<String, Float> getKCal() {
        if (kCalGeneral == null && kCalSpecific == null && kCalLegacy == null && protein == null && sugarsTotal == null && totalLipidFat == null && totalFatNLEA == null) return new Tuple<>("null", null);

        if (kCalSpecific != null) {
            return new Tuple<>("S", kCalSpecific);
        } else if (kCalGeneral != null) {
            return new Tuple<>("G", kCalGeneral);
        } else if (kCalLegacy != null) {
            return new Tuple<>("L", kCalLegacy);
        } else {
            return new Tuple<>("C", getProtein() * 4 + getCarbs() * 4 + getFat() * 9);
        }
    }

    public float getProtein() {
        return protein != null ? protein : 0;
    }

    public float getFat() {
        return totalLipidFat != null ? totalLipidFat : totalFatNLEA != null ? totalFatNLEA : 0;
    }

    public float getCarbs() {
        return carbohydrateByDifference != null ? carbohydrateByDifference : sugarsTotal != null ? sugarsTotal : 0;
    }

    public float getVitaminARAE() {
        return vitaminARAE != null ? vitaminARAE : 0;
    }

    public float getVitaminC() {
        return vitaminCTotalAscorbicAcid != null ? vitaminCTotalAscorbicAcid : 0;
    }

    public float getVitaminB6() {
        return vitaminB6 != null ? vitaminB6 : 0;
    }

    public float getVitaminB12() {
        return vitaminB12 != null ? vitaminB12 : 0;
    }

    public float getVitaminE() {
        return vitaminE != null ? vitaminE : 0;
    }

    public float getVitaminK() {
        return (vitaminKMena !=  null ? vitaminKMena : 0) + (vitaminKDihy != null ? vitaminKDihy : 0) + (vitaminKPhyllo != null ? vitaminKPhyllo : 0);
    }

    public float getThiamin() {
        return thiamin != null ? thiamin : 0;
    }

    public float getRiboflavin() { return riboflavin != null ? riboflavin : 0; }

    public float getFolate() { return folate != null ? folate : 0; }

    public float getNiacin() { return niacin != null ? niacin : 0; }

    public float getCholine() {
        return choline != null ? choline : 0;
    }

    public float getPantothenicAcid() { return pantothenicAcid != null ? pantothenicAcid : 0; }

    public float getBiotin() {return biotin != null ? biotin : 0; }

    public float getCalcium() { return calcium != null ? calcium : 0; }

    public float getChloride() {return chloride != null ? chloride : 0; }

    public float getCopper() { return copper != null ? copper : 0; }

    public float getIodine() { return iodine != null ? iodine : 0; }

    public float getIron() { return iron != null ? iron : 0; }

    public float getMagnesium() { return magnesium != null ? magnesium : 0; }

    public float getManganese() { return manganese != null ? manganese : 0; }

    public float getMolybdenum() { return molybdenum != null ? molybdenum : 0; }

    public float getPhosphorus() {return phosphorus != null ? phosphorus : 0; }

    public float getPotassium() { return potassium != null ? potassium : 0; }

    public float getSelenium() { return selenium != null ? selenium : 0; }

    public float getSodium() { return sodium != null ? sodium : 0; }

    public float getZinc() {return zinc != null ? zinc : 0; }

    public float getOmega6() {
        return (PUFA18c2o6 != null ? PUFA18c2o6 : 0)
                + (PUFA18c3o6 != null ? PUFA18c3o6 : 0)
                + (PUFA20c2o6 != null ? PUFA20c2o6 : 0)
                + (PUFA20c3o6 != null ? PUFA20c3o6 : 0)
                + (PUFA20c4o6 != null ? PUFA20c4o6 : 0)
                ;
    }

    public float getOmega3() {
        return (PUFA18c3o3 != null ? PUFA18c3o3 : 0)
                + (PUFA20c3o3 != null ? PUFA20c3o3 : 0)
                + (PUFA20c4o3 != null ? PUFA20c4o3 : 0)
                + (PUFA20c5o3 != null ? PUFA20c5o3 : 0)
                + (PUFA22c5o3 != null ? PUFA22c5o3 : 0)
                + (PUFA22c6o3 != null ? PUFA22c6o3 : 0)
                ;
    }
}
