public class Character implements Damagable {
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

    public void changeName(String newName){
        this.name = newName;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public int getDamage(){
        return this.damage;
    }

    @Override
    public void takeDamage(int damage){
        if(this.health-damage>=0){
            this.health -=damage;
        }else{
            this.health = 0;
        }
    }

    public void heal(int amount){
        if(this.health + amount<=this.maxHealth){
            this.health+=amount;
        }else{
            this.health = maxHealth;
        }
    }

    public void attack(Damagable damagable){
        damagable.takeDamage(this.damage);
    }
}
