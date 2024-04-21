package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Dragonite extends Pokemon{
    public Dragonite() {
        super(CardBuyPrices.Dragonite.price, CardSellPrices.Dragonite.price, CardNames.Dragonite.name, "fire",
                120,40);
    }
}
