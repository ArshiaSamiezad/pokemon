package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Pineco extends Pokemon{
    public Pineco() {
        super(CardBuyPrices.Pineco.price, CardSellPrices.Pineco.price, CardNames.Pineco.name, "plant");
    }
}
