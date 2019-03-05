package multithreadsexamples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsPool implements Runnable {
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
    
    public ThreadsPool(int port){
        this.serverPort = port;
    }
    
    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while( ! isStopped()){
            Socket connectionSocket = null;
            try{
                connectionSocket = this.serverSocket.accept();
            }catch(IOException e){
                if(isStopped()){
                    System.out.print("Server Stopped.");
                    break;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            this.threadPool.execute(new WorkerRunnerable(connectionSocket));
        }
        this.threadPool.shutdown();
        System.out.println("Server Stopped");
        
    }
    private synchronized boolean isStopped(){
        return this.isStopped;
    }
    private void openServerSocket(){
         try{
             this.serverSocket = new ServerSocket(this.serverPort);
         }catch(IOException e){
             throw new RuntimeException("Cannot open port", e);
         }   
    }
}
