package com.msedcl.main;

import com.msedcl.main.domain.Calculations;


public class CalculationMainV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printResultOne((n1,n2) ->  10+20);
		
		printResultTwo((x , y) -> x + y , 10,20);
		printResultTwo((x , y) -> x - y , 10,5);
		printResultTwo((x , y) -> x * y , 10,20);
		printResultTwo((x , y) -> x / y , 30,3);

		}
		
		public static void printResultOne(Calculations calculations) {
			System.out.println("Addition is ::" + calculations.doCalculations(10, 20));
			
		}
		
		public static void printResultTwo(Calculations calculations, double numberOne, double numberTwo) {
			System.out.println("Result of " + numberOne + " and " +
					numberTwo +" is :: " + calculations.doCalculations(numberOne, numberTwo));
			
		}

}
