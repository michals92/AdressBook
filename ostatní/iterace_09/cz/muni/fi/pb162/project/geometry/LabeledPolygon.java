package cz.muni.fi.pb162.project.geometry;
import java.util.*;
import java.io.*;
/**
 * Polygon, vrcholy ulozeny pod svymi nazvy.
 * 
 * @author Michal Simik 
 * @version 1.12.2014
 */
public class LabeledPolygon extends SimplePolygon implements PolygonIO
{
    private SortedMap<String, Vertex2D> vertex = new TreeMap<String, Vertex2D>();

     /**
     * Add vertex to polygon
     * 
     * @param label - label of vertex
     * @param value - value of vertex
     */
    public void addVertex(String label, Vertex2D vert) {
        if(label == null) {
            throw new NullPointerException("Vertex label in null.");
        }
        
        if(vert == null) {
            throw new NullPointerException("Vertex is null.");
        }
        
        vertex.put(label, vert);
    }
    
    /**
     * Returns vertex of specified name
     * 
     * @param label - name of vertex 
     * @return vertex - value of vertex
     */
    public Vertex2D getVertex(String label) {
        if(!vertex.containsKey(label)) {
            throw new IllegalArgumentException("Tree does not contains vertex.");
        }
        return vertex.get(label);
    }
    
    /**
     * Returns vertex on specified index
     * 
     * @param index - number of index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    public Vertex2D getVertex(int index) {
       if(index < 0) {
            throw new IllegalArgumentException("Index is negative.");
       }
       
       Vertex2D[] vertex2 = vertex.values().toArray(new Vertex2D[vertex.size()]);
       return vertex2[index % vertex.size()];
    }
        
    /**
     * Returns number of vertices of the polygon.
     * 
     * @return number of vertices
     */
    public int getNumVertices() {
        return vertex.size();
    }
    
    /**
     * Returns collection of labels ascendently.
     * 
     * @return set of labels
     */
    public Collection<String> getLabels() {
        Set<String> labels = new TreeSet<String>();
        for(String i: vertex.keySet()) {
            labels.add(i);
        }
        
        return Collections.unmodifiableCollection(labels);
    }

    /**
     * Returns sorted vertices
     * 
     * @return set of sorted vertices
     */
     public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<Vertex2D>(vertex.values());
    }
    
    /**
     * Returns sorted vertices with defined comparator
     * 
     * @param comparator
     * @return set of sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
       SortedSet<Vertex2D> values = new TreeSet<Vertex2D>(comparator);
       
       values.addAll(vertex.values());
       
       return values;
    }
     
    /**
     * Returns labels of all vertices with same position
     * 
     * @param vert position 
     * @return set of labels
     */
    public Collection<String> getLabels(Vertex2D vert) {
        Set<String> labels = new HashSet<String>();
        
        for(String i: vertex.keySet()) {
            if(vertex.get(i).equals(vert)) {
                labels.add(i);
            }
        }
        
        return labels;
    }
    
    /**
     * Returns vertices that are duplicates
     * 
     * @return set of equal vertices
     */
       public Collection<Vertex2D> duplicateVertices() {
        Collection<Vertex2D> equalVert = new HashSet<Vertex2D>();
        Vertex2D[] tempEqualVert = new Vertex2D[vertex.size()];
       
        vertex.values().toArray(tempEqualVert);
       
        for (int i = 0; i < vertex.size()-1; i++){
            for (int j = i+1; j < vertex.size(); j++){      
                if (tempEqualVert[i].equals(tempEqualVert[j])){
                equalVert.add(tempEqualVert[i]);
               }
            }
        }
       
        return equalVert;
    }

    /**
     * Reads vertices and their labels from InputStream
     * 
     * @param InputStream is - specified stream to read
     * @throws IOException - when read error
     */
    public void read(InputStream is) throws IOException {

        SortedMap<String, Vertex2D> auxMap = new TreeMap<String, Vertex2D>();
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 3);
            
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Length of array is not 3.");
                }
                
                double x, y;
                try {
                    x = Double.parseDouble(parts[0]);
                    y = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    throw new IOException("Error parsing double.",e);
                }
                
                auxMap.put(parts[2], new Vertex2D(x, y));
            }
        }     catch(IOException ex) {
            throw new IOException("Input error", ex);
        }
        vertex.putAll(auxMap);
    }
    
    /**
     * Reads vertices and their labels from file
     * 
     * @param File file - specified file
     * @throws IOException - when read error
     */
    public void read(File file) throws IOException{
        try (InputStream is = new FileInputStream(file) ) {
            read(is);
        }
        catch(IOException ex) {
            throw new IOException("File read error", ex);
        }
    }
    
    /**
     * Writes all vertices and their labels into OutputStream
     * 
     * @param OutpustStream os - output to write
     * @throws IOException - when write error
     */
    public void write(OutputStream os) throws IOException {
        BufferedWriter aux = new BufferedWriter(new OutputStreamWriter(os));
        String output = "";
        Vertex2D vert = null;
        
        try {
            for(Map.Entry<String, Vertex2D> entry : vertex.entrySet()) {
                vert = entry.getValue();
                aux.write(vert.getX() + " " + vert.getY() + " " + entry.getKey());
                aux.newLine();
            }
        }
        catch(IOException ex) {
            throw new IOException("Output error", ex);
        }        
    }
    
    /**
     * Writes all vertices and their labels into file
     * 
     * @param File file - file to write
     * @throws IOException - when write error
     */
    public void write(File file) throws IOException {
        try (OutputStream os = new FileOutputStream(file)){
            write(os);        
        }
        catch(IOException ex) {
            throw new IOException("File write error", ex);
        }
    }
    
    /**
     * Writes all vertices and their labels into OutputStream binary
     * 
     * @param OutpustStream os - output to write
     * @throws IOException - when write error
     */
    public void binaryWrite(OutputStream os) throws IOException {
        for(String s: vertex.keySet()) {
            byte [] line = (vertex.get(s).getX() + " " + vertex.get(s).getY() + " " + s + System.lineSeparator()).getBytes();
            os.write(line);          
        }
        os.flush();
     }
}

