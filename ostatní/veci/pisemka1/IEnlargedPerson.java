
/**
 * The interface IEnlargedPerson discribing simply but a little bit enlarged person.
 * 
 * @author   Ales  Zlamal 
 * @version 2014 10 28
 */
public interface IEnlargedPerson{

    /**
     * The method change surname of the person.
     * 
     * @param  string with the new surname which sets the atribut surname
     */
    void changeName(String surname);
    
    /**
     * The method returned the just previously former surname of the person. 
     * Repeatedly application has no effect.
     */
    void renewName();
    
    /**
     * The setter method sets the partner.
     * 
     * @param  person the partner (the only one) by object implementing inteface IEnlargedPerson
     */
    void setPartner(IEnlargedPerson person);
    
    /**
     * The getter method gets the partner.
     * 
     * @return  the partner (the object implementing inteface IEnlargedPerson or null)
     */
    IEnlargedPerson getPartner();
}
