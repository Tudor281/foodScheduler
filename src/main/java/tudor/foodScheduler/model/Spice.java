package tudor.foodScheduler.model;

/** Spices have the characteristic of giving a lot of taste, for a few calories
 * Most of them are dried and stored, so they are not seasonal */
public enum Spice {
    Apio (true),
    BoiaAfumata,
    BoiaDulce,
    BoiaIute,
    Busuioc,
    Chimen,
    Cimbru,
    Coriandru,
    Curry,
    Curcuma,
    Dafin,
    FrunzeTelina,
    FuchsFasole,
    Iuteala,
    Leustean,
    Pastarnac,
    Patrunjel,
    Rozmarin,
    Marar,
    Mustar,
    SucLamaie,
    Tarhon,
    Telina(true),
    Usturoi,
    VinAlb;

    public boolean perishable = false;

    Spice() {}
    Spice(boolean perishable) {
        this.perishable = perishable;
    }
}
