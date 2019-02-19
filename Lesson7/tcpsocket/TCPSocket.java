
package tcpsocket;
import java.io.*;
import java.net.*;
import java.util.Random;

public class TCPSocket {
    
 public static void main(String argv[]) throws Exception {
  String clientSentence;
  String capitalizedSentence;
  //Random randomNo = new Random();

  ServerSocket welcomeSocket = new ServerSocket(6781);

  while (true) {
      Socket connectionSocket = welcomeSocket.accept();
      ObjectInputStream inFromClient = 
              new ObjectInputStream(connectionSocket.getInputStream());
      ObjectOutputStream outToClient = 
              new ObjectOutputStream(connectionSocket.getOutputStream());
   
      clientSentence = (String) inFromClient.readObject();
      System.out.println("Received: " + clientSentence);
      capitalizedSentence = clientSentence.toUpperCase();
      outToClient.writeObject(capitalizedSentence);
    
     // int randomNumber = randomNo.nextInt(101);
     // outToClient.writeObject(randomNumber);
      
      inFromClient.close();
      outToClient.close();
      connectionSocket.close();
  }
 
  
 }}
 

    



