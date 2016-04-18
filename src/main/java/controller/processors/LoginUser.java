package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 /**
 * Class that specified precess for login.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class LoginUser implements GeneralProcess {
    public static String NAME_LOGIN_INPUT = "nameLogin";
    public static String NAME_PASSWORD_INPUT = "namePassword";

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        String login = request.getParameter(NAME_LOGIN_INPUT);
        String password = request.getParameter(NAME_PASSWORD_INPUT);
        Customer customer = null;
        //get

        request.getSession().setAttribute("customer", customer);
        request.getSession().setAttribute("login", login);

        Commands.forward("/bookDetail.jsp",request,response);
    }

}
