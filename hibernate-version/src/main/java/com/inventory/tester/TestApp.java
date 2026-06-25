package com.inventory.tester;

import java.util.List;
import java.util.Scanner;

import com.inventory.dal.ProductDao;
import com.inventory.model.Product;

public class TestApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ProductDao dao = new ProductDao();

     
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            int ch;

          
            do {
            	System.out.println("Enter your choice:");
            	 ch = sc.nextInt();
            switch (ch) {

            case 1:
                System.out.println("Enter ID, Name, Qty, Price:");
                Product p = new Product(
                        sc.nextInt(),
                        sc.next(),
                        sc.nextInt(),
                        sc.nextDouble());

                dao.addProduct(p);
                break;

            case 2:
                List<Product> list = dao.getAllProducts();
                for (Product pr : list) {
                    System.out.println(pr.getProdId() + " "
                            + pr.getProdName() + " "
                            + pr.getProdQty() + " "
                            + pr.getPrice());
                }
                break;

            case 3:
                System.out.println("Enter ID, New Qty, New Price:");
                dao.updateProduct(sc.nextInt(), sc.nextInt(), sc.nextDouble());
                break;

            case 4:
                System.out.println("Enter ID to delete:");
                dao.deleteProduct(sc.nextInt());
                break;

            case 5:
                System.exit(0);
            }
            } while(ch!=0);
            
            
	}
}

    

	


