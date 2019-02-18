/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemotest;

/**
 *
 * @author guang
 */
public class SynPrintDemo {
    public synchronized void printCount(){
        try{
            for(int i = 5; i>0; i--){
                System.out.println("Count --- " + i);               
            }
           
        }catch (Exception e){
            System.out.println("Thread interrupted");
        }
    }
    
}
