package cz.muni.fi.pb162.project.geometry;
import java.util.Comparator;

/**
 * Write a description of class VertexInverseComparator here.
 * 
 * @author Michal Simik
 * @version 1.12.2014
 */
public class VertexInverseComparator implements Comparator<Vertex2D>
{
    /**
     * Compares two vertices
     * 
     * @para
     */
    
    public int compare(Vertex2D first, Vertex2D second) {
        if(first.getX() == second.getX()) {
                        if(first.getY() == second.getY()) {
                return 0;
            }
                return (first.getY() < second.getY())?1:-1;
        }
        return (first.getX() < second.getX())?1:-1;
    }
  
}
