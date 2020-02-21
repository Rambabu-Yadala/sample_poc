package com.sample.practise.springrest.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.junit5.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.sample.practise.springrest.dto.CartDetailsResponse;
import com.sample.practise.springrest.dto.CartProductListRequest;
import com.sample.practise.springrest.dto.ProductDetails;
import com.sample.practise.springrest.dto.Promotions;


@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	ProductServiceImpl  productServiceImpl;
	
	CartDetailsResponse cartDetailsResponse;
	
	List<CartProductListRequest> productListRequests;
	
	CartProductListRequest productListRequest;
	
	@MockBean
	ProductDetails productDetails;
	
	@MockBean
	RestTemplate restTemplate;
	
	Promotions promotions;
	
	@MockBean
	ResponseEntity responseEntity;
	
	private MockRestServiceServer mockServer;
	
	@Before
	public void setup() {
		
		 mockServer = MockRestServiceServer.createServer(restTemplate);

		productListRequests = new ArrayList<CartProductListRequest>();
		productServiceImpl = new ProductServiceImpl();
		productDetails= new ProductDetails();
		
		CartProductListRequest cartProductListRequest1 = new CartProductListRequest();
		CartProductListRequest cartProductListRequest2 =  new CartProductListRequest();
		CartProductListRequest cartProductListRequest3 =  new CartProductListRequest();
		
		cartProductListRequest1.setProduct_id(1);
		cartProductListRequest1.setQuantity(1);
		
		cartProductListRequest2.setProduct_id(2);
		cartProductListRequest2.setQuantity(1);
		
		cartProductListRequest3.setProduct_id(8);
		cartProductListRequest3.setQuantity(1);
		
		productListRequests.add(cartProductListRequest1);
		productListRequests.add(cartProductListRequest2);
		productListRequests.add(cartProductListRequest3);
		
	}
	@Test
	public void calcaulateCartDetailTest() {
		//new RestTemplate().getForEntity(uri, ProductDetails.class,id)
		
		/*
		 * Mockito .when(restTemplate.getForEntity(
		 * "http://localhost:9000/products/{id}", ProductDetails.class)) .thenReturn(new
		 * ResponseEntity(productDetails, HttpStatus.OK));
		 */
		
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(), ProductDetails.class)).thenReturn(responseEntity);
		
		
		CartDetailsResponse cartDetailsResponse = productServiceImpl.calcaulateCartDetial(productListRequests);
		Assert.assertNotNull(cartDetailsResponse);
		
	}
	@After
	public void tearDown() {
		cartDetailsResponse = null;
		productListRequests = null;
		productListRequest = null;
		productDetails = null;
		restTemplate = null;
		promotions = null;
		
				
	}
	

}

