package cz.muni.fi.pb162.project.geometry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Polygon ulozeny v kolekci
 * 
 * @author Michal Simik 
 * @version 18. 11. 2014
 */
public class CollectionPolygon extends SimplePolygon
{
    private List<Vertex2D> vertex;
    
    /**
     * Constructor for objects of class CollectionPolygon
     */
    public CollectionPolygon(Vertex2D [] vertex)
    {
       if(vertex == null) {
            throw new NullPointerException("Null pointer to array.");
       }
        
       this.vertex = new ArrayList<Vertex2D>(Arrays.asList(vertex));
        
       for (Vertex2D obj : vertex) {
           if(obj == null) {
               throw new NullPointerException("Null pointer in array."); 
            }
        }
       
    }

    public Vertex2D getVertex(int index)
    {
        if(index < 0)
            throw new IllegalArgumentException("Invalid index number.");
            
        return this.vertex.get(index % getNumVertices());
    }
    
    public int getNumVertices()
    {
        return vertex.size();
    }
    
    
    /** 
     * Vrati vsechny vrcholy trojuhelnika 
     * 
     * @return - vrati vsechny vrcholy n-uhelniku 
     */
    public Collection<Vertex2D> getVertices()
    {
         return Collections.unmodifiableList(this.vertex); 
    }
    
    /** 
     * Vrati obraceny n-uhelnik
     * 
     * @return - invertovany polygon
     */
    public CollectionPolygon invert() {
        Collections.reverse(vertex);
        return this;
    }
    
    /**
     * Vrati seznam odebranych nejlevejsich bodu z polygonu
     * 
     * @return - odstranene body
     */
    public Collection<Vertex2D> removeLeftmostVertices() {
        double leftmost = vertex.get(0).getX();
       
        for (Vertex2D obj : vertex) {
            leftmost = Math.min(leftmost, obj.getX());
        }
       
        List<Vertex2D> removedVertices = new ArrayList<>();
       
        for(int i = 0; i < vertex.size(); i++) {
            if(vertex.get(i).getX() == leftmost) {
                removedVertices.add(vertex.get(i));
                if (vertex.remove(i) != null) {
                i--;
            }
            }
        }
        return removedVertices;
    }
}
