
/*******************************************************************************
 * Instance třídy {@code Woman} představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Woman extends EnlargedPerson implements ISexedEnlargedPerson {
    
    /***************************************************************************
     *
     */
    public Woman(String givenName, String surname)
    {
        super(givenName, surname);
    }



    public boolean isMan() {
        return false;
    }
        
    public boolean isWoman() {
        return true;
    }
    
    public String toString(){
         return "zena "+ super.toString();
    }
}
