/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */




/*******************************************************************************
 * Instance třídy {@code Marriage} představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Marriage
{
    private static int numOfMarriages;
    /***************************************************************************
     *
     */
    /*public Marriage()
    {
        numOfMarriages = 0;
    }*/
    
    public static void marriage (ISexedEnlargedPerson p1, ISexedEnlargedPerson p2) {
        if ((p1.isMan() == true && p2.isMan() == false) || (p1.isMan() == false && p2.isMan() == true)){
            if (p1.getPartner() != null || p2.getPartner() != null ) {
                System.out.println( p1 + " a " + p2 + " nemohou zavrit manzelstvi, protoze alespon jeden z nich je jiz vdan ci zenat");
                
            } else {
                p1.setPartner(p2);
                p2.setPartner(p1);
                numOfMarriages ++;
            }
        } else {
            System.out.println( p1 + " a " + p2 + " nemohou zavrit manzelstvi, protoze jsou ruzneho pohlavi");
            System.out.println( " mohou uzavrit registrovane partnerstvi");
        }
    }
    
    public static int numberOfMarriages() {
        return numOfMarriages;
    }

    
}
