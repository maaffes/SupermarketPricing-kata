package com.model;

import com.enums.Offer;

/**
 * 
 * @author affes
 *
 */
public class Discount {

	private Offer name;
	private Product product;

	public Discount(Offer threefortwo, Product product) {
		super();
		this.name = threefortwo;
		this.product = product;
	}

	public Offer getName() {
		return name;
	}

	public Product getProduct() {
		return product;
	}

}
