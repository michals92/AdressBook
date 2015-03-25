/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * Instance třídy {@code RegularOctagon} představují ...
 *
 * @author    Michal Simik 410003
 * @version   21.10.2014 
 */
public class RegularOctagon extends GeneralRegularPolygon
{
   
    /**
     * Konstruktor vytvoří 8-uhelník 
     */
    public RegularOctagon(Vertex2D center, double edgeLength)
    {
        super(center, 8, edgeLength);
    }


}
