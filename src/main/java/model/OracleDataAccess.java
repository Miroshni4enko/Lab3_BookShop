package model;

import exception.DataBaseException;
import org.apache.log4j.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Class for connected to Data Base.
 *
 * @author Sasha Kostyan, Veleri Rechembei
 * @version %I%, %G%
 */

public class OracleDataAccess implements ModelDataBase{
    private static final Logger LOG = Logger.getLogger(OracleDataAccess.class);

    protected static class Singleton {
        public static final OracleDataAccess _INSTANCE = new OracleDataAccess();
    }

    public static OracleDataAccess getInstance() {
        return Singleton._INSTANCE;
    }

    private DataSource ds;
    private Context ctx;
    private Hashtable ht = new Hashtable();

    private OracleDataAccess(){
        ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
        try {
            ctx = new InitialContext(ht);
            ds = (javax.sql.DataSource) ctx.lookup("myJNDIDBName"); // change your JNDI_name
        } catch (NamingException e) {
            LOG.error("InitialContext or DataSource error", e);
        }finally {
            try {
                if (ctx != null) {ctx.close();}
            } catch (NamingException e) {
                LOG.error("error of close connection", e);
            }
        }
    }

    /**
     * Method for get connection with database.
     * @return connection with database.
     */
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            LOG.error(e);
        }
        return connection;
    }

    /**
     * Method for disconnected of database.
     * @param connection connection of database.
     * @param result result of query.
     * @param statement statement for query.
     */
    private void disconnect(Connection connection, ResultSet result, Statement statement) {
        try {
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();
            if(result != null)
                result.close();
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

 /*   public boolean isConnection() {
        return false;
    }
*/

    /**
     * Method for update book.
     * @param book book,that needed to update.
     */
    public void updateBook(Book book) {


    }

    /**
     * Method for update author.
     * @param author author,that needed to update.
     */
    public void updateAuthor(Author author) {

    }

    /**
     * Method for update order.
     * @param order order,that needed to update.
     */
    public void updateOrder(Order order) {

    }

    /**
     * Method for update customer.
     * @param customer customer, that needed to update.
     */
    public void updateCustomer(Customer customer) {

    }

    /**
     * Method for create customer.
     * @param customer customer, that needed to create.
     * @return created customer.
     */
    public void createCustomer(Customer customer) throws DataBaseException{
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.CREATE_CUSTOMER);
            statement.setString(1, customer.getLogin());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.geteMail());
            statement.setString(4, customer.getPhone());
            statement.setInt(5, customer.getRole());
            statement.execute();
        } catch (SQLException e) {
            throw new DataBaseException("Exception for create", e);
        } finally {
            disconnect(connection, result, statement);
        }

    }

    /**
     * Method for create order.
     * @param order order, that needed to create.
     * @return created order.
     */
    public void createOrder(Order order) {

    }

    /**
     * Method for create book.
     * @param book book, that needed to create.
     * @return created book.
     */
    public void createBook(Book book) {

    }

    /**
     * Method for create author.
     * @param author author, that needed to create.
     * @return created author.
     */
    public void createAuthor(Author author) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.CREATE_AUTHOR);
            statement.setString(1, author.getSurname());
            statement.setString(2, author.getName());
            statement.execute();
        } catch (SQLException e) {
            throw new DataBaseException("Exception for create", e);
        } finally {
            disconnect(connection, result, statement);
        }
    }

    /**
     * Method for remove book.
     * @param bookId id of book, that needed to remove.
     */
    public void removeBook(int bookId) {

    }

    /**
     * Method for remove author.
     * @param authorId id of author, that needed to remove.
     */
    public void removeAuthor(int authorId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.DELETE_AUTHOR);
            statement.setInt(1, authorId);
            statement.execute();
        } catch (SQLException e) {
            throw new DataBaseException("Exception for remove", e);
        }
        finally {
            disconnect(connection, result, statement);
        }
    }

    /**
     * Method for remove order.
     * @param orderId id of order, that needed to remove.
     */
    public void removeOrder(int orderId) {

    }

    /**
     * Method for remove customer.
     * @param customerId id of customer, that needed to remove.
     */
    public void removeCustomer(int customerId)  throws DataBaseException{
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.DELETE_CUSTOMER);
            statement.setInt(1, customerId);
            statement.execute();
        } catch (SQLException e) {
            throw new DataBaseException("Exception for remove", e);
        }
        finally {
            disconnect(connection, result, statement);
        }
    }

    /**
     * Method for return list of all customers.
     * @return list of all customers.
     * @throws DataBaseException if method have exception.
     */
    public List<Customer> getAllCustomer() throws DataBaseException {

        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Customer> listCustomer = new ArrayList<Customer>();
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_CUSTOMER);
            result = statement.executeQuery();
            while (result.next()) {
                listCustomer.add(getCustomer(result));
            }

        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
       } finally {
            disconnect(connection, result, statement);
        }

        return listCustomer;
    }

    private Customer getCustomer(ResultSet result) throws DataBaseException {
        Customer customer;
        try {
            int id = result.getInt("ID_CUSTOMER");
            String login = result.getString("LOGIN");
            String password = result.getString("PASSWORD");
            String eMail = result.getString("E_MAIL");
            String phone = result.getString("PHOME_NUBMER");
            int role = result.getInt("ROLE");
            customer = new Customer(id, login, password, eMail, phone, role);

        } catch (SQLException e) {
            throw new DataBaseException("Exception with data from result set", e);
        }
        return customer;
    }

    /**
     * Method for return list of all authors.
     * @return list of all authors.
     * @throws DataBaseException if method have exception.
     */
    public List<Author> getAllAuthor() throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Author> listAuthor = new ArrayList<Author>();
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_AUTHOR);
            result = statement.executeQuery();
            while (result.next()) {
                listAuthor.add(getAuthor(result));
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return listAuthor;
    }

    private Author getAuthor(ResultSet result) throws DataBaseException {
        Author author;
        try {
            int id = result.getInt("ID_AUTHOR");
            String surname = result.getString("SURNAME");
            String name = result.getString("NAME");
            author = new Author(id, surname, name);
        } catch (SQLException e) {
            throw new DataBaseException("Exception with data from result set", e);
        }
        return author;
    }

    /**
     * Method for return list of all orders.
     * @return list of all orders.
     * @throws DataBaseException if method have exception.
     */
    public List<Order> getAllOrder() throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Order> listOrder = new ArrayList<Order>();
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_ORDER);
            result = statement.executeQuery();
            while (result.next()) {
                listOrder.add(getOrder(result));
                getConOfOrder(getOrder(result));
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return listOrder;
    }

    private void getConOfOrder(Order order) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_CON_OF_ORDER);
            statement.setInt(1, order.getIdOrder());
            result = statement.executeQuery();
            while (result.next()) {
                int idBook = result.getInt("ID_BOOK");
                int amount = result.getInt("AMOUNT");
                order.getContents().addBook(getBookById(idBook), amount);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }

    }

    private Order getOrder(ResultSet result) throws DataBaseException {
        Order order;
        try {
            int idOr = result.getInt("ID_ORDER");
            int idCus = result.getInt("ID_CUSTOMER");
            Date data = result.getDate("DATE");
            int idCon = result.getInt("ID_CONTENT");
            order = new Order(idOr, idCus, data, idCon);
        } catch (SQLException e) {
            throw new DataBaseException("Exception with data from result set", e);
        }
        return order;
    }

    /**
     *
     * @param bookId
     * @return
     * @throws DataBaseException
     */
    public Book getBookById(int bookId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        Book book = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_BOOK_BY_ID);
            statement.setInt(1, bookId);
            result = statement.executeQuery();
            while (result.next()) {
                book = getBook(result);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return book;
    }

    /**
     *
     * @param customerId
     * @return
     * @throws DataBaseException
     */
    public Customer getCustomerById(int customerId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        Customer cus = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_CUSTOMER_BY_ID);
            statement.setInt(1, customerId);
            result = statement.executeQuery();
            while (result.next()) {
                cus = getCustomer(result);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return cus;
    }

    /**
     *
     * @param orderId
     * @return
     * @throws DataBaseException
     */
    public Order getOrderById(int orderId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        Order order = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ODER_BY_ID);
            statement.setInt(1, orderId);
            result = statement.executeQuery();
            while (result.next()) {
                order = getOrder(result);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return order;
    }

    /**
     *
     * @param authorId
     * @return
     * @throws DataBaseException
     */
    public Author getAuthorById(int authorId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        Author author = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_AUTHOR_BY_ID);
            statement.setInt(1, authorId);
            result = statement.executeQuery();
            while (result.next()) {
                author = getAuthor(result);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return author;
    }

    /**
     *
     * @return
     * @throws DataBaseException
     */
    public List<Item> getAllRubric() throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Item> listRubric = new ArrayList<Item>();
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_RUBRIC);
            result = statement.executeQuery();
            while (result.next()) {
                listRubric.add(getItem(result, Item.ItemType.Rubric));
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return listRubric;
    }

    private Item getItem(ResultSet result, Item.ItemType type) throws DataBaseException {
        Item item;
        try {
            int id = result.getInt("ID_ITEM");
            String name = result.getString("NAME");
            String description = result.getString("DESCRIPTION");
            int par = result.getInt("PARENT_ID");
            String parStr = String.valueOf(par);
            item = new Item(id, name, description, parStr, type);
        } catch (SQLException e) {
            throw new DataBaseException("Exception with data from result set", e);
        }
        return item;
    }

    /**
     *
     * @return
     * @throws DataBaseException
     */
    public List<Item> getAllSection() throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Item> listSection = new ArrayList<Item>();
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_SECTION);
            result = statement.executeQuery();
            while (result.next()) {
                listSection.add(getItem(result, Item.ItemType.Section));
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return listSection;
    }

    public List<Book> getAllBooks() throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        List<Book> listBooks = new ArrayList<Book>();

        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_ALL_BOOK);
            result = statement.executeQuery();
            while (result.next()) {
                listBooks.add(getBook(result));
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return listBooks;
    }
    private Book getBook(ResultSet result) throws DataBaseException {
        Book book;
        try {
            int id = result.getInt("ID_ITEM");
            String name = result.getString("NAME");
            int rubricId = result.getInt("RUBRIC");
            int authorId = result.getInt("AUTHOR");
            int pages = result.getInt("PAGES");
            int price = result.getInt("PRICE");
            int amount = result.getInt("AMOUNT");
            String description = result.getString("DESCRIPTION");
            Author findAuthor = getAuthorById(authorId);
            Item findRubric = getRubricById(rubricId);
            book = new Book(id, name, description, findRubric,findAuthor,pages,price,amount);

        } catch (SQLException e) {
            throw new DataBaseException("Exception with data from result set", e);
        }
        return book;
    }
    /**
     *
     * @param rubricId
     * @throws DataBaseException
     */
    public void removeRubric(int rubricId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.DELETE_RUBRIC);
            statement.setInt(1, rubricId);
            statement.execute();
        } catch (SQLException e) {
            throw new DataBaseException("Exception for remove", e);
        }
        finally {
            disconnect(connection, result, statement);
        }
    }

    /**
     *
     * @param sectionId
     * @throws DataBaseException
     */
    public void removeSection(int sectionId) throws DataBaseException {
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SqlScripts.DELETE_SECTION);
            statement.setInt(1, sectionId);
            statement.execute();
        } catch (SQLException e) {
            throw new DataBaseException("Exception for remove", e);
        }
        finally {
            disconnect(connection, result, statement);
        }
    }

    /**
     *
     * @param rubric
     * @return
     * @throws DataBaseException
     */
    public void createRubric(Item rubric) throws DataBaseException {

    }

    /**
     *
     * @param section
     * @return
     * @throws DataBaseException
     */
    public void createSection(Item section) throws DataBaseException {

    }

    /**
     *
     * @param rubric
     * @throws DataBaseException
     */
    public void updateRubric(Item rubric) throws DataBaseException {

    }

    /**
     *
     * @param section
     * @throws DataBaseException
     */
    public void updateSection(Item section) throws DataBaseException {

    }

    /**
     *
     * @param rubricId
     * @return
     * @throws DataBaseException
     */
    public Item getRubricById(int rubricId)throws DataBaseException{
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        Item rubric = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_RUBRIC_BY_ID);
            statement.setInt(1, rubricId);
            result = statement.executeQuery();
            while (result.next()) {
                rubric = getItem(result,Item.ItemType.Rubric);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return rubric;
    }

    /**
     *
     * @param sectionId
     * @return
     * @throws DataBaseException
     */
    public  Item getSectionById(int sectionId)throws DataBaseException{
        Connection connection = getConnection();
        ResultSet result = null;
        PreparedStatement statement = null;
        Item section = null;
        try {
            statement = connection.prepareStatement(SqlScripts.SELECT_SECTION_BY_ID);
            statement.setInt(1, sectionId);
            result = statement.executeQuery();
            while (result.next()) {
                section = getItem(result,Item.ItemType.Section);
            }
        } catch (Exception e) {
            throw new DataBaseException("Exception with data from database", e);
        } finally {
            disconnect(connection, result, statement);
        }
        return section;
    }
}

