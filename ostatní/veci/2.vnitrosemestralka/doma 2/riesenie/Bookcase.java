import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Write a description of class Bookcase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bookcase
{
    private List<Book> books = new ArrayList<Book>();
    
    public void addBook(String author, String name) {
        if (author == null){
            throw new NullPointerException("author");
        }
        if (name == null) {
            throw new NullPointerException("name");
        }
        books.add(new Book(author, name));
    }
    
    public int remove(String author, String name) {
        if (author == null){
            throw new NullPointerException("author");
        }
        if (name == null) {
            throw new NullPointerException("name");
        }
        Book book = new Book(author, name);
        int counter = 0;
        for (int i=0; i< books.size(); i++) {
            if (books.get(i).equals(book)) {
                counter++;
            }
        }
        for (int i=0; i<counter; i++) {
            books.remove(book);
        }
        return counter;
    }
    
    public Collection<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
    
    public Collection<Book> getCatalogue() {
        SortedSet<Book> tempSet = new TreeSet<Book>();
        tempSet.addAll(books);
        return tempSet;
    }
    
    public Collection<Book> getCatalogue(Comparator<Book> comparator) {
        SortedSet<Book> tempSet = new TreeSet<Book>(comparator);
        tempSet.addAll(books);
        return tempSet;
    }
}
