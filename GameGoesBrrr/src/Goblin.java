public class Goblin implements Enemy, Damageable {
    private int health;
    private int damage;

    public Goblin(){
        this.health = 10;
        this.damage = 3;
    }
    @Override
    public void takeDamage(int damage) {
        if(this.health-damage>=0){
            this.health -=damage;
        }else{
            this.health = 0;
        }

    }

    @Override
    public int getLoot() {
        return 1;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void attack(Damageable damageable){
        damageable.takeDamage(this.damage);
    }

    @Override
    public String toString(){
        return "Goblin";
    }
}
