import java.util.Random;

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
    public int getCoinLoot() {
        Random random = new Random();
        int coinChance = random.nextInt(100);
        if(coinChance>=0 && coinChance <= 50){
            return 1;
        }else if(coinChance >= 51 && coinChance <= 76){
            return 2;
        }else if(coinChance>= 77 && coinChance <= 87){
            return 3;
        }else if(coinChance>= 88 && coinChance <= 95){
            return 4;
        }else if(coinChance >= 96 && coinChance <= 100){
            return 5;
        }
        return -1;
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
