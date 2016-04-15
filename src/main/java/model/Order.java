package model;



import java.util.*;

/**
 * Class that describes the order's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Order {

    private  int                       idOrder;
    private Customer                   customer;
    private Date                       dateOfOrder;
    private ArrayList<ContentOrder>    content;

    public Order(int id, Customer customer,Date dateOfOrder,ArrayList<ContentOrder>  con ) {
        content = new ArrayList<>();
        this.idOrder = id;
        this.customer = customer;
        this.dateOfOrder = dateOfOrder;
        this.content=con;

    }
    public Order(int id, Customer customer,Date dateOfOrder ) {
        content = new ArrayList<>();
        this.idOrder = id;
        this.customer = customer;
        this.dateOfOrder = dateOfOrder;


    }
    public Order(){
        content = new ArrayList<>();
    }
    public int getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(int id) {
        this.idOrder = id;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public ArrayList<ContentOrder>  getContents() {
        return content;
    }

    public void setContents(ArrayList<ContentOrder>  contents) {
        this.content = contents;
    }
    public void addCon(ContentOrder con){
        content.add(con);
    }


    public class ContentOrder{

        private Book   book;
        private int    amount;

        public ContentOrder(){

        }

        public Book getBooks() {
            return book;
        }

        public int getAmount() {
            return amount;
        }

        public void setBook(Book book,int count){
            this.book=book;
            this.amount=count;
        }
        public void removeBook(){
            this.book=null;
            this.amount=0;
        }

    }

}
