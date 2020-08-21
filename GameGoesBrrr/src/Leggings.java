public class Leggings extends Armor {

    public Leggings(int itemID){
        super(itemID);
        if(itemID == -3){
            super.setName("placeholder");
            super.setDurability(0);
        }

        if(itemID == 601){
            super.setName("Jeans");
            super.setDurability(4);
        }
    }
}
