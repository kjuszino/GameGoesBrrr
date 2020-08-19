public class Dog implements Enemy, Damageable {
    private int health;
    private int damage;

    public Dog(){
        this.health = 5;
        this.damage = 5;
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
        return "Dog";
    }
}
