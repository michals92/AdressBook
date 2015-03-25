
/**
 * The interface ISexedEnlargedPerson discribing simply but a little bit enlarged person with the sex.
 * 
 * @author   Ales  Zlamal 
 * @version 2014 10 28
 */
public interface ISexedEnlargedPerson extends IEnlargedPerson{
    
    /**
     * The method returns the sex of the person.
     * 
     * @return  for Man true and false for Women
     */
    boolean isMan();
    
    /**
     * The method returns the sex of the person.
     * 
     * @return  for Women true and false for Man 
     */
    boolean isWoman();
}
