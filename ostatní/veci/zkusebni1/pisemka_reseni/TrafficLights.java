import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Write a description of class TrafficLights here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrafficLights
{
    private List<Car> carQueue = new ArrayList<Car>();
    boolean color;

    public TrafficLights(boolean color) {
        this.color = color;
    }
    
    public boolean hasGreenLight() {
        return color;
    }
    
    public void setRed() throws TrafficLightsException {
        if (!hasGreenLight()) {
            throw new TrafficLightsException("It's already red.");
        }
        color = false;
    }
    
    public List<Car> setGreen(int throughput) throws TrafficLightsException, IllegalArgumentException {
        if (hasGreenLight()) {
            throw new TrafficLightsException("It's already green.");
        }
        if (throughput <= 0) {
            throw new IllegalArgumentException("Throughput is lower then 1.");
        }
        
        color = true;
        
        List<Car> passedCars = new ArrayList<Car>();
        
        for (int i=0; i < throughput; i++) {
            passedCars.add(carQueue.get(0));
            carQueue.remove(0);
        }
        
        return passedCars;
    }
    
    public boolean comeTo(Car car) throws NullPointerException, IllegalArgumentException {
        if (car == null) {
            throw new NullPointerException("Car is null.");
        }
        
        if (carQueue.contains(car)) {
            throw new IllegalArgumentException("Car is already in queue.");
        }
        
        if (hasGreenLight() && carQueue.isEmpty()) {
            return true;
        }
        
        carQueue.add(car);
        return false;
    }
    
    public List<Car> getWaitingCars() {
        return Collections.unmodifiableList(carQueue);
    }
}
