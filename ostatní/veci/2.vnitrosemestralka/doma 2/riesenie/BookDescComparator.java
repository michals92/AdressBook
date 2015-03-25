import java.util.Comparator;
import java.lang.Comparable;

/**
 * Write a description of class BookDescComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookDescComparator implements Comparator<Book>
{
    
    public int compare(Book book1, Book book2) {
        return book2.compareTo(book1);
    }
}
