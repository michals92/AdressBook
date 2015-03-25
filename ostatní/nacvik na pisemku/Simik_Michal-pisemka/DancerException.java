
/**
 * Write a description of class DancerException here.
 * 
 * @author Micha Simik
 * @version (a version number or a date)
 */
public class DancerException extends Exception
{
    public DancerException()
    {
        super();
    }
    
    public DancerException(String message) {
        super(message);
    }

    public DancerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DancerException(Throwable cause) {
        super(cause);
    }
}
