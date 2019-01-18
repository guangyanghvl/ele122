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
public class Dog extends Animal {
    
    public void move(){
        super.move();
        System.out.println("Dogs can move");
    }
    
}
