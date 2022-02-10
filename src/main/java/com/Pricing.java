package com;

import java.util.List;

import com.enums.Offer;
import com.model.Discount;
import com.model.ProductQuantity;

/**
 * 
 * @author affes
 *
 */



public class Pricing {

	private static double productDiscount=0.0;
	
	/**
	 * GetDiscountPricingThirdForFree calculate a total products's price when offer is "Buy two, get one free"

	 * @param listDiscount
	 * @param productQuantities
	 * @return productDiscount
	 * @throws Exception 
	 */
	public static double getDiscountPricingThirdForFree(List<Discount> listDiscount,
			List<ProductQuantity> productQuantities) throws Exception {

		try {
		 productDiscount = productQuantities.stream()

				.filter(e -> (e.getQuantity() > 2) && listDiscount.stream().anyMatch(
						f -> (e.getProduct().equals(f.getProduct())) && (f.getName().equals(Offer.ThirdForFree))))
				.mapToDouble(x -> x.getQuantity() / 3 * x.getProduct().getPrice() * 2
						+ (x.getQuantity() % 3) * x.getProduct().getPrice())
				.sum();
	}catch (Exception ex){
		
		throw new Exception(ex);
	}
		return productDiscount;
	}

	/**
	 * GetDiscountPricingThreeFor calculate a total products's price when the offer is "three for price"

	 * @param listDiscount
	 * @param productQuantities
	 * @param amount
	 * @return
	 * @throws Exception 
	 */
	public static double getDiscountPricingThreeFor(List<Discount> listDiscount,
			List<ProductQuantity> productQuantities, int amount) throws Exception {
		try {
		 productDiscount = productQuantities.stream()
				.filter(e -> (e.getQuantity() > 2) && listDiscount.stream()
						.anyMatch(f -> (e.getProduct().equals(f.getProduct())) && (f.getName().equals(Offer.ThreeForAmount))))
				.mapToDouble(x -> x.getQuantity() / 3 * amount + (x.getQuantity() % 3) * x.getProduct().getPrice())
				.sum();
		}catch (Exception ex){
			
			throw new Exception(ex);
		}
		

		return productDiscount;
	}

	/**
	 * GetPricingNoOffer calculate a total products's price when no offer

	 * @param listDiscount
	 * @param productQuantities
	 * @return
	 * @throws Exception 
	 */
	public static double getPricingNoOffer(List<Discount> listDiscount, List<ProductQuantity> productQuantities) throws Exception {
		try {
		 productDiscount = productQuantities.stream()
				.filter(e -> (e.getQuantity() < 2)
						|| listDiscount.stream().anyMatch(f -> (e.getProduct().equals(f.getProduct())) && (f.getName().equals(Offer.NoOffer))))

				.mapToDouble(x -> x.getQuantity() * x.getProduct().getPrice()).sum();
		}catch (Exception ex){
			
			throw new Exception(ex);
		}
		return productDiscount;
	}

}
