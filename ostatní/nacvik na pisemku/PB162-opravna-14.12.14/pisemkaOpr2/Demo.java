import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

/**
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2014-12-05
 */
public class Demo
{
    public static void main(String[] args)
    {
        Obligations debts = new Obligations();
        debts.addInvoice(new Invoice("Jun/UPC", 1630.0, 0));
        debts.addInvoice(new Invoice("Jun/UPC", 2000.0, 0));
        debts.addInvoice(new Invoice("Jul/UPC", 1630.0, 0));
        debts.addInvoice(new EnergyInvoice(Month.Jun, 5600.0));
        debts.addInvoice(new Invoice("Jul/Tablet", 8000.0, 5));
        
        System.out.println("All obligations before payment: ");
        for (Invoice inv: debts.getInvoices()) {
            System.out.println("  " + inv);
        }
        
        System.out.println("Obligations from UPC: ");
        for (Invoice inv: debts.getInvoices("UPC")) {
            System.out.println("  " + inv);
        }
        
        double balance = debts.payInvoices(5500);
        System.out.println("Obligations after paying 5500 Kc: ");
        for (Invoice inv: debts.getInvoices()) {
            System.out.println("  " + inv);
        }
        System.out.println("Remains: " + balance + " Kc");
    }
}
