package model;

/**
 * Class that describes the item's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Item {
    private final int idItem;
    private String name;
    private String description;
   // private int parent;
    private ItemType type;
    private String parent;


    public Item(int id, String name, String des,String par,ItemType itemType){
        this.idItem=id;
        this.name=name;
        this.description=des;
        this.parent=par;
        this.type=itemType;
    }
    public enum ItemType {
        Rubric,
        Book,
        Section;
    }
    public Item(int id ){
        this.idItem=id;
    }
    public int getId() {
        return idItem;
    }
    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
