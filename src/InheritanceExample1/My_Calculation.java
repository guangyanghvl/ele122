/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritanceExample1;

/**
 *
 * @author guang
 */
public class My_Calculation extends Calaulation {
    
    public void multiplication(int x, int y){
        z = x + y;
        System.out.println("The produce of the given numbers: " + z);
    }
    
    public static void main(String args[]){
        int a = 20, b = 10;
        My_Calculation demo = new My_Calculation();
        demo.addtion(a, b);
        demo.Substraction(a, b);
        demo.multiplication(a, b);
    }
    
}
