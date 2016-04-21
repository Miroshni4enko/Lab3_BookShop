package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class for log out of user.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class UnLogin implements GeneralProcess {

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        /*HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }*/
        request.getSession().setAttribute(LoginUser.ATTRIBUTE_CUSTTOMER,null);
        request.getSession().setAttribute(LoginUser.ATTRIBUTE_LOGIN, "false");
        Commands.forward("/index.jsp", request, response);
    }

}
