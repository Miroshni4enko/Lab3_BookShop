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
    private static final Logger LOG        = Logger.getLogger(OracleDataAccess.class);

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
    public Customer createCustomer(Customer customer) {
        return null;
    }

    /**
     * Method for create order.
     * @param order order, that needed to create.
     * @return created order.
     */
    public Order createOrder(Order order) {
        return null;
    }

    /**
     * Method for create book.
     * @param book book, that needed to create.
     * @return created book.
     */
    public Book createBook(Book book) {
        return null;
    }

    /**
     * Method for create author.
     * @param author author, that needed to create.
     * @return created author.
     */
    public Author createAuthor(Author author) {
        return null;
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
    public void removeAuthor(int authorId) {

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
    public void removeCustomer(int customerId) {

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
            statement = connection.prepareStatement(SqlScripts.selectAllCustomer);
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
            statement = connection.prepareStatement(SqlScripts.selectAllAuthor);
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
            statement = connection.prepareStatement(SqlScripts.selectAllOrder);
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
            statement = connection.prepareStatement(SqlScripts.selectConOfOrder);
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
        return null;
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
            statement = connection.prepareStatement(SqlScripts.selectCustomerById);
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
            statement = connection.prepareStatement(SqlScripts.selectOderById);
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
            statement = connection.prepareStatement(SqlScripts.selectAuthorById);
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
            statement = connection.prepareStatement(SqlScripts.selectAllRubric);
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
            item = new Item(id, name, description, par, type);
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
            statement = connection.prepareStatement(SqlScripts.selectAllSection);
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

    /**
     *
     * @param rubricId
     * @throws DataBaseException
     */
    public void removeRubric(int rubricId) throws DataBaseException {

    }

    /**
     *
     * @param sectionId
     * @throws DataBaseException
     */
    public void removeSection(int sectionId) throws DataBaseException {

    }

    /**
     *
     * @param rubric
     * @return
     * @throws DataBaseException
     */
    public Item createRubric(Item rubric) throws DataBaseException {
        return null;
    }

    /**
     *
     * @param section
     * @return
     * @throws DataBaseException
     */
    public Item createSection(Item section) throws DataBaseException {
        return null;
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
            statement = connection.prepareStatement(SqlScripts.selectRubricById);
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
            statement = connection.prepareStatement(SqlScripts.selectSectionById);
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

