package com.inventory.util;

import com.inventory.exception.InvalidProductException;
import com.inventory.model.Product;

public class ValidationRules {
	
	public static void validate(Product p) throws InvalidProductException{
		
		if(p.getProdName()==null || p.getProdName().length()<3) {
			throw new InvalidProductException("Product name must be at least 3 characters");
		}
		if(p.getProdQty()<0) {
			throw new InvalidProductException("Product Qty cannot be neagtive");
		}
		if(p.getPrice()<0) {
			throw new InvalidProductException("Product pr");
		}
	}

}
