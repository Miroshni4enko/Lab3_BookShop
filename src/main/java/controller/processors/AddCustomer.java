package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Customer;
import model.OracleDataAccess;
import model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Фокстрот on 05.04.2016.
 */
public class AddCustomer implements GeneralProcess {

    public final static String CUS_ID      = "ID_CUSTOMER";
    public final static String CUS_LOGIN   = "LOGIN";
    public final static String CUS_PASSWORD= "PASSWORD";
    public final static String CUS_E_MAIL  = "E_MAIL";
    public final static String CUS_PHONE   = "PHOME_NUMBER";
    public final static String CUS_ROLE    = "ROLE";
    public final static String CUS_IS_REG  = "isRegistration";

    public void process(HttpServletRequest request,HttpServletResponse response) throws DataBaseException  {
       // int id = Integer.valueOf(request.getParameter(CUS_ID));
        String login = request.getParameter(CUS_LOGIN);
        String password = request.getParameter(CUS_PASSWORD);
        Customer cusWithId  = OracleDataAccess.getInstance().getCustomer(login,password);

        if(cusWithId==null) {
            String eMail = request.getParameter(CUS_E_MAIL);
            int role = 1;
            String phone = request.getParameter(CUS_PHONE);
            Customer cus = new Customer(login, password, eMail, phone, role);
            OracleDataAccess.getInstance().createCustomer(cus);
            request.getSession().setAttribute(LoginUser.ATTRIBUTE_LOGIN, login);
            cusWithId = OracleDataAccess.getInstance().getCustomer(login, password);
            request.getSession().setAttribute(LoginUser.ATTRIBUTE_CUSTOMER, cusWithId);
            List<Order> listOrders = new ArrayList<Order>();
            request.getSession().setAttribute("listOfAllOrders", listOrders);
            Commands.forward("/index.jsp", request, response);
        }else{
            request.getSession().setAttribute(CUS_IS_REG,"This login and password is already use");

            Commands.forward("/showProfile.jsp", request, response);
        }
    }
}
