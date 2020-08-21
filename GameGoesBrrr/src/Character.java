public class Character implements Damageable {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private Weapon weapon;
    private Inventory inventory;
    private Chestplate chestplate;
    private Helmet helmet;
    private Leggings leggings;
    private Currency money;

    public Character(String name){
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.damage = 1;
        this.weapon = new Weapon(2);
        this.inventory = new Inventory();
        this.chestplate = new Chestplate(202);
        this.helmet = new Helmet(402);
        this.leggings = new Leggings(602);
        this.money = new Currency();
    }
    //Changes the name of the character
    public void changeName(String newName){
        this.name = newName;
    }
    public void equip(Equipable equipable){
        if(equipable instanceof Weapon){
            if(!(this.weapon.getName().toLowerCase().equals("placeholder"))){
                this.inventory.add(this.weapon.getItemID());
            }
            this.weapon = (Weapon)equipable;
            this.damage = this.weapon.getDamage();
            this.inventory.remove(this.weapon);
        }
        if(equipable instanceof Chestplate){
            if(!(this.chestplate.getName().toLowerCase().equals("placeholder"))){
                this.inventory.add(this.chestplate.getItemID());
            }
            this.chestplate = (Chestplate) equipable;
            this.maxHealth += this.chestplate.getDurability();
            this.heal(this.helmet.getDurability());
            this.inventory.remove(this.chestplate);
        }
        if(equipable instanceof Helmet){
            if(!(this.helmet.getName().toLowerCase().equals("placeholder"))){
                this.inventory.add(this.helmet.getItemID());
            }
            this.helmet = (Helmet) equipable;
            this.maxHealth += this.helmet.getDurability();
            this.heal(this.helmet.getDurability());
            this.inventory.remove(this.helmet);
        }
        if(equipable instanceof Leggings){
            if(!(this.leggings.getName().toLowerCase().equals("placeholder"))){
                this.inventory.add(this.leggings.getItemID());
            }
            this.leggings = (Leggings) equipable;
            this.maxHealth += this.leggings.getDurability();
            this.heal(this.leggings.getDurability());
            this.inventory.remove(this.leggings);
        }

    }


    public Currency getCurrency(){
        return this.money;
    }
    public String getName(){

        return this.name;
    }
    //returns player's health
    public int getHealth(){

        return this.health;
    }
    //returns player's damage
    public int getDamage(){

        return this.damage;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    //reduces the health by amount provided in the parameter
    @Override
    public void takeDamage(int damage){
        if(this.health-damage>=0){
            this.health -=damage;
        }else{
            this.health = 0;
        }
    }
    //Heals the player
    public void heal(int amount){

        if(this.health + amount<=this.maxHealth){
            this.health+=amount;

        }else{

            this.health = maxHealth;

        }
    }

    public int amountHealed(int amount){
        if(this.health + amount <= maxHealth){
            return amount;
        }else{
            int healed = this.maxHealth - this.health;
            return healed;
        }
    }
    //Deals damage to the object implementing Damageable interface
    public void attack(Damageable damageable) {
        damageable.takeDamage(this.damage);

    }
}
