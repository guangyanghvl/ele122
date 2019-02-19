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
public class OuterClass2 {
    private int num = 175;
    
    public class InnerClass {
        public int readNum(){
            System.out.println("This is readNum method of inner class");
            return num;
        }
    }
    
}
