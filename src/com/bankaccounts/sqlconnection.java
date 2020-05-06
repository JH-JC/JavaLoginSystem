package com.bankaccounts;

import javax.swing.*;

import java.sql.*;

public class sqlconnection

{
	
	static Connection con = null;
	static String databaseName = "";
	static String url = "jdbc:mysql://127.0.0.1:3306/";
	
	static String username = "root";
	
	static String password = "2eG8y35gk";





	public static Connection dbConnector() { //This is for mySQL workbench connection
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url ,username, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO 'accountinfo'.'info' ('accountID') VALUES ('e14gKvsWMl86k4fa'), ('xD1fKmvSa79Kalsf'), ('aCkf17nJk7aAe4k9');");
			
			
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

	





