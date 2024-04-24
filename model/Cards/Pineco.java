package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;
import model.Game;
import model.Player;

public class Pineco extends Pokemon {
    public Pineco() {
        super(CardBuyPrices.Pineco.price, CardSellPrices.Pineco.price, CardNames.Pineco.name, "plant",
                110, 25, 0.9, 1, 1, 1, 15);
    }

    public void doPassive(Game game, Player player, Player enemy) {
        return;
    }

    public void doAction(Game game, Player player, Player enemy) {
        Pokemon playerPokemon = player.getActiveCard();
        double heal = playerPokemon.getDamageToTarget(playerPokemon);
        playerPokemon.setHitpoint(playerPokemon.getHitpoint() + heal);
    }
}
