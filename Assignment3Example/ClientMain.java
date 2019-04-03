package Assignment3_ChatRoomApp.Client;

import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class ClientMain {
    private static Scanner scanner = new Scanner(System.in);
    private static String messageToServer = "";
    private static boolean run = true;

    public static void main(String[] args) {
        Communication server = new Communication();

        try {
            System.out.print("Please write a username: ");
            String username = "USERNAME: " + scanner.nextLine();

            server.connect("localhost", 9871);
            listener(server);

            server.write(username);

            while(run){
                messageToServer = scanner.nextLine();
                run = !messageToServer.toUpperCase().contains("EXIT");
                server.write(messageToServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("Closing connection to server ...");
                server.closeConnection();
                System.out.println("Connections to server has been closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listener(Communication communication){
        new Thread(() -> {
            try {
                while(run){
                    String messageFromServer = communication.readMessage();
                    if(!messageFromServer.equals("")) System.out.println(messageFromServer);
                }

            }
            catch(SocketException se){
                System.out.println("Stopped listening from chat room");
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

