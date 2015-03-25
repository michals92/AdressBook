public class Person {

    private String name;
    private ITicket ticket;

    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ITicket getTicket() {
        return this.ticket;
    }
    
    public void setTicket(ITicket ticket) {
        this.ticket = ticket;
    }

    public void removeTicket() {
        this.ticket = null;
    }
}
