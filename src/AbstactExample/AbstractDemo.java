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
public class AbstractDemo {
    public static void main(String[] args){
        Salary s = new Salary("Tom Jerry", "Oslo", 3, 3600.00);
        Employee e = new Salary("John Adams", "Bergen", 2, 2400.00);
        System.out.println("Call mailCheck using Salary reference -- ");
        s.mailCheck();
        s.computePay();
        System.out.println("Call mailCheck using Employeereference -- ");
        e.mailCheck();
        e.computePay();
    }
    
}
