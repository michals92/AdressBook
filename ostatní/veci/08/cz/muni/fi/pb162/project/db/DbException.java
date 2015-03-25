/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.db;





/*******************************************************************************
 * Instance třídy {@code DbException} představují ...
 *
 * @author    Michal Simik
 * @version   11.11.2014
 */
public class DbException extends Exception
{
    
    /**
     * Zakladni konstruktor pro DbException
     *
     */
    public DbException()
    {
    }
    
    /**
     * Pretizeny konstruktor pro DbException
     * 
     * @param message - zprava pro vyjimku
     */
    public DbException(String message) {
        super(message);
    }

    /**
     * Pretizeny konstruktor pro DbException
     * 
     * @param message - zprava pro vyjimku
     * @param cause - duvod vyjimky 
     */
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Pretizeny konstruktor pro DbException
     *
     * @param cause - duvod vyjimky 
     */
    public DbException(Throwable cause) {
        super(cause);
    }
}
