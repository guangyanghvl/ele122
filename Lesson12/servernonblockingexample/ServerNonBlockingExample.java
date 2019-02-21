package servernonblockingexample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class ServerNonBlockingExample {
       private static final int BUFSIZE = 256;
       private static final int TIMEOUT = 3000; 
       
    public static void main(String[] args) throws IOException {
       //create a selector to multiplex listening sockets and connections
        Selector selector = Selector.open();
        
      //create listning socket channel on port and register selector  
        try{
            ServerSocketChannel listnChannel = ServerSocketChannel.open();
            listnChannel.socket().bind(new InetSocketAddress(5004));
            listnChannel.configureBlocking(false);
      //register selector with the channel, the returned key is ignored      
            listnChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        
        //create a handle that will implement SelectorHandling
        SelectorHandling handling = new EchoSelector(BUFSIZE);
        
        while(true){ //run forever, processing available I/O operations
            //wait for some channel to be ready, or timeout
            if(selector.select(TIMEOUT) == 0) {
                System.out.print(".");
                continue;
            }
            //get iterator on set of keys with I/O to process,
            //for each key, we check whether it is ready for accept, read, or write
            //and invoke approprite handler
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while(keyIter.hasNext()){
                SelectionKey key = keyIter.next();
                if(key.isAcceptable()){
                    handling.handleAccept(key);
                }
                if(key.isReadable()){
                    handling.handleRead(key);
                }
                if(key.isValid() && key.isWritable()){
                    handling.handleWrite(key);
                }
                keyIter.remove();
            }
        }
    }
    
}
