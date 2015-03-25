import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.*;

/**
 * Play
 * 
 */
public class Play implements Comparable<Play>
{
    private String title;
    private String author;
    private List actors = null;

    /**
     * @param title Title of the play
     * @param author Author
     * @param actors Actors
     * @throws IllegalArgumentException if some parameter is missing
     */
    public Play(String title, String author, String[] actors) {
        if (title        == null || title.isEmpty())        throw new IllegalArgumentException("title");
        if (author   == null || author.isEmpty())    throw new IllegalArgumentException("author");
        if (actors    == null || actors.length == 0) throw new IllegalArgumentException("actors");
   
        this.actors = new ArrayList<String>(Arrays.asList(actors));
        this.title = title;
        this.author = author;
    }
    
    /**
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Author
     */
    public String getAuthor() {
        return author;
    }
    
    @Override
    public String toString() {
        return title + " by " + author;
    }
    
    public List<String> getActors() {
        return Collections.unmodifiableList(actors);
    }
    
     @Override
    public boolean equals(Object obj) {

        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            
        Play play = (Play) obj;
        return (title.equals(play.title));
    }
    
    @Override 
    public int hashCode() {
        return title.hashCode();
    }
   

    public int compareTo(Play obj) {
        return this.title.compareTo(obj.title);
    }
}
