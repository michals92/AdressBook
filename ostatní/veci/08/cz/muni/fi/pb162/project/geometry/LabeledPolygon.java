package cz.muni.fi.pb162.project.geometry;
import java.util.Set;
import java.util.SortedSet;
import java.util.SortedMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;

/**
 * Polygon, vrcholy ulozeny pod svymi nazvy.
 * 
 * @author Michal Simik 
 * @version 1.12.2014
 */
public class LabeledPolygon extends SimplePolygon
{
    private SortedMap<String, Vertex2D> vertex = new TreeMap<String, Vertex2D>();

     /**
     * Add vertex to polygon
     * 
     * @param label - label of vertex
     * @param value - value of vertex
     */
    public void addVertex(String label, Vertex2D vert) {
        if(label == null) {
            throw new NullPointerException("Vertex label in null.");
        }
        
        if(vert == null) {
            throw new NullPointerException("Vertex is null.");
        }
        
        vertex.put(label, vert);
    }
    
    /**
     * Returns vertex of specified name
     * 
     * @param label - name of vertex 
     * @return vertex - value of vertex
     */
    public Vertex2D getVertex(String label) {
        if(!vertex.containsKey(label)) {
            throw new IllegalArgumentException("Tree does not contains vertex.");
        }
        return vertex.get(label);
    }
    
    /**
     * Returns vertex on specified index
     * 
     * @param index - number of index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    public Vertex2D getVertex(int index) {
       if(index < 0) {
            throw new IllegalArgumentException("Index is negative.");
       }
       
       Vertex2D[] vertex2 = vertex.values().toArray(new Vertex2D[vertex.size()]);
       return vertex2[index % vertex.size()];
    }
        
    /**
     * Returns number of vertices of the polygon.
     * 
     * @return number of vertices
     */
    public int getNumVertices() {
        return vertex.size();
    }
    
    /**
     * Returns collection of labels ascendently.
     * 
     * @return set of labels
     */
    public Collection<String> getLabels() {
        Set<String> labels = new TreeSet<String>();
        for(String i: vertex.keySet()) {
            labels.add(i);
        }
        
        return Collections.unmodifiableCollection(labels);
    }

    /**
     * Returns sorted vertices
     * 
     * @return set of sorted vertices
     */
     public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<Vertex2D>(vertex.values());
    }
    
    /**
     * Returns sorted vertices with defined comparator
     * 
     * @param comparator
     * @return set of sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
       SortedSet<Vertex2D> values = new TreeSet<Vertex2D>(comparator);
       
       values.addAll(vertex.values());
       
       return values;
    }
     
    /**
     * Returns labels of all vertices with same position
     * 
     * @param vert position 
     * @return set of labels
     */
    public Collection<String> getLabels(Vertex2D vert) {
        Set<String> labels = new HashSet<String>();
        
        for(String i: vertex.keySet()) {
            if(vertex.get(i).equals(vert)) {
                labels.add(i);
            }
        }
        
        return labels;
    }
    
    /**
     * Returns vertices that are duplicates
     * 
     * @return set of equal vertices
     */
       public Collection<Vertex2D> duplicateVertices() {
        Collection<Vertex2D> equalVert = new HashSet<Vertex2D>();
        Vertex2D[] tempEqualVert = new Vertex2D[vertex.size()];
       
        vertex.values().toArray(tempEqualVert);
       
        for (int i = 0; i < vertex.size()-1; i++){
            for (int j = i+1; j < vertex.size(); j++){      
                if (tempEqualVert[i].equals(tempEqualVert[j])){
                equalVert.add(tempEqualVert[i]);
               }
            }
        }
       
        return equalVert;
    }
}
