public interface Enemy {
    int getLoot();
    int getHealth();
    int getDamage();
    void attack(Damagable damagable);

}
