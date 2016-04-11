package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Customer;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Фокстрот on 05.04.2016.
 */
public class AddCustomer implements GeneralProcess {

    public static String CUS_ID="ID_CUSTOMER";
    public static String CUS_LOGIN="LOGIN";
    public static String CUS_PASSWORD="PASSWORD";
    public static String CUS_E_MAIL="E_MAIL";
    public static String CUS_PHONE="PHOME_NUMBER";
    public static String CUS_ROLE="ROLE";

    public void process(HttpServletRequest request,HttpServletResponse response) throws DataBaseException  {
        int id = Integer.valueOf(request.getParameter(CUS_ID));
        String login = request.getParameter(CUS_LOGIN);
        String password = request.getParameter(CUS_PASSWORD);
        String eMail = request.getParameter(CUS_E_MAIL);
        int role = Integer.valueOf(request.getParameter(CUS_ROLE));
        String phone = request.getParameter(CUS_PHONE);
        Customer cus = new Customer(id, login, password,eMail,phone,role);
        OracleDataAccess.getInstance().createCustomer(cus);

        request.getSession().setAttribute("CusId", cus.getId());

        Commands.forward("/showProfile.jsp",request,response);


    }
}
