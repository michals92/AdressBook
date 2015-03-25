
/**
 * Symmetric signalized crossroads with four road from nort, south, west and east.
 * The green light is always on opposite roads only.
 */
public class Crossroads
{
    private TrafficLights north = new TrafficLights(true);
    private TrafficLights south = new TrafficLights(true);
    private TrafficLights west  = new TrafficLights(false);
    private TrafficLights east  = new TrafficLights(false);
    private int throughput;

    /**
     * @param throughput Throughput of the crossroads
     * @throws IllegalArgumentException if the throughput argument is <= 0
     */
    public Crossroads(int throughput) {
        if (throughput <= 0) throw new IllegalArgumentException("throughput");
        this.throughput = throughput;
    }
    
    public int getThroughput() {
        return throughput;
    }
    
    /**
     * Car is comming to the crossroad from given direction.
     * 
     * @param car car
     * @param dir comming direction (either north, south, west or east)
     * @return true if the car went throught the crossroads immediately,
     *         false if the car stopped
     * @throws IllegalArgumentException if the comming direction is not known
     */
    public boolean comeTo(Car car, CardinalPoint dir) {
        switch (dir) {
            case WEST:  return west.comeTo(car);
            case EAST:  return east.comeTo(car);
            case NORTH: return north.comeTo(car);
            case SOUTH: return south.comeTo(car);
            default:    throw new IllegalArgumentException("dir");
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret = ret.append("North way has a " + (north.hasGreenLight() ? "green" : "red") + " light: ");
        ret = ret.append(north.getWaitingCars());
        ret = ret.append(System.getProperty("line.separator"));
        ret = ret.append("South way has a " + (south.hasGreenLight() ? "green" : "red") + " light: ");
        ret = ret.append(south.getWaitingCars());
        ret = ret.append(System.getProperty("line.separator"));
        ret = ret.append("West way has a " + (west.hasGreenLight() ? "green" : "red") + " light: ");
        ret = ret.append(west.getWaitingCars());
        ret = ret.append(System.getProperty("line.separator"));
        ret = ret.append("East way has a " + (east.hasGreenLight() ? "green" : "red") + " light: ");
        ret = ret.append(east.getWaitingCars());
        return ret.toString();
    }
    
    public void switchLights() {
        if (north.hasGreenLight() && south.hasGreenLight()) {
            try {
                north.setRed();
                south.setRed();
                west.setGreen(getThroughput());
                east.setGreen(getThroughput());
            }catch (Exception e) {
            }
        }else {
            try {
                west.setRed();
                east.setRed();
                north.setGreen(getThroughput());
                south.setGreen(getThroughput());
            }catch (Exception e) {
            }
        }
    }
}
