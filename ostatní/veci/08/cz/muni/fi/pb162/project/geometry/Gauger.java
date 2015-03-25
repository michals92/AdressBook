/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.geometry;





/*******************************************************************************
 * meridlo vypisuje hodnoty objektu
 *
 * @author    Michal Simik
 * @version   14.10.2014
 */
public class Gauger
{
    
    /**
     * Tiskne informace o objektu measurable
     * 
     * @param object - Measurable object
     */
    public static void printMeasurement(Measurable object){
        System.out.println(object.toString());
        System.out.println("Length/Perimeter: " + object.getLength());
    }

    /**
     *  Tiskne informace o objektu solid
     *  
     *  @param object - Solid object
     */
    public static void printMeasurement(Solid object){
        printMeasurement( (Measurable) object);
        System.out.println("Area: " + object.getArea());
    }
    

}