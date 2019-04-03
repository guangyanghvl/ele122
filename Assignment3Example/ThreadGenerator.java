package Assignment3_ChatRoomApp.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadGenerator implements Runnable {
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public ConcurrentLinkedQueue<Client> newClients = new ConcurrentLinkedQueue<>();

    public ThreadGenerator(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized (this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(!isStopped()){
            Socket connectionSocket = null;
            try{
                connectionSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(!isStopped()){
                    System.out.println("Server stopped.");
                    break;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            Client client = new Client(connectionSocket);
            this.threadPool.execute(client);
            newClients.add(client);
        }
        this.threadPool.shutdown();
        System.out.println("Server Stopped");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try{
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try{
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port", e);
        }
    }
}
