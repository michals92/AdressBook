
public class ExceptionDemo
{
    public static void main(String[] args)
    {
        try {
            load(1);
        } catch(OverweightException oe) {
            // sem neco dopsat
        } finally {
            // toto probehne vzdy
        }

    }
    private static void load(int weight) throws OverweightException {
        if(weight > 100) throw new OverweightException();
    }
}