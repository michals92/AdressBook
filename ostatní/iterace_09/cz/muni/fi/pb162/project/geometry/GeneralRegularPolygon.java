/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * Instance třídy {@code GeneralRegularPolygon} představují ...
 *
 * @author    Michal Simik 410003
 * @version   21.10.2014
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored
{
    private Vertex2D center;
    private int numEdges;
    private double edgeLength;
    private Color color;
    
    /**
     * Konstruktor n-uhelniku
     * 
     * @param center - stred kruznice opsane n-uhelniku
     * @param numEdges - pocet hran
     * @param edgeLength - delka jedne hrany
     */
    public GeneralRegularPolygon(Vertex2D center, int numEdges, double edgeLength) {
        this.center = center;
        this.numEdges = numEdges;
        this.edgeLength = edgeLength;
        this.color = Color.BLACK;
    }
    
    @Override 
    public double getRadius() {
        return edgeLength / (2 * Math.sin( Math.PI / numEdges));
    }
    
    @Override
    public Vertex2D getCenter() {
        return center;
    }
    
    @Override
    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }
    
    /**
     * Nastavi zadanou barvu
     * 
     * @param color - nazev barvy
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public Color getColor() {
        return color;
    }
    
    @Override
    public double getArea() {
        return 0.5 * numEdges * Math.pow(getRadius(), 2) * Math.sin( (2* Math.PI) / numEdges);
    }
    
    @Override
    public double getWidth() {
        return 2 * getRadius();
    }
    
    @Override
    public double getHeight() {
        return 2 * getRadius();
    }
    
    @Override
    public double getLength() {
        return numEdges * edgeLength;
    }
    
    @Override
    public String toString() {
        return  numEdges + "-gon: center=" + center + ", edge length=" + edgeLength + ", color=" + color;
    }
    
    @Override
    public int getNumVertices() {
        return numEdges;
    }
    
    @Override
    public Vertex2D getVertex(int index) {
      
        double x = getCenter().getX() - getRadius() * Math.cos((index * 2 * Math.PI ) / getNumEdges());
        double y = getCenter().getY() - getRadius() * Math.sin((index * 2 * Math.PI ) / getNumEdges());
        Vertex2D vertex = new Vertex2D(x, y);
        return vertex;
    }
    
    /**
     * vrati pole trojuhelniku rozdelujici pravidelny n-uhelnik
     * 
     */
    public Triangle[] triangulate() {
        
        Triangle[] triangles = new Triangle[getNumEdges()];
        
        for (int i = 0; i < getNumEdges(); i++) {
            triangles[i] = new Triangle( getCenter() , getVertex(i), getVertex(i+1)); 
        }
        
        return  triangles;
    }
    
    
}
