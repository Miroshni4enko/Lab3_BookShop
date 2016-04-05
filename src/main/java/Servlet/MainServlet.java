package Servlet;

import controller.processors.GeneralProcess;
import exception.DataBaseException;
import model.ActionResult;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Class for handling requests and responses.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */
public class MainServlet extends HttpServlet {
    private Map<String, Object> map = Commands.getInstance().getCommandsMap();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* CmdExecs cmdExecs = map.get(request.getParameter());
        if (cmdExecs != null) {
            cmdExecs.doIt(request, response);
        }*/

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = Commands.ACTION_WELCOME;
        }
            GeneralProcess process = null;
            process = (GeneralProcess) map.get(action);
        if (process != null) {
            process.process(request, response);
        }
        else{
            //exception
        }



    }
}
