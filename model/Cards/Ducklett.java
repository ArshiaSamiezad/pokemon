package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class Ducklett extends Pokemon{
    public Ducklett() {
        super(CardBuyPrices.Ducklett.price, CardSellPrices.Ducklett.price, CardNames.Ducklett.name, "water",
                70,20,0.6,1,1,1.5);
    }
}
