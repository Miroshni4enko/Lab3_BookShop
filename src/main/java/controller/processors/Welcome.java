package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Item;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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

        ArrayList<Item> sectionAll = (ArrayList<Item>) OracleDataAccess.getInstance().getAllSection();
        HashMap<Item, ArrayList<Item>> list = new HashMap<Item, ArrayList<Item>>();
        for(int i=0; i <= sectionAll.size() - 1; i++){
            ArrayList<Item> rubric = (ArrayList<Item>) OracleDataAccess.getInstance().getRubricBySection(sectionAll.get(i).getId());
            list.put(sectionAll.get(i), rubric);

        }

        request.getSession().setAttribute("Category", list);
        request.getSession().setAttribute("Section" , sectionAll);
        request.getSession().setAttribute(LoginUser.ATTRIBUTE_LOGIN, "false");

        Commands.forward("/index.jsp", request, response);
    }

}
