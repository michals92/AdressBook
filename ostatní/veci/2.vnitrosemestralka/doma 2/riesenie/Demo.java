
import java.util.Set;
import java.util.HashSet;

/**
 * Demo class
 * 
 */
public class Demo
{
    public static void main(String[] args) {
        Bookcase bookcase = new Bookcase();
        bookcase.addBook("Bozena Nemcova", "Devet Krizu");
        bookcase.addBook("Bozena Nemcova", "Babicka");
        bookcase.addBook("Karel Capek", "RUR");
        bookcase.addBook("Bozena Nemcova", "Babicka");
        
        try {
            bookcase.addBook(null, "Babicka");
            System.out.println("ERROR in addBook()");
        } catch(NullPointerException ex) {
        } catch(IllegalArgumentException ex) {
        }
        
        try {
            bookcase.addBook("Bozena Nemcova", null);
            System.out.println("ERROR in addBook()");
        } catch(NullPointerException ex) {
        } catch(IllegalArgumentException ex) {
        }
        
        System.out.println("Books in bookcase (order does'n matter):");
        System.out.println(bookcase.getBooks());
        System.out.println();
        System.out.println("Catalogue in natural ordering (order does matter):");
        System.out.println(bookcase.getCatalogue());
        System.out.println();
        System.out.println("Catalogue ordered by comparator (order does matter):");
        System.out.println(bookcase.getCatalogue(new BookDescComparator()));
        System.out.println();
        System.out.print("Number of removed books \"Babicka\" (should be 2): ");
        System.out.println(bookcase.remove("Bozena Nemcova", "Babicka"));
        System.out.println("Books in bookcase (order does'n matter):");
        System.out.println(bookcase.getBooks());
        System.out.println();
        
    }
}
