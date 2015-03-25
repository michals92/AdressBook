import java.util.Comparator;

/**
 * Write a description of class PlaysComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaysComparator implements Comparator<Play> 
{
    public int compare(Play s1, Play s2){
        if(s1.getAuthor().equals(s2.getAuthor())){
            if(!s1.getTitle().equals(s2.getTitle())){
                return s1.getTitle().compareTo(s2.getTitle());
            }
        }
        
        if(!s1.getAuthor().equals(s2.getAuthor())){
            return s1.getAuthor().compareTo(s2.getAuthor());
        }
        
        return s1.compareTo(s2);
    
    }
}



