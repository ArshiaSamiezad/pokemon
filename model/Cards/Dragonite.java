package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;
import model.*;

public class Dragonite extends Pokemon {
    public Dragonite() {
        super(CardBuyPrices.Dragonite.price, CardSellPrices.Dragonite.price, CardNames.Dragonite.name, "fire",
                120, 40, 0.7, 1, 1.2, 1, 0);
    }

    public void doPassive(Game game, Player player, Player enemy) {
        if (enemy.getActiveCard().getType().equals("water")) {
            return;
        }
        enemy.getActiveCard().setCondition("burning");
    }

    public void doAction(Game game, Player player, Player enemy) {
        Pokemon playerPokemon = player.getActiveCard();
        Pokemon enemyPokemon = enemy.getActiveCard();
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
            enemy.setActiveCard(null);
            return;
        } else {
            enemyPokemon.setHitpoint(enemyPokemon.getHitpoint() - damage);
        }

    }
}
