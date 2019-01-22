/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author guang
 */
public class ExceptionTest2 {
    
    public static void main(String args[]) throws IOException{
        try{
            FileReader fr = new FileReader("E://file.txt");
            char[] a = new char[50];
            fr.read(a);
            for(char c:a)
                System.out.print(c);
        }catch (FileNotFoundException ee){          
        }finally{
            System.out.println("finnaly");
        }
        
    }
    
}
