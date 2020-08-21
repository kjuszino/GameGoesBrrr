public class Chestplate extends Armor {

    public Chestplate(int itemID) {
        super(itemID);
        if(itemID == 201){
            super.setName("T-shirt");
            super.setDurability(5);
        }
        if(itemID == 202){
            super.setName("placeholder");
            super.setDurability(0);
        }
    }
}
