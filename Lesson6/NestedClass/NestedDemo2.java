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
public class NestedDemo2 {
    
    public static void main(String[] arg){
        //Instantiating the outer class
        OuterClass2 outer = new OuterClass2();
        //Instantiating the inner class
        OuterClass2.InnerClass inner = outer.new InnerClass();
        
        System.out.println(inner.readNum());
    }
}
