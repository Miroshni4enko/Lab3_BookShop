package model;


/**
 * Class that describes the book's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Book extends Item{

    //private int idAuthor;
    private Author author;
    private int pages;
    private int price;
    private int amount;

    public Book(int id, String name, String des, Item rubric, Author author, int pages, int price, int amount) {
        super(id, name, des, rubric, ItemType.Book);
        if(rubric.getType()!=ItemType.Rubric){
            throw  new IllegalArgumentException("This is not a rubric!");
        }
            this.author = author;
            this.pages = pages;
            this.price = price;
            this.amount = amount;


    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
