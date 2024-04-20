package model.Cards;

public class Pokemon extends Card{

    private Energy energy1;
    private Energy energy2;
    public Pokemon(int buyValue, int sellValue, String name, String type) {
        super(buyValue, sellValue, name, type);
        this.energy1=null;
        this.energy2=null;
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
}
