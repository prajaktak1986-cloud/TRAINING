
package com.msedcl.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.msedcl.main.domain.Person;
import com.msedcl.main.domain.SortByLastName;

public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person1 = new Person("Vivek", "Gohil", 36);
		Person person2 = new Person("Trupti", "Acharekar", 38);
		Person person3 = new Person("Samarth", "Patil", 10);
		Person person4 = new Person("Gurubux", "Gill", 30);

		// Storing person objects into List
		List<Person> people = Arrays.asList(person1, person2, person3, person4);

		// Printing all persons from list
//		for (Iterator iterator = people.iterator(); iterator.hasNext();) {
//			Person person = (Person) iterator.next();
//			
//		}
		for (Person person : people) {// type foreach then ctr+space it will show loop
			System.out.println(person);

		}
		//Without Lambda Expression
		//1. Sort this list by last name
		System.out.println();
		System.out.println("--------------Sort by last name, then first name---------------");
		System.out.println();
		
        // Sort by last name, then first name
//        people.sort(Comparator
//            .comparing(Person::getLastName, String.CASE_INSENSITIVE_ORDER)
//            .thenComparing(Person::getFirstName, String.CASE_INSENSITIVE_ORDER));
//
//        // Print sorted list
//        for (Person p : people) {
//            System.out.println(p);
//            System.out.println();
//        }
		
		SortByLastName byLastName = new SortByLastName();
		people.sort(byLastName);
		System.out.println("Done sorting by last name");
		
      
		//2.Create a method to print all elements from list
        System.out.println();
        System.out.println("-------------print all elements from sorted list----------------");
        System.out.println();
		
//        for (Person person : people) {// type foreach then ctr+space it will show loop
//			System.out.println(person);
//
//		}
        
       printAll(people);
       
       
		//3.Create a method that prints
		//all people having last name beginning with G
        System.out.println();
        System.out.println("-------------print all people having last name beginning with G----------------");
        System.out.println();
        
//        people.stream()
//        .filter(p -> p.getLastName().startsWith("G"))
//        .forEach(System.out::println);
        
        for (Person person : people) {// type foreach then ctr+space it will show loop
			if(person.getLastName().startsWith("G"))
        	System.out.println(person);

		}
		
		//4. Create a method that prints 
		//all people having last name ending with L
        System.out.println();
        System.out.println("-------------print all people having last name ending with L----------------");
        System.out.println();
//        
//        people.stream()
//        .filter(p -> p.getLastName().toLowerCase().endsWith("l"))
//        .forEach(System.out::println);
        
        for (Person person : people) {// type foreach then ctr+space it will show loop
			if(person.getLastName().endsWith("l"))
        	System.out.println(person);

		}

	}
	
	public static void printAll(List<Person> people)
    {
      for (Person person : people) {// type foreach then ctr+space it will show loop
			System.out.println(person);

		}
    }
}
