package model;


/**
 * Class that describes the book's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class Book extends Item{

    private int idAuthor;
    private int pages;
    private int price;
    private int amount;

    public Book(int id, String name, String des, int par, int idAuthor, int pages, int price, int amount) {
        super(id, name, des, par, ItemType.Book);
        this.idAuthor=idAuthor;
        this.pages=pages;
        this.price=price;
        this.amount=amount;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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
