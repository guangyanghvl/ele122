/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadsexamples;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.net.Socket;

public class WorkerRunnerable implements Runnable {
   
    protected Socket connectionSocket = null; 
    String clientSentence;
    String capitalizedSentence;
 
    public WorkerRunnerable(Socket connectionSocket){
        this.connectionSocket = connectionSocket;
    }

  //ServerSocket welcomeSocket = new ServerSocket(6781);
  public void run(){
 //
     // Socket connectionSocket = welcomeSocket.accept();
     try{ 
     ObjectInputStream inFromClient = 
              new ObjectInputStream(connectionSocket.getInputStream());
      ObjectOutputStream outToClient = 
              new ObjectOutputStream(connectionSocket.getOutputStream());
   
      clientSentence = (String) inFromClient.readObject();
      System.out.println("Received: " + clientSentence);
      capitalizedSentence = clientSentence.toUpperCase();
      outToClient.writeObject(capitalizedSentence);
      
      inFromClient.close();
      outToClient.close();
      connectionSocket.close();
  }catch (IOException e){
      e.printStackTrace();
  }catch (ClassNotFoundException ex){
      
  }
    
}}
