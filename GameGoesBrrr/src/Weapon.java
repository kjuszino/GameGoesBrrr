public class Weapon extends Item implements Equipable {

    public int damage;
    public Weapon(int ItemID){
        super(ItemID);
        if(super.getItemID() == 1){
            super.setName("Rusty Dagger");
            this.damage = 2;

        }

        if(super.getItemID() == 2){
            super.setName("placeholder");
            this.damage = 0;
        }

    }



    public int getDamage(){
        return this.damage;
    }

    public String getType(){
        return "Weapon";
    }



    @Override
    public String toString(){
        return super.getName() + " - " + this.damage + " damage";
    }
}
