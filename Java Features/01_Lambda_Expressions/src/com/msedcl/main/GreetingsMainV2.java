package com.msedcl.main;

import com.msedcl.main.domain.GoodMorning;
import com.msedcl.main.domain.Greetings;

public class GreetingsMainV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printMessage(new GoodMorning());
		
		System.out.println();
		
		printMessage(() -> System.out.println("Have a good day"));
		
	}
	
	public static void printMessage(Greetings greetings) {
		greetings.greet();
	}

}
