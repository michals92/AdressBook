/**
 * Figure scater.
 */
public class FigureScater implements Comparable<FigureScater>{

    private int startNumber;
    private String name;

    public FigureScater(int startNumber, String name) {
        if (startNumber <= 0) throw new IllegalArgumentException("startNumber");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name");
        this.startNumber = startNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStartNumber() {
        return startNumber;
    }

    @Override
    public String toString() {
        return startNumber + ":" + name;
    }
    
    @Override 
    public boolean equals(Object obj) {
         
        
        if(obj == null || !(obj instanceof FigureScater)) {
            return false;
        }
            
        
        return this.startNumber == ((FigureScater) obj).startNumber;
    }
    
    @Override public int hashCode() {
        return this.startNumber;
    }
    
    @Override public int compareTo(FigureScater obj) {
        if(this.startNumber == obj.startNumber) {
            return 0;    
        }
        return (this.startNumber > obj.startNumber)?1:-1;
    }
}
