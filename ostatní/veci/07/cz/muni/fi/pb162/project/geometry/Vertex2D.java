/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;




/*******************************************************************************
 * Reprezentace bodu v plose.
 *
 * @author    Michal Simik 410003
 * @version   30.9.2014
 */
public class Vertex2D
{
    private double x;
    private double y;
    
    /**
     * Konstruktor 
     * 
     * @param x souradnice x
     * @param y souradnice y
     */
    public Vertex2D (double x,double y) {
        this.x = x;
        this.y = y;
    }
   
    /**
     * Spocita vzdalenost mezi dvema body
     * 
     * @param vertex
     * @return vzdalenost
     */
    
    public double distance(Vertex2D vertex) {
        if (vertex == null) {
            return -1.0;
        }
        return Math.sqrt(Math.pow(vertex.x - x, 2) + Math.pow(vertex.y - y, 2));
    }
    
    
    public double getX() {
        return x;
    }
   
    public double getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }    
        
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            
        Vertex2D vertex = (Vertex2D) obj;
        return (x == vertex.x && y == vertex.y);
    }
    
    @Override public int hashCode() {
        int result = 13;
        
        result = result * 17 + (int) getX();
        result = result * 31 + (int) getY();
        
        return result;
    }
}
