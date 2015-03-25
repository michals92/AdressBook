import java.util.Set;
import java.util.HashSet;

/**
 * Write a description of class BettingShop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BettingShop
{
    private Set<Ticket> betTickets = new HashSet<Ticket>();
    private Set<Ticket> paidTickets = new HashSet<Ticket>();
    private int lastId;
    private Ticket ticket;
    private int[] tips;
    
    
    /* public int getLastId() {
       return lastId;
    }*/
    
    
   public void betTicket(Person customer, int[] numbers) {
       
       this.ticket = new Ticket(lastId, numbers);
       
       
       betTickets.add(ticket);

   }
    
  
   public int didIWin(Person customer, int[] winningNumbers) throws FakeTicketException, AlreadyPaidTicketException {
      int b = 0;
      if (tips == null) {
          throw new NullPointerException("Customer has no ticket");
        }
        
      if (paidTickets.contains(ticket)){
          throw new AlreadyPaidTicketException("Ticket was already paid");
      }
      
       if (!betTickets.contains(ticket)){
          throw new FakeTicketException("Fake ticket");
      }
      
      
      for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] != tips[i]) {
                b = -1;    
            }             
      }
      return b;
   }
   
   
   
   
   public Set<Ticket> getTickets() {
        return betTickets;
   }
    
   public void addPaidTicket(Ticket ticket) {
       paidTickets.add(ticket);

   }
   
   public Set<Ticket> getPaidTickets() {
        return paidTickets;
   }
    
}
