package model;

import model.Cards.*;

import java.util.ArrayList;

public class Player extends User{
    private Pokemon activeCard;
    private Pokemon benchCard1;
    private Pokemon benchCard2;
    private Pokemon benchCard3;
    private boolean playedEnergyThisTurn;
    private int kills;
    private double reduce;
    public Player(User user) {
        super(user.getUsername(), user.getPassword(), user.getEmail());
        this.activeCard=null;
        this.benchCard1=null;
        this.benchCard2=null;
        this.benchCard3=null;
        this.playedEnergyThisTurn=false;
        this.kills=0;
        this.reduce=0;
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

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public double getReduce() {
        return reduce;
    }

    public void setReduce(double reduce) {
        this.reduce = reduce;
    }
}
