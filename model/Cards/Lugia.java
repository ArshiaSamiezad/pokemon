package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Lugia extends Pokemon{
    public Lugia() {
        super(CardBuyPrices.Lugia.price, CardSellPrices.Lugia.price, CardNames.Lugia.name, "water");
    }
}