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

    private final int           idOrder;
    private int                 idCustomer;
    private Date                dateOfOrder;
    private ContentOrder        content;

    public Order(int id, int idCustomer,Date dateOfOrder,int con ) {
        this.idOrder = id;
        this.idCustomer = idCustomer;
        this.dateOfOrder = dateOfOrder;
        this.content=new ContentOrder(con);
        //this.contents.add(new ContentOrder(con));

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
