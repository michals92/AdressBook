import java.io.*;
import java.util.*;
/**
 * Write a description of class EmploymentOffice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmploymentOffice
{
   private SortedSet<Job> jobs = null;
   private List<Unemployed> unemployed = null;
   public static final String FILE_NAME = "DB.txt";
   
    public static void main(String [] args){
        EmploymentOffice eo = new EmploymentOffice();
        File f = new File(FILE_NAME);
        try {
            eo.loadData(f);
            for (Job j : eo.getJobs()){
                System.out.print(j + ":[");
                List<Unemployed> unemp= new ArrayList<Unemployed>();
                unemp.addAll(eo.findEmployees(j));
                int uSize = unemp.size();
                int counter = 1;
                for (Unemployed u : unemp){
                    System.out.print(u);
                    if (counter < uSize)
                        System.out.print(",");
                    counter++;
                }
                System.out.println("]");
            }
        }
        catch (EmploymentOfficeException ex){
           ex.printStackTrace();
           System.exit(1);
        }
    }
   
   public EmploymentOffice() {
       jobs = new TreeSet<Job>();
       unemployed = new ArrayList<Unemployed>();
   }
    
    public List<Unemployed> getUnemployed() {
        return Collections.unmodifiableList(unemployed);
    }
    
    public SortedSet<Job> getJobs() {
        return Collections.unmodifiableSortedSet(jobs);
    }
    
    public List<Unemployed> findEmployees(Job job) throws EmploymentOfficeException{
        if (job == null) {
            throw new IllegalArgumentException("job"); 
        }
        
        if (!jobs.contains(job)) { 
            throw new EmploymentOfficeException("Job neexistuje");
        }
        
        List<Unemployed> meets = new ArrayList<Unemployed>();
        for (Unemployed u : unemployed){
            if (job.checkApplicant(u))
                meets.add(u);
        }
        
        return meets;
    }
    
    public SortedSet<Job> findJobs(Unemployed person) throws EmploymentOfficeException{
        if (person == null) {
            throw new IllegalArgumentException("person");
        }
        
        if (!unemployed.contains(person)) {
            throw new EmploymentOfficeException("Person neexistuje");
        }
            
        SortedSet<Job> meets= new TreeSet<Job>();
        for (Job j : jobs){
            if (j.checkApplicant(person))
                meets.add(j);
        }
        
        return meets;
    }
    
    public void loadData(InputStream is) throws EmploymentOfficeException{
        
        if (is == null)
            throw new EmploymentOfficeException("is je null");
        List<Unemployed> newUnemployed = new ArrayList<Unemployed>();
        SortedSet<Job> newJobs = new TreeSet<Job>();
        
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = null;
                
                while ((line = reader.readLine()) != null){               
                    String[] split = line.split(":");
                    if (split[0].equals("job")){
                
                        if (split.length != 5){
                            throw new IOException("split != 5 " + split.length);
                        }
                
                        String id = split[1];
                        String position = split[2];
                        int salary = Integer.parseInt(split[3]);
                        int workingHours = Integer.parseInt(split[4]);
                        newJobs.add(new Job(id, position, salary, workingHours));
                    } else if (split[0].equals("unemployed")){
                        
                        if (split.length != 4){
                            throw new IOException("split != 4 " + split.length);
                        }
                
                        String name = split[1];
                        int minSalary = Integer.parseInt(split[2]);
                        int maxHoursPerDay = Integer.parseInt(split[3]);
                        newUnemployed.add(new Unemployed(name, minSalary, maxHoursPerDay));
            
                    }
                    else{
                        throw new IOException("Illegal format");
                    }         
                }
            }
            catch(IOException ex) {
                throw new EmploymentOfficeException("IOException", ex);
            }
            jobs.addAll(newJobs);
            unemployed.addAll(newUnemployed);
        }
          
    
    public void loadData(File file) throws EmploymentOfficeException{
       try (InputStream is = new FileInputStream(file) ) {
           loadData(is);
       }
       catch(IOException ex) {
           throw new EmploymentOfficeException(ex);
       }
   }
}
