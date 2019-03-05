package multithreadsexamples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerClient implements Runnable {
    protected int serverPort;
    protected Thread runningThread = null;
    protected boolean isStopped =false;
    ServerSocket welcomeSocket;
    
    public ThreadPerClient(int port){
        this.serverPort = port;
    }
    
    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        
        while( !isStopped()){
            Socket connectionSocket = null;
            try{
                connectionSocket = this.welcomeSocket.accept();
            }catch (IOException e){
                if(isStopped()){
                    System.out.println("Server Stooped.");
                }
            
            throw new RuntimeException("Error accepting client connection", e);
            }
        new Thread(
            new WorkerRunnerable(connectionSocket)).start();
        }
        System.out.println("Server Stooped");
    }
    private synchronized boolean isStopped(){
        return this.isStopped;
    }
    
    public synchronized void stop(){
        this.isStopped = true;
        try{
            this.welcomeSocket.close();
        }catch(IOException e){
            throw new RuntimeException("Error closing server", e);
        }
    }
    
    private void openServerSocket(){
         try{
             this.welcomeSocket = new ServerSocket(this.serverPort);
         }catch(IOException e){
             throw new RuntimeException("Cannot open port", e);
         }   
    }
}
