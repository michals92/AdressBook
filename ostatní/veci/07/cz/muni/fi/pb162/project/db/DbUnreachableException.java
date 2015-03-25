/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.db;





/*******************************************************************************
 * Instance třídy {@code DbUnreachableException} představují ...
 *
 * @author    Michal Simik
 * @version   11.11.2014
 */
public class DbUnreachableException extends DbException
{
    
    /**
     * Zakladni konstruktor pro DbUnreachableException
     *
     */
    public DbUnreachableException()
    {
    }

    /**
     * Pretizeny konstruktor pro DbUnreachableException
     * 
     * @param message - zprava pro vyjimku
     */
    public DbUnreachableException(String message) {
        super(message);
    }

    /**
     * Pretizeny konstruktor pro DbUnreachableException
     * 
     * @param message - zprava pro vyjimku
     * @param cause - duvod vyjimky 
     */
    public DbUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Pretizeny konstruktor pro DbUnreachableException
     *
     * @param cause - duvod vyjimky 
     */
    public DbUnreachableException(Throwable cause) {
        super(cause);
    }
}
