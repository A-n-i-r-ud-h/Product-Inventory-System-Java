package com.inventory.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getDbConnection()
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("____Driver loaded_____");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root","Ani@1604");
			System.out.println("db connected");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
