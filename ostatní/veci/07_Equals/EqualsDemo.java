public class EqualsDemo {
    public static void main(String[] args) {
        
       double[] a = new double[3];
       a[0] = -1.2;
       a[1] = -.5;
       a[2] = 3;
        
       for(int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
       }
        
       Person[] people = new Person[3];
       
       Person honza = new Person("Honza");
       Person honza1 = new Person("Honza");
 
       System.out.println("== ?    "+(honza == honza1));
       System.out.println("equals? "+honza.equals(honza1));

       people[0] = honza;
       people[1] = new Person("Pepa");
       people[2] = new Person("Franta");
       
       honza.setName("Jan");

       for(int i = 0; i < people.length; i++) {
            System.out.println("people[" + i + "]=" + people[i].getName());
       }
      
    }
}
class Person {
    private String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; } 
}