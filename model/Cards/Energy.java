package model.Cards;

public class Energy extends Card{
    private double fireEffect;
    private double waterEffect;
    private double plantEffect;
    public Energy(int buyValue, int sellValue, String name,double fireEffect, double waterEffect, double plantEffect) {
        super(buyValue, sellValue, name, "energy");
        this.fireEffect=fireEffect;
        this.waterEffect=waterEffect;
        this.plantEffect=plantEffect;
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
}
