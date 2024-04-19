package model.Cards;

public class Card {
    private int buyValue;
    private int sellValue;
    private String name;
    private String type;

    public Card(int buyValue, int sellValue, String name, String type) {
        this.buyValue = buyValue;
        this.sellValue = sellValue;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getBuyValue() {
        return buyValue;
    }

    public int getSellValue() {
        return sellValue;
    }

    public String getName() {
        return name;
    }
}
