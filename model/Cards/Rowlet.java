package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Rowlet extends Pokemon{
    public Rowlet() {
        super(CardBuyPrices.Rowlet.price, CardSellPrices.Rowlet.price, CardNames.Rowlet.name, "plant");
    }
}
