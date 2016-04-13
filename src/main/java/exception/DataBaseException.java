package exception;

/**
 * Class that describes the exception for database.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class DataBaseException  extends Exception {
    private String message;

    public DataBaseException(String message, Exception e){
        super(message,e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "is: " + message;
    }
}
