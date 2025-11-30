package tudor.foodScheduler.model;

import java.text.DecimalFormat;

public class Nutrients {
    public Float kCalGeneral;
    public Float kCalSpecific;
    public Float kCalLegacy;

    static DecimalFormat df = new DecimalFormat("#.##");

    public String toString() {
        if (kCalGeneral == null && kCalSpecific == null && kCalLegacy == null) return "all null";

        String kCalSymbol;
        float calories;
        if (kCalSpecific != null) {
            kCalSymbol = "S";
            calories = kCalSpecific;
        } else if (kCalGeneral != null) {
            kCalSymbol = "G";
            calories = kCalGeneral;
        } else {
            kCalSymbol = "L";
            calories = kCalLegacy;
        }
        return df.format(calories) + "kCal (" + kCalSymbol + ")\t";
    }
}
