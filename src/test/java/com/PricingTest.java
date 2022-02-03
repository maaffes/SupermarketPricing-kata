package com;

import org.junit.*;

import com.enums.Offer;
import com.model.Discount;
import com.model.Product;
import com.model.ProductQuantity;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author affes
 *
 */
public class PricingTest {
	private static final double DELTA = 1e-15;
	private Product product1=new Product("product1",1.0);
	private Product product2=new Product("product2",3.0);
	private Product product3=new Product("product3",4.0);
	private Product product4=new Product("product4",2.0);

    private List<ProductQuantity> productQuantities= new ArrayList<ProductQuantity>();
    private List<Discount> listDiscount= new ArrayList<Discount>();
    
	@Test
	public void pricing_test_third_free() {
		
		productQuantities.add(new ProductQuantity( product1, 5));
		productQuantities.add(new ProductQuantity( product2, 3));
		productQuantities.add(new ProductQuantity(product3, 2));

		
		listDiscount.add(new Discount(Offer.ThirdForFree,product1));
		listDiscount.add(new Discount(Offer.ThreeForAmount,product2));
		listDiscount.add(new Discount(Offer.NoOffer,product3));
		double  total=  Pricing.getDiscountPricingThirdForFree(listDiscount,productQuantities);	
	    assertEquals(4.0d, total,DELTA);
	
	}
	
	@Test
	public void three_amount_discount() {
		productQuantities.add(new ProductQuantity( product1, 5));
		productQuantities.add(new ProductQuantity( product2, 3));
		productQuantities.add(new ProductQuantity(product3, 2));

		
		listDiscount.add(new Discount(Offer.ThreeForAmount,product1));
		listDiscount.add(new Discount(Offer.ThirdForFree,product2));
		listDiscount.add(new Discount(Offer.NoOffer,product3));

		double  total=  Pricing.getDiscountPricingThreeFor(listDiscount,productQuantities,5);	
	    assertEquals(7.0, total,DELTA);
	}
	
	@Test
	public void pricing_test_no_offer() {
		
		productQuantities.add(new ProductQuantity( product1, 5));
		productQuantities.add(new ProductQuantity( product2, 3));
		productQuantities.add(new ProductQuantity(product3, 2));
		productQuantities.add(new ProductQuantity(product4, 1));

		listDiscount.add(new Discount(Offer.ThirdForFree,product1));
		listDiscount.add(new Discount(Offer.ThreeForAmount,product2));
		listDiscount.add(new Discount(Offer.NoOffer,product3));

		double  total=  Pricing.getPricingNoOffer(listDiscount,productQuantities);	
	    assertEquals(10.0, total, DELTA);
	
	}
	
}
