package com.inventory.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.inventory.model.Admin;
import com.inventory.util.*;

public class AdminDao {
	private Connection con;
	Scanner sc=new Scanner(System.in);
	
	public AdminDao() {
		con=ConnectionUtil.getDbConnection();
	}
	public Admin login(String email,String password) throws SQLException {
		String sql="Select * from admin where email=? AND password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		ResultSet rset=pstmt.executeQuery();
		if(rset.next()) {
			System.out.println("email"+rset.getString("email"));
			return new Admin(rset.getString("email"),rset.getString("password"));
		}
		return null;
	}
	
	

}
