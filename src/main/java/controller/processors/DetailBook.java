package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Book;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class that handling command DetailBook.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class DetailBook implements GeneralProcess {
    public final static String ID_DETAIL = "IdDetail";

    public void process(HttpServletRequest request, HttpServletResponse response) throws  DataBaseException{
        int IdDetail = Integer.valueOf(request.getParameter(ID_DETAIL));
        Book book = OracleDataAccess.getInstance().getBookById(IdDetail);
        request.getSession().setAttribute("DetailBook", book);
        Commands.forward("/bookDetail.jsp",request,response);
    }

}
