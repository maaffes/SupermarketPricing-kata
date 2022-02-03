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

	/**
	 * 
	 * @param listDiscount
	 * @param productQuantities
	 * @return
	 */
	public static double getDiscountPricingThirdForFree(List<Discount> listDiscount,
			List<ProductQuantity> productQuantities) {

		double productDiscount = productQuantities.stream()

				.filter(e -> (e.getQuantity() > 2) && listDiscount.stream().anyMatch(
						f -> (e.getProduct().equals(f.getProduct())) && (f.getName().equals(Offer.ThirdForFree))))
				.mapToDouble(x -> x.getQuantity() / 3 * x.getProduct().getPrice() * 2
						+ (x.getQuantity() % 3) * x.getProduct().getPrice())
				.sum();
		return productDiscount;
	}

	/**
	 * 
	 * @param listDiscount
	 * @param productQuantities
	 * @param amount
	 * @return
	 */
	public static double getDiscountPricingThreeFor(List<Discount> listDiscount,
			List<ProductQuantity> productQuantities, int amount) {
		double productDiscount = productQuantities.stream()
				.filter(e -> (e.getQuantity() > 2) && listDiscount.stream()
						.anyMatch(f -> (e.getProduct().equals(f.getProduct())) && (f.getName().equals(Offer.ThreeForAmount))))
				.mapToDouble(x -> x.getQuantity() / 3 * amount + (x.getQuantity() % 3) * x.getProduct().getPrice())
				.sum();

		return productDiscount;
	}

	/**
	 * 
	 * @param listDiscount
	 * @param productQuantities
	 * @return
	 */
	public static double getPricingNoOffer(List<Discount> listDiscount, List<ProductQuantity> productQuantities) {
		double productDiscount = productQuantities.stream()
				.filter(e -> (e.getQuantity() < 2)
						|| listDiscount.stream().anyMatch(f -> (e.getProduct().equals(f.getProduct())) && (f.getName().equals(Offer.NoOffer))))

				.mapToDouble(x -> x.getQuantity() * x.getProduct().getPrice()).sum();

		return productDiscount;
	}

}
