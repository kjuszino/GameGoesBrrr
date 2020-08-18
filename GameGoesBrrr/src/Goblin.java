public class Goblin implements Enemy,Damagable {
    private int health;
    private int damage;

    public Goblin(){
        this.health = 25;
        this.damage = 7;
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
    public void attack(Damagable damagable){
        damagable.takeDamage(this.damage);
    }

    @Override
    public String toString(){
        return "Goblin";
    }
}
