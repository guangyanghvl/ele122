/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author guang
 */
public class TestFlush {
   
   public static void main(String[] args) {
      try {
         // create a new output stream
         OutputStream os = new FileOutputStream("test.txt");

         // craete a new input stream
         InputStream is = new FileInputStream("test.txt");

         // write something
         os.write('A');

         // flush the stream but it does nothing
         //os.flush();

         // write something else
         os.write('B');

         // read what we wrote
         System.out.println("" + is.available()); //Returns an estimate of the number of bytes that can be read 
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
}
    

