/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InheritanceExample3;

/**
 *
 * @author guang
 */
public class SubClass extends SuperClass {
    
    SubClass (int age){
        super(age);
    }
    
    public static void main(String args[]){
        SubClass a  = new SubClass(24);
       // a.getAge();
    }
}
