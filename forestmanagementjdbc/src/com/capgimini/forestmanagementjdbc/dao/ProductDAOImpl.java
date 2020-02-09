package com.capgimini.forestmanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.capgimini.forestmanagementjdbc.bean.ProductBean;

//create one class of ProductDAOImpl which implements ProductDAO interface 
public class ProductDAOImpl implements ProductDAO {

	FileReader reader;
	Properties prop;
	PreparedStatement pstmt= null;

	public ProductDAOImpl() {
		try {
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	//Implements all the unimplements methods of ProductDAO
	public List<ProductBean> getAllProductss() {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt=conn.createStatement();

				ResultSet rs=stmt.executeQuery(prop.getProperty("query8"))){
			while( rs.next()) {
				System.out.println("---------------------------------------");
				System.out.println("Product Id: " +rs.getInt(1));
				System.out.println("Product Name: "+rs.getString(2));
				System.out.println("Product Description: " +rs.getString(3));
				System.out.println("---------------------------------------");}

		}

		catch (Exception e) {
			System.out.println("Data not found");	
			
		}

		return null;
	}
	

	@Override
	public boolean addProduct(ProductBean bean) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query9"));){
			pstmt.setInt(1, bean.getProdid());
			pstmt.setString(2, bean.getPname());
			pstmt.setString(3, bean.getPdesc());
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



	@Override
	public boolean deleteProduct(int id) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query10"));){
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

	@Override
	public boolean modifyProduct(ProductBean  bean) {
		
	try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
			prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

			PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query11"));){
	
		pstmt.setString(1, bean.getPname());
		pstmt.setInt(2, bean.getProdid());
		
		int count =pstmt.executeUpdate();
		if(count>0) {
			return true;
		}
	}
	catch (Exception e) {
		System.err.println("Something Went Wrong");
		e.printStackTrace();
}

	return false;
}

}//end of class
