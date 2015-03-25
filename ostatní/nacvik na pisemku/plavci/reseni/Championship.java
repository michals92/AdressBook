import java.util.*;
import java.io.*;

/**
 * Championship in synchronized swimming.
 * 
 * @author James Bond
 * @version special
 */
public class Championship {
    
    public static final int REFEREES = 8;
    private SortedMap<SynSwimmers,List<Integer>> champ = null;
    
    public Championship() {
        champ = new TreeMap<SynSwimmers,List<Integer>>();
    }
    
    public void setMarks(SynSwimmers team, List<Integer> marks) throws IllegalArgumentException {
        if (team == null || marks == null) {
            throw new IllegalArgumentException("One of arguments is null.");
        }
        if (marks.size() != REFEREES) {
            throw new IllegalArgumentException("Not " + REFEREES + " marks.");
        }
        if (champ.containsKey(team)) {
            throw new IllegalArgumentException("Team already marked.");
        }
        champ.put(team, marks);
    }
    
    public List<Integer> getMarks(SynSwimmers team) throws IllegalArgumentException {
        if (team == null) {
            throw new IllegalArgumentException("Swimmer is null.");
        }
        if (!champ.containsKey(team)) {
            throw new IllegalArgumentException("Team not in competition.");
        }
        List<Integer> marks = new ArrayList<Integer>();
        marks.addAll(champ.get(team));
        return Collections.unmodifiableList(marks);
    }
    
    public SortedSet<SynSwimmers> getSynSwimmers() {
        SortedSet<SynSwimmers> teams = new TreeSet<SynSwimmers>(new SwimmerComparator());
        teams.addAll(champ.keySet());
        return Collections.unmodifiableSortedSet(teams);
    }
    
    public double getFinalMark(SynSwimmers ss) throws IllegalArgumentException {
        if (ss == null) {
            throw new IllegalArgumentException("Swimmer is null.");
        }
        if (!champ.containsKey(ss)) {
            throw new IllegalArgumentException("Team not in competition.");
        }
        List<Integer> marks = new ArrayList<Integer>();
        marks.addAll(champ.get(ss));
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
                for (int i = 0; i < REFEREES-1; i++) {
                    str.append((champ.get(s)).get(i) + ",");
                }
                str.append((champ.get(s)).get(REFEREES-1));
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
        Map<SynSwimmers,List<Integer>> newChamp = new TreeMap<SynSwimmers,List<Integer>>();
        try {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = null;
                while((line = reader.readLine()) != null){
                    
                    
                    String[] split = line.split(":",3);
                    if (split.length < 3) {
                        throw new IOException("Wrong format.");
                    }
                    
                    int number = 0;
                    String name = null;
                    List<Integer> marks = new ArrayList<Integer>();
                    
                    number = Integer.parseInt(split[0]);
                    name = split[1];
                    String[] s = split[2].split(",");
                    if (s.length != REFEREES) {
                        throw new IOException("Wrong format.");
                    }
                    for (int i = 0; i < REFEREES; i++) {
                        marks.add(Integer.parseInt(s[i]));
                    }
                    newChamp.put(new SynSwimmers(number, name), marks);
                }
            }
            catch (IOException ex) {
                throw new IOException(ex);
            }
            champ.putAll(newChamp);
        }
        finally {
            is.close();
        }
    }
}
