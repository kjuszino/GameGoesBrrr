public class Armor extends Item implements Equipable {
    private int durability;

    public Armor(int itemID) {
        super(itemID);
        this.durability = 0;
    }



    public int getDurability(){
        return this.durability;
    }

    public void setDurability(int amount){
        this.durability = amount;
    }





}
