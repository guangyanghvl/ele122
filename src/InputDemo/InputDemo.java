/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class InputDemo {
    
    public static void main(String[] args) throws IOException{
        
        //using BufferedReader
        BufferedReader reader =  new BufferedReader(new InputStreamReader (System.in));
        System.out.print("Enter your name: ");
        
        String name = reader.readLine();
        System.out.println("Your name is: " + name);
        
        //using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        System.out.println("You ID is: " + id);
        
    }
    
}
