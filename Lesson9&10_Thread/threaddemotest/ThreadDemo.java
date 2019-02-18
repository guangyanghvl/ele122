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
public class ThreadDemo extends Thread {
   // private Thread t;
    private String threadName;
    
    ThreadDemo (String name) {
        threadName = name;
        System.out.println("Create " + threadName );
    }
    
    public void run(){
        System.out.println("Running " + threadName );
        try{
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                //let the thread sleep for a while
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
    
    //public void start (){
    //    System.out.print("Starting " + threadName );
    //    if(t==null) {
    //        t = new Thread (this, threadName);
    //        t.start();
    //    }
   // }
}
