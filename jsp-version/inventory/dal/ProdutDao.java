package com.inventory.dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

import com.inventory.exception.DuplicateProductException;
import com.inventory.exception.InvalidProductException;
import com.inventory.exception.ProductNotFoundException;
import com.inventory.model.Product;
import com.inventory.util.ConnectionUtil;
import com.inventory.util.ValidationRules;



public class ProdutDao {
	private Connection con;
	Scanner sc = new Scanner(System.in);
	
	
	public ProdutDao() throws SQLException {
		con=ConnectionUtil.getDbConnection();
		
	}
	public boolean productExists(int id) {
	    boolean exists = false;

	    try {
	        String sql = "SELECT * FROM product WHERE prodId=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            exists = true;  
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return exists;
	}
	public ArrayList<Product> getAllProducts() throws SQLException {
		ArrayList<Product> prods = new ArrayList<Product>();
		String sql = "Select * from product";
		
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(sql);
		
		while(rset.next()) {
			prods.add(new Product(rset.getString("prodName"),rset.getInt("prodQty"),rset.getDouble("price")));
		    
		}
		rset.close();
		return prods;
		
	}
	public int addProduct(Product prod) {
		try {
		ValidationRules.validate(prod);
		if (productExists(prod.getProdId())) {
		    throw new DuplicateProductException("Product ID already exists");
		}
		String sql = "Insert into product values(?,?,?,?)";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, prod.getProdId());
		pstmt.setString(2, prod.getProdName());
		pstmt.setInt(3, prod.getProdQty());
		pstmt.setDouble(4, prod.getPrice());
		
		int i = pstmt.executeUpdate();
		return i;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int editProdDetails(int prodQty,double price,int prodId) throws SQLException, InvalidProductException, ProductNotFoundException {
		Product prod=new Product();
		ValidationRules.validate(prod);
		if (!productExists(prod.getProdId())) {
		    throw new ProductNotFoundException("Product not found");
		}
		String sql = "update product set prodQty=? , price=? where prodId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, prodQty);
		pstmt.setDouble(2, price);
		pstmt.setInt(3, prodId);
		
		int i =pstmt.executeUpdate();
		return i;
	}
	public int deleteProduct(int prodId) throws SQLException, InvalidProductException, ProductNotFoundException {
		Product prod=new Product();
		
		ValidationRules.validate(prod);
		if (!productExists(prodId)) {
		    throw new ProductNotFoundException("Product not found");
		}
		String sql="delete from product where prodId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, prodId);
		
		int i = pstmt.executeUpdate();
		return i;
	}
	public Product getByProductId(int prodId) throws SQLException {
		String sql="Select * from product where prodId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, prodId);
		
		ResultSet rset = pstmt.executeQuery();
		if(rset.next()) {
			return new Product(rset.getString("prodName"),rset.getInt("prodQty"),rset.getDouble("price"));
		}
		return null;
	}
	

}
