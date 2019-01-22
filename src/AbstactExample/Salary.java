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
public class Salary extends Employee {
    private double salary;
    
    public Salary(String name, String address, int number, double salary){
        super(name, address, number);
        this.salary = salary;
    }
    
    public void mailCheck(){
        System.out.println("Within mailCheck of salary class ");
        System.out.println("Mailing check to " + getName() + " with salary " + getSalary());
    }
    
    public double getSalary(){
        return salary;
    }
    
    public double computePay(){
        System.out.println("Computing Salary pay for " + getName());
        return salary/52;
    }
    
}
