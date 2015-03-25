import java.util.*;
import java.io.*;
/**
 * Write a description of class Obligations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obligations
{
    
    private SortedSet<Invoice> obligations = new TreeSet<Invoice>();
    
    public boolean addInvoice(Invoice invoice) {
        if (invoice == null){
            return false;
        }
        
        if (obligations.contains(invoice)){
            return false;
        }
        obligations.add(invoice);
        return true;
    
    }
    
    public double payInvoices(double money) {
        SortedSet<Invoice> temp = new TreeSet<Invoice>(new InvoicePriorityComparator());
        double lowestAmount = obligations.first().getAmount();
        temp.addAll(obligat);
        
        for(Invoice inv : temp){
                if(inv.getAmount() < lowestAmount){
                    lowestAmount = inv.getAmount();
                }
            }
        
        
    }

    
}
