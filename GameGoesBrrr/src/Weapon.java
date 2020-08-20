public class Weapon extends Item implements Equipable {

    public int damage;
    public Weapon(int ItemID){
        super(ItemID);
        if(super.getItemID() == 0){
            super.setName("Fist");
            this.damage = 1;
        }else if(super.getItemID() == 1){
            super.setName("Rusty dagger");
            this.damage = 2;

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
