/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NestedClass;

/**
 *
 * @author guang
 */
public class OuterClass {
    int num;
    //inner class
    private class InnerClass {
        public void print(){
            System.out.println("An inner class");
        }
    }
    //Accessing the inner class from the method
    void display_Inner(){
        InnerClass inner =  new InnerClass();
        inner.print();
    }
    
}
