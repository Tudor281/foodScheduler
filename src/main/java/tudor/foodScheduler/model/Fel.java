package tudor.foodScheduler.model;

public enum Fel {
    F1(0,4),
    F2(1, 4),
    FastFood(2, 15),
    Fruits(3, 20),
    Rece(4, 50),
    Desert(4, 50);

    public final int channel;
    public final int cap;

    Fel(int channel, int cap) {
        this.channel = channel;
        this.cap = cap;
    }
}
