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


        ArrayList<Item> sectionAll = (ArrayList) OracleDataAccess.getInstance().getAllSection();
      /*  TreeMap<Item,ArrayList<Item>> list = new TreeMap<>((Comparator) (section, section2) -> {
            if (section.equals(section2)) {
                return 1;
            } else {
                return -1;
            }
        });
       */
        HashMap<Item,ArrayList<Item>> list = new HashMap<Item,ArrayList<Item>>();
        for(int i=0;i<=sectionAll.size()-1;i++){
            ArrayList<Item> rubric = (ArrayList) OracleDataAccess.getInstance().getRubricBySection(sectionAll.get(i).getId());
            list.put(sectionAll.get(i),rubric);

        }
        request.getSession().setAttribute("Category", list);
        request.getSession().setAttribute("Section", sectionAll);

        Commands.forward("/index.jsp", request, response);
    }

}
