package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;
import model.Game;
import model.Player;

public class Lugia extends Pokemon{
    public Lugia() {
        super(CardBuyPrices.Lugia.price, CardSellPrices.Lugia.price, CardNames.Lugia.name, "water",
                90,20,0.7,1.3,1,1,0);
    }

    public void doPassive(Game game, Player player, Player enemy) {
        enemy.getActiveCard().setCondition("sleeping");
    }

    public void doAction(Game game, Player player, Player enemy) {
        Pokemon playerPokemon = player.getActiveCard();
        Pokemon enemyPokemon = enemy.getActiveCard();
        double damage = (int) playerPokemon.getDamageToTarget(enemyPokemon);
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
            player.setReduce(player.getReduce()+enemyPokemon.getHitpoint());
            enemyPokemon.setHitpoint(0);
            return;
        } else {
            player.setReduce(player.getReduce()+damage);
            enemyPokemon.setHitpoint(enemyPokemon.getHitpoint()-damage);
        }

    }
}
