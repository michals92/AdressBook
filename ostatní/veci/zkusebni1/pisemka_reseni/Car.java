
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
    
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (o == null || (!(o instanceof Car))) {
            return false;
        }
        
        Car car = (Car) o;
        return (this.getRegistration().equals(car.getRegistration()));
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
}
