package com.capgimini.forestmanagementjdbc.controller;

import java.util.Scanner;

import com.capgimini.forestmanagementjdbc.bean.LandBean;
import com.capgimini.forestmanagementjdbc.dao.LandDAO;
import com.capgimini.forestmanagementjdbc.factory.LandDAOManagerFactory;
import com.capgimini.forestmanagementjdbc.main.AdminPage;
import com.capgimini.forestmanagementjdbc.main.MainForestry;
import com.capgimini.forestmanagementjdbc.service.LandService;
import com.capgimini.forestmanagementjdbc.validation.ForesteryValidation;

public class Land {//create one class
	public void Land(){//create one method

		LandBean bean=new LandBean(); //create one LandBean object
		LandDAO dao=LandDAOManagerFactory.getLandDAO();//create one LandDAO object
		Scanner sc=new Scanner(System.in);
		char ch='y';
		while(ch=='y'||ch=='y') {//check if the condition true enter the while loop
			System.out.println("Enter 1 to insert data");
			System.out.println("Enter 2 to delete data");
			System.out.println("Enter 3 to get all data");
			System.out.println("Enter 4 to update the data");
			System.out.println("Enter 5 to return home");
			System.out.println("Enter 6 to Logout");

			String ch6=null;
			char c6 = 'y';
			while(c6=='y') {
				ch6= sc.next();
				if(ForesteryValidation.isNumber(ch6)) {
					c6='n';
				} else {
					System.err.println("enter numbers only");
				}
			} 
			Integer choice = Integer.parseInt(ch6);
			
			switch(choice) {//create one switch case
			//switch case for addition of a Land
			case 1:
				LandBean bean1=new LandBean();//create  one LandBean object

				boolean again;
				System.out.println("Enter  Land Id........");
				String land=null;
				char c1 = 'y';
				while(c1=='y') {
					land= sc.next();
					if(ForesteryValidation.isNumber(land)) {
						c1='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer id1 = Integer.parseInt(land);
			
				bean1.setLandId(id1);

				System.out.println("Enter Land Location........");
				String loc=null;
				char c2 = 'y';
				while(c2=='y') {
					loc= sc.next();
					if(ForesteryValidation.isStringAlphabet(loc)) {
						c2='n';
					} else {
						System.err.println("enter alphabets only");
					}
				} 
				bean1.setLandLocation(loc);
				
				System.out.println("Enter Land Price.......");
				String price=null;
				char c3 = 'y';
				while(c3=='y') {
					price= sc.next();
					if(ForesteryValidation.isNumber(price)) {
						c3='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer value = Integer.parseInt(price);
				bean1.setLandValue(value);
				
				try {
					System.out.println("Enter Delivery Date  (dd-mm-yyyy).........");
					String date=sc.next();
					bean1.setAcqDate(date);
				}

				catch(Exception e) {
					System.out.println("Please enter Delivery Date  (dd-mm-yyyy) this format only");
					Land l=new Land();
					l.Land();
				}
				
				
				boolean check=dao.addLand(bean1);
				//check if the Land id is not present in the list then add the Land details in the list
				if(check) {
					System.out.println("Land details added to the list");
				}
				else
				{
					System.out.println("Land id is repeated");
				}

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);//returns next token as a string
				break;
				//if the Land is present in the list then using Land id you can delete the Land
			case 2:
				System.out.println("Enter Land id to delete");
				String landid1=null;
				char c5 = 'y';
				while(c5=='y') {
					landid1= sc.next();
					if(ForesteryValidation.isNumber(landid1)) {
						c5='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer id3 = Integer.parseInt(landid1);

				if(dao.deleteLand(id3)) {

					System.out.println("given Land details has been deleted");
				}
				else {
					System.out.println("sorry....Unable to delete. Land id not present in the list.");
				}

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;
				//list all the Lands present in the database
			case 3:

				System.out.println(dao.getAllLands());

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;
				//if the Land is present in the list then using Land id you can update the Land

			case 4:
				LandService services= LandDAOManagerFactory.instanceOfLandServiceImpl();
				 bean=new LandBean();			 
				System.out.println("Enter Land Id .....");
				String land4=null;
				char c4 = 'y';
				while(c4=='y') {
					land4= sc.next();
					if(ForesteryValidation.isNumber(land4)) {
						c4='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer id4 = Integer.parseInt(land4);
				bean.setLandId(id4);
				System.out.println("Enter Land Value to update.......");
				String price9=null;
				char c9 = 'y';
				while(c9=='y') {
					price9= sc.next();
					if(ForesteryValidation.isNumber(price9)) {
						c9='n';
					} else {
						System.err.println("enter numbers only");
					}
				} 
				Integer value9 = Integer.parseInt(price9);
				
				bean.setLandValue(value9);
				if(services.modifyLand(bean)) {
					System.out.println("Land details updated successfully....");
				}
				else {
					System.out.println("Unable to update the Land details...!!! Land id doesnot match");
				}
//				System.out.println(services.modifyLand(bean2));
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;

				//this switch case use to go back to main menu
			case 5:
				MainForestry m=new MainForestry();
				m.main(null);

				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);

				break;
			case 6:
				AdminPage a=new AdminPage();
				a.main(null);
				System.out.println("do u want to countinue(y/n) ");
				ch=sc.next().charAt(0);
				break;

				//if we choose other then 1-6 then display one message 
			default:
				System.err.println("Your choice should be 1-6");
				Land p=new Land();
				p.Land();
				break;

			}//end of switch case


		}//end of while loop
	}//end of Land ()

}//end of class
