package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Item;
import model.OracleDataAccess;
import model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

/**
 * Class that handling command Welcome.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class Welcome implements GeneralProcess{
    public static final String ATTRIBUTE_SECTION  = "Section";
    public static final String ATTRIBUTE_CATEGORY = "Category";

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException{

        List<Order> listOrders = OracleDataAccess.getInstance().getAllOrder();
        request.getSession().setAttribute("listOfAllOrders", listOrders);
        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute("listOfAllBooks", books);

        ArrayList<Item> sectionAll = (ArrayList<Item>) OracleDataAccess.getInstance().getAllSection();
        HashMap<Item, ArrayList<Item>> listRubric = new HashMap<Item, ArrayList<Item>>();

        for(int i = 0; i <= sectionAll.size() - 1; i++){
            ArrayList<Item> rubric = (ArrayList<Item>) OracleDataAccess.getInstance().getRubricBySection(sectionAll.get(i).getId());
            listRubric.put(sectionAll.get(i), rubric);
        }

        request.getSession().setAttribute(ATTRIBUTE_CATEGORY, listRubric);
        request.getSession().setAttribute(ATTRIBUTE_SECTION,  sectionAll);

        request.getSession().setAttribute(ViewListBooks.ATTRIBUTE_VIEW_LIST, ViewListBooks.ID_RUBRIC_ALL);
        request.getSession().setAttribute(LoginUser.ATTRIBUTE_LOGIN, "false");

        Commands.forward("/index.jsp", request, response);
    }

}
