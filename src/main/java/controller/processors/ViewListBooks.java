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

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        Commands.AMOUNT_OF_BOOKS_ON_LIST += Commands.PLUS_BOOKS_TO_LIST;

        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute("listOfAllBooks", books);

        Commands.forward("/index.jsp", request, response);
    }

}
