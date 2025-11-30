package tudor.foodScheduler.model;

import java.text.DecimalFormat;

public class Nutrients {
    public Float kCalSpecific;
    public Float kCalGeneral;
    public Float kCalLegacy;

    public Float protein;
    public Float sugarsTotal;

    public Float totalLipidFat;
    public Float totalFatNLEA; // nutrition-labeling value defined by U.S. law (Nutrition Labeling and Education Act), which may be calculated differently to match FDA labeling rules. (E mai mic decat totalFat)

    static DecimalFormat df = new DecimalFormat("#.##");

    public void loadNutrient(String nutrientIdUnparsed, String quantityUnparsed) {
        String nutrientIdParsed = nutrientIdUnparsed.replace("\"", "");

        float quantity = Float.parseFloat(quantityUnparsed.replace("\"", ""));

        switch (nutrientIdParsed) {
            case "1003" : {protein = quantity; break;} // protein
            case "1004" : {totalLipidFat = quantity; break;} // totalLipidFat
            case "1008" : {kCalGeneral = quantity;break;}// kcal legacy
            case "1063" : {sugarsTotal = quantity;break;} // Sugars Total
            case "1085" : {totalFatNLEA = quantity; break;} // total fat NLEA
            case "2047" : {kCalGeneral = quantity;break;} // kcal general
            case "2048" : {kCalSpecific = quantity;break;} // kcal specific
        }
    }

    public String toString() {
        if (kCalGeneral == null && kCalSpecific == null && kCalLegacy == null && protein == null && sugarsTotal == null && totalLipidFat == null && totalFatNLEA == null) return "all null";

        String kCalSymbol;
        float calories;
        if (kCalSpecific != null) {
            kCalSymbol = "S";
            calories = kCalSpecific;
        } else if (kCalGeneral != null) {
            kCalSymbol = "G";
            calories = kCalGeneral;
        } else if (kCalLegacy != null) {
            kCalSymbol = "L";
            calories = kCalLegacy;
        } else {
            kCalSymbol = "C";
            calories = (protein != null ? protein : 0) * 4 +
                    (sugarsTotal != null ? sugarsTotal : 0) * 4 +
                    (totalLipidFat != null ? totalLipidFat : totalFatNLEA != null ? totalFatNLEA : 0) * 9;
        }
        return df.format(calories) + "kCal (" + kCalSymbol + ")\t";
    }
}
