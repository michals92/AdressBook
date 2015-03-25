import java.io.*;
import java.util.*;

/**
 * Write a description of class Competition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Competition
{
    private SortedMap<FigureScater,List<Integer>> comp = null;
   
    public Competition() {
        comp = new TreeMap<FigureScater,List<Integer>>();
    }

    public void setMarks(FigureScater scater ,List<Integer> marks) throws IllegalArgumentException
    {
        
        if(scater == null || marks == null) {
            throw new NullPointerException("Scater or marks are null.");
        }
        
        if (marks.size() != 6) {
            throw new IllegalArgumentException("Input does not have 6 marks");
        }
        if (comp.containsKey(scater)) {
            throw new IllegalArgumentException("Scater already marked.");
        }
        
        comp.put(scater, marks); 
    }
    
    public Collection<Integer> getMarks(FigureScater scater) throws IllegalArgumentException {
        if(scater== null) {
            throw new NullPointerException("Scater is null.");
        }

        if(!comp.containsKey(scater)) {
            throw new NullPointerException("Scater is not in collection");
        }
        List<Integer> marks = new ArrayList<Integer>();
        marks.addAll(comp.get(scater));
        return Collections.unmodifiableList(marks);
    }
    
    public Collection<FigureScater> getScaters() {
        SortedSet<FigureScater> scaters = new TreeSet<FigureScater>(new ScaterComparator());
        scaters.addAll(comp.keySet());
        return Collections.unmodifiableSortedSet(scaters);
    }
    
    public double getFinalMark(FigureScater scater) throws IllegalArgumentException {
        if (scater == null) {
            throw new IllegalArgumentException("Scater is null.");
        }
        
        if (!comp.containsKey(scater)) {
            throw new IllegalArgumentException("Scater not in competition.");
        }
        
        List<Integer> marks = new ArrayList<Integer>();
        marks.addAll(comp.get(scater));
        marks.remove(marks.indexOf(Collections.min(marks)));
        marks.remove(marks.indexOf(Collections.max(marks)));
        double mark = 0.0;
        int num = 0;
        for (Integer i : marks) {
            mark += i;
            num++;
        }
        return mark/((double)num);
    }
    
    public void store(OutputStream os) throws IOException {
        if (os == null) {
            throw new IOException("Output stream is null.");
        }
        
        BufferedWriter aux = new BufferedWriter(new OutputStreamWriter(os));
        
        
        try {
            StringBuilder str = new StringBuilder();
            for (FigureScater s : comp.keySet()) {
                str.delete(0,str.length());
                str.append(s.toString() + ":");
                for (int i = 0; i < 5; i++) {
                    str.append((comp.get(s)).get(i) + ",");
                }
                str.append((comp.get(s)).get(6-1));
                aux.write(str.toString());
                aux.newLine();
            }
        }
        catch(IOException ex) {
            throw new IOException("Output error", ex);
        }        
        finally {
            aux.flush();
        }
    }
    
    public void store(File file) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        try {
            store(out);
        }
        finally {
            out.close();
        }
    }
    
    public void load(File f) throws IOException {
        FileInputStream is = new FileInputStream(f);
        
        Map<FigureScater,List<Integer>> newComp = new TreeMap<FigureScater,List<Integer>>();
        try {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = null;
                
                while( (line = reader.readLine()) != null){
                    int number = 0;
                    String name = null;
                    List<Integer> marks = new ArrayList<Integer>();
                    String[] split = line.split(":",3);
                    if (split.length != 3) {
                        throw new IOException("Wrong format.");
                    }
                    number = Integer.parseInt(split[0]);
                    name = split[1];
                    String[] s = split[2].split(",");
                    if (s.length != 6) {
                        throw new IOException("Wrong format.");
                    }
                    for (int i = 0; i < 6; i++) {
                        marks.add(Integer.parseInt(s[i]));
                    }
                    newComp.put(new FigureScater(number, name), marks);
                    
                }
            }
            catch (IOException ex) {
                throw new IOException(ex);
            }
            comp.putAll(newComp);
        }
        finally {
            is.close();
        }
    }
}
