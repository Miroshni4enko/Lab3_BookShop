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
    public final static String ATTRIBUTE_ACTION_VIEW_LIST  = "attribute_list_books";// action for list: all, search, id

    
    public final static String ID_RUBRIC      = "idRubric";
    public final static String RUBRIC_ALL     = "all";

    public static final String ATTRIBUTE_NAME_FOR_SEARCH = "nameForSearch";
    public final static String RUBRIC_SEARCH  = "search";
    public final static String ID_SEARCH_BOOK = "searchBook";

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {

        String requestIdRubric = request.getParameter(ID_RUBRIC);
        Integer idRubric = null;
        String search = null;

        if (requestIdRubric != null) {
            if (requestIdRubric.equals(RUBRIC_SEARCH)) {
                request.getSession().setAttribute(ATTRIBUTE_ACTION_VIEW_LIST, RUBRIC_SEARCH);
                search = request.getParameter(ID_SEARCH_BOOK);
                request.getSession().setAttribute(ATTRIBUTE_NAME_FOR_SEARCH, search);
            } else {
                if (requestIdRubric.equals(RUBRIC_ALL)) {
                    request.getSession().setAttribute(ATTRIBUTE_ACTION_VIEW_LIST, RUBRIC_ALL);
                } else {
                    try {
                        idRubric = Integer.valueOf(requestIdRubric);
                        request.getSession().setAttribute(ATTRIBUTE_ACTION_VIEW_LIST, idRubric.toString());
                    } catch (Exception e) {
                        idRubric = null;
                    }
                }
            }

            Commands.AMOUNT_OF_BOOKS_ON_LIST = Commands.START_OR_PLUS_BOOKS_TO_LIST;
        } else {
            String listBooks = (String) request.getSession().getAttribute(ATTRIBUTE_ACTION_VIEW_LIST);
            if (!listBooks.equals(RUBRIC_ALL)) {
                if (listBooks.equals(RUBRIC_SEARCH)) {
                    search = (String) request.getSession().getAttribute(ATTRIBUTE_NAME_FOR_SEARCH);
                } else {
                    idRubric = Integer.valueOf(listBooks);
                }
            }

            Commands.AMOUNT_OF_BOOKS_ON_LIST += Commands.START_OR_PLUS_BOOKS_TO_LIST;
        }

        ArrayList books;
        if (search != null) {
            books = (ArrayList) OracleDataAccess.getInstance().getBooksByName(search);
        } else {
            if (idRubric != null) {
                books = (ArrayList) OracleDataAccess.getInstance().getAllBooksByRubric(idRubric);
            } else {
                books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
            }
        }

        request.getSession().setAttribute(ATTRIBUTE_LIST_OF_ALL_BOOKS, books);
        Commands.forward("/index.jsp", request, response);
    }

}
