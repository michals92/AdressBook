
public class TheatreException extends Exception
{
    public TheatreException() {
        super();
    }
    
    public TheatreException(String msg) {
        super(msg);
    }

    public TheatreException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public TheatreException(Throwable cause) {
        super(cause);
    }
}
