import java.util.ArrayList;
public class Inventory {
    public ArrayList<Weapon> weapons;

    public Inventory(){
        this.weapons = new ArrayList<>();
    }

    public void add(Item item){
        if(item.getItemID()<=200){
            Weapon weapon = (Weapon) item;
            this.weapons.add(weapon);
        }
    }

    public void print(){
        if(weapons.size()>0){
            this.weapons.stream().forEach(w -> System.out.println(w.getName()));
            return;
        }
        System.out.println("Inventory is empty");

    }

}
