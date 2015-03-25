public class Demo {

    public static void main(String[] args) {
        Person p1 = new Person("Karel Novak");
        Person p2 = new Person("Frantisek Omacka");
        Person p3 = new Person("Anezka Velika");
        Person p4 = new Person("Alena Podolni");
        Person p5 = new Person("Josef Orisek");
        Person p6 = new Person("Podvodnik z Podvodnikova");
        
        ITicket t1 = new Ticket(5, new int[] {5, 15, 18, 26, 32});
        p6.setTicket(t1);

        BettingShop bettingShop = new BettingShop();
        bettingShop.betTicket(p1, new int[] {5, 15, 18, 26, 32});
        bettingShop.betTicket(p2, new int[] {1, 7, 9, 12, 31});
        bettingShop.betTicket(p3, new int[] {8, 14, 19, 23, 29});
        bettingShop.betTicket(p4, new int[] {1, 7, 9, 12, 31});
        bettingShop.betTicket(p5, new int[] {13, 19, 21, 26, 28});
        
        int[] winningNumbers = new int[] {7, 9, 16, 19, 25};
        
        try {
            System.out.println("Match in "+bettingShop.didIWin(p2, winningNumbers)+" number(s)");
        } catch (Exception e) {
            System.out.println("not OK");
        }
        
        try {
            System.out.println("Match in "+bettingShop.didIWin(p5, winningNumbers)+" number(s)");
        } catch (Exception e) {
            System.out.println("not OK");
        }
        
        System.out.print("1: ");
        try {
            bettingShop.didIWin(p5, winningNumbers);
            System.out.println("not OK");
        } catch (NullPointerException e) {
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("not OK");
        }
        
        System.out.print("2: ");
        try {
            bettingShop.didIWin(p6, winningNumbers);
            System.out.println("not OK");
        } catch (FakeTicketException e) {
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("not OK");
        }
        
        System.out.print("3: ");
        try {
            p1.setTicket(new Ticket(1, new int[] {7, 9, 16, 19, 25}));
            bettingShop.didIWin(p1, winningNumbers);
            System.out.println("not OK");
        } catch (AlreadyPaidTicketException e) {
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("not OK");
        }
        
        System.out.println(bettingShop.getTickets());
        System.out.println(bettingShop.getPaidTickets());
    }

}