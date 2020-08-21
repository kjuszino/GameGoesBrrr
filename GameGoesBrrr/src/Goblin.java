import java.util.Random;
public class Goblin implements Enemy, Damageable {
    private int health;
    private int damage;

    public Goblin(){
        this.health = 3;
        this.damage = 3;
    }

    //reduces health by amount provided
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
        Random random =new Random();
        int lootChance = random.nextInt(1000);
        if(lootChance>=0 && lootChance <500){
            return -1;
        }else if(lootChance>=500 && lootChance<600){
            return 1;
        }else if(lootChance>=600 && lootChance<700){
            return 201;
        }else if(lootChance>=700 && lootChance <800){
            return 401;
        }else if(lootChance>=800 && lootChance<900){
           return 601;
        }else if(lootChance>= 900 && lootChance<=1000){
            return 1001;
        }
        return -1;
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
