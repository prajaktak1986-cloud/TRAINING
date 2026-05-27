package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

import com.msedcl.main.domain.Person;

public class StreamsMain {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Prajakta","Snehal","Shamal","Prachi");
		
		//Print all except Prachi
		
		for (String string : names) {
			if(!string.equals("Prachi"))
				System.out.println(string);
		}
		
		System.out.println("----------");
		//Using Streams -  filter
		
		names.stream().filter((name) -> !name.equals("Prachi")).forEach((name) -> System.out.println(name));
		
		//creating person class object
		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);
		
		//print all First name and last name of person from list 
		//except samarth
		System.out.println();
		System.out.println("---Except Samartha ---");
		people.stream().filter((p) -> !p.getFirstName().equals("Samarth")).forEach((p) -> System.out.println(p.getFirstName() + " " + p.getLastName()));
		
		
		
	}

}
