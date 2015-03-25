import java.util.*;
import java.io.*;
/**
 * Write a description of class TheatreGuide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheatreGuide
{
    private Set<Play> rep = new TreeSet<Play>();
    
    
    
     public List<Play> getPlaysOfAuthor(String author) {
        if (author == null) {
            throw new NullPointerException("author"); 
        }
        
        List<Play> plays = new ArrayList<Play>();
        for (Play u : rep){
            if (u.getAuthor().equals(author))
                plays.add(u);
        }
        
        return plays;
    }
    
    
    public SortedSet<Play> getPlaysOfActor(String actor) {
        SortedSet<Play> plays = new TreeSet<Play>();
        
    
        for (Play u : rep){
            if (u.getActors().equals(actor))
                plays.add(u);
        }
        
        return Collections.unmodifiableSortedSet(plays);
    }
    
    public SortedSet<Play> getAllPlays() {
        SortedSet<Play> plays = new TreeSet<Play>(new PlaysComparator());
         for (Play u : rep){
                plays.add(u);
        }
        
        return Collections.unmodifiableSortedSet(plays);
    }
    
    public SortedSet<Play> removePlaysOfAuthor(String author) {
        SortedSet<Play> removed = new TreeSet<Play>();
        
         Iterator<Play> iterator = removed.iterator();
         while(iterator.hasNext()) {
             Play setElement = iterator.next();
             if(setElement.getAuthor().equals(author)) {
                 removed.add(setElement);
                 iterator.remove();
                }
            }
        
        return Collections.unmodifiableSortedSet(removed);
    }
    
    public void read(InputStream is) throws TheatreException, IOException{
         SortedSet<Play> auxMap = new TreeSet<Play>();
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 3);
            
                if (parts.length != 3) {
                    throw new TheatreException("Length of array is not 3.");
                }
                
                String[] s = parts[2].split(",");
                
                auxMap.add(new Play(parts[0], parts[1], s));
            }
        }     catch(TheatreException ex) {
            throw new TheatreException("Input error", ex);
        }
        rep.addAll(auxMap);
    }
    
    public void read(File file) throws TheatreException, IOException{
        try (InputStream is = new FileInputStream(file) ) {
            read(is);
        }
        catch(TheatreException ex) {
            throw new TheatreException("File read error", ex);
        }
    }
    
    public void write(Writer writer) throws IOException{
        if (writer == null) {
            throw new IOException("Output stream is null.");
        }
        BufferedWriter writer2 = null;
        try {
            writer2 = new BufferedWriter(writer);
            StringBuilder str = new StringBuilder();
            for (Play p : rep) {
                str.delete(0,str.length());
                str.append(p.toString() + ";");
                for (int i = 0; i < p.getActors().size()-1; i++) {
                    str.append(p.getActors().get(i) + ",");
                }
                str.append(p.getActors().get(p.getActors().size()-1));
                writer2.write(str.toString());
                writer2.newLine();

            }
        }
        catch (IOException ex) {
            throw new IOException(ex);
        }
        finally {
            writer2.flush();
        }
    }
}
