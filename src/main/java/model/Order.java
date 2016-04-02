package model;



import java.util.ArrayList;
import java.util.Date;

/**
 * Class that describes the order's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Order {

    private final int           idOrder;
    private int                 idCustomer;
    private Date                dateOfOrder;
    private ArrayList<Content>  contents;

    public Order(int id) {
        this.idOrder = id;

    }
    public int getIdOrder() {
        return idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public ArrayList<Content> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Content> contents) {
        this.contents = contents;
    }

    public void addContent(Content cont){
        contents.add(cont);

    }
    public void removeContent(Content cont){
        contents.remove(cont);

    }

}
