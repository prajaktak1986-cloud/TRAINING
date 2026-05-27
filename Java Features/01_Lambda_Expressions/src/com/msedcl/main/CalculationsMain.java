package com.msedcl.main;

import com.msedcl.main.domain.Calculations;

public class CalculationsMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculations calculations = null;

		// addition
		calculations = (double numberOne, double numberTwo) -> {
			return (numberOne + numberTwo);
		};

		double additionResult = calculations.doCalculations(10, 20);

		System.out.println("Addition is :: " + additionResult);

		// substraction

		calculations = (double numberOne, double numberTwo) -> {
			return (numberOne - numberTwo);
		};

		double substractionResult = calculations.doCalculations(30, 20);

		System.out.println("Substraction is :: " + substractionResult);

		// multiplication

		calculations = (double numberOne, double numberTwo) -> {
			return (numberOne * numberTwo);
		};

		double multiplicationResult = calculations.doCalculations(10, 10);

		System.out.println("Multiplication is :: " + multiplicationResult);
		
		// division

		calculations = (double numberOne, double numberTwo) -> {
			return (numberOne / numberTwo);
		};

		double divisionResult = calculations.doCalculations(30, 10);

		System.out.println("Division is :: " + divisionResult);
		
		//multiplication
		
		calculations = (n1,n2) -> n1 * n2;
		System.out.println("Multiplication is :: " + calculations.doCalculations(10,4) );
		
		// division

		calculations = (n1, n2) -> n1 / n2;
		System.out.println("Division is :: " + calculations.doCalculations(30, 5));
		
		//Anonymous inner class
		
		calculations = new Calculations() {
			
			@Override
			public double doCalculations(double numberOne, double numberTwo) {
				// TODO Auto-generated method stub
				return numberOne - numberTwo;
			}
		};
		
		double Result = calculations.doCalculations(30, 10);
		System.out.println("Substraction is :: " + Result);
		

	}

}


