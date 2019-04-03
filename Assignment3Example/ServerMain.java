package Assignment3_ChatRoomApp.Server;

import java.util.HashMap;
import java.util.Map;

public class ServerMain {
    static ThreadGenerator threadGenerator = new ThreadGenerator(9871);
    static HashMap<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {
        Thread listeningThread = new Thread(threadGenerator);
        listeningThread.start();

        while(true){
            if(threadGenerator.newClients.size() > 0) addNewClients();

            broadcastNewMessages();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addNewClients(){
        for (Client client: threadGenerator.newClients) {
            if(client.messagesFromClient.size() > 0) {
                String firstMessageFromClient = client.messagesFromClient.poll();
                String userJoinedMessage = "NEW USER JOINED - " + firstMessageFromClient;
                System.out.println(userJoinedMessage);
                sendToAllClients(null, userJoinedMessage);
                if (!firstMessageFromClient.contains("USERNAME"))
                    client.send("ERROR! expected username, received: " + firstMessageFromClient);

                String username = firstMessageFromClient.replace("USERNAME: ", "");
                client.setUsername(username);
                clients.put(username, client);

                client.send("Users in chat-room: " + String.join(", ", clients.keySet()));

                threadGenerator.newClients.remove(client);
            }
            else {
                System.out.println("Awaiting username from client");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void broadcastNewMessages(){
        for (Map.Entry<String, Client> clientSet : clients.entrySet()) {
            if(clientSet.getValue().messagesFromClient.size() > 0){
                String messageFromClient = clientSet.getValue().messagesFromClient.poll();
                if(messageFromClient.contains("EXIT")){
                    sendToAllClients(null,clientSet.getKey() + " exited the chat-room");
                    disconnectClient(clientSet);
                    return;
                }
                else{
                    sendToAllClients(clientSet, messageFromClient);
                }
            }
        }
    }

    private static void sendToAllClients(Map.Entry<String, Client> sender, String message){
        for (Map.Entry<String, Client> client : clients.entrySet()) {
            if(sender == null){
                client.getValue().send(message);
            }
            else if(!client.equals(sender)){
                client.getValue().send(sender.getKey() + ": " + message);
            }
        }
    }

    private static void disconnectClient(Map.Entry<String, Client> clientSet){
        clientSet.getValue().exit();
        clients.remove(clientSet.getKey());
    }
}
