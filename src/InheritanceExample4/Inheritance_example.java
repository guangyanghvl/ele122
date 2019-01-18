/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritanceExample4;

/**
 *
 * @author guang
 */
public class Inheritance_example {
    
    public static void main(String[] args){
    Rectangle rec = new Rectangle();
    Triangle tri = new Triangle();
    
    rec.set_values(10, 10);
    tri.set_values(10, 10);
    
    System.out.println("Area of Rectangle is : " + rec.area());
    System.out.println("Area of Rectangle is : " + tri.area());
    System.out.println(rec instanceof Polygon);
    System.out.println(tri instanceof Polygon);
    
    
    }
    
}
