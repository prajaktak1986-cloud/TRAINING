package com.msedcl.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.msedcl.main.domain.Condition;
import com.msedcl.main.domain.LastNameStartsWithG;
import com.msedcl.main.domain.Person;

public class PersonMainLambda {

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
				
				//1. First way
				Comparator<Person> sortByLastName = (p1,p2) -> p1.getLastName().compareTo(p2.getLastName());
				people.sort(sortByLastName);
				System.out.println("Done Sorting by last name First way");
				
				
				//2. Second way
//				people.sort((p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
//				System.out.println("Done Sorting by last name Second way");
				
				printAll(people);
				
				//3.Create a method that prints
				//all people having last name beginning with G
				System.out.println();
		        System.out.println("-------------print all people having last name beginning with G----------------");
		        System.out.println();
		        printStartsWithG(people);
				
		        System.out.println();
		        System.out.println("-------------people last name beginning with G----------------");
		        System.out.println();
		        
		        Condition condition = new LastNameStartsWithG();
		        printStartsWithGNew(people, condition);
		        
		        System.out.println();
		        System.out.println("-------------print people last name beginning with G using Lambda Expression----------------");
		        System.out.println();
		        
		        printStartsWithGLambdaExp(people, (p) -> {
		        	if(p.getLastName().startsWith("G"))
		        		return true;
		        	else 
		        		return false;
		        	
		        });
		        
////
/// 
/// 
/// 
		        System.out.println();
		        System.out.println("printConditionally");
		        printConditionally(people, (p) -> true);
		        printConditionallyNew(people, (p) -> true, (p) -> System.out.println(p));
		        
		        System.out.println();
		        System.out.println("Starts with G");		        
		        printConditionally(people, (p) -> p.getLastName().startsWith("G"));
		        printConditionallyNew(people, (p) -> p.getLastName().startsWith("G"), (p) -> System.out.println(p.getLastName()));
		        
		        System.out.println();
		        System.out.println("ends with l");		        
		        printConditionally(people, (p) -> p.getLastName().endsWith("l"));
		        printConditionallyNew(people, (p) -> p.getLastName().endsWith("l"), (p) -> System.out.println(p.getFirstName() + " "+ p.getLastName()));
	}
	
	public static void printAll(List<Person> people)
    {
      for (Person person : people) {// type foreach then ctr+space it will show loop
			System.out.println(person);

		}
    }
	
	public static void printStartsWithG(List<Person> people)
    {
		for (Person person : people) {// type foreach then ctr+space it will show loop
			if(person.getLastName().startsWith("G"))
        	System.out.println(person);

		}
    }
	
	public static void printStartsWithGNew(List<Person> people, Condition condition)
    {
		System.out.println();
		System.out.println("---inside printStartsWithGNew ---");
		for (Person person : people) {// type foreach then ctr+space it will show loop
			if(condition.test(person))
        	System.out.println(person);

		}
    }
	
	public static void printStartsWithGLambdaExp(List<Person> people, Condition condition)
    {
		System.out.println();
		System.out.println("---inside printStartsWithGLambdaExp ---");
		for (Person person : people) {// type foreach then ctr+space it will show loop
			if(condition.test(person))
        	System.out.println(person);

		}
    }
	
	public static void printConditionally(List<Person> people , Condition condition)
    {
		System.out.println();
		System.out.println("---inside printConditionally ---");
		System.out.println();
      for (Person person : people) {// type foreach then ctr+space it will show loop
    	  if(condition.test(person))
    	  System.out.println(person);

		}
    }
	
	public static void printConditionallyNew(List<Person> people , Predicate<Person> condition, Consumer<Person> consumer)
    {
		System.out.println();
		System.out.println("---inside printConditionallyNew ---");
		System.out.println();
      for (Person person : people) {// type foreach then ctr+space it will show loop
    	  if(condition.test(person))
    	  consumer.accept(person);

		}
    }


}
