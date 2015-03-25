import java.util.*;

/**
 * Write a description of class DancingLesson here.
 * 
 * @author Michal Simik 
 * @version (a version number or a date)
 */
public class DancingLesson
{
   
    private List<Dancer> dancers = null;

    /**
     * Constructor for objects of class DancingLesson
     */
    public DancingLesson(Dancer[] arr)
    {
        if(arr == null) {
            throw new NullPointerException("Null pointer to array.");
       }
       
       dancers = new LinkedList<Dancer>();
       
       for(int i=0;i<arr.length;i++) {
           if(arr[i]==null) {
                throw new IllegalArgumentException("Element "+i+" of vertex list is null!");
           } else {
                dancers.add(arr[i]);
           }
       }
    }
    
    public Dancer getDancer(int number)
    {    
       for(Dancer dancer : dancers) {
            if(dancer.getNumber() == number){
                return dancer;
            }
        }      
        return null;
    }
    
    public boolean pair(int ladie, int gentleman) throws DancerException{
        Dancer lady = getDancer(ladie);
        //Dancer gent = getDancer(gentleman);
        
        try {
            lady.setPartner(getDancer(gentleman));
            //.setPartner(getDancer(ladie));
        } catch (DancerException ex) {
            return false; 
        } catch (NullPointerException ex) {
            return false; 
        }
        return true;
    }
    
    
    public boolean disjoin(int dancer) {
        Dancer dancer1 = getDancer(dancer);
     
        try {
            return dancer1.unsetPartner();
        } catch (NullPointerException ex1) {
            return false;
        }
    }
    
    public Collection<Dancer> getSingles() {
        List<Dancer> singles = new LinkedList<>();
           
        for(Dancer dancer : dancers) {
            if(!dancer.hasPartner()){
                singles.add(dancer);
            }
        }
        
        return singles;
        }
    }
        

