/**
 * A team of synchronized swimmers.
 */
public class SynSwimmers implements Comparable<SynSwimmers> {

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
    
    public boolean equals(Object obj){
        if(!(obj instanceof SynSwimmers)){
            return false;
        }
        return this.startNumber == ((SynSwimmers)obj).getStartNumber();
    }
    
    public int hashCode() {
        return this.startNumber;
    }
    
    public int compareTo(SynSwimmers swimmer) {
        return this.startNumber - swimmer.getStartNumber();
    }
}