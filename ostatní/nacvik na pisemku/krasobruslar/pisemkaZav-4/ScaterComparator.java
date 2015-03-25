import java.util.Comparator;

/**
 * Write a description of class ScaterComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScaterComparator implements Comparator<FigureScater>
{
    public int compare(FigureScater s1, FigureScater s2){

        if(!s1.getName().equals(s2.getName())){
            return s1.getName().compareTo(s2.getName());
        }
        return s1.compareTo(s2);
    
    }
}
