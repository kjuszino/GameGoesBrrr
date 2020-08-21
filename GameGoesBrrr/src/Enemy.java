public interface Enemy {
    int getLoot();
    int getHealth();
    int getDamage();
    void attack(Damageable damageable);
    int getCoinLoot();

}
