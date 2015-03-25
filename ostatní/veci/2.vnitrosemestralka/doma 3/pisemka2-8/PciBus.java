import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;


/**
 * Write a description of class PciBus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PciBus {
    private int numberOfSlots;
    List<PciCard> listOfPcis;
    

    public PciBus(int numberOfSlots) {
       if(numberOfSlots <= 0) {
           throw new IllegalArgumentException();
        }
       
           this.numberOfSlots = numberOfSlots;
           listOfPcis = new ArrayList<PciCard>(numberOfSlots);
        
       
       
    }
    
    public int removeCard(PciCard card) throws NoSuchCardException {
        if (!listOfPcis.contains(card)) {
            throw new NoSuchCardException("null");
        }
        
        int slot = 0;
        
            if (listOfPcis.contains(card) == true) {
                
                slot = listOfPcis.indexOf(card);
                listOfPcis.remove(card);
            }
    
        return slot;
    }
    
    public int addCard(PciCard card, int slot) throws NullPointerException, SlotFullException, NoSuchCardException {
        int prevSlot = -1;
            if(card == null) {
            throw new NullPointerException("card");
            }
            
            if(getAllCards() == null) {
                throw new IllegalArgumentException();
            }
            
            if(numberOfSlots <= slot) {
                throw new NullPointerException("slot");
            }
             
            if(listOfPcis.get(slot) != null) {
                 throw new SlotFullException("slot full");
            } 
 
            if(listOfPcis.contains(card)){
                prevSlot = removeCard(card);
                listOfPcis.add(slot, card);
            } else {
                listOfPcis.add(slot, card);
            }
            
        return prevSlot;
    }
    public List<PciCard> getAllCards() {
        return Collections.unmodifiableList(listOfPcis);
    }
    
    public List<String> getFreeSlots() {
        List<String> listOfSlots = new ArrayList<>();
        for(int i = 0; i < listOfPcis.size(); i++) {
            if(listOfPcis.get(i) == null) {
                String cislo = Integer.toString(i);
                listOfSlots.add(cislo);
                
            }
        }
            return listOfSlots;
        
    }
    
    
}
