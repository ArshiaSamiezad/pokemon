package enums;

public enum CardSellPrices {
    Dragonite(8),
    Tepig(10),
    Lugia(9),
    Ducklett(11),
    Pineco(7),
    Rowlet(9),
    PinkEnergy(3),
    YellowEnergy(3);

    public final int price;

    CardSellPrices(int price) {
        this.price = price;
    }
}
