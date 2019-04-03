package Assignment3_ChatRoomApp.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Communication {
    Socket clientSocket;
    ObjectOutputStream outToServer;
    ObjectInputStream inFromServer;

    public void connect(String host, int port) throws IOException {
        clientSocket = new Socket(host, port);
        outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        inFromServer = new ObjectInputStream(clientSocket.getInputStream());
    }

    public void write(String request) throws IOException, ClassNotFoundException {
        outToServer.writeObject(request);
        outToServer.flush();
    }

    public String readMessage() throws IOException, ClassNotFoundException {
        String messageFromServer = "";

        if (clientSocket != null && clientSocket.isConnected() && inFromServer != null){
            messageFromServer = inFromServer.readObject().toString();
        }

        return messageFromServer;
    }

    public void closeConnection() throws IOException {
        if(inFromServer != null) inFromServer.close();
        if(outToServer != null) outToServer.close();
        if(clientSocket != null) clientSocket.close();
    }
}
