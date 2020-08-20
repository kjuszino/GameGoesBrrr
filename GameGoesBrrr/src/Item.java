
public class Item {
    private int itemID;
    private String name;


    public Item(int itemID){
        this.itemID = itemID;
        this.name = "bruh";
    }

    public int getItemID(){
        return this.itemID;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }

        if(!(object instanceof Item)){
            return false;
        }
        Item compared = (Item) object;
        if(this.name.equals(compared.getName())){
            return true;
        }
        return false;

    }

    @Override
    public int hashCode(){
        return itemID * this.name.hashCode();
    }



}
