
/**
 * Dancer.
 */
public class Dancer
{
    private Dancer partner;
    
    private boolean female;
    
    private int number;

    /**
     * @param number Dancer's number
     * @param isFemale Dancer's genre
     */
    public Dancer(int number, boolean isFemale) {
        this.number = number;
        female = isFemale;
    }
    
    /**
     * @return true if the dancer has a partner
     */
    public boolean hasPartner() {
        return partner != null;
    }
    
    /**
     * @return true if the dancer is female
     */
    public boolean isFemale() {
        return female;
    }    

    /**
     * @return true if the dancer is male
     */
    public boolean isMale() {
        return !female;
    }  
    
    /**
     * @return dancer's number
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Breaks the dancing pair, i.e. unsets partner of this dancer and vice versa.
     * 
     * @return false if this dancer had no partner.
     */
    public boolean unsetPartner() {
        if (!hasPartner()) return false;
        partner.partner = null;
        partner = null;
        return true;
    }
    
    @Override
    public String toString() {
        if (female) {
            return "Female dancer No. " + number;
        } else {
            return "Male dancer No. " + number;
        }
    }
    
    public void setPartner(Dancer partner) throws DancerException{
        if(partner == null) {
            throw new NullPointerException("Partner is null");
        }
        
        if(this.partner != null || partner.partner != null) {
            throw new DancerException("One of pair has already partner");
        }
        
        if((this.isFemale() && partner.isFemale()) || (this.isMale() && this.isMale())) {
            throw new DancerException("Dancers of same genre");
        }
        
        this.partner = partner;
        partner.partner = this;
    }
    
    @Override 
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }    
        
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            
        Dancer dancer = (Dancer) obj;
        return this.number == dancer.number;
    }
    
    @Override public int hashCode() {
        int result = 13;
        
        result = result * 17 + (int) getNumber();
        
        return result;
    }
    
}
