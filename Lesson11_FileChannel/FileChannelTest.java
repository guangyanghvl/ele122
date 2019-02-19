package filechanneltest;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile aFile = new RandomAccessFile("test.txt", "rw")) {
            FileChannel inChannel = aFile.getChannel(); //create a FileChannel
            
            ByteBuffer buf = ByteBuffer.allocate(48);
            /*Create a ByteBuffer using the ByteBuffer‘s allocate() static method. 
            The new buffer’s position will be zero, its limit will be its capacity and its elements 
            will be initialized to zero. In this example, the initial capacity is set to 48.*/
                    
            int bytesRead = inChannel.read(buf);   
            /* FileChannel‘s read() method reads a sequence of bytes into the given buffer. 
            The method returns the number of bytes read, 
            or -1 if the channel has reached the end-of-stream.*/
            while(bytesRead != -1 ){
                System.out.println("Read" + bytesRead);
                buf.flip();
                /*The buffer’s flip() method makes a buffer ready for a new sequence of relative get operations: 
                It sets the limit to the current position (in this example, 48) and then sets the position to zero.*/
                
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }
                //buf.get() returns this buffer 
                
                buf.clear();
                /*The buffer’s clear() method makes a buffer ready for a new sequence of channel-read: 
                It sets the limit to the capacity (48) and the position to zero.*/
                bytesRead = inChannel.read(buf);
            }
        }
    }
    
}
