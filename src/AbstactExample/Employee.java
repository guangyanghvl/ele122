/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstactExample;

/**
 *
 * @author guang
 */
public abstract class Employee {
    private String name;
    private String address;
    private int number;
    
    public Employee(String name, String address, int number){
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    
    public void mailCheck(){
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }
    
    public String getName(){
        return name;
    }
    
    public abstract double computePay(); 
    
}
