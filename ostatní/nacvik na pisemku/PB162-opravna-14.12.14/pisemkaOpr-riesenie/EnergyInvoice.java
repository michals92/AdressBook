
/**
 * Write a description of class EnergyInvoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnergyInvoice extends Invoice
{
    public static final String idAddition = "/E.ON";
    
    public EnergyInvoice(Month month, double amount){
        super(month+idAddition, amount, 10);
    }
    
}
