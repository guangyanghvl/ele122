/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericexample;

/**
 *
 * @author guang
 */
public class GenericExample {

    public static void main(String[] args) {
       // int [] iarray = {1,2,3,4,5};
       // char [] carray = {'a','b','c','d','e'};
        Integer [] iarray = {1,2,3,4,5};
        Character [] carray = {'a','b','c','d','e'};
        printArray(iarray);
        printArray(carray);
    }
    
    //public static void printArray(int[] i){
    //    for (int x: i)
    //        System.out.printf("%s", x);
    //    System.out.println();
   // }
    public static <T> void printArray(T[] x){
        for (T b: x)
            System.out.printf("%s", b);
        System.out.println();
    }
   
    
}
