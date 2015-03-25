
/**
 * Write a description of class Demo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo
{
    public static void main(String[] args) throws Exception {
        PciCard card1 = new PciCard("No name");
        PciCard card2 = new PciCard("No name"); 
        PciCard card3 = new NetworkCard("Broadcom", 100);
        PciCard card4 = new NetworkCard("Broadcom", 100);
        PciCard card5 = new NetworkCard("Broadcom", 10);
        
        PciBus bus = new PciBus(3);
        
        if (card1.equals(null) || card1.equals(card3) || 
            !card1.equals(card1) || !card1.equals(card2) ||
            card3.equals(null) || card3.equals(card5) || !card3.equals(card4))
        {
            System.out.println("CHYBA: equals()");
        }
        
        try {
            new PciBus(-1);
            System.out.println("CHYBA: kostruktor PciBus");
        } catch(IllegalArgumentException ex) {
        }
        
        try {
            bus.removeCard(card1);
            System.out.println("CHYBA: odebrani neexistujici kardy");
        } catch(NoSuchCardException ex) {
        }
        
        if (bus.addCard(card3, 1) != -1) {
            System.out.println("CHYBA: pridani nove kardy do volneho slotu");
        }
        
        if (bus.removeCard(card4) != 1) {
            System.out.println("CHYBA: odebrani existujici kardy");
        }
        
        bus.addCard(card3, 1);
        if (bus.addCard(card4, 0) != 1) {
            System.out.println("CHYBA: presun kardy do jineho slotu");
        }
        
        if (bus.removeCard(card4) != 0) {
            System.out.println("CHYBA: odebrani presunute kardy");
        }
        
        bus.addCard(card1, 0);
        bus.addCard(card4, 2);
        System.out.println("Used cards: " + bus.getAllCards());
        System.out.println("Free slots: " + bus.getFreeSlots());
    }
}
