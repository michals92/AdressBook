import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Write a description of class DancingLesson here.
 * 
 * @author Michal Simik 
 * @version (a version number or a date)
 */
public class DancingLesson
{
   
    private List<Dancer> dancers;

    /**
     * Constructor for objects of class DancingLesson
     */
    public DancingLesson(Dancer[] dancers)
    {
        if(dancers == null) {
            throw new NullPointerException("Null pointer to array.");
       }
       
       this.dancers = new ArrayList<Dancer>(Arrays.asList(dancers));
       
       for (Dancer obj : dancers) {
           if(obj == null) {
               throw new NullPointerException("Null pointer in array."); 
            }
        }
    }
    

    public Dancer getDancer(int number)
    {
        Dancer dancer = null;
        
       //if (this.getNumber() == number) {
        //   dancer = this;
        //}
        return dancer;
    }
    
    public boolean pair(int ladie, int gentleman) {
        
        Dancer lady = getDancer(ladie);
        Dancer gent = getDancer(gentleman);
        //lady.partner = getDancer().gentleman;
        //gent.partner = gentleman.partner = lady;
        return false;
    }
    
    
    public boolean disjoin(int dancer) {
        Dancer dancer1 = getDancer(dancer);
       // Dancer dancer2 = getDancer(dancer).partner;
        //dancer1.partner = null;
        //dancer2.partner = null;
        return false;
    }
    public Collection<Dancer> getSingles() {
        List<Dancer> singles = new ArrayList<>();
        
        for(int i = 0; i < dancers.size(); i++) {
            //if(dancers.get(i).partner == null) {
                singles.add(dancers.get(i));
           // }
        }
        
        return singles;
    }
        
}
