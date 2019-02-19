/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsocketclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPSocketClient {

     public static void main(String argv[]) throws Exception {
            String sentence;
            String modifiedSentence;
            int getRandomNumber;
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
       
            try (Socket clientSocket = new Socket("localhost", 6781)) {
                  ObjectOutputStream outToServer = 
                          new ObjectOutputStream(clientSocket.getOutputStream());
                  ObjectInputStream  inFromServer = 
                          new ObjectInputStream(clientSocket.getInputStream());
             
             sentence = inFromUser.readLine();
             outToServer.writeObject(sentence + '\n');
             
             modifiedSentence = (String)inFromServer.readObject();
             System.out.println("FROM SERVER: " + modifiedSentence);
            // getRandomNumber = (int)inFromServer.readObject();
             //System.out.println("Number FROM SERVER is: " + getRandomNumber);
             
            outToServer.close();
            inFromServer.close();
            clientSocket.close();

         }
 }
    
}
