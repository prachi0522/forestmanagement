package com.capgimini.forestmanagementjdbc.controller;

import java.util.Scanner;

import com.capgimini.forestmanagementjdbc.bean.CustomerBean;
import com.capgimini.forestmanagementjdbc.dao.CustomerDAO;
import com.capgimini.forestmanagementjdbc.factory.CustomerDAOManagerFactory;
import com.capgimini.forestmanagementjdbc.main.AdminPage;
import com.capgimini.forestmanagementjdbc.main.MainForestry;
import com.capgimini.forestmanagementjdbc.service.CustomerService;
import com.capgimini.forestmanagementjdbc.validation.ForesteryValidation;

//create one class
public class Customer {
	public void customer() {// create one method

		CustomerBean bean = new CustomerBean();// create one CustomerBean object
		CustomerDAO dao = CustomerDAOManagerFactory.getCustomerDAO();// create one CustomerDAO object
		Scanner sc = new Scanner(System.in);
		char ch = 'y';
		while (ch == 'Y' || ch == 'y') {// create one while loop
			System.out.println("****CUSTOMER OPERATONS****");
			System.out.println("--------------");
			System.out.println("Enter 1 to insert data");
			System.out.println("Enter 2 to delete data");
			System.out.println("Enter 3 to get all data");
			System.out.println("Enter 4 to update the data");
			System.out.println("Enter 5 to return home");
			System.out.println("Enter 6 to Logout");
			String ca=null;
			char c6 = 'y';
			while(c6=='y') {
				ca= sc.next();
				if(ForesteryValidation.isNumber(ca)) {
					c6='n';
				} else {
					System.err.println("enter numbers only");
				}
			} 
			Integer choice = Integer.parseInt(ca);

			// create one variable
			// create one switch case pass the choice variable
			switch (choice) {
			// Add details of customer
			case 1:
				CustomerBean bean1 = new CustomerBean();
				System.out.println("Add Details of customer ");
				System.out.println("-------------------");
				System.out.println("Enter customer id");
				String ch2=null;
				char c2 = 'y';
				while(c2=='y') {
					ch2= sc.next();
					if(ForesteryValidation.isNumber(ch2)) {
						c2='n';
					} else {
						System.err.println("enter numbers only");
					}
				}
				Integer id= Integer.parseInt(ch2);

				bean1.setCustomerid(id);
				boolean again;

				System.out.println("Enter customer name");
				String name=null;
				char n = 'y';
				while(n=='y') {
					name= sc.next();

					if(ForesteryValidation.isStringAlphabet(name)) {
						n='n';
					} else {
						System.err.println("enter only alphabets");
					}
				}
				bean1.setCustomername(name);
				System.out.println("Enter customer pin code");
				String pin=null;
				char c3 = 'y';
				while(c3=='y') {
					pin= sc.next();
					if(ForesteryValidation.isNumber(pin)) {
						c3='n';
					} else {
						System.err.println("enter numbers only");
					}
				}
				Integer zip= Integer.parseInt(pin);
				bean1.setPostalCode(zip);

				System.out.println("Enter streetaddress1...");
				String streetAddress1 = sc.next();
				System.out.println("Enter streetaddress2...");
				String streetAddress2 = sc.next();
				System.out.println("Enter customer town");
				String town=null;
				char n1 = 'y';
				while(n1=='y') {
					town= sc.next();

					if(ForesteryValidation.isStringAlphabet(town)) {
						n1='n';
					} else {
						System.err.println("enter only alphabets");
					}
				}
				bean1.setTown(town);

				System.out.println("Enter customer email address");
				String email=null;
				char ce = 'y';
				while(ce=='y') {
					email= sc.next();
					if(ForesteryValidation.isEmail(email)) {
						ce='n';
					} else {
						System.err.println("enter valid email");
					}
				}
				bean1.setEmail(email);
				System.out.println("Enter customer phone number");
				String phone=null;
				char c4 = 'y';
				while (c4=='y') {
					phone= sc.next();
					if (ForesteryValidation.phoneValidation(phone)) {
						c4='n';
					} else {
						System.err.println("enter valid phone number");
					}
				}
				Long telephoneno= Long.parseLong(phone);
				bean1.setTelephoneNo(telephoneno);
				bean1.setStreetAddress1(streetAddress1);
				bean1.setStreetAddress2(streetAddress2);

				// check if customer id is present in the list customer details are not added
				// else customer details are added to the list
				boolean check = dao.addCustomer(bean1);
				if (check) {
					System.out.println("customer details added to the list");
				} else {
					System.out.println("customerid is repeated");
				}

				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);
				break;
				// case 2 is for deleting customer details
			case 2:
				System.out.println("Enter customerid to delete");
				
				String ch8=null;
				char c8 = 'y';
				while(c8=='y') {
					ch8= sc.next();
					if(ForesteryValidation.isNumber(ch8)) {
						c8='n';
					} else {
						System.err.println("enter numbers only");
					}
				}
				Integer id1= Integer.parseInt(ch8);

				if (dao.deleteCustomer(id1)) {

					System.out.println("given customerid details has been deleted");
				} else {
					System.out.println("sorry....Unable to delete. Customer id is not present in the list");
				}

				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);

				break;
				// case 3 for search customer details by using customer id
			case 3:
				System.out.println(dao.getAllCustomers());

				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);

				break;
				// case 5 for update customer
			case 4:

				CustomerService service=CustomerDAOManagerFactory.instanceOfCustomerServiceImpl();
				CustomerBean bean2 = new CustomerBean();
				System.out.println("Enter Customer Id for Update.........");
				String ch7=null;
				char c7 = 'y';
				while(c7=='y') {
					ch7= sc.next();
					if(ForesteryValidation.isNumber(ch7)) {
						c7='n';
					} else {
						System.err.println("enter numbers only");
					}
				}
				Integer id2= Integer.parseInt(ch7);

				bean2.setCustomerid(id2);
				System.out.println("Enter Telephone Number to update.......");
				String phone1=null;
				char c5 = 'y';
				while (c5=='y') {
					phone1= sc.next();
					if (ForesteryValidation.phoneValidation(phone1)) {
						c5='n';
					} else {
						System.err.println("enter valid phone number");
					}
				}
				Long telephoneno1= Long.parseLong(phone1);
			
				bean2.setTelephoneNo(telephoneno1);
				if(service.modifyCustomer(bean2)) {
					
					System.out.println("Customer details updated successfully....");
				}
				else {
					System.out.println("Unable to update the Customer details...!!! Customer id doesnot match");
				}
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;

				// case 4 for go back to main menu
			case 5:
				MainForestry m = new MainForestry();
				m.main(null);
				System.out.println("do u want to countinue(y/n) ");
				ch = sc.next().charAt(0);
				break;
			case 6:
				AdminPage a=new AdminPage();
				a.main(null);
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;

				// if we choose other then 1-6 one message will display
			default:
				System.out.println("Your choice should be 1-6");
				Customer c = new Customer();
				c.customer();
				break;
			}// end of switch case

		} // end of while loop

	}// end of customer()

}// end of class
