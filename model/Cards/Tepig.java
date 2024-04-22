package model.Cards;

import enums.CardBuyPrices;
import enums.CardNames;
import enums.CardSellPrices;
import model.Game;
import model.Player;

public class Tepig extends Pokemon {
    public Tepig() {
        super(CardBuyPrices.Tepig.price, CardSellPrices.Tepig.price, CardNames.Tepig.name, "fire",
                140, 25, 0.8, 1, 2, 1.3, 0);
    }

    private void doDamage(Player enemy, Pokemon enemyPokemon, double damage) {
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

    public void doPassive(Game game, Player player, Player enemy) {
        if (!enemy.getActiveCard().getType().equals("water")) {
            enemy.getActiveCard().setCondition("burning");
        }
        if (!enemy.getBenchCard1().getType().equals("water")) {
            enemy.getBenchCard1().setCondition("burning");
        }
        if (!enemy.getBenchCard2().getType().equals("water")) {
            enemy.getBenchCard2().setCondition("burning");
        }
        if (!enemy.getBenchCard3().getType().equals("water")) {
            enemy.getBenchCard3().setCondition("burning");
        }
    }

    public void doAction(Game game, Player player, Player enemy) {
        Pokemon playerPokemon = player.getActiveCard();

        int damage = (int) playerPokemon.getDamageToTarget(enemy.getActiveCard());
        int damage1 = (int) (0.2 * playerPokemon.getDamageToTarget(enemy.getBenchCard1()));
        int damage2 = (int) (0.2 * playerPokemon.getDamageToTarget(enemy.getBenchCard2()));
        int damage3 = (int) (0.2 * playerPokemon.getDamageToTarget(enemy.getBenchCard3()));

        doDamage(enemy, enemy.getActiveCard(), damage);
        doDamage(enemy, enemy.getBenchCard1(), damage1);
        doDamage(enemy, enemy.getBenchCard2(), damage2);
        doDamage(enemy, enemy.getBenchCard3(), damage3);
    }
}
