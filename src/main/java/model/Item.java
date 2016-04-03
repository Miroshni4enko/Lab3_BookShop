package model;

/**
 * Created by Фокстрот on 02.04.2016.
 */
public class Item {
    private int idItem;
    private String name;
    private String description;
    private int parent;
    private ItemType type;

    public Item(int id, String name, String des,int par,ItemType itemType){
        this.idItem=id;
        this.name=name;
        this.description=des;
        this.parent=par;
        this.type=itemType;
    }
    public enum ItemType {
        Rubric,
        Section;
    }

}
