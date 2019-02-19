/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
  
    public static void main(String[] args){
         
      String result = "";

      while(result.isEmpty()){
          List<Integer> numbers = new ArrayList<>(10);         
          for (int i = 0; i < 10; i++){
               numbers.add(i);
               }
          Collections.shuffle(numbers);
 
           if((numbers.get(0)*100+numbers.get(1)*10+numbers.get(2))*(numbers.get(3)*10+numbers.get(4))
                   ==(numbers.get(5)*100+numbers.get(6)*10+numbers.get(7))*(numbers.get(8)*10+numbers.get(9)) )
              {    
                 result = numbers.toString();
              }
      }
          System.out.println(result);
}
}
