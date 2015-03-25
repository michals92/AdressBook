/**
 * Person looking for a job.
 */
public class Unemployed {

    private String name;
    private int minSalary;
    private int maxHoursPerDay;
    
    /**
     * @param name Name
     * @param minSalary minimal salary required by the person
     * @param maxHoursPerDay maximal number of hours per day the person is willing to work
     * @throws IllegalArgumentexception if name is empty
     * @throws IllegalArgumentexception if minSalary or maxHoursPerDay <= 0
     */
    public Unemployed(String name, int minSalary, int maxHoursPerDay) {
        if (name == null || "".equals(name)) throw new IllegalArgumentException("name");
        if (minSalary <= 0) throw new IllegalArgumentException("minSalary");
        if (maxHoursPerDay <= 0) throw new IllegalArgumentException("maxHoursPerDay");
        this.name = name;
        this.minSalary = minSalary;
        this.maxHoursPerDay = maxHoursPerDay;
    }
    
    /**
     * @return Person's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return minimal salary required by the person
     */
    public int getMinSalary() {
        return minSalary;
    }
    
    /**
     * @return maximal number of hours per day the person is willing to work
     */
    public int getMaxHoursPerDay() {
        return maxHoursPerDay;
    }
    
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
