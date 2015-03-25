public class NumberDemo
{
    public static void main(String[] args)
    {
        int d = 0;
        boolean ok = false;
        
        int i = 0;
        while(!ok) {
            try {
                String number = args[i]; // ArrayIndexOutOfBoundsException

                d = Integer.parseInt(number);
                
                ok = true;

            } catch(ArrayIndexOutOfBoundsException e) {
                System.err.println("No valid number specified");
                System.exit(1);
                
            } catch(NumberFormatException e) {
                System.err.println("No valid number specified");
                
            } catch(IllegalArgumentException e) {

            }
            i++;
        } 

        System.out.println(d);
        
        System.out.println("End of program");
    }
}