public class Character implements Damageable {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;

    public Character(String name){
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.damage = 5;
    }
    //Changes the name of the character
    public void changeName(String newName){
        this.name = newName;
    }

    public String getName(){

        return this.name;
    }

    public int getHealth(){

        return this.health;
    }
    //returns player's damage
    public int getDamage(){

        return this.damage;
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
    //Deals damage to the object implementing Damageable interface
    public void attack(Damageable damageable) {
        damageable.takeDamage(this.damage);

    }
}
