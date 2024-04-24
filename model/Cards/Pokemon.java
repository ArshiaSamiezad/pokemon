package model.Cards;

import model.*;

public class Pokemon extends Card {

    private Energy energy1;
    private Energy energy2;
    private String condition;
    private double hitpoint;
    private double maxHitpoint;
    private double power;
    private double resistance;
    private double fireEffect;
    private double waterEffect;
    private double plantEffect;
    private double maxShield;
    private double shield;

    public Pokemon(int buyValue, int sellValue, String name, String type, int maxHitpoint, int power, double resistance,
                   double fireEffect, double waterEffect, double plantEffect, int maxShield) {
        super(buyValue, sellValue, name, type);
        this.energy1 = null;
        this.energy2 = null;
        this.condition = "ok";
        this.maxHitpoint = maxHitpoint;
        this.hitpoint = maxHitpoint;
        this.power = power;
        this.resistance = resistance;
        this.fireEffect = fireEffect;
        this.waterEffect = waterEffect;
        this.plantEffect = plantEffect;
        this.maxShield = maxShield;
        this.shield = maxShield;
    }

    public Energy getEnergy1() {
        return energy1;
    }

    public void setEnergy1(Energy energy1) {
        this.energy1 = energy1;
    }

    public Energy getEnergy2() {
        return energy2;
    }

    public void setEnergy2(Energy energy2) {
        this.energy2 = energy2;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getMaxHitpoint() {
        return maxHitpoint;
    }

    public double getPower() {
        return power;
    }

    public double getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(double hitpoint) {
        this.hitpoint = hitpoint;
    }

    public double getResistance() {
        return resistance;
    }

    public double getFireEffect() {
        return fireEffect;
    }

    public double getWaterEffect() {
        return waterEffect;
    }

    public double getPlantEffect() {
        return plantEffect;
    }

    public double getShield() {
        return shield;
    }

    public void setShield(double shield) {
        this.shield = shield;
    }

    public double getMaxShield() {
        return maxShield;
    }

    private double getEnergyValue(Energy energy) {
        if (this.getType().equals("fire")) {
            return energy.getFireEffect();
        } else if (this.getType().equals("water")) {
            return energy.getWaterEffect();
        } else {
            return energy.getPlantEffect();
        }
    }

    private double getTargetWeakness(Pokemon pokemon) {
        if (this.getType().equals("fire")) {
            return pokemon.getFireEffect();
        } else if (this.getType().equals("water")) {
            return pokemon.getWaterEffect();
        } else {
            return pokemon.getPlantEffect();
        }
    }

    private double getTargetResistance(Pokemon pokemon) {
        return pokemon.getResistance();
    }

    public double getDamageToTarget(Pokemon pokemon) {
        double energy1 = 1;
        double energy2 = 1;
        Energy energy;
        if ((energy = getEnergy1()) != null) {
            energy1 = getEnergyValue(energy);
        }
        if ((energy = getEnergy2()) != null) {
            energy2 = getEnergyValue(energy);
        }
        return power * energy1 * energy2 * getTargetResistance(pokemon) * getTargetWeakness(pokemon);
    }

}
