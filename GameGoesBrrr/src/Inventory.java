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
            System.out.println("Inventory:");
            this.weapons.stream().forEach(w -> System.out.println(w.getName()));
            return;
        }
        System.out.println("Inventory is empty");

    }
    public void remove(int itemID){
        for(int i = 0; i<this.weapons.size(); i++){
            if(this.weapons.get(i).getItemID() == itemID){
                this.weapons.remove(i);
            }
        }
    }

    public Weapon weaponByName(String name){
        for(int i = 0; i<this.weapons.size(); i++){
            if(this.weapons.get(i).getName().equals(name)){
                return this.weapons.get(i);
            }
        }
        return null;
    }
    public void remove(Weapon weapon){
        for(int i = 0; i<this.weapons.size(); i++){
            if(this.weapons.get(i).getItemID() == weapon.getItemID()){
                this.weapons.remove(i);
            }
        }
    }
    public ArrayList<Weapon> getItems(){
        return this.weapons;
    }

}
