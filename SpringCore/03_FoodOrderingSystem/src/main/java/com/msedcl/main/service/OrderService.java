package com.msedcl.main.service;

import org.springframework.stereotype.Service;


@Service
public class OrderService {

	//private BillService billService;
	private BillService billService;

	public OrderService(BillService billService) {
		super();
		System.out.println("Overloaded Constructor called - OrderService.");
		this.billService = billService;
	}

	public BillService getBillService() {
		System.out.println("getBillService");
		return billService;
	}

	public void setBillService(BillService billService) {
		System.out.println("setBillService");
		this.billService = billService;
	}
	
	public void billCalculate() {
		System.out.println("billCalculate called - OrderService");
		billService.billCalculate();
		
}
	
}
