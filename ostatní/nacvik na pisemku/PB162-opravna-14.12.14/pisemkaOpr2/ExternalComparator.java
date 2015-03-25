import java.util.Comparator;

/**
 * Write a description of class ExternalComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExternalComparator implements Comparator<Invoice>
{
    public int compare(Invoice s1, Invoice s2){

        if( s1.getPriority() == s2.getPriority()){
            
            return s1.getId().compareTo(s2.getId());
        }
        
            
        return s1.getPriority() - s2.getPriority(); 
    
    }
}
