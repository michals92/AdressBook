import java.util.Comparator;

/**
 * Write a description of class SwimmersComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwimmersComparator implements Comparator<SynSwimmers>
{
    public int compare(SynSwimmers s1, SynSwimmers s2) {
	if(!s1.getCountry().equals(s2.getCountry())){
            return s1.getCountry().compareTo(s2.getCountry());
        }
        return s1.compareTo(s2);
}
}
