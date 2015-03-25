
/**
 * Write a description of class Debt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invoice
{   
    private double amount;
    
    private int priority;
    
    private String id;
    
    /**
     * @param id ID of the invoice. Must not be null.
     * @param amount Sum to pay. Must be bigger than zero
     * @param priority Priority of payment as a number between 0 (low) and 10 (high)
     * @throws valuable exceptions on wrong parameters :-)
     */
    public Invoice(String id, double amount, int priority) {
        if (id == null) throw new NullPointerException("id");
        if (amount <= 0) throw new IllegalArgumentException("amount");
        if (priority < 0 || priority > 10) throw new IllegalArgumentException("priority");
        this.id = id;
        this.amount = amount;
        this.priority = priority;
    }
    
    /**
     * @return Sum to pay
     */
    public double getAmount() {
        return amount;
    }
    
    /**
     * @returns Priority of payment: 0 = low, 10 = high
     */
    public int getPriority() {
        return priority;
    }
    
    /**
     * @returns ID of the invoice
     */
    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return id + ":\t" + amount + " Kc, priority: " + priority;
    }
    
    @Override
    public boolean equals(final Object obj) {
         if (obj == null) {
             return false;
         }
         
         if (getClass() != obj.getClass()) {
             return false;
         }
         
         final Invoice other = (Invoice) obj;
         return this.id.equals(other.id);
    }
    
    @Override
    public int hashCode(){
        return 3*this.id.hashCode();
        
    }
    
    public int compareTo(Invoice v) {
        return this.id.compareTo(v.id);
    }
    
}
