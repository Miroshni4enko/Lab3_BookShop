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
 * Class for add book.
 *
 * @author Slavik Miroshnychenko
 * @version %I%, %G%
 */
public class AddBook implements  GeneralProcess{

    public void process(HttpServletRequest request, HttpServletResponse response) throws DataBaseException {
        String authorSurname =request.getParameter(UpdateBook.BOOK_AUTHOR_SURNAME);
        String authorName = request.getParameter(UpdateBook.BOOK_AUTHOR_NAME);
        List<Author>  listAuthor=  OracleDataAccess.getInstance().getAllAuthor();

        Author author = null;
        for(Author auth:listAuthor){
            if( auth.getSurname().equals(authorSurname)&&auth.getName().equals(authorName)){
                author = auth;
            }

        }

        if(author == null) {
            author = new Author();
            author.setName(authorName);
            author.setSurname(authorSurname);
            OracleDataAccess.getInstance().createAuthor(author);
            listAuthor = OracleDataAccess.getInstance().getAllAuthor();
            for(Author auth:listAuthor){
                if( auth.getSurname().equals(authorSurname)&&auth.getName().equals(authorName)){
                    author = auth;
                }
            }
        }

        String bookName = request.getParameter(UpdateBook.BOOK_NAME);
        String description = request.getParameter(UpdateBook.BOOK_DESCRIPTION);
        String rubricName =request.getParameter(UpdateBook.BOOK_RUBRIC_NAME);
        //int idBook =Integer.parseInt(request.getParameter("IdDetail"));
        int amount = Integer.parseInt(request.getParameter(UpdateBook.BOOK_AMOUNT));
        int price = Integer.parseInt(request.getParameter(UpdateBook.BOOK_PRICE));
        int pages = Integer.parseInt(request.getParameter(UpdateBook.BOOK_PAGES));
        List<Item> listItem = OracleDataAccess.getInstance().getAllRubric();

        Item rubric = null;
        for(Item item:listItem){
            if(item.getName().equals(rubricName)){
                rubric = item;
            }
        }

        Book book = new Book(0,bookName,description,rubric,author,pages,price,amount);
        OracleDataAccess.getInstance().createBook(book);

        ArrayList books = (ArrayList) OracleDataAccess.getInstance().getAmountOfBooks(Commands.AMOUNT_OF_BOOKS_ON_LIST);
        request.getSession().setAttribute(ViewListBooks.ATTRIBUTE_LIST_OF_ALL_BOOKS, books);

        Commands.forward("/index.jsp", request, response);
    }
}
