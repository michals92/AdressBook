import java.util.Comparator;

/**
 * Comparator.
 * 
 * @author James Bond
 * @version special
 */
public class SwimmerComparator implements Comparator<SynSwimmers> {   
    public int compare(SynSwimmers s1, SynSwimmers s2){
        if(!s1.getCountry().equals(s2.getCountry())){
            return s1.getCountry().compareTo(s2.getCountry());
        }
        return s1.compareTo(s2);
    }
}
