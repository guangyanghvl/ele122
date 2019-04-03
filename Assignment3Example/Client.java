package Assignment3_ChatRoomApp.Server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client implements Runnable {
    public String username;
    public final ConcurrentLinkedQueue<String> messagesFromClient = new ConcurrentLinkedQueue<>();

    private Socket connectionSocket = null;
    private boolean exit = false;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;


    public Client(Socket connectionSocket){
        this.connectionSocket = connectionSocket;
        try {
            outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    public void run() {
        try {
            inFromClient = new ObjectInputStream(connectionSocket.getInputStream());;
            while (!exit) {
                String messageFromClient = (String) inFromClient.readObject();
                messagesFromClient.add(messageFromClient);
            }
        }
        catch (EOFException eof){
            System.out.println(username + " exited from the chat-room.");
        }
        catch (SocketException se){
            System.out.println(username + " lost connection to the chat room.");
            exit();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void exit(){
        exit = true;

        try {
            inFromClient.close();
            outToClient.close();
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(String requestedUsername){
        username = requestedUsername;
    }

    public void send(String message) {
        try {
            outToClient.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
