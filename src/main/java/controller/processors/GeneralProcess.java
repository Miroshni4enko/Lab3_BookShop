package controller.processors;

import exception.DataBaseException;
import model.ActionResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface that describes processors.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public interface GeneralProcess {
    void process(HttpServletRequest request, HttpServletResponse response);

}
