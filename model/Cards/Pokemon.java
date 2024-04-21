package model.Cards;

public class Pokemon extends Card {

    private Energy energy1;
    private Energy energy2;
    private String condition;
    private int hitpoint;
    private int maxHitpoint;
    private int power;
    private double Resistance;
    private double fireEffect;
    private double waterEffect;
    private double plantEffect;

    public Pokemon(int buyValue, int sellValue, String name, String type, int maxHitpoint, int power, double Resistance,
                   double fireEffect, double waterEffect, double plantEffect) {
        super(buyValue, sellValue, name, type);
        this.energy1 = null;
        this.energy2 = null;
        this.condition = null;
        this.maxHitpoint = maxHitpoint;
        this.hitpoint = maxHitpoint;
        this.power = power;
        this.Resistance = Resistance;
        this.fireEffect = fireEffect;
        this.waterEffect = waterEffect;
        this.plantEffect = plantEffect;
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

    public int getMaxHitpoint() {
        return maxHitpoint;
    }

    public int getPower() {
        return power;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

}
