package tudor.foodScheduler.model;

public enum Multiplicity {
    AtLeastOnce("AL"),
    AtMostOnce("AM"),
    Disabled("D"),
    Optional("OP"),
    Once("ON");

    public final String shortName;

    Multiplicity(String shortName) {
        this.shortName = shortName;
    }
}
