/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;


/**
 * Kruh
 * 
 * @author Michal Simik 410003 
 * @version 7.1.2014
 */
public class Circle extends GeneralRegularPolygon implements Solid {
    private double radius;

    /**
     * konstructor circle
     * 
     * @param center udává střed kruhu
     * @param radius udává poloměr kruhu
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, 0);
        this.radius = radius;
    }
    
    /**
     * konstructor circle, vola predchozi kontruktor s parametry [0, 0], 1 
     */
    public Circle() {
        this(new Vertex2D(0, 0), 1);
    }
    
    @Override 
    public double getRadius() {
        return radius;
    }
    
    public String toString(){
        return "Circle: center=" + getCenter() + ", radius=" + radius;
    }
    
    /**
     * vraci obvod kruhu
     */
    @Override 
    public double getLength(){
        return 2 * Math.PI * radius;
    }
    
    /**
     * vraci obsah kruhu
     */
    @Override 
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    
}
