package com.model;

/**
 * 
 * @author affes
 *
 */
public class ProductQuantity {
	
private Product product;
private int quantity;
public Product getProduct() {
	return product;
}


public int getQuantity() {
	return quantity;
}

public ProductQuantity(Product product, int quantity) {
	super();
	this.product = product;
	this.quantity = quantity;
}


}
