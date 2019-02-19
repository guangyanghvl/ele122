/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericexample;

/**
 *
 * @author guang
 */
public class Container <T> {
  private T t;
  
  public void put(T t){
      this.t = t;
  }
  
  public T get(){
      return t;
  }
  
  public static void main(String[] args){
      Container<Integer> integerContainer = new Container<Integer>();
      Container<String> stringContainer = new Container<String>();
      
     // integerContainer.put(new Integer(10));
     // stringContainer.put(new String("String"));
      integerContainer.put(10);
      stringContainer.put("String");
      
      
      System.out.printf("Integer Value : %d\n\n", integerContainer.get());
      System.out.printf("String Value : %s\n", stringContainer.get());
  }
}
