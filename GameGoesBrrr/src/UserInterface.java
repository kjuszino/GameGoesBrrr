import java.util.Scanner;
import java.util.Random;

public class UserInterface {
    private final Scanner scanner;
    private Character mainCharacter;
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.mainCharacter = new Character("Placeholder");

    }
    //runs the game
    public void start() throws InterruptedException {


        System.out.println("Hello, what's your name?");
        this.mainCharacter.changeName(scanner.nextLine());
        System.out.println("Hello, " + this.mainCharacter.getName());
        System.out.println("To access the list of commands, type in \"help\"");
        Weapon fists = new Weapon(0);
        this.mainCharacter.getInventory().add(0);
        this.mainCharacter.equip(fists);//equips the "fist" weapon
        this.mainCharacter.getInventory().remove(fists);
        while(this.mainCharacter.getHealth()>0) {
            String advance = scanner.nextLine();
            while(!(advance.equals("quit"))){
                if(advance.equals("inventory")){
                    this.mainCharacter.getInventory().print();
                    advance = scanner.nextLine();
                    continue;
                }

                if(advance.equals("equip")){
                    System.out.println("What item do you want to equip?");
                    String item = scanner.nextLine();

                    if(this.mainCharacter.getInventory().getItems().contains(this.mainCharacter.getInventory().itemByName(item))){
                        if(this.mainCharacter.getInventory().itemByName(item) instanceof Equipable){
                            this.mainCharacter.equip((Equipable)this.mainCharacter.getInventory().itemByName(item));
                            System.out.println(this.mainCharacter.getName() + " has equipped " + item);
                        }else{
                            System.out.println("The item cannot be equipped");
                        }

                    }

                    advance = scanner.nextLine();
                    continue;
                }
                System.out.println(this.mainCharacter.getName() + " takes a step forward");
                System.out.println();
                eventDrawer();
                advance = scanner.nextLine();
            }
            break;

        }


    }
    //randomises the event
    public void eventDrawer() throws InterruptedException {
        Random random = new Random();
        int encounter = random.nextInt(1000);
        if(encounter<=499){
            System.out.println("Nothing happens");
        }else if(encounter>=501 && encounter<=990){
            fight(new Goblin());
        }else if(encounter>=991 && encounter<=1000){
            fight(new Dog());
        }
    }

    public void fight(Enemy enemy) throws InterruptedException {
        while(enemy.getHealth()>0 && this.mainCharacter.getHealth()>0) {
            this.mainCharacter.attack((Damageable) enemy);
            System.out.println(this.mainCharacter.getName() + " attacked " + enemy + " and dealt " + this.mainCharacter.getDamage() + " damage");
            Thread.sleep(400);
            System.out.println(enemy + " has " + enemy.getHealth() + " health left");
            Thread.sleep(1000);
            if (enemy.getHealth() < 1) {
                break;
            }
            System.out.println();
            enemy.attack(this.mainCharacter);
            System.out.println(enemy + " attacked " + this.mainCharacter.getName() + " and dealt " + enemy.getDamage() + " damage");
            Thread.sleep(400);
            System.out.println(this.mainCharacter.getName() + " has " + this.mainCharacter.getHealth() + " health left");
            Thread.sleep(1000);
            System.out.println();

        }
        System.out.println();
        int drop = enemy.getLoot();
        if(drop>0){

            this.mainCharacter.getInventory().add(drop);
            System.out.println(enemy + " has been defeated by " + this.mainCharacter.getName() + " and dropped " + this.mainCharacter.getInventory().itemByID(drop).getName());
            return;
        }
        System.out.println(enemy + " has been defeated by " + this.mainCharacter.getName());
    }
}
