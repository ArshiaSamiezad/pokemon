package enums;

public enum CardBuyPrices {
    Dragonite(10),
    Tepig(13),
    Lugia(11),
    Ducklett(15),
    Pineco(9),
    Rowlet(12),
    PinkEnergy(5),
    YellowEnergy(5);

    public final int price;

    CardBuyPrices(int price) {
        this.price = price;
    }
}
