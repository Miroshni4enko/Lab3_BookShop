package controller.processors;

import exception.DataBaseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Слава on 20.04.2016.
 */
public class UpdateBook implements GeneralProcess {
    public static String BOOK_NAME = "bookName";
    public static String BOOK_PAGES = "bookPages";
    public static String BOOK_AUTHOR_NAME ="bookAuthorName";
    public static String BOOK_AUTHOR_SURNAME = "bookAuthorSurname";
    public static String BOOK_DESCRIPTION = "bookDescription";
    public static String BOOK_AMOUNT = "bookAmount";
    public static String BOOK_PRICE = "bookPrice";
    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {

    }
}
