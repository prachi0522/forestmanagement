package com.capgimini.forestmanagementjdbc.bean;

import lombok.Data;

@Data
//create one class ProductBean
public class ProductBean {
	//declare and initialize variables in product bean class
	private int prodid;
    private String pname;
    private String pdesc;
    //Override toString class
	@Override
	public String toString() {
		return "[ Product Id=" + prodid + ", Product Name=" + pname + ", Product Description=" + pdesc + "]";
	}
	  
}//End of class
