package model;

import model.Cards.*;

import java.util.ArrayList;

public class Player extends User {
    private Pokemon activeCard;
    private Pokemon benchCard1;
    private Pokemon benchCard2;
    private Pokemon benchCard3;
    private boolean playedEnergyThisTurn;
    private double reduce;

    public Player(User user) {
        super(user.getUsername(), user.getPassword(), user.getEmail());
        this.setCoins(user.getCoins());
        this.setExperience(user.getExperience());
        this.setDeckCards(user.getDeckCards());
        this.setStorageCards(user.getStorageCards());
        this.setUnequippedCards(user.getUnequippedCards());
        this.activeCard = null;
        this.benchCard1 = null;
        this.benchCard2 = null;
        this.benchCard3 = null;
        this.playedEnergyThisTurn = false;
        this.reduce = 0;
    }

    public Pokemon getActiveCard() {
        return activeCard;
    }

    public void setActiveCard(Pokemon activeCard) {
        this.activeCard = activeCard;
    }

    public Pokemon getBenchCard1() {
        return benchCard1;
    }

    public void setBenchCard1(Pokemon benchCard1) {
        this.benchCard1 = benchCard1;
    }

    public Pokemon getBenchCard2() {
        return benchCard2;
    }

    public void setBenchCard2(Pokemon benchCard2) {
        this.benchCard2 = benchCard2;
    }

    public Pokemon getBenchCard3() {
        return benchCard3;
    }

    public void setBenchCard3(Pokemon benchCard3) {
        this.benchCard3 = benchCard3;
    }

    public boolean isPlayedEnergyThisTurn() {
        return playedEnergyThisTurn;
    }

    public void setPlayedEnergyThisTurn(boolean playedEnergyThisTurn) {
        this.playedEnergyThisTurn = playedEnergyThisTurn;
    }

    public double getReduce() {
        return reduce;
    }

    public void setReduce(double reduce) {
        this.reduce = reduce;
    }

    public int getDead() {
        int numOfAlive = 0;
        ArrayList<Card> cards = getDeckCards();
        numOfAlive += cards.size();
        if (getActiveCard() != null) {
            numOfAlive += 1;
            if (getActiveCard().getEnergy1() != null) numOfAlive += 1;
            if (getActiveCard().getEnergy2() != null) numOfAlive += 1;
        }
        if (getBenchCard1() != null) {
            numOfAlive += 1;
            if (getBenchCard1().getEnergy1() != null) numOfAlive += 1;
            if (getBenchCard1().getEnergy2() != null) numOfAlive += 1;
        }
        if (getBenchCard2() != null) {
            numOfAlive += 1;
            if (getBenchCard2().getEnergy1() != null) numOfAlive += 1;
            if (getBenchCard2().getEnergy2() != null) numOfAlive += 1;
        }
        if (getBenchCard3() != null) {
            numOfAlive += 1;
            if (getBenchCard3().getEnergy1() != null) numOfAlive += 1;
            if (getBenchCard3().getEnergy2() != null) numOfAlive += 1;
        }
        return 12 - numOfAlive;
    }
}
