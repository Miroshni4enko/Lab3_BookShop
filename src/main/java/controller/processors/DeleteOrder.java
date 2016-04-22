package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.OracleDataAccess;
import model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Слава on 22.04.2016.
 */
public class DeleteOrder implements GeneralProcess {
    public final static String DELETE_ORDER = "deleteOrder";
    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        Order order =(Order) request.getSession().getAttribute(DELETE_ORDER);
        OracleDataAccess.getInstance().removeOrder(order);
        List<Order> orders = OracleDataAccess.getInstance().getAllOrder();
        request.getSession().setAttribute("listOfAllOrders", orders);
        Commands.forward("/showProfile.jsp", request, response);
    }
}
