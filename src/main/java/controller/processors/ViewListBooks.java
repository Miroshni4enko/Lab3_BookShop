package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Class that handling command ViewListBooks.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class ViewListBooks implements GeneralProcess {

    public static final String ATTRIBUTE_LIST_OF_ALL_BOOKS = "listOfAllBooks";      //list with books
    public final static String ACTION_VIEW_LIST_ATTRIBUTE  = "attribute_list_books";// action for list: all, search, id
    public final static String PARAMETER_ACTION_FOR_LIST_ATTRIBUTE = "parameterForList_action";

    public final static String NAME_ACTION_FOR_ALL    = "actionAll";
    public final static String NAME_ACTION_FOR_RUBRIC = "actionRubric";
    public final static String NAME_ACTION_FOR_SEARCH = "actionSearch";

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {

        String requestAction = request.getParameter(ACTION_VIEW_LIST_ATTRIBUTE);
        Integer idRubric;
        String nameForSearch;
        ArrayList books = null;

        if (requestAction != null) {
            switch (requestAction) {
                case NAME_ACTION_FOR_ALL:
                    request.getSession().setAttribute(ACTION_VIEW_LIST_ATTRIBUTE, NAME_ACTION_FOR_ALL);
                    books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
                    break;
                case NAME_ACTION_FOR_RUBRIC:
                    try {
                        idRubric = Integer.valueOf(request.getParameter(PARAMETER_ACTION_FOR_LIST_ATTRIBUTE));
                        request.getSession().setAttribute(PARAMETER_ACTION_FOR_LIST_ATTRIBUTE, idRubric);
                        books = (ArrayList) OracleDataAccess.getInstance().getAllBooksByRubric(idRubric);
                    } catch (Exception e) {
                        request.getSession().setAttribute(ACTION_VIEW_LIST_ATTRIBUTE, NAME_ACTION_FOR_ALL);
                        books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
                    }
                    break;
                case NAME_ACTION_FOR_SEARCH:
                    request.getSession().setAttribute(ACTION_VIEW_LIST_ATTRIBUTE, NAME_ACTION_FOR_SEARCH);
                    nameForSearch = request.getParameter(PARAMETER_ACTION_FOR_LIST_ATTRIBUTE);
                    System.out.println("d2222222222222222 "+ nameForSearch);
                    request.getSession().setAttribute(PARAMETER_ACTION_FOR_LIST_ATTRIBUTE, nameForSearch);
                    books = (ArrayList) OracleDataAccess.getInstance().getBooksByName(nameForSearch);
                    System.out.println("fff"+books.toString());
                    break;
                default:
                    request.getSession().setAttribute(ACTION_VIEW_LIST_ATTRIBUTE, NAME_ACTION_FOR_ALL);
                    books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
                    break;
            }
            Commands.AMOUNT_OF_BOOKS_ON_LIST = Commands.START_OR_PLUS_BOOKS_TO_LIST;
        } else {
            requestAction = (String) request.getSession().getAttribute(ACTION_VIEW_LIST_ATTRIBUTE);
            switch (requestAction) {
                case NAME_ACTION_FOR_ALL:
                    Commands.AMOUNT_OF_BOOKS_ON_LIST += Commands.START_OR_PLUS_BOOKS_TO_LIST;
                    books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
                    break;
                case NAME_ACTION_FOR_RUBRIC:
                    idRubric = (Integer) request.getSession().getAttribute(PARAMETER_ACTION_FOR_LIST_ATTRIBUTE);
                    books = (ArrayList) OracleDataAccess.getInstance().getAllBooksByRubric(idRubric);
                    break;
                case NAME_ACTION_FOR_SEARCH:
                    nameForSearch = (String) request.getSession().getAttribute(PARAMETER_ACTION_FOR_LIST_ATTRIBUTE);
                    books = (ArrayList) OracleDataAccess.getInstance().getBooksByName(nameForSearch);
                    break;
                default:
                    books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
                    Commands.AMOUNT_OF_BOOKS_ON_LIST += Commands.START_OR_PLUS_BOOKS_TO_LIST;
                    break;
            }

        }

        request.getSession().setAttribute(ATTRIBUTE_LIST_OF_ALL_BOOKS, books);
        Commands.forward("/index.jsp", request, response);
    }

}
