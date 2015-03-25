/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.*;

/*******************************************************************************
 * inicializuje vypsani trojuhelniku
 *
 * @author    Michal Simik
 * @version   23.9.2014
 */
public class Demo
{
   
    public static void main(String[] args){
        
        Vertex2D vertexA = new Vertex2D(-100, 0);
        Vertex2D vertexB = new Vertex2D(0, 100);
        Vertex2D vertexC = new Vertex2D(100, -100);
        
        Triangle triangle = new Triangle(vertexA, vertexB, vertexC);
        Circle circle = new Circle();
        
        System.out.println(triangle);
        
        //Gauger.printMeasurement((Measurable)new Circle(new Vertex2D(0,0), 1));
        
    }
 
}
