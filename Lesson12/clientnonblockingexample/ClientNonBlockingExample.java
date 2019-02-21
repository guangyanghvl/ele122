
package clientnonblockingexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientNonBlockingExample {

    public static void main(String[] args) throws IOException {
        String server = "localhost"; //server name or IP address
        int servPort = 5004;
        
        byte[] inputfromclient = "Hello".getBytes();
        
        SocketChannel clientChannel = SocketChannel.open();
        clientChannel.configureBlocking(false);
        /*
         Initiate connection to server and repeated poll until complete
         it returns true if connection completes before it returns
        */
        if(!clientChannel.connect(new InetSocketAddress(server, servPort))){
            while(!clientChannel.finishConnect()){
                System.out.print(".");
            }
        }
        ByteBuffer writeBuf = ByteBuffer.wrap(inputfromclient);
        ByteBuffer readBuf = ByteBuffer.allocate(inputfromclient.length);
        
        int totalBytesRecvd = 0;
        int bytesRecvd;
           
           while(totalBytesRecvd < inputfromclient.length){
               if(writeBuf.hasRemaining()){
                   clientChannel.write(writeBuf);
                   
               }
               if((bytesRecvd = clientChannel.read(readBuf)) == -1){
                   throw new SocketException("Connection closed prematurely");
               }
               totalBytesRecvd += bytesRecvd;
               System.out.print(".");
           }
       System.out.println("Received: " + new String(readBuf.array(),0,totalBytesRecvd));
       clientChannel.close();
    }
    
}
