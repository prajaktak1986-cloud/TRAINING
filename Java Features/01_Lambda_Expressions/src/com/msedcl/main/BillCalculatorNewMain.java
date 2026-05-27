package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.domain.BillCalculatorNew;

public class BillCalculatorNewMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		BillCalculatorNew calculateTotalUnits = (totalUnits, perUnitCost) -> totalUnits * perUnitCost;

		System.out.println("Enter consumed units");
		double unitConsumed = scanner.nextDouble();

		double totalUnitCost = getDetails(calculateTotalUnits, unitConsumed, 8);
		System.out.println("Total unit cost :: " + totalUnitCost);

		BillCalculatorNew calculateGST = (tuc, gst) -> (gst * tuc) / 100;
		double totalGST = getDetails(calculateGST, totalUnitCost, 18);
		System.out.println("Total GST :: " + totalGST);

		BillCalculatorNew calculateFinalBill = (tuc, tgst) -> tuc + tgst;
		double finalBill = getDetails(calculateFinalBill, totalUnitCost, totalGST);
		System.out.println("Final Bill :: " + finalBill);

		scanner.close();
	}

	public static double getDetails(BillCalculatorNew billCalculator, double numberOne, double numberTwo) {
		return billCalculator.calculateBill(numberOne, numberTwo);
	}

}