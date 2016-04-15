package model;



import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Class that describes the order's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Order {

    private int                 idOrder;
    private Customer            customer;
    private Date                dateOfOrder;
    private ContentOrder        content;

    public Order(int id, Customer customer,Date dateOfOrder,int con ) {
        this.idOrder = id;
        this.customer = customer;
        this.dateOfOrder = dateOfOrder;
        this.content=new ContentOrder(con);
        //this.contents.add(new ContentOrder(con));

    }
    public Order(){

    }
    public int getIdOrder() {
        return idOrder;
    }

    public Customer getIdCustomer() {
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

    public ContentOrder getContents() {
        return content;
    }

    public void setContents(ContentOrder contents) {
        this.content = contents;
    }

   /* public void addContent(ContentOrder cont){
        contents.add(cont);

    }
    public void removeContent(ContentOrder cont){
        contents.remove(cont);

    }
    */

    public class ContentOrder{
        private final int               id;
        private ArrayList<Book>         books;
        private Map<Book,Integer> amount;
        public ContentOrder(int id){
            this.id=id;
        }

        public int getId() {
            return id;
        }

        public void addSeveralBooks(ArrayList<Book> books, ArrayList<Integer> booksCount){
            for(int i=0; i <=books.size();i++){
                books.add(books.get(i));
                amount.put(books.get(i),booksCount.get(i));
            }

        }
        public ArrayList<Book> getBooks() {
            return books;
        }

        public Map<Book, Integer> getAmount() {
            return amount;
        }

        public void addBook(Book book,int count){
            books.add(book);
            amount.put(book,count);
        }
        public void removeBook(Book book){
            books.remove(book);
            amount.remove(book);
        }

        public void editAmount(Book book,int count){
            amount.put(book,count);
        }
    }

}
