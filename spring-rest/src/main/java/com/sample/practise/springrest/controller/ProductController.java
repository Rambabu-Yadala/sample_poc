package com.sample.practise.springrest.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.practise.springrest.dto.CartDetailsResponse;
import com.sample.practise.springrest.dto.ProductDetails;
import com.sample.practise.springrest.dto.CartProductListRequest;
import com.sample.practise.springrest.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping("/getCartDetails")
	public void getCartDetails(@RequestBody List<CartProductListRequest> productListRequest) {
		
		//int product_id=productListRequest.forEach(action);
		
		final String uri = "http://localhost:9000/products/2";
	     
		ResponseEntity<ProductDetails> responseEntity=new RestTemplate().getForEntity("http://localhost:9000/products/2",ProductDetails.class);
		ProductDetails response=responseEntity.getBody();
		
	  
	   System.out.println(response);
	}
	@PostMapping("/getCartDetailsFromUser")
	public @ResponseBody CartDetailsResponse getCartDetailsFromUser(@RequestBody List<CartProductListRequest> productListRequest) {
		
		//int product_id=productListRequest.forEach(action);
		CartDetailsResponse cartDetailsResponse = productService.calcaulateCartDetial(productListRequest);
		
		CartDetailsResponse cartDetailsResponse1 = new CartDetailsResponse();
		cartDetailsResponse1.setTotalBill(1000);
		
		return cartDetailsResponse;
	}
	
	
}
