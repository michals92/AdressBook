import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class BookCase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookCase
{
   private List<Book> bookCase = new ArrayList<Book>();

   
   public void addBook(String author, String name) throws NullPointerException {
       if (author == null || name == null) {
           throw new NullPointerException();
        }
       
       Book book = new Book(author, name);
       
       bookCase.add(book);
       
    }
   
   public int remove(String author, String name) throws NullPointerException {
       if (author == null || name == null) {
           throw new NullPointerException();
        }
        
       int count = 0;
       
       Book book = new Book(author, name);
        
       if (bookCase.contains(book) == true) {
           
           bookCase.remove(book);
           count++;
        }
        

       return count; 
    }
    
    
   public Collection<Book> getBooks() {
       return Collections.unmodifiableList(bookCase);
    }
    
  
    
}
