/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultipleInterface;

/**
 *
 * @author guang
 */
public class MultiInferfaceImplements implements FirstInterface, SecondInterface {
    public void firstMethod(){
        System.out.println("the first method from the first interface");
    }
    
     public void secondMethod(){
        System.out.println("the second method from the second interface");
    }
}
