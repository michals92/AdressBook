
/**
 * Job.
 */
public class Job implements Comparable<Job>
{
    private String id;
    private String position;
    private int    salary;
    private int    workingHours;
    
    /**
     * @param id Job's ID
     * @param position Title of the offered position
     * @param salary Salary
     * @param workingHours Working hours per day
     * @throws IllegalArgumentException If id or position are empty
     * @throws IllegalArgumentException If salary or workingHours are <= 0
     */
    public Job(String id, String position, int salary, int workingHours) {
        if (id == null || "".equals(id)) throw new IllegalArgumentException("id");
        if (position == null || "".equals(position)) throw new IllegalArgumentException("position");
        if (salary <= 0) throw new IllegalArgumentException("salary");
        if (workingHours <= 0) throw new IllegalArgumentException("workingHours");
        this.id = id;
        this.position = position;
        this.workingHours = workingHours;
        this.salary = salary;
    }
    
    /**
     * @param unemployed Applicant for the job
     * @throws NullPointerException if unemployed is null
     */
    public boolean checkApplicant(Unemployed unemployed) {
        return unemployed.getMaxHoursPerDay() >= this.workingHours &&
               unemployed.getMinSalary() <= this.salary;
    }  
    
    
    @Override 
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }    
        
        if(obj == null || !(obj instanceof Job)) {
            return false;
        }
            
        Job job = (Job) obj;
        return (id.equals(job.id));
    }
    
    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
   
     public int compareTo(Job j) {
        return this.id.compareTo(j.id);
    }
    
    @Override
    public String toString() {
        return id + ":" + position;
    }
    
}
