public class Leggings extends Armor {

    public Leggings(int itemID){
        super(itemID);
        if(itemID == 601){
            super.setName("Jeans");
            super.setDurability(4);
        }
        if(itemID == 602){
            super.setName("placeholder");
            super.setDurability(0);
        }
    }
}
