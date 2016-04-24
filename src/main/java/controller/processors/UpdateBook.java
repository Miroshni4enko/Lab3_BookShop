package controller.processors;

import Servlet.Commands;
import exception.DataBaseException;
import model.Author;
import model.Book;
import model.Item;
import model.OracleDataAccess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling update of book.
 *
 * @author Slavik Miroshnychenko
 * @version %I%, %G%
 */
public class UpdateBook implements GeneralProcess {

    public final static String BOOK_NAME = "bookName";
    public final static String BOOK_PAGES = "bookPages";
    public final static String BOOK_AUTHOR_ID ="AuthorID";
    public final static String BOOK_AUTHOR_NAME ="bookAuthorName";
    public final static String BOOK_AUTHOR_SURNAME = "bookAuthorSurname";
    public final static String BOOK_DESCRIPTION = "bookDescription";
    public final static String BOOK_AMOUNT = "bookAmount";
    public final static String BOOK_PRICE = "bookPrice";
    public final static String BOOK_RUBRIC = "bookRubric";
    public final static String BOOK_RUBRIC_NAME = "nameRubric";

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        String authorSurname = request.getParameter(BOOK_AUTHOR_SURNAME);
        String authorName = request.getParameter(BOOK_AUTHOR_NAME);
        int idAuthor = (Integer) request.getSession().getAttribute(BOOK_AUTHOR_ID);
        Author author = new Author(idAuthor,authorSurname,authorName);

        String bookName = request.getParameter(BOOK_NAME);
        String description = request.getParameter(BOOK_DESCRIPTION);
        int idBook = Integer.parseInt(request.getParameter("IdDetail"));
        int amount = Integer.parseInt(request.getParameter(BOOK_AMOUNT));
        int price = Integer.parseInt(request.getParameter(BOOK_PRICE));
        int pages = Integer.parseInt(request.getParameter(BOOK_PAGES));

        String rubricName =request.getParameter(BOOK_RUBRIC_NAME);
        List<Item> listItem = (List<Item>) request.getSession().getAttribute(Welcome.ATTRIBUTE_All_CATEGORY);

        Item rubric = null;
        for(Item item:listItem){
            if(item.getName().equals(rubricName)){
                rubric = item;
            }
        }

        Book book = new Book(idBook,bookName,description,rubric,author,pages,price,amount);
        OracleDataAccess.getInstance().updateBook(book);

        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute(ViewListBooks.ATTRIBUTE_LIST_OF_ALL_BOOKS, books);

        Commands.forward("/MainServlet?action=" + Commands.ACTION_DETAIL +
                "&"+ DetailBook.ID_DETAIL + "=" + idBook, request, response);
        //OracleDataAccess.getInstance().updateBook();
    }
}
