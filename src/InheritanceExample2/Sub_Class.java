/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritanceExample2;

/**
 *
 * @author guang
 */
public class Sub_Class extends Super_Class {
    int num = 10;
    public void display() {
        System.out.println("This is the display method of subclass");
    }
    
    public void my_method() {
        Sub_Class sub = new Sub_Class();
        sub.display(); //invoking the display() method of sub class
        super.display(); //invoking the display() method of superclass
        
        System.out.println("Value of the variable named num in sub calss: " + sub.num);
        System.out.println("Value of the variable named num in sub calss: " + super.num);
        
    }
    //super.variable;
    //super.method();
    
    public static void main(String args[]){
        Sub_Class obj = new Sub_Class();
        obj.my_method();
               
    }
    
}
