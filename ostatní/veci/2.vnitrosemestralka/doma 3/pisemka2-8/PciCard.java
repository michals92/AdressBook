
/**
 * PCI card.
 */
public class PciCard
{
    private String producer;
    
    /**
     * @param producer card producer (manufacturer), must not be null
     * @throws IllegalArgumentException if producer is null
     */
    public PciCard(String producer){
        if (producer == null) throw new IllegalArgumentException("producer");
        this.producer = producer;
    }
    
    @Override
    public String toString() {
        return producer;
    }
    
    @Override
    public boolean equals(Object o) {
        
       
        if (o == this) { //zkontrolu, jestli se nejedla o tentyz objekt
            return true;
        }
        
        if (o == null || !(o instanceof PciCard)) { //zkontroluje, zda neni objekt null nebo jestli neni objektem jine tridy
            return false;
        }

        final PciCard other = (PciCard) o;

        return this.producer.equals(other.producer);
       
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
}
