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
public class OuterClass3 {
    void my_Method(){
        int num = 23;
        
        class MethodInner {
            public void print() {
                System.out.println("This is method inner class " + num);
            }
        }// end of inner class
    
    //Access the inner class
    MethodInner inner = new MethodInner();
    inner.print();
    }
    
    public static void main(String[] args){
        OuterClass3 outer = new OuterClass3();
        outer.my_Method();
    }
    
}
