package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Book;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Фокстрот on 05.04.2016.
 */
public class Welcome implements GeneralProcess{
    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException{

            ArrayList<Book> books = (ArrayList) OracleDataAccess.getInstance().getAllBooks();
            request.getSession().setAttribute("listOfAllBooks",books);
            Commands.forward("/index.jsp",request,response);


    }
}
