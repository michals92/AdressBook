
/**
 * The class Person discribing very simply a person.
 * 
 * @author   Ales  Zlamal 
 * @version 2014 10 28
 */
public class Person{
    private String givenName;
    private String surname;

    /**
     * Constructor for objects of class Person.
     * 
     * @param  givenName is the string of the givenName
     * @param  surname is the string of the surname
     */
    public Person(String givenName, String surname){
        this.givenName = givenName;
        this.surname = surname;
    }

    /**
     * The setter method sets the surname.
     * 
     * @param  string characterizing the instance
     */
    public void setSurname(String surname){
        this.surname = surname;
    }

    /**
     * The getter method gets the surname.
     * 
     * @return  string characterizing the instance
     */
    public String getSurname(){
        return surname;
    }
    
    /**
     * The method overrides the method toString() of the class Object.
     * 
     * @return  string characterizing the instance
     */
    @Override
    public String toString(){
        return givenName + " " + surname;
    }
}
