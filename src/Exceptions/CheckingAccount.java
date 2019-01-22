/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

public class CheckingAccount {
    private double balance;
    private int number;
    
    public CheckingAccount (int number) {
        this.number = number;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= balance) {
            balance -= amount;
        }else{
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }
    
    public double getBalance(){
        return balance;
    }
    
    public int getNumber() {
        return number;
    }
}
