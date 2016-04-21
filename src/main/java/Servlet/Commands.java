package Servlet;

import controller.processors.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that generate commands for servlet.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class Commands {
    private static final Logger LOG = Logger.getLogger(Commands.class);
    private Map<String, Object> map;

    protected static class Singleton {
        public static final Commands _INSTANCE = new Commands();
    }

    private Commands() {
        this.initMap();
    }

    public static Commands getInstance() {
        return Singleton._INSTANCE;
    }

    public Map<String, Object> getCommandsMap(){
        return map;
    }

    private void initMap() {
        map = new HashMap<String, Object>();
        map.put(ACTION_WELCOME, new Welcome());
        map.put(ACTION__ADD_CUSTOMER, new AddCustomer());
        map.put(ACTION_DETAIL, new DetailBook());
        map.put(VIEW_LIST_BOOKS, new ViewListBooks());
        map.put(LOGIN_USER, new LoginUser());
        map.put(ACTION__ADD_ORDER, new AddOrder());
        map.put(ACTION__UPDATE_CUSTOMER, new UpdateCustomer());
        map.put(ACTION_UN_LOGIN, new UnLogin());
        map.put(ACTION__UPDATE_BOOK,new UpdateBook());
    }

    public static void forward(String url, HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    public static final String ACTION__ADD_CUSTOMER = "addCustomer";

    public static final String ACTION_WELCOME       = "welcome";
    public static final String ACTION_DETAIL        = "viewDetailBooks";

    public static final String VIEW_LIST_BOOKS      = "viewListBooks";
    public static       int    AMOUNT_OF_BOOKS_ON_LIST = 6;             // when session starts it equals 6 and after each
    public static final int    PLUS_BOOKS_TO_LIST      = 6;             // request + 6 in ViewListBooks.java
    public static final String LOGIN_USER           = "loginUser";

    public static final String ACTION_EDIT_BOOK     = "editBook";
    public static final String ACTION_UN_LOGIN      = "unLogin";

    public static final String ACTION__UPDATE_CUSTOMER = "updateCustomer";
    public static final String ACTION__UPDATE_BOOK = "updateBook";
    public static final String ACTION__ADD_ORDER = "addOrder";
    /*
     public static final String ACTION_OTHER = "otherAction";
    public static final String ACTION_WELCOME = "welcome";
    public static final String ACTION_VIEW = "view";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION__DELETE = "delete";

    public static final String ACTION__ADD_BOOK = "addBook";
    public static final String ACTION__ADD_AUTHOR = "addAuthor";
    public static final String ACTION__ADD_RUBRIC = "addRubric";
    public static final String ACTION__ADD_SECTION = "addSection";
    public static final String ACTION__ADD_CUSTOMER = "addCustomer";


    public static final String ACTION__DELETE_BOOK = "deleteBook";
    public static final String ACTION__DELETE_AUTHOR = "deleteAuthor";
    public static final String ACTION__DELETE_RUBRIC = "deleteRubric";
    public static final String ACTION__DELETE_SECTION = "deleteSection";
    public static final String ACTION__DELETE_CSUTOMER = "deleteCustomer";





    public static final String ACTION__UPDATE_AUTHOR = "updateAuthor";
    public static final String ACTION__UPDATE_RUBRIC = "updateRubric";
    public static final String ACTION__UPDATE_SECTION = "updateSection";




    public static final String PARAMETER_BOOK_ID = "ID";
    public static final String PARAMETER_AUTHOR_ID  = "IDA";
    public static final String PARAMETER_CUTOMER_ID  = "IDC";
    public static final String PARAMETER_ORDER_ID  = "IDO";
     */

}
