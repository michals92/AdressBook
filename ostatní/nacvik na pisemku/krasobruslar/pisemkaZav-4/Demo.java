import java.io.*;
import java.util.*;

public class Demo {

    public static void main(String[] args) throws Exception {

        Competition comp = new Competition();
        
        FigureScater fs1 = new FigureScater(1, "Pljuscenko");
        FigureScater fs2 = new FigureScater(2, "Chan");
        FigureScater fs3 = new FigureScater(3, "Chan");
        FigureScater fs4 = new FigureScater(1, "Pljuscenko");
        
        List<Integer> marks1 = new ArrayList<Integer>();
        marks1.add(7);
        marks1.add(7);
        marks1.add(5);
        marks1.add(8);
        marks1.add(7);
        
        try {
            comp.setMarks(fs1, marks1);
            System.out.println("Required expected has not been thrown: ");
        } catch(IllegalArgumentException ex) {
        } catch(Exception ex) {
            System.out.println("Unexpected exception: " + ex);
        }
        
        marks1.add(8);
        comp.setMarks(fs1, marks1);
        
        System.out.println("Pljuscenko's marks: " + comp.getMarks(fs1));
        System.out.println("Pljuscenko's final mark: " + comp.getFinalMark(fs1));
        
        System.out.println("Re-loading from file...");
        comp = new Competition();
        comp.load(new File("competition.txt"));
        System.out.println("Figure scaters and their final marks /order does matter/:");
        for (FigureScater fs: comp.getScaters()) {
            System.out.println(fs + ":" + comp.getFinalMark(fs));
        }
        System.out.println("Product of store() method /order of lines does not matter/:");
        comp.store(System.out);
    }
}
