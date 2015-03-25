
/**
 * Write a description of class EnergyInvoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnergyInvoice extends Invoice
{
    public static final String eon = "E.ON" ;

    /**
     * Constructor for objects of class EnergyInvoice
     */
    public EnergyInvoice(Month month, double amount)
    {
        super(month + "/" + eon, amount, 10);
    }
    
}

