package com.capgimini.forestmanagementjdbc.main;

import java.util.Scanner;

import com.capgimini.forestmanagementjdbc.controller.Contract;
import com.capgimini.forestmanagementjdbc.controller.Customer;
import com.capgimini.forestmanagementjdbc.controller.Land;
import com.capgimini.forestmanagementjdbc.controller.Product;
import com.capgimini.forestmanagementjdbc.validation.ForesteryValidation;


public class MainForestry {//creating a class
	public static void main(String[] args) {//creating a main method
		Scanner sc=new Scanner(System.in);

		char ch='y';
		while(ch=='y'||ch=='y') {//check value is true or not
			System.out.println("------------------ FORESTRY MANAGMENT SYSTEM----------------------");
			System.out.println("            HOME");
			System.out.println("Press 1 if you are a contractor");
			System.out.println("Press 2 if you are a customer");
			System.out.println("Press 3 if you are looking for a product");	
			System.out.println("Press 4 if you are looking for a Land");
			System.out.println("Press 5 For Logout");
			
			String ca=null;
			char c1 = 'y';
			while(c1=='y') {
				ca= sc.next();
				if(ForesteryValidation.isNumber(ca)) {
					c1='n';
				} else {
					System.err.println("enter numbers only");
				}
			} 
			Integer options = Integer.parseInt(ca);
			switch (options) {
			//case 1 for contractor 
			case 1:
				Contract c=new Contract();
				c.contractor();
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
				//case 2 for customer
			case 2:
				Customer cu=new Customer();
				cu.customer();
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
				//case 3 for product
			case 3:
				Product p=new Product();
				p.product();
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
			case 4:
				Land l=new Land();
				l.Land();
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
			case 5:
				AdminPage a=new AdminPage();
				a.main(null);
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
			default:
				System.err.println("Insert valid input 1-5");
				MainForestry m= new MainForestry();
				m.main(null);
			}//end of of switch case
		}//end of while loop

	}//end of main method

}//end of class
