/**
 * Write a description of class Ticket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ticket implements ITicket
{
   private int id; 
   private int ticketNumber;
   private int[] tips;
   
   
   
   public Ticket(int id, int[] tips) throws NullPointerException, IllegalArgumentException{
       if (id < 0) {
           throw new IllegalArgumentException("Id must not be less then 0");
        }
       
       if (tips == null) {
           throw new NullPointerException("Array is null");
        } 

       for(int i = 0; i < tips.length; i++) {
            
            if (tips[i] <= 0 ) {
                throw new IllegalArgumentException("One or more elements of the array is breaging the rulesl");
            } 
        }
    }
    
    
   public boolean compareTickets(int id1, int id2) {
       return id1 == id2;
    }
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder ("id: ");
        sb.append(this.id +  "numbers: [");
        for(int i = 0; i < tips.length; i++) {
            sb.append(tips[i] + ", " );
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        
        return sb.toString();
    }
    
   @Override
   public int getId() {
       return id;
    }
    
   @Override
   
   public int getMatch(int[] numbers) {
       
       
       return ticketNumber;
    }
    
    
}
