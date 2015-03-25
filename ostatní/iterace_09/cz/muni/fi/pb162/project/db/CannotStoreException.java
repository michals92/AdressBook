/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.db;





/*******************************************************************************
 * Instance třídy {@code CannotStoreException} představují ...
 *
 * @author    Michal Simik
 * @version   11.11.2014
 */
public class CannotStoreException extends DbException
{
   
    /**
     * Zakladni konstruktor pro CannotStoreException
     *
     */
    public CannotStoreException()
    {
    }
    
    /**
     * Pretizeny konstruktor pro CannotStoreException
     * 
     * @param message - zprava pro vyjimku
     */
    public CannotStoreException(String message) {
        super(message);
    }
    
    /**
     * Pretizeny konstruktor pro CannotStoreException
     * 
     * @param message - zprava pro vyjimku
     * @param cause - duvod vyjimky 
     */
    public CannotStoreException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Pretizeny konstruktor pro CannotStoreException
     *
     * @param cause - duvod vyjimky 
     */
    public CannotStoreException(Throwable cause) {
        super(cause);
    }
}
