public class Weapon extends Item {

    public String name;
    public int damage;
    public Weapon(int ItemID){
        super(ItemID);
        if(super.getItemID() == 0){
            this.name = "Fists";
            this.damage = 1;
        }else if(super.getItemID() == 1){
            this.name = "Rusty dagger";
            this.damage = 2;

        }

    }



    public int getDamage(){
        return this.damage;
    }

    public String getType(){
        return "Weapon";
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.damage + " damage";
    }
}
