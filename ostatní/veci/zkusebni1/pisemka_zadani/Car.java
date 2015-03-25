
/**
 * Car.
 */
public class Car
{
    private String registration;
    
    /**
     * @param registraction registration (i.e. license number)
     */
    public Car(String registration) {
        if (registration == null) throw new NullPointerException("registration");
        this.registration = registration;
    }
    
    /**
     * @return registraction (license number)
     */
    public String getRegistration() {
        return registration;
    }
    
    @Override
    public String toString() {
        return registration;
    }
    
    public boolean equals(Object obj) {
         if (obj == this) {
            return true;
        }
        
        if (obj == null || (!(obj instanceof Car))) {
            return false;
        }
        
        Car car = (Car) obj;
        return (this.getRegistration().equals(car.getRegistration()));
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
}
