package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Pineco extends Pokemon{
    public Pineco() {
        super(CardBuyPrices.Pineco.price, CardSellPrices.Pineco.price, CardNames.Pineco.name, "plant",
                110,25,0.9,1,1,1);
    }
}
