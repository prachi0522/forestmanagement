package com.capgimini.forestmanagementjdbc.bean;

import lombok.Data;
@Data
//create one class
public class ContractBean {
	//declare and initialize variables
	private  long contractno;
	private int customerid;
	private int productid;
	private int haulierid;
	private String deliverydate;
	private String deliveryday;
	private int quantity;
	@Override
	public String toString() {
		return "[ Contract Number=" + contractno + ", Customer Id=" + customerid + ", Product Id=" + productid
				+ ", Haulier Id=" + haulierid + ", Delivery Date=" + deliverydate + ", Delivery Day=" + deliveryday
				+ ", Quantity=" + quantity + "]";
	}

	//override toString method

}//end of class
