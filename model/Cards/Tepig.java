package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Tepig extends Pokemon{
    public Tepig() {
        super(CardBuyPrices.Tepig.price, CardSellPrices.Tepig.price, CardNames.Tepig.name, "fire");
    }
}
