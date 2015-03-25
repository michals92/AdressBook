import java.io.*;
import java.util.*;

public class Demo {

    public static void main(String[] args) throws Exception {

        Championship champ = new Championship();
        
        SynSwimmers ss1 = new SynSwimmers(1, "Czech Republic");
        SynSwimmers ss2 = new SynSwimmers(2, "China");
        SynSwimmers ss3 = new SynSwimmers(3, "China");
        SynSwimmers ss4 = new SynSwimmers(1, "Czech Republic");
        
        List<Integer> marks1 = new ArrayList<Integer>();
        marks1.add(7);
        marks1.add(7);
        marks1.add(5);
        marks1.add(8);
        marks1.add(7);
        marks1.add(5);
        marks1.add(7);

        try {
            champ.setMarks(ss1, marks1);
            System.out.println("Required exception has not been thrown.");
        } catch(IllegalArgumentException ex) {
        } catch(Exception ex) {
            System.out.println("Unexpected exception: " + ex);
        }
        
        marks1.add(8);
        champ.setMarks(ss1, marks1);
        
        try {
            champ.setMarks(ss4, marks1);
            System.out.println("Required exception has not been thrown when marks are already set");
        } catch(IllegalArgumentException ex) {
        } catch(Exception ex) {
            System.out.println("Unexpected exception: " + ex);
        }
        
        System.out.println("Czech Rep. marks: " + champ.getMarks(ss1));
        System.out.println("Czech Rep. final mark: " + String.format("%.2f", champ.getFinalMark(ss1)));
        
        System.out.println("Re-loading from file...");
        champ = new Championship();
        champ.load(new File("championship.txt"));
        System.out.println("Syn. swimmers and their final marks /order does matter/:");
        for (SynSwimmers ss: champ.getSynSwimmers()) {
            System.out.println(ss + ":" + String.format("%.2f", champ.getFinalMark(ss)));
        }
        System.out.println("Product of store() method /order of lines does not matter/:");
        champ.store(System.out);
    }
}
