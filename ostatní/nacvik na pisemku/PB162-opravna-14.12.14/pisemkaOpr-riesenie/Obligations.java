import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
/**
 * Write a description of class Obligations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obligations
{
    private SortedSet<Invoice> invoices = new TreeSet<>();
    
    public boolean addInvoice(Invoice invoice){
        
        if (invoice == null){
           return false;
        }
        
        if (invoices.contains(invoice))
            return false;
        
        invoices.add(invoice);
        return true;
    }
    
    public double payInvoices(double money){
        SortedSet<Invoice> ahoj = new TreeSet<Invoice>(new ExternalComparator());
        ahoj.addAll(invoices);
        
        
        for(Invoice temp: ahoj){
            if(money >= temp.getAmount()){
                money -= temp.getAmount();
                invoices.remove(temp);
                
            }
        }
        
       return money;
    }
    
    public Set<Invoice> getInvoices(){
        SortedSet<Invoice> sorted = new TreeSet<>();
        sorted.addAll(invoices);
        return Collections.unmodifiableSet(sorted);
    }
    
    public Set<Invoice> getInvoices(String idPart){
        SortedSet<Invoice> temp = new TreeSet<Invoice>();
        
        for(Invoice x: invoices){
            if(x.getId().endsWith(idPart)){
                temp.add(x);
            }
        }
        
        return Collections.unmodifiableSet(temp);
    }
}
