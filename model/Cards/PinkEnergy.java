package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class PinkEnergy extends Energy {
    public PinkEnergy() {
        super(CardBuyPrices.PinkEnergy.price, CardSellPrices.PinkEnergy.price, CardNames.PinkEnergy.name,
                1, 1.05, 1.15);
    }
}
