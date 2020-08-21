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
                            String bruh = this.mainCharacter.getInventory().itemByName(item).getName();
                            this.mainCharacter.equip((Equipable)this.mainCharacter.getInventory().itemByName(item));
                            System.out.println(this.mainCharacter.getName() + " has equipped " + bruh);
                        }else{
                            System.out.println("The item cannot be equipped");
                        }

                    }else{
                        System.out.println(this.mainCharacter.getName() + " doesn't have that item, or the item doesn't exist");
                    }

                    advance = scanner.nextLine();
                    continue;
                }

                // in the print print the getCurrency function
                if(advance.equals("bal")){
                    System.out.println(this.mainCharacter.getCurrency());
                    advance = scanner.nextLine();
                    continue;
                }

                if(advance.equals("help")){
                    System.out.println("Enter - move forward");
                    System.out.println("\"help\" prints the list of commands");
                    System.out.println("\"inventory\" prints the inventory");
                    System.out.println("\"equip\" equips the item with the name provided on the next line");
                    System.out.println("\"heal\" heals using the potion with the name provided on the next line");
                    System.out.println("\"bal\" displays your balance on the next line");

                    advance = scanner.nextLine();
                    continue;
                }

                if(advance.equals("heal")){
                    System.out.println("What health potion do you want to use?");
                    String choice = scanner.nextLine();
                    if(this.mainCharacter.getInventory().getItems().contains(this.mainCharacter.getInventory().itemByName(choice))){
                        Potion potion = new Potion(this.mainCharacter.getInventory().itemByName(choice).getItemID());
                        System.out.println(this.mainCharacter.getName() + " healed for " + this.mainCharacter.amountHealed(potion.getHealAmount()) + " health");
                        this.mainCharacter.heal(potion.getHealAmount());
                        this.mainCharacter.getInventory().remove(potion);
                    }else{
                        System.out.println(this.mainCharacter.getName() + " doesn't have that potion");
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
        }else if(encounter>=997 && encounter<=1000){
            fight(new Dog());
        }
    }

    public void fight(Enemy enemy) throws InterruptedException {
        System.out.println(this.mainCharacter.getName() + " has been ambushed by " + enemy);
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
        int coinDrop = enemy.getCoinLoot();
        if(drop>0){

            this.mainCharacter.getInventory().add(drop);
            this.mainCharacter.getCurrency().addCurrency(coinDrop);
            System.out.println(enemy + " has been defeated by " + this.mainCharacter.getName() + " and dropped " + this.mainCharacter.getInventory().itemByID(drop).getName() + " and " + coinDrop + " coins!");
            return;
        }
        this.mainCharacter.getCurrency().addCurrency(coinDrop);
        System.out.println(enemy + " has been defeated by " + this.mainCharacter.getName() + " and dropped " + coinDrop + " coins!");
    }
}
