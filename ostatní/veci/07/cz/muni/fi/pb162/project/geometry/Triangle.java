/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;



/*******************************************************************************
 * Reprezentace trojuhelniku v plose
 *
 * @author    Michal Simik 410003
 * @version   30.9.2014
 */
public class Triangle extends ArrayPolygon implements Solid  {
    
    public static final double EPSILON = 0.001;
   
    
    /** 
     * Konstruktor trojuhelniku
     *
     * @param vertexA bod A
     * @param vertexB bod B
     * @param vertexC bod C
     */
    public Triangle(Vertex2D vertexA, Vertex2D vertexB, Vertex2D vertexC ) {
        super(new Vertex2D[] {vertexA, vertexB, vertexC});
    }
    
   
    /**
     * zjistí jestli je trojuhelnik rovnostranny 
     * 
     * @return true pokud je rovnostranny, false pokud není
     */
    public boolean isEquilateral() {
        double distanceAB = getVertex(0).distance(getVertex(1));
        double distanceBC = getVertex(0).distance(getVertex(2));
        double distanceAC = getVertex(1).distance(getVertex(2));
        
        return Math.abs(distanceAB - distanceBC) < EPSILON && Math.abs(distanceBC - distanceAC) < EPSILON && Math.abs(distanceAB - distanceAC) < EPSILON ; 
    }
    
    
    
}
    
