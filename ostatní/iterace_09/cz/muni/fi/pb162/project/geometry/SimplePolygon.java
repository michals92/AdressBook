/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * Instance třídy {@code SimplePolygon} představují ...
 *
 * @author    Michal Simik 410003
 * @version   4.11.2014
 */
public abstract class SimplePolygon implements Polygon {
    
    /**
     * Return height of a simple polygon.
     * 
     * @return Height
     */
    public double getHeight() {
        double maxY;
        double minY;
        
        minY = getVertex(0).getY();
        maxY = minY;
    
        for (int i = 0; i < getNumVertices(); i++) {
            maxY = Math.max(maxY, getVertex(i).getY());
            minY = Math.min(minY, getVertex(i).getY());
        }
        
        return maxY - minY; 
    }
    
    /**
     * Return width of a simple polygon.
     * 
     * @return Width
     */
    public double getWidth() {
        double maxX;
        double minX;
        
        minX = getVertex(0).getX();
        maxX = minX;
    
        for (int i = 0; i < getNumVertices(); i++) {
            maxX = Math.max(maxX, getVertex(i).getX());
            minX = Math.min(minX, getVertex(i).getX());
        }
        
        return maxX - minX; 
    }
    
    /**
     * Return length of a simple polygon.
     * 
     * @return Length
     */
    public double getLength() {
        double length = 0;
        
        for (int i = 0; i < (getNumVertices()-1); i++) {
            
            length += getVertex(i).distance(getVertex(i+1));
        }
        length += getVertex(getNumVertices()-1).distance(getVertex(0));
        return length;
    }
    
    /**
     * Return area of a simple polygon.
     * 
     * @return Area
     */
    public double getArea() {
        double area = 0;
        
        for (int i = 0; i < getNumVertices(); i++) {
            
            area +=  getVertex(i).getX() * getVertex(i+1).getY() - getVertex(i+1).getX() * getVertex(i).getY();
        }
        return 0.5 * area;
    }
   
    
    public String toString () {
        String string = new String("Polygon: vertices =");
        for (int i= 0; i < getNumVertices(); i++) { 
            string += " " + getVertex(i);
        }
        
        return string;
    }
    
    
}
