package model;

import model.Cards.Card;
import model.Cards.Pokemon;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private User user1;
    private User user2;
    private double allHitpoints1;
    private double allHitpoints2;
    private Player activePlayer;
    private int round;

    public Game(Player player1, Player player2,User user1, User user2) {
        this.player1 = player1;
        this.player2 = player2;
        this.user1 = user1;
        this.user2 = user2;
        this.activePlayer = player1;
        this.round=1;
        this.allHitpoints1=this.getAllHitpoints(player1);
        this.allHitpoints2=this.getAllHitpoints(player2);
    }

    public double getAllHitpoints(Player player){
        double maxHitpoints=0;
        ArrayList<Card> cards = player.getDeckCards();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) instanceof Pokemon) {
                maxHitpoints += ((Pokemon) cards.get(i)).getHitpoint();
            }
        }
        if (player.getActiveCard() != null) {
            maxHitpoints += player.getActiveCard().getHitpoint();
        }
        if (player.getBenchCard1() != null) {
            maxHitpoints += player.getBenchCard1().getHitpoint();
        }
        if (player.getBenchCard2() != null) {
            maxHitpoints += player.getBenchCard2().getHitpoint();
        }
        if (player.getBenchCard3() != null) {
            maxHitpoints += player.getBenchCard3().getHitpoint();
        }
        return maxHitpoints;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getEnemy(){
        if(activePlayer.equals(player1)){
            return player2;
        }
        return player1;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public double getAllHitpoints1() {
        return allHitpoints1;
    }

    public double getAllHitpoints2() {
        return allHitpoints2;
    }
}
