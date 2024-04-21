package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Tepig extends Pokemon{
    public Tepig() {
        super(CardBuyPrices.Tepig.price, CardSellPrices.Tepig.price, CardNames.Tepig.name, "fire",
                140,25,0.8,1,2,1.3);
    }
}
