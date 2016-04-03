package exception;

/**
 * Created by Фокстрот on 03.04.2016.
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
