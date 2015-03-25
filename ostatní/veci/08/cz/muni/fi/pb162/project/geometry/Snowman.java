/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * vytvori obrazek snehulaka
 *
 * @author    Michal Simik 410003
 * @version   14.10.2014
 */
public class Snowman
{
    private Circle bottom;
    private Circle middle;
    private Circle top;
    
    private Circle leftHand;
    private Circle rightHand;
   
    /**
     * Inicializuje snehulaka, vola tridy pro vytvoreni tela a rukou
     * 
     * @param radius - poloměr kruhu
     * @param redustion - poměr redukce
     */
    public Snowman(double radius, double reduction) {
        if ((reduction <= 0) || (reduction > 1)) {
            reduction = 0.8;
        }
        
        createBody(radius, reduction);
        createHands();
    }
    
    
    /**
     * Vytvori telo snehulaka ze 3 kruznic
     * 
     * @param radius - poloměr kruhu
     * @param redustion - poměr redukce
     */
     private void createBody(double radius, double reduction) {
        bottom = new Circle(new Vertex2D (0, 0), radius);
        
        double x = bottom.getCenter().getX();
        double y = bottom.getCenter().getY();
        
        Vertex2D centerMiddle = new Vertex2D(x, y + radius + radius * reduction);
        middle = new Circle(centerMiddle, radius * reduction);
        
        y = middle.getCenter().getY();
        Vertex2D centerHead = new Vertex2D(x, y + middle.getRadius() + (middle.getRadius() * reduction));
        top = new Circle(centerHead, (radius * reduction) * reduction);
    }
   
    
    /**
     * Vytvoti ruce ze dvou kruznic
     * 
     */
    private void createHands() {
        double x = middle.getCenter().getX();
        double y = middle.getCenter().getY();
        
        Vertex2D centerLeft = new Vertex2D(x - middle.getRadius() - (middle.getRadius() / 2), y);
        Vertex2D centerRight = new Vertex2D(x + middle.getRadius() + (middle.getRadius() / 2), y);
        
        leftHand = new Circle(centerLeft, middle.getRadius() / 2);
        rightHand = new Circle(centerRight, middle.getRadius() / 2);
    }
   
    public Circle getBottomBall() {
        return bottom;
    }
 
    public Circle getMiddleBall() {
        return middle;
    }
 
    public Circle getTopBall() {
        return top;
    }
 
    public Circle getLeftHandBall() {
        return leftHand;
    }
 
    public Circle getRightHandBall() {
        return rightHand;
    }
}
