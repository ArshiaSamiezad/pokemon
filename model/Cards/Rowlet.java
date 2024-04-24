package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;
import model.Game;
import model.Player;

public class Rowlet extends Pokemon {
    public Rowlet() {
        super(CardBuyPrices.Rowlet.price, CardSellPrices.Rowlet.price, CardNames.Rowlet.name, "plant",
                180, 40, 0.5, 1.3, 1, 1, 15);
    }

    public void doPassive(Game game, Player player, Player enemy, Pokemon targetPokemon) {
        return;
    }

    public void doAction(Game game, Player player, Player enemy, Pokemon targetPokemon) {
        double heal = player.getActiveCard().getDamageToTarget(targetPokemon);
        targetPokemon.setHitpoint(targetPokemon.getHitpoint() + heal);
    }
}
