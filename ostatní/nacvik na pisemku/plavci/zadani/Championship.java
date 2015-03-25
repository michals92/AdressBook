import java.util.*;
import java.io.*;

/**
 * Write a description of class Championship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Championship
{
    public static final int REFEREE = 8;
    private SortedMap<SynSwimmers, List<Integer>> champ = null;

    /**
     * Constructor for objects of class Championship
     */
    public Championship()
    {
        champ = new TreeMap<SynSwimmers, List<Integer>>();
    }

    public void setMarks(SynSwimmers swimmers, List<Integer> marks) {
        if (swimmers == null || marks == null) {
            throw new NullPointerException();
        }
        
        if (marks.size() != REFEREE || champ.containsKey(swimmers)) {
            throw new IllegalArgumentException();
        }
        
        champ.put(swimmers, marks);
        
    }
    
    public List<Integer> getMarks(SynSwimmers ss) {
        if (ss == null) {
            throw new NullPointerException("Swimmers are null");
        }
        
        if (!champ.containsKey(ss)) {
            throw new IllegalArgumentException("Swimmers are not in Map");
        }
        return Collections.unmodifiableList(champ.get(ss));
    }
    
    public Set<SynSwimmers> getSynSwimmers() {
        SortedSet<SynSwimmers> teams= new TreeSet<SynSwimmers>(new SwimmersComparator());
        teams.addAll(champ.keySet());
        return Collections.unmodifiableSortedSet(teams);
    }
    
    public double getFinalMark(SynSwimmers ss) {
        if (ss == null) {
            throw new IllegalArgumentException("Swimmer is null.");
        }
        if (!champ.containsKey(ss)) {
            throw new IllegalArgumentException("Team not in competition.");
        }
        
        List<Integer> marks = new ArrayList<Integer>();

        marks.addAll(champ.get(ss));

      
        marks.remove(marks.indexOf(Collections.max(marks)));
        marks.remove(marks.indexOf(Collections.min(marks)));
        
        double mark = 0.0;

        for (Integer i : marks) {
            mark += i;
        }
        
        return mark/marks.size();
    }
    
    public void store(OutputStream os) throws IOException {
        BufferedWriter writer = null;
        if (os == null) {
            throw new IOException("Output stream is null.");
        }
        try {
            writer = new BufferedWriter(new OutputStreamWriter(os));
            StringBuilder str = new StringBuilder();
            for (SynSwimmers s : champ.keySet()) {
                str.delete(0,str.length());
                str.append(s.toString() + ":");
                for (int i = 0; i < REFEREE-1; i++) {
                    str.append((champ.get(s)).get(i) + ",");
                }
                str.append((champ.get(s)).get(REFEREE-1));
                writer.write(str.toString());
                writer.newLine();
            }
        }
        catch (IOException ex) {
            throw new IOException(ex);
        }
        finally {
            writer.flush();
        }
    }
    
    public void store(File file) throws IOException {
        try (OutputStream os = new FileOutputStream(file)){
            store(os);        
        }
        catch(IOException ex) {
            throw new IOException("File write error", ex);
        }
    }
    
    
    public void load(File f) throws IOException{
        try (InputStream is = new FileInputStream(f) ) {
            SortedMap<SynSwimmers, List<Integer>> auxMap = new TreeMap<SynSwimmers, List<Integer>>();
            
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = null;
            
                while((line = reader.readLine()) != null) {
                    String[] parts = line.split(":", 3);
                
                    if (parts.length != 3) {
                        throw new IllegalArgumentException("Length of array is not 3.");
                    }
                    
                    int number = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    List<Integer> marks = new ArrayList<Integer>();
                    
                    String[] s = parts[2].split(",");
                    if (s.length != REFEREE) {
                            throw new IOException("Wrong format.");
                        }
                    
                    for (int i = 0; i < REFEREE; i++) {
                            marks.add(Integer.parseInt(s[i]));
                        }
                    
                    auxMap.put(new SynSwimmers(number, name), marks);
                }
            }     
            catch(IOException ex) {
                throw new IOException("Input error", ex);
            }
            champ.putAll(auxMap);
        }
        catch(IOException ex) {
            throw new IOException("File read error", ex);
        }

    }
}
