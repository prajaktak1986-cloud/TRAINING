package com.msedcl.main;

import com.msedcl.main.domain.GoodAfternoon;
import com.msedcl.main.domain.GoodEvening;
import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       GoodMorning goodMorning = new GoodMorning();
//       goodMorning.greet();
      
       Greetings greetings = null;
       
       greetings = new GoodMorning();
       greetings.greet();
       
       System.out.println();
       
       greetings = new GoodAfternoon();
       greetings.greet();   
       
       System.out.println();
       
//       greetings = new GoodEvening();
//       greetings.greet();  
       
       greetings = () -> {
    	   System.out.println("Good Evening All");
       };
       
       greetings.greet(); 
       
       System.out.println();
       
       greetings = () -> {
    	   System.out.println("Good Night All");
       };
       
       greetings.greet(); 
	}

}
