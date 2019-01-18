/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolymorphismExample;

/**
 *
 * @author guang
 */
public class Polymorphism_Example {
    
    public static void main(String[] args){
        Bank abc = new Bank_ABC();
        Bank def = new Bank_DEF();
        Bank xyz = new Bank_XYZ();
        
        System.out.println(abc.getInterestRate());
        System.out.println(def.getInterestRate());
        System.out.println(xyz.getInterestRate());
    }
    
}
