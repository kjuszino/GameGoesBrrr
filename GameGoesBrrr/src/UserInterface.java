import java.util.Scanner;
import java.util.Random;

public class UserInterface {
    private final Scanner scanner;
    private Character mainCharacter;
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.mainCharacter = new Character("Placeholder");

    }
    public void start() throws InterruptedException {


        System.out.println("Hello, what's your name?");
        this.mainCharacter.changeName(scanner.nextLine());
        System.out.println("Hello, " + this.mainCharacter.getName());
        while(this.mainCharacter.getHealth()>0) {
            String advance = scanner.nextLine();
            while(!(advance.equals("quit"))){
                System.out.println(this.mainCharacter.getName() + " takes a step forward");
                System.out.println();
                eventDrawer();
                advance = scanner.nextLine();
            }


        }


    }

    public void eventDrawer() throws InterruptedException {
        Random random = new Random();
        int encounter = random.nextInt(1000);
        if(encounter<=499){
            System.out.println("Nothing happens");
        }else {
            fight(new Goblin());
        }
    }

    public void fight(Enemy enemy) throws InterruptedException {
        while(enemy.getHealth()>0 && this.mainCharacter.getHealth()>0) {
            this.mainCharacter.attack((Damageable) enemy);
            System.out.println(this.mainCharacter.getName() + " attacked " + enemy + " and dealt " + this.mainCharacter.getDamage() + " damage");
            Thread.sleep(300);
            System.out.println(enemy + " has " + enemy.getHealth() + " health left");
            Thread.sleep(500);
            if (enemy.getHealth() < 1) {
                break;
            }
            System.out.println();
            enemy.attack(this.mainCharacter);
            System.out.println(enemy + " attacked " + this.mainCharacter.getName() + " and dealt " + enemy.getDamage() + " damage");
            Thread.sleep(300);
            System.out.println(this.mainCharacter.getName() + " has " + this.mainCharacter.getHealth() + " health left");
            Thread.sleep(500);
            System.out.println();

        }
        System.out.println();
        System.out.println(enemy + " has been defeated by " + this.mainCharacter.getName() + " and dropped " + enemy.getLoot());
    }
}
