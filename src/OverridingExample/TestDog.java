/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OverridingExample;

/**
 *
 * @author guang
 */
public class TestDog {
    
    public static void main(String args[]){
        Animal a = new Animal();
        Dog b = new Dog();
        
        a.move();
        b.move();
    }
}
