package model;

import exception.DataBaseException;

import java.sql.Connection;
import java.util.List;

/**
 * Interface that describes the communication with the database.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public interface ModelDataBase {

    Connection getConnection();
    // boolean isConnection();

    void updateBook(Book book)throws DataBaseException;
    void updateAuthor(Author author)throws DataBaseException;
    void updateOrder(Order order)throws DataBaseException;
    void updateCustomer(Customer customer)throws DataBaseException;
    void updateRubric(Item rubric) throws DataBaseException;
    void updateSection(Item section) throws DataBaseException;

    void createCustomer(Customer customer)throws DataBaseException;
    void createOrder(Order order)throws DataBaseException;
    void createBook(Book book)throws DataBaseException;
    void createAuthor(Author author)throws DataBaseException;
    void createRubric(Item rubric) throws DataBaseException;
    void createSection(Item section) throws DataBaseException;

    void removeBook(int bookId)throws DataBaseException;
    void removeAuthor(int authorId)throws DataBaseException;
    void removeOrder(int orderId)throws DataBaseException;
    void removeCustomer(int customerId)throws DataBaseException;
    void removeRubric(int rubricId) throws DataBaseException;
    void removeSection(int sectionId) throws DataBaseException;

    List<Customer> getAllCustomer() throws DataBaseException;
    List<Author> getAllAuthor() throws DataBaseException;
    List<Order> getAllOrder() throws DataBaseException;
    List<Item> getAllRubric() throws DataBaseException;
    List<Item> getAllSection() throws DataBaseException;
    List<Book> getAllBooks() throws DataBaseException;

    Book getBookById(int bookId) throws DataBaseException;
    Customer getCustomerById(int customerId) throws DataBaseException;
    Order getOrderById(int orderId) throws DataBaseException;
    Author getAuthorById(int authorId) throws DataBaseException;
    Item getRubricById(int rubricId) throws DataBaseException;
    Item getSectionById(int sectionId) throws DataBaseException;

}
