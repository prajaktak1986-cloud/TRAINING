package com.msedcl.main;

import com.msedcl.main.domain.BillCalculation;

public class BillPrint {	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	final float totalUnits = 100;
	final float costPerUnit = 8;
	final float gst=0.18f;
	
	printResultTwo((x , y, z) -> (x*z) + (((x*z) * y) / 100) , 100, 18, 8);
//	                    
	//printResultOne((totUnits) -> (totalUnits*costPerUnit),totUnits);
	}
	
	
	
	public static void printResultTwo(BillCalculation billCalculation, double numberOne, double numberTwo, double numberThree) {
//		System.out.println("Total Unit Cost is :: " + numberOne*numberThree + " GST Amount is ::" +
//				((numberOne*numberThree) * numberTwo/100) +" Final bill is :: " + billCalculation.doCalculations(numberOne, numberTwo, numberThree));
//		
		System.out.println("Total Unit Cost is :: " + numberOne*numberThree);
		System.out.println("GST Amount is ::" + ((numberOne*numberThree) * numberTwo/100) );		
		System.out.println("Final bill is :: " + billCalculation.doCalculations(numberOne, numberTwo, numberThree));
		
		
	}
	
//	public static void printResultOne(BillCalculation billCalculation, double numberOne) {
////		System.out.println("Total Unit Cost is :: " + numberOne*numberThree + " GST Amount is ::" +
////				((numberOne*numberThree) * numberTwo/100) +" Final bill is :: " + billCalculation.doCalculations(numberOne, numberTwo, numberThree));
////		
//		System.out.println("Total Unit Cost is :: " + numberOne);
//		System.out.println("GST Amount is ::" + ((numberOne*numberThree) * numberTwo/100) );		
//		System.out.println("Final bill is :: " + billCalculation.doCalculations(numberOne, numberTwo, numberThree));
//		
//		
//	}

}
