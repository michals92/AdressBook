/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * Instance třídy {@code Square} představují ...
 *
 * @author    Michal Simik
 * @version   21.10.2014
 */
public class Square extends GeneralRegularPolygon
{
    
    /**
     * Kontruktor čtverce 
     * 
     * @param center - stred ctverce
     * @param edgeLength - delka hrany ctverce
     */
    public Square(Vertex2D center, double edgeLength)
    {
        super(center, 4, edgeLength);
    }
    
    /**
     * Kontruktor čtverce 
     * 
     * @param edgeLength - polomer opsane kruznice ctverce
     * @param center - stred ctverce
     */
    public Square(double radius, Vertex2D center)
    {    
        super(center, 4, radius * (2 * Math.sin(Math.PI / 4)));        
    }
    
    
}
