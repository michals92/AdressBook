import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Book
{
    private String name;
    private String author;
    private List<Book> bookList = new ArrayList<Book>();
    
    public Book(String author, String name) {
        if (name == null) throw new IllegalArgumentException("name");
        if (author == null) throw new IllegalArgumentException("author");
        this.name = name;
        this.author = author;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAuthor() {
        return author;
    }
    
      
     public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (o == null || (!(o instanceof Book))) {
            return false;
        }
        
        Book other = (Book) o;

        
        return ((this.getName().equals(other.getName())) && (this.getAuthor().equals(other.getAuthor()))); 
           
       
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    public List<Book> sortList(List<Book> bookList) {
       
        List<Book> sortedList = new ArrayList<Book>();
        
        //return Collections.sort(sortedList);
        
        
        
        Collections.sort(sortedList, new Comparator<Book>() {

        
        }
    }

    
    public int compare(Book a, Book b) {
            int f = a.name.compareTo(b.name);
         return (f != 0) ? f : a.author.compareTo(b.author);
        }
}