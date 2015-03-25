import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SetDemo
{
    private Set<Person> people;
    
    public SetDemo() {
        people = new HashSet<>();
    }
    
    public Collection<Person> getPeople() {
        return Collections.unmodifiableCollection(people);
    }
    
    public void init() {
        
        people.add(new Person("Jan Novak", "2014/11/20"));
        people.add(new Person("Jan Novak", "2014/11/20"));
        people.add(new Person("Jan Novak", "1970/11/20"));
        people.add(new Person("Jan Novak", "2014/10/21") );
        
        //getPeople().add(new Person("Pavel Novotny", "2014/10/21"));
        
        System.out.println("Contains?: "
           +people.contains(new Person("Jan Novak", "2014/10/21")));
        }
    
    public static void main(String[] args)
    {
        SetDemo d = new SetDemo();
        d.init();
        
        for(Iterator<Person> i = d.getPeople().iterator(); i.hasNext(); ) {
            Person person = i.next();
            System.out.println(person);
        }
        
        Map<Person, Double> salaries = new HashMap<>();
        salaries.put(new Person("Jan Novak", "2014/11/20"), 10000.0);
        salaries.put(new Person("Jan Novak", "1970/11/20"), 50000.0);

        
        salaries.put(new Person("Jan Novak", "2014/11/20"), 20000.0);

        double salary = salaries.get(new Person("Jan Novak", "2014/11/20"));
        System.out.println(salary);
    }
}
class Person {
    private String name;
    private String date;
    public Person(String name, String date) { this.name = name; this.date = date; }
    public String toString() { return name+" born "+date; }
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person p = (Person)obj;
            return name.equals(p.name) && date.equals(p.date);
        } else return false;
    }
    public int hashCode() {
        return name.hashCode() ^ date.hashCode();
    }
}