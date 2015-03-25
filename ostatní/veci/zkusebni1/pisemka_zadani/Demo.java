import java.util.List;

/**
 * Demo.
 */
public class Demo
{
    public static void main(String[] args) {
        Crossroads cr = new Crossroads(2);
       
        boolean success = true;
        
        success &= !comeTo(cr, new Car("1W1 11-11"), CardinalPoint.WEST);
        success &= !comeTo(cr, new Car("2W2 22-22"), CardinalPoint.WEST);
        success &= !comeTo(cr, new Car("3W3 33-33"), CardinalPoint.WEST);
        success &= comeTo(cr, new Car("1N1 11-11"), CardinalPoint.NORTH);
        
        System.out.println();
        System.out.println("Crossroads state: ");
        System.out.println(cr);
        
        System.out.println();
        System.out.println("Setting green to west-east direction, crossroads state: ");
        cr.switchLights();
        System.out.println(cr);
        
        System.out.println();
        success &= !comeTo(cr, new Car("4W4 44-44"), CardinalPoint.WEST);
        System.out.println();
        System.out.println("Crossroads state: ");
        System.out.println(cr);
        
        System.out.println();
        System.out.println("Overall results: " + (success ? "OK" : "ERROR"));
    }
   
    private static boolean comeTo(Crossroads cr, Car car, CardinalPoint dir) {
        boolean ret = cr.comeTo(car, dir);
        System.out.println("Car " + car + " is comming from " + dir + ": " + (ret ? "went through" : "stopped"));
        return ret;
    }
}
