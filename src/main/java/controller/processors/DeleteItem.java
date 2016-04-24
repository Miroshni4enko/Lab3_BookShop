package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Item;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Слава on 24.04.2016.
 */
public class DeleteItem implements GeneralProcess {
    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        String nameItem = request.getParameter(AddItem.ITEM_NAME);
        List<Item> listSection = (List<Item>) request.getSession().getAttribute(Welcome.ATTRIBUTE_SECTION);
        List<Item> listRubrics = (List<Item>) request.getSession().getAttribute(Welcome.ATTRIBUTE_All_CATEGORY);
        Item item = null;
        for (Item index : listSection) {
            if (index.getName().equals(nameItem)) {
                item = index;
                break;
            }
        }
        if(item!=null) {
            System.out.println(item.getId());
            OracleDataAccess.getInstance().removeSection(item.getId());
        }else{
            for (Item index : listRubrics) {
                if (index.getName().equals(nameItem)) {
                    item = index;
                    break;
                }
            }
            System.out.println(item.getId());
            OracleDataAccess.getInstance().removeRubric(item.getId());
        }
        Commands.forward("/MainServlet?action=" + Commands.ACTION_WELCOME, request, response);

    }
}
