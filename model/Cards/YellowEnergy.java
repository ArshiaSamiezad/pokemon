package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;

public class YellowEnergy extends Energy{
    public YellowEnergy() {
        super(CardBuyPrices.YellowEnergy.price, CardSellPrices.YellowEnergy.price, CardNames.YellowEnergy.name);
    }
}
