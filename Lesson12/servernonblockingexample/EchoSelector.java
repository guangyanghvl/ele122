
package servernonblockingexample;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class EchoSelector implements SelectorHandling{
    
    private int bufSize;
    
    public EchoSelector(int bufSize){
        this.bufSize = bufSize;
    }
    
    public void handleAccept(SelectionKey key) throws IOException{
        SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
    }
    
    public void handleRead(SelectionKey key) throws IOException{
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = clientChannel.read(buf);
        if(bytesRead == -1){
            clientChannel.close();
        }else if(bytesRead > 0){
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
        
    }   
    public void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel clientChannel = (SocketChannel)key.channel();
        clientChannel.write(buf);
        if(!buf.hasRemaining()){
            key.interestOps(SelectionKey.OP_READ);
        }
        buf.compact();
    }
}
