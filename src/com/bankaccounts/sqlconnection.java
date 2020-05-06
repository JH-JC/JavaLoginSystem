package com.bankaccounts;

import javax.swing.*;

import java.sql.*;

public class sqlconnection

{
	
	static Connection con = null;
	static String databaseName = "";
	static String url = "<url name>";
	
	static String username = "<root name>";
	
	static String password = "<password>";





	public static Connection dbConnector() { //This is for mySQL workbench connection
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url ,username, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO 'accountinfo'.'info' ('accountID') VALUES ('<id number>'), ('<id number>'), ('<id number>');");
			
			
			int status = ps.executeUpdate();
			
			if (status != 0) {
				
				System.out.println("Database was Connected");
				
				System.out.println("RECORDS WAS INSERTED");
			
			}
		
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		return null;
	}
}

	





