
public class Book
{
    private String name;
    private String author;
    
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
    
    @Override
    public String toString() {
        return author + ": " + name; 
    }
}
