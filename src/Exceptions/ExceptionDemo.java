/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

public class ExceptionDemo {
    public static void main(String[] args){
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Deposoting $ 550...");
        c.deposit(500.00);
        
        try{
            System.out.println("\nWithDrawing $ 100...");
            c.withdraw(100.00);
            System.out.println("\nWithDrawing $ 200...");
            c.withdraw(600.00);
        }catch(InsufficientFundsException e){
            System.out.println("you are short $ " + e.getAmount());
            e.printStackTrace(); //print out the exceptions
        }
    }
}
