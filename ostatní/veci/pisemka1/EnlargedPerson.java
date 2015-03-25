/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */




/*******************************************************************************
 * Instance třídy {@code EnlargedPerson} představují ...
 *
 * @author    Michal Simik
 * @version   0.00.000
 */
public class EnlargedPerson extends Person implements IEnlargedPerson
{
    private IEnlargedPerson partner;
    private String oldName;
    /***************************************************************************
     *
     */
    public EnlargedPerson(String givenName, String surname)
    {
        super(givenName, surname);
    }

    public IEnlargedPerson getPartner(){
        return partner;
    }
    
    public void setPartner (IEnlargedPerson person) {
        partner = person;
    }
    
    public void renewName() {
        setSurname(oldName);
    }
    
    public void changeName(String surname) {
        oldName = getSurname();
        setSurname(surname);
        
    }
}
