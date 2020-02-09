package com.capgimini.forestmanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.capgimini.forestmanagementjdbc.bean.CustomerBean;

//create one class CustomerDAOImpl which implements all unimplemented methods of CustomerDAO
public class CustomerDAOImpl implements CustomerDAO{
	FileReader reader;
	Properties prop;
	PreparedStatement pstmt= null;

	public CustomerDAOImpl() {
		try {
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	//This will return all CUstomer list
	@Override
	public List<CustomerBean> getAllCustomers() {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query4"))){
			while( rs.next()) {
				System.out.println("---------------------------------------");
				System.out.println("Customer Id: " +rs.getInt(1));
				System.out.println("Customer Name: "+rs.getString(2));
				System.out.println("Street Address1: " +rs.getString(3));
				System.out.println("Street Address2: "+rs.getString(4));
				System.out.println("Town: " +rs.getString(5));
				System.out.println("Postal Code: "+ rs.getString(6));
				System.out.println("Email: " +rs.getString(7));
				System.out.println("Telephone Number: " +rs.getLong(8));

				System.out.println("---------------------------------------");}

		}

		catch (Exception e) {
			System.out.println("Data not found");	
		}

		return null;
	}


	//Add Customer records to the list
	@Override
	public boolean addCustomer(CustomerBean bean) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query5"));){
			pstmt.setInt(1, bean.getCustomerid());
			pstmt.setString(2, bean.getCustomername());
			pstmt.setString(4, bean.getStreetAddress1());
			pstmt.setString(3, bean.getStreetAddress1());
			pstmt.setString(5,  bean.getTown() );
			pstmt.setInt(6, bean.getPostalCode());
			pstmt.setString(7, bean.getEmail());
			pstmt.setLong(8, bean.getTelephoneNo());

			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}

		}

		catch (Exception e) {
			System.err.println("Customer id already present");
			}

		return false;
	}


	//delete customer records to the list
	@Override
	public boolean deleteCustomer(int id) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query6"));){
			pstmt.setInt(1,id );

			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}

		}

		catch (Exception e) {
			System.err.println("Records not Deleted");
		}

		return false;
	}

	//modify customer records to the list
	@Override
	public boolean modifyCustomer(CustomerBean bean) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query7"));){
		
			pstmt.setLong(1, bean.getTelephoneNo());
			pstmt.setInt(2, bean.getCustomerid());
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Something Went Wrong");
			e.printStackTrace();
	}

		return false;
	}
}//end of class