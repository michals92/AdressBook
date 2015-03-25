/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * Instance třídy {@code OlympicRings} představují ...
 *
 * @author    Michal Simik 410003
 * @version   21.10.2014
 */
public class OlympicRings {
    private Circle blackRing;
    private Circle redRing;
    private Circle blueRing;
    private Circle yellowRing;
    private Circle greenRing;
    
    /**
     * Vytvori 5 kruhu - olympijske kruhy 
     * 
     * @param center - stred prvniho cerneho kruhu
     * @param radius - polomer vsech kruhu
     */
    public OlympicRings(Vertex2D center, double radius){
        
        blackRing = new Circle(center, radius); 
       
        redRing = new Circle(new Vertex2D(center.getX() + 2 * radius, center.getY()), radius);
        redRing.setColor(Color.RED);
        
        blueRing = new Circle(new Vertex2D(center.getX() - 2 * radius, center.getY()), radius);
        blueRing.setColor(Color.BLUE);

        yellowRing = new Circle(new Vertex2D(center.getX() - radius, center.getY() - radius), radius);
        yellowRing.setColor(Color.YELLOW);
        
        greenRing = new Circle(new Vertex2D(center.getX() + radius, center.getY() - radius), radius);
        greenRing.setColor(Color.GREEN);
    }
    
    public Circle getBlackRing() {
        return blackRing;
    }
   
    public Circle getBlueRing() {
        return blueRing;
    }
   
    public Circle getRedRing() {
        return redRing;
    }
   
    public Circle getYellowRing() {
        return yellowRing;
    }
   
    public Circle getGreenRing()
    {
        return greenRing;
    }

}
