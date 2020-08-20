import java.util.ArrayList;
public class Inventory {
    private ArrayList<Weapon> weapons;
    private ArrayList<Item> items;

    public Inventory(){
        this.items = new ArrayList<>();
    }

    public void add(int ID){

        if(ID <= 200){
            Weapon weapon = new Weapon(ID);
            this.items.add(weapon);
            return;
        }
        Item item = new Item(ID);
        this.items.add(item);
    }

    public void print(){
        if(this.items.size()>0){
            System.out.println("Inventory:");
            this.items.stream().forEach(i -> System.out.println(i.getName()));
            return;
        }
        System.out.println("Inventory is empty");

    }
    public void remove(int itemID){
        for(int i = 0; i<this.items.size(); i++){
            if(this.items.get(i).getItemID() == itemID){
                this.items.remove(i);
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

    public Item itemByName(String name){
        for(int i = 0; i<this.items.size(); i++){
            if(this.items.get(i).getName().equals(name)){
                return this.items.get(i);
            }
        }
        return null;
    }


    public void remove(Item item){
        for(int i = 0; i<this.items.size(); i++){
            if(this.items.get(i).getItemID() == item.getItemID()){
                this.items.remove(i);
            }
        }
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }

    public Item itemByID(int ID){
        for(int i = 0; i<this.items.size(); i++){
            if(this.items.get(i).getItemID() == ID){
                return this.items.get(i);
            }
        }
        return null;
    }
}
