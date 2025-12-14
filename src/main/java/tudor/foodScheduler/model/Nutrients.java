package tudor.foodScheduler.model;

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
            case "1106" : {vitaminARAE = quantity; break;}
            case "1162" : {vitaminCTotalAscorbicAcid = quantity; break;}
            case "1175" : {vitaminB6 = quantity; break;}
            case "1178" : {vitaminB12 = quantity; break; }
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
                doubleDigitFormatter.format(getVitaminB12()) + "\t" // mcg
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
}
