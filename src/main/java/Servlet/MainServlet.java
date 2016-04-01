package Servlet;

import org.apache.log4j.Logger;

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
    private static final Logger LOG        = Logger.getLogger(MainServlet.class);
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


    }
}
