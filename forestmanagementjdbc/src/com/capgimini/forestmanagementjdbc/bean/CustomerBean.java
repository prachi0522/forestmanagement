package com.capgimini.forestmanagementjdbc.bean;

import lombok.Data;

@Data
//create one class
public class CustomerBean {
	//declare and initialized variables 
	private  int customerid;
	private String customername;
	private String streetAddress1;
	private String streetAddress2;
	private String town;
	private int postalCode;
	private String email;
	private long telephoneNo;
	//Override toString method 
	@Override
	public String toString() {
		return "[ Contract Id=" + customerid + ", Customer Name=" + customername + ", Street Address1="
				+ streetAddress1 + ", Street Address2=" + streetAddress2 + ", Town=" + town + ", Postal Code="
				+ postalCode + ", Email=" + email + ", Telephone Number=" + telephoneNo + "]";
	}//end of toString


}//end of class
