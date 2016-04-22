package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Class for delete book.
 *
 * @author Slavik Miroshnychenko
 * @version %I%, %G%
 */
public class DeleteBook implements GeneralProcess {

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        int idBook = Integer.parseInt(request.getParameter(DetailBook.ID_DETAIL));

        OracleDataAccess.getInstance().removeBook(idBook);
        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute(ViewListBooks.ATTRIBUTE_LIST_OF_ALL_BOOKS, books);

        Commands.forward("/index.jsp", request, response);
    }

}
