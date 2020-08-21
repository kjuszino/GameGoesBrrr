public class Potion extends Item {
    private int healAmount;
    public Potion(int itemID) {
        super(itemID);
        if(itemID == 1001){
            super.setName("Small Health Potion");
            this.healAmount = 20;
        }
    }

    public int getHealAmount(){
        return this.healAmount;
    }
}
