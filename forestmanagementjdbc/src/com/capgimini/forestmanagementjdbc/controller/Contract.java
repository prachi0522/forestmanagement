package com.capgimini.forestmanagementjdbc.controller;

import java.util.Scanner;

import com.capgimini.forestmanagementjdbc.bean.ContractBean;
import com.capgimini.forestmanagementjdbc.dao.ContractDAO;
import com.capgimini.forestmanagementjdbc.factory.ContractDAOManagerFactory;
import com.capgimini.forestmanagementjdbc.main.MainForestry;
import com.capgimini.forestmanagementjdbc.validation.ForesteryValidation;

//create one class
public class Contract {
	//create one method
	public void contractor() {
		//create one ContractBean object
		ContractBean bean=new ContractBean();
		//Create one ContractDAO Object
		ContractDAO dao=ContractDAOManagerFactory.getContractDAO();
		Scanner sc=new Scanner(System.in);
		char ch='y';
		while(ch=='y'||ch=='y') {//create one while loop
			System.out.println("****CONTRACT OPERATONS****");
			System.out.println("--------------");
			System.out.println("Enter 1 to insert data");
			System.out.println("Enter 2 to delete data");
			System.out.println("Enter 3 to get all data");
			System.out.println("Enter 4 to return home");
			String ch6=null;
			char c6 = 'y';
			while(c6=='y') {
				ch6= sc.next();
				if(ForesteryValidation.isNumber(ch6)) {
					c6='n';
				} else {
					System.err.println("Enter numbers only.....");
				}
			} 
			Integer choice = Integer.parseInt(ch6);
			switch (choice) {//create one switch case
			//case 1 for insert contract details
			case 1:
				ContractBean bean1=new ContractBean();

				System.out.println("Add Contract Details of contract");
				System.out.println("-------------------");
				System.out.println("Enter contract id");
				String ch1=null;
				char c1 = 'y';
				while(c1=='y') {
					ch1= sc.next();
					if(ForesteryValidation.isNumber(ch1)) {
						c1='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Long id = Long.parseLong(ch1);

				bean1.setContractno(id);
				boolean again;

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
				Integer id1 = Integer.parseInt(ch2);
				bean1.setCustomerid(id1);


				System.out.println("Enter Haulier id");
				String ch3=null;
				char c3 = 'y';
				while(c3=='y') {
					ch3= sc.next();
					if(ForesteryValidation.isNumber(ch3)) {
						c3='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer id2 = Integer.parseInt(ch3);
				bean1.setHaulierid(id2);

				System.out.println("Enter Product id");
				String ch4=null;
				char c4 = 'y';
				while(c4=='y') {
					ch4= sc.next();
					if(ForesteryValidation.isNumber(ch4)) {
						c4='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer id4 = Integer.parseInt(ch4);
				bean1.setProductid(id4);

				System.out.println("Enter quantity");
				String quantity=null;
				char q1 = 'y';
				while(q1=='y') {
					quantity= sc.next();
					if(ForesteryValidation.isNumber(quantity)) {
						q1='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				bean1.setQuantity(Integer.parseInt(quantity));
				try {
					System.out.println("Enter Delivery Date  (dd-mm-yyyy).........");
					String date=sc.next();
					bean1.setDeliverydate(date);
				}

				catch(Exception e){
					System.out.println("Invalid Delivery Date try again........");
					again=false;

				}      

				do {
					System.out.println("Enter Delivery Day like Sunday/Monday.........");
					String deliveryday=sc.next();
					if(deliveryday.matches("Sunday||Monday||Tuesday||Wednesday||Thursday||Friday||Saturday")){
						System.out.println("Valid Delivery day");
						bean1.setDeliveryday(deliveryday);
						again=true;
					}

					else{
						System.out.println("Invalid Delivery day try again........");
						again=false;

					}      
				}while(!again);

				boolean check=dao.addContract(bean1);
				if(check) {
					System.out.println("contract details added to the list");
				}
				else
				{
					System.out.println("contractno is repeated");
				}

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
				//case 1 for delete the contract details
			case 2:
				System.out.println("Enter contractno to delete");
				String ch5=null;
				char c5 = 'y';
				while(c5=='y') {
					ch5= sc.next();
					if(ForesteryValidation.isNumber(ch5)) {
						c1='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Long id5 = Long.parseLong(ch5);

				if(dao.deleteContract(id5)) {

					System.out.println("given contractno details has been deleted");
				}
				else {
					System.out.println("sorry....Unable to deleted.Contact number not present in the list");
				}

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;
				//case 1 for get all details of contract 
			case 3:
				System.out.println(dao.getAllContracts());

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;
				//case 5 for back to main menu 
			case 4:
				MainForestry m=new MainForestry();
				m.main(null);
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;
			default:
				Contract c= new Contract();
				c.contractor();
			}

		}//end of while loop
	}//end of method contractor()

}//end of class
