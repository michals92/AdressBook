/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */




/*******************************************************************************
 * Instance třídy {@code Man} představují ...
 *
 * @author    Michal Simik
 * @version   0.00.000
 */
public class Man extends EnlargedPerson implements ISexedEnlargedPerson
{
   

    /***************************************************************************
     *
     */
    public Man(String givenName, String surname)
    {
        super(givenName, surname);
    }

    public boolean isMan() {
        return true;
    }
        
    public boolean isWoman() {
        return false;
    }

   public String toString(){
         return "muz "+ super.toString();
    }
}
