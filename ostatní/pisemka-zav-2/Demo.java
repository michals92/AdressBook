import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.File;

public class Demo
{
    public static void main(String[] args) throws IOException, TheatreException {
        TheatreGuide guide = new TheatreGuide();
        guide.read(new File("input.txt"));
        guide.removePlaysOfAuthor("Fake Author");
        System.out.println("Plays of William Shakespeare  sorted by title:");
        System.out.println(guide.getPlaysOfAuthor("William Shakespeare"));
        System.out.println();
        System.out.println("Plays of actor Petr Blaha sorted by title:");
        System.out.println(guide.getPlaysOfActor("Petr Blaha"));
        System.out.println();
        System.out.println("All plays sorted by authors:");
        System.out.println(guide.getAllPlays());
        System.out.println();
        System.out.println("Output of write() method /order does not matter/:");
        guide.write(new OutputStreamWriter(System.out));
    }
}
