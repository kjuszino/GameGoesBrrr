public class Helmet extends Armor {

    public Helmet(int itemID){
        super(itemID);
        if(itemID == 401){
            super.setName("Baseball Cap");
            super.setDurability(3);
        }
        if(itemID == 402){
            super.setName("placeholder");
            super.setDurability(0);
        }
    }
}
