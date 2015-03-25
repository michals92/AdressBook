
/**
 * Write a description of class TrafficLightsException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrafficLightsException extends Exception
{
    
    /**
     * Zakladni konstruktor pro DbException
     *
     */
    public TrafficLightsException()
    {
        super();
    }
    
    /**
     * Pretizeny konstruktor pro DbException
     * 
     * @param message - zprava pro vyjimku
     */
    public TrafficLightsException(String message) {
        super(message);
    }

    /**
     * Pretizeny konstruktor pro DbException
     * 
     * @param message - zprava pro vyjimku
     * @param cause - duvod vyjimky 
     */
    public TrafficLightsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Pretizeny konstruktor pro DbException
     *
     * @param cause - duvod vyjimky 
     */
    public TrafficLightsException(Throwable cause) {
        super(cause);
    }
}
