
/**
 * Network PCI card.
 */
public class NetworkCard extends PciCard
{
    private int speed;
    
    /**
     * @param producer card producer (manufacturer), must not be null
     * @param speed maximal speed in Mbps, must be bigger than zero
     * @throws IllegalArgumentException if producer is null or speed is <= 0
     */
    public NetworkCard(String producer, int speed) {
        super(producer);
        if (speed <= 0) throw new IllegalArgumentException("speed");
        this.speed = speed;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + speed + "Mbps";
    }
    
    @Override
    public boolean equals(Object obj) {
       
        if (obj == this) { //zkontrolu, jestli se nejedla o tentyz objekt
            return true;
        }
        
        if (obj == null || !(obj instanceof NetworkCard)) { //zkontroluje, zda neni objekt null nebo jestli neni objektem jine tridy
            return false;
        }

        final NetworkCard other = (NetworkCard) obj;

        return this.speed == other.speed;
    }
    
    
    @Override
    public int hashCode() { //zvetsi cislo x-nasobne proto, aby byla mensi pravdepodobnost pri jeho porovnani ze se jedna o jine z porovnavanych cisel
        
        int hash = 5;
        hash = 79 * hash + speed;
        return hash;
    }
}
