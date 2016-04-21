package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Слава on 21.04.2016.
 */
public class DeleteBook implements GeneralProcess {
    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        int idBook = Integer.parseInt(request.getParameter("IdDetail"));
        OracleDataAccess.getInstance().removeBook(idBook);
        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute("listOfAllBooks", books);
        Commands.forward("/index.jsp", request, response);
    }
}
