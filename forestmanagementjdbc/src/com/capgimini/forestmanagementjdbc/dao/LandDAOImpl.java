package com.capgimini.forestmanagementjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import com.capgimini.forestmanagementjdbc.bean.LandBean;
import com.capgimini.forestmanagementjdbc.controller.Land;

//create one class of ProductDAOImpl which implements ProductDAO interface 
public class LandDAOImpl implements LandDAO {

	FileReader reader;
	Properties prop;
	PreparedStatement pstmt= null;
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

	public LandDAOImpl() {
		try {
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public List<LandBean> getAllLands() {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt=conn.createStatement();

				ResultSet rs=stmt.executeQuery(prop.getProperty("query15"))){
			while( rs.next()) {
				System.out.println("---------------------------------------");
				System.out.println("LandId Id: " +rs.getInt(1));
				System.out.println("Land Location: "+rs.getString(2));
				System.out.println("Land Value: " +rs.getString(3));
				System.out.println("Aquisition Date: " +rs.getString(4));
				System.out.println("---------------------------------------");}

		}

		catch (Exception e) {
			System.out.println("Data not found");	

		}

		return null;
	}



	@Override
	public boolean deleteLand(int id) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query13"));){
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
	public boolean addLand(LandBean bean) {

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query12"));){
			try {
				java.util.Date udate=sdf.parse(bean.getAcqDate());
				long l=udate.getTime();
				java.sql.Date sdate =new java.sql.Date(l);
				pstmt.setDate(4,  sdate );


			}catch(Exception e) {
				System.out.println("Please enter Delivery Date  (dd-mm-yyyy) this format only");
				Land l=new Land();
				l.Land();
			}
			pstmt.setInt(1, bean.getLandId());
			pstmt.setString(2, bean.getLandLocation());
			pstmt.setInt(3, bean.getLandValue());

			int count =pstmt.executeUpdate();
			if(count>0) {
				return true;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Land Id already present");
		}

		return false;
	}

	@Override
	public boolean modifyLand(LandBean bean) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));

				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query16"));){

			pstmt.setInt(1, bean.getLandValue());
			pstmt.setInt(2, bean.getLandId());

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
