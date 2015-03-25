import java.util.List;
import java.util.ArrayList;

public class ListDemo
{
    public static void main(String[] args)
    {
        List<String> ls = new ArrayList<>();
        
        ls.add("Ahoj");
        ls.add("Cheers");
        ls.add("Nazdar");
        
        System.out.println(ls.get(0));
        ls.add(0, "Bye");
        System.out.println(ls.get(0));
        
        System.out.println("Whole list:");
        
        for(int i = 0; i < ls.size(); i++) {
            System.out.println(i + ". " + ls.get(i));
        }
        
        System.out.println("Whole list without indices:");
        
        for(String s: ls) {
            System.out.println(s);
        }
    }
}