
/**
 * The class Demo demonstrate objects implementing ISexedEnlargedPerson and methods of class Marriage.
 * 
 * @author   Ales  Zlamal 
 * @version 2014 10 28
 */
public class Demo{

    /**
     * The method demonstrate objects implementing ISexedEnlargedPerson and methods of class Marriage.
     */
    public static void main(String[] args){
        ISexedEnlargedPerson m1, m2, z;
        
        z = new Woman("Anna", "Stradova");
        m1 = new Man("Karel", "Varel");
        m2 = new Man("Ivos", "Papez"); 
        
        System.out.println(m1);
        m1.changeName("Biskup");
        System.out.println(m1);
        m1.renewName();
        System.out.println(m1);
        m1.renewName();
        System.out.println(m1);
        System.out.println("Pocet uzavrenych manzelstvi: " + Marriage.numberOfMarriages() + ".");
        Marriage.marriage(m1, m2);
        System.out.println(m1 + (m1.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + m1.getPartner()));
        System.out.println(m2 + (m2.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)m2).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)m2).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + m2.getPartner()));
        System.out.println("Pocet uzavrenych manzelstvi: " + Marriage.numberOfMarriages() + ".");
        Marriage.marriage(z, m1);
        System.out.println(z + (z.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)z).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)z).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + z.getPartner()));
        System.out.println(m1 + (m1.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + m1.getPartner()));
        System.out.println("Pocet uzavrenych manzelstvi: " + Marriage.numberOfMarriages() + ".");
        Marriage.marriage(z, m2);
        System.out.println(z + (z.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)z).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)z).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + z.getPartner()));
        System.out.println(m1 + (m1.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + m1.getPartner()));
        System.out.println("Pocet uzavrenych manzelstvi: " + Marriage.numberOfMarriages() + ".");
        Marriage.marriage(m1, m2);
        System.out.println(m1 + (m1.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)m1).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + m1.getPartner()));
        System.out.println(m2 + (m2.getPartner() == null ? " nema manzel" 
                                                               + (((ISexedEnlargedPerson)m2).isMan() ? 
                                                                              "ku" : "a") 
                                                         : (((ISexedEnlargedPerson)m2).isMan() ? 
                                                                 ", jeho manzelka je " 
                                                                : ", jeji manzel je ") + m2.getPartner()));
        System.out.println("Pocet uzavrenych manzelstvi: " + Marriage.numberOfMarriages() + ".");
    }
}
