/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.db;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.io.IOException;




/*******************************************************************************
 * Instance třídy {@code MyStorage} představují ...
 *
 * @author    Michal Simik  
 * @version   11.11.2014
 */
public class MyStorage implements Storage
{
    private Connector connector;
    private int maxAttempts;

    /**
     * kontroluje platnost vstupnich argumentu
     *
     * @param connector - nesmi byt null
     * @param maxAttempts - cele cislo vetsi jak nula
     */
    public MyStorage(Connector connector, int maxAttempts)
    {
        if (connector == null) {
            throw new NullPointerException("connector is null"); }
            
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts is < 1 "); }
            
        this.connector = connector;
        this.maxAttempts = maxAttempts;
            
    }
    
    /**
     * uklada fiktivni data , kontroluje vyjimky
     * 
     * @param host - adresa vzdaleneho serveru
     * @param data - data k ulozeni
     */
    public void store(String host, Object data) throws DbUnreachableException, CannotStoreException{
        
        try {
            Connection connection = connector.getConnection(host);
            boolean isSent = false;
            
            while(!isSent) {
                try {
                    connection.sendData(data);
                    isSent = true;
                } catch(IOException ioe){
                    maxAttempts--;
                    if(maxAttempts == 0) {
                        throw new CannotStoreException("Cannot store data",ioe);}
                    }
            }
        } catch (UnknownHostException | NoRouteToHostException ex){
            throw new DbUnreachableException("Unknown host or no route to host",ex);
        }
    }

    


    
}
