package model;



import java.util.ArrayList;
import java.util.Map;

/**
 * Class that describes the contents of orders.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Content {
    private final int               id;
    private ArrayList<Book>         books;
    private Map<Book,Integer>       amount;

    public Content(int id){
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
