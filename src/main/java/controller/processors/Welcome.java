package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Class that handling command Welcome.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class Welcome implements GeneralProcess{

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException{

        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute("listOfAllBooks", books);

        TreeMap list = new TreeMap<>((Comparator) (section, section2) -> {
            if (section.equals(section2)) {
                return 1;
            } else {
                return -1;
            }
        });
        request.getSession().setAttribute("Category", list);

        Commands.forward("/index.jsp", request, response);
    }

}
