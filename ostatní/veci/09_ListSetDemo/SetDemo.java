import java.util.Set;
import java.util.HashSet;

public class SetDemo
{
    public static void main(String[] args)
    {
        Set<String> ss = new HashSet<>();
        
        ss.add("Ahoj");
        ss.add("Cheers");
        ss.add("Nazdar");
        ss.add("Nazdar");
        
        System.out.println("Whole set:");
        
        for(String s: ss) {
            System.out.println(s);
        }
        
        System.out.println("Contains Ahoj?: "+ss.contains("Ahoj"));
    }
}