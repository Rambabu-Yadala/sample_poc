package com.sample.practise.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.practise.springrest.dto.CartDetailsResponse;
import com.sample.practise.springrest.dto.Constants;
import com.sample.practise.springrest.dto.ProductDetails;
import com.sample.practise.springrest.dto.CartProductListRequest;
import com.sample.practise.springrest.dto.Promotions;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	RestTemplate restTemplate;
	public CartDetailsResponse calcaulateCartDetial(List<CartProductListRequest> cartProductListRequest) {
		
		List<Double> totalBill = new ArrayList<Double>();
		List<Double> totalPromo = new ArrayList<Double>();
		Double cost = 0.0;
		double promoAmount = 0.0;
		for (CartProductListRequest productListRequest : cartProductListRequest) {
			int id = productListRequest.getProduct_id();
			int qauntity = productListRequest.getQuantity();
			final String uri = "http://localhost:9000/products/{id}";

			ResponseEntity<ProductDetails> responseEntity = restTemplate.getForEntity(uri, ProductDetails.class,id);
			ProductDetails responseProduct = responseEntity.getBody();

			List<Promotions> PromotionsList = responseProduct.getPromotions();
			if (PromotionsList.size() != 0) {
				for (Promotions promotions : PromotionsList) {
					String promoType = promotions.getType();
					if (Constants.BUY_1_GET_1.equalsIgnoreCase(promoType) && productListRequest.getQuantity() >= 2) {
						totalBill.add(responseProduct.getPrice());
						// totalPromo.add(responseProduct.getPrice());
					} else if (Constants.PRICE_DISCOUNT.equalsIgnoreCase(promoType)
							&& productListRequest.getQuantity() >= 2) {
						totalPromo.add((responseProduct.getPrice() * productListRequest.getQuantity())
								- promotions.getPrice());
						totalBill.add(promotions.getPrice());
					} else if (Constants.FLAT_DISCOUNT.equalsIgnoreCase(promoType)) {
						totalPromo.add(promotions.getAmount());//
						totalBill.add(responseProduct.getPrice());
					} else if (Constants.PRICE_DISCOUNT.equalsIgnoreCase(promoType)
							&& promotions.getRequiredQuantity() > 1) {
						totalBill.add(responseProduct.getPrice() * qauntity);
					} else if (Constants.BUY_1_GET_1.equalsIgnoreCase(promoType)
							&& promotions.getRequiredQuantity() == 1) {
						totalBill.add(responseProduct.getPrice() * qauntity);
					}

				}
			} else {
				totalBill.add(responseProduct.getPrice() * qauntity);
			}

			System.out.println("-----" + responseProduct);

		}
		//add all the promos amount
		for (Double promo : totalPromo) {
			promoAmount += promo;
		}
		// add all the items amount
		for (Double bill : totalBill) {
			cost += bill;
		}
		System.out.println("Total cost of the products is :: >" + cost);
		System.out.println("Total promo amount is :: >" + promoAmount);
		System.out.println("Total Payable amount is :: >" + (cost - promoAmount));

		CartDetailsResponse cartDetailsResponse = new CartDetailsResponse();
		cartDetailsResponse.setTotalBill(cost);
		cartDetailsResponse.setTotalPromo(promoAmount);
		cartDetailsResponse.setTotalPayable((cost - promoAmount));

		return cartDetailsResponse;

	}
}
