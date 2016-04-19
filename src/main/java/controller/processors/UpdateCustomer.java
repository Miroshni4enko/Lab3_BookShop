package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Customer;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Слава on 19.04.2016.
 */
public class UpdateCustomer implements GeneralProcess {
    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        Customer cus = (Customer) request.getSession().getAttribute(LoginUser.ATTRIBUTE_CUSTTOMER);
        cus.setLogin(request.getParameter(AddCustomer.CUS_LOGIN));
        cus.setPassword(request.getParameter(AddCustomer.CUS_PASSWORD));
        cus.seteMail(request.getParameter(AddCustomer.CUS_E_MAIL));
        cus.setPhone(request.getParameter(AddCustomer.CUS_PHONE));
        OracleDataAccess.getInstance().updateCustomer(cus);
        request.getSession().setAttribute(LoginUser.ATTRIBUTE_LOGIN, cus.getLogin());
        request.getSession().setAttribute(LoginUser.ATTRIBUTE_CUSTTOMER,cus);

        Commands.forward("/index.jsp",request,response);
    }
}
