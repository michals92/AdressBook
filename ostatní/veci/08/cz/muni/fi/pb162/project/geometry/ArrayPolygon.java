/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * Instance třídy {@code ArrayPolygon} představují ...
 *
 * @author    Michal Simik
 * @version   4.11.2014
 */
public class ArrayPolygon extends SimplePolygon
{
    private Vertex2D[] vertex;
   
    public ArrayPolygon(Vertex2D[] vertex) {
        if(vertex == null) {
            throw new IllegalArgumentException("Null pointer to array");   
           // NullPointerException("verts");
        }   
            
        this.vertex = new Vertex2D[vertex.length];
        
        for (int i=0; i < getNumVertices() ;i++) {
            if(vertex[i] == null) {
                throw new IllegalArgumentException("Null pointer in array"); }
        }
        
        System.arraycopy(vertex, 0, this.vertex, 0, getNumVertices());
    }
    
    /**
     * Returns number of index modulo length
     * 
     * @param index - number of index
     * @return vertex 
     */
    public Vertex2D getVertex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Invalid number of index");
        }
        
        return vertex[index % getNumVertices()];
    }
    
    /**
     * Returns length of array
     * 
     * @return length 
     */
    public int getNumVertices() {
        return vertex.length;
    }
    
    /**
     * Inverts array
     * 
     * @return polygon - inverted array 
     */
    public ArrayPolygon invert() {
        Vertex2D[] vertex = new  Vertex2D[getNumVertices()];
        ArrayPolygon polygon = new ArrayPolygon(vertex);
        
        for (int i = 0; i < getNumVertices(); i++) {
            polygon.vertex[i] = vertex[getNumVertices()-i-1];
        }
        
        return polygon;
    }
    
    
    /**
     * Compares arrays if are equal
     * they can be shifted, reversed or both
     * 
     * @return areEqual - true if are equal, else false
     */
    public boolean compare(ArrayPolygon pol) {
        boolean areEqual = false;
 
        if (getNumVertices() == pol.getNumVertices() ) {
            for (int i = 0; i < getNumVertices(); i++) {
                if ( getVertex(0).getX() == pol.getVertex(i).getX() && getVertex(0).getY() == pol.getVertex(i).getY() && !areEqual) {
                    areEqual = compareArray(pol, i);
                } 
            }        
        }
        return areEqual;
    }
   
    /**
     * Help method to compare
     * 
     * @return isSame - true if are equal, else false
     */
    private boolean compareArray(ArrayPolygon pol, int shift) {
        boolean areEqual = false;
        int normal = 0;
        int reverse = 0;
        
        for (int i = 0; i < getNumVertices(); i++) {
            if (getVertex(i).getX() == pol.getVertex(i+shift).getX() && getVertex(i).getY() == pol.getVertex(i+shift).getY() ) {
                normal++;
            }
        }
        
        for (int i = 0; i < getNumVertices(); i++) {
            if (getVertex(i).getX() == pol.getVertex(getNumVertices()-i+shift).getX() && getVertex(i).getY() == pol.getVertex(getNumVertices()-i+shift).getY() ) {
                reverse++;
            }    
        }
        
        if (normal == getNumVertices() || reverse == getNumVertices()) {
            areEqual = true;
        }
        
        return areEqual;
    }
}
        
