package model;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Interface that describes the communication with the database.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public interface ModelDataBase {

    Connection getConnection();

    boolean isConnection();

    void updateBook(Book book);

    void updateAuthor(Author author);

    void updateItem(Item item);

    void updateOrder(Order order);

    void updateCustomer(Customer customer);

    Customer createCustomer(Customer customer);

    Order createOrder(Order order);

    Book createBook(Book book);

    Author createAuthor(Author author);

    Item createItem(Item item);


    void removeBook(Book book);

    void removeAuthor(Author author);

    void removeItem(Item item);

    void removeOrder(Order order);

    void removeCustomer(Customer customer);

    ArrayList<Customer> getAllCustomer();

    ArrayList<Author> getAllAuthor();

    ArrayList<Order> getAllOrder();

    ArrayList<Item> getAllItem();

    void showAllBook();

    void showAllCutomer();

    void showAllItem();

    void showAllAuthor();

    void showAllOrder();

}
