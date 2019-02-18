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
public class ThreadSynDemo extends Thread{
    private String threadName;
    SynPrintDemo PD;
    
    ThreadSynDemo(String name, SynPrintDemo pd){
        threadName = name;
        PD = pd;
    }
    
    public void run(){
        //synchronized(PD){
        PD.printCount();
       // }
        System.out.print("Thread " + threadName + " exiting.");
    }
}
