package tudor.foodScheduler.model;

/** Spices have the characteristic of giving a lot of taste, for a few calories
 * Most of them are dried and stored, so they are not seasonal */
public enum Spice {
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
    Ghimbir,
    Iuteala,
    Leustean,
    Marar,
    Mustar,
    Oregano,
    Pastarnac,
    Patrunjel,
    Rozmarin,
    Scortisoara,
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
