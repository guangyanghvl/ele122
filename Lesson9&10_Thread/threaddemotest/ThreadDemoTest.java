/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemotest;

public class ThreadDemoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo T1 = new ThreadDemo("Thread-1");
        T1.start();
        T1.join();
        //T1.interrupt();
        
        ThreadDemo T2 = new ThreadDemo("Thread-2");
        T2.start();
       // T2.join();
        //T2.interrupt();

        //(new Thread(new ThreadDemo2("Thread-3"))).start();
        ThreadDemo2 T33 = new ThreadDemo2("Thread-3");
        Thread T3 = new Thread(T33);
        T3.start();
        //T3.join();
        //(new Thread(new ThreadDemo2("Thread-4"))).start();
        ThreadDemo2 T44 = new ThreadDemo2("Thread-4");
        Thread T4 = new Thread(T44);
        T4.start();
        //T4.join();
        //join will let other thread wait until this thread finished. 
        //but only can control those threads that hasn't been started
        //put them into a waiting pool
        //Those woh have started are not listen to this
    }
    
}
