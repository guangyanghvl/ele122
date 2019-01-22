/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceExample;

/**
 *
 * @author guang
 */
public class Mammal implements Animal {
    
    public void eat(){
        System.out.println("Mammal eats");
    }
    
    public void travel(){
        System.out.println("Mammal travels");
    }
    
    public int ownMethod(){
        return 0;
    }
    
    public static void main(String[] args){
        Mammal m =  new Mammal();
        m.eat();
        m.travel();
    }
}
