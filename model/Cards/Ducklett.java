package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;
import model.Game;
import model.Player;

public class Ducklett extends Pokemon {
    public Ducklett() {
        super(CardBuyPrices.Ducklett.price, CardSellPrices.Ducklett.price, CardNames.Ducklett.name, "water",
                70, 20, 0.6, 1, 1, 1.5, 0);
    }

    public void doPassive(Game game, Player player, Player enemy, Pokemon enemyPokemon) {
        if (enemyPokemon.getEnergy1() != null) {
            enemyPokemon.setEnergy1(null);
        }
        if (enemyPokemon.getEnergy2() != null) {
            enemyPokemon.setEnergy2(null);
        }
    }

    public void doAction(Game game, Player player, Player enemy, Pokemon enemyPokemon) {
        Pokemon playerPokemon = player.getActiveCard();
        double damage = playerPokemon.getDamageToTarget(enemyPokemon);
        if (enemyPokemon.getShield() > 0) {
            if (damage > enemyPokemon.getShield()) {
                damage = damage - enemyPokemon.getShield();
                enemyPokemon.setShield(0);
            } else {
                enemyPokemon.setShield(enemyPokemon.getShield() - damage);
                damage = 0;
                return;
            }
        }

        if (damage >= enemyPokemon.getHitpoint()) {
            enemyPokemon.setHitpoint(0);
            return;
        } else {
            enemyPokemon.setHitpoint(enemyPokemon.getHitpoint() - damage);
        }
    }
}
