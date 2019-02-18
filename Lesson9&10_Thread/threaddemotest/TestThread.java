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
public class TestThread {
    public static void main(String[] arg){
        SynPrintDemo PD = new SynPrintDemo();
        
        ThreadSynDemo T1 = new ThreadSynDemo("Thread - 1", PD);
        ThreadSynDemo T2 = new ThreadSynDemo("Thread - 2", PD);
        
        T1.start();
        T2.start();
        
        try{
            T1.join();
            T2.join();
        }catch(Exception e){
            System.out.println("Interrupted");
        }
    }
    
}
