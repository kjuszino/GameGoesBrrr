public class Chestplate extends Armor {

    public Chestplate(int itemID) {
        super(itemID);
        if(itemID == 201){
            super.setName("T-shirt");
            super.setDurability(5);
        }else if(itemID == -1){
            super.setName("Placeholder");
            super.setDurability(0);
        }
    }
}
