/**
 * A team of synchronized swimmers.
 */
public class SynSwimmers implements Comparable<SynSwimmers>{

    private int startNumber;
    private String country;

    public SynSwimmers(int startNumber, String country) {
        if (startNumber <= 0) throw new IllegalArgumentException("startNumber");
        if (country == null || country.isEmpty()) throw new IllegalArgumentException("country");
        this.startNumber = startNumber;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public int getStartNumber() {
        return startNumber;
    }

    @Override
    public String toString() {
        return startNumber + ":" + country;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }    
        
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            
        SynSwimmers swimmers = (SynSwimmers) obj;
        return (startNumber == swimmers.startNumber);
    }
    
    @Override 
    public int hashCode() {
        return startNumber;
    }
    
    @Override 
    public int compareTo(SynSwimmers obj) {
        if(this.startNumber == obj.startNumber) {
                return 0;
        }
        return (this.startNumber > obj.startNumber)?1:-1;
    }
}
