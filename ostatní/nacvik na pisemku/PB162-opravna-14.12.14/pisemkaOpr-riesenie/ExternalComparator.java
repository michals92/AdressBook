import java.util.*;
/**
 * Write a description of class ExternalComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExternalComparator implements Comparator<Invoice>
{
    public int compare(Invoice n1, Invoice n2) {
        if (n1.getPriority() == n2.getPriority() )
            return n1.getId().compareTo(n2.getId());
            
        return n1.getPriority() - n2.getPriority(); 
    }
}
