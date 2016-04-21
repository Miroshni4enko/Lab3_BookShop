package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Customer;
import model.OracleDataAccess;
import model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Class that specified precess for login.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
 public class LoginUser implements GeneralProcess {
     public final static String ATTRIBUTE_CUSTTOMER  = "customer";
     public final static String ATTRIBUTE_LOGIN      = "login";
     public final static String NAME_LOGIN_INPUT     = "nameLogin";
     public final static String NAME_PASSWORD_INPUT  = "namePassword";

     public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
         String login    = request.getParameter(NAME_LOGIN_INPUT);
         String password = request.getParameter(NAME_PASSWORD_INPUT);
         Customer customer = OracleDataAccess.getInstance().getCustomer(login, password);

         if (customer != null) {
             request.getSession().setAttribute(ATTRIBUTE_CUSTTOMER, customer);
             request.getSession().setAttribute(ATTRIBUTE_LOGIN, login);
             List<Order> listOrders = OracleDataAccess.getInstance().getOrderByIdCustomer(customer.getId());
             request.getSession().setAttribute("listOfAllOrders", listOrders);
             Commands.forward("/index.jsp", request, response);
         } else {
             Commands.forward("/Login.jsp", request, response);
         }
     }

 }
