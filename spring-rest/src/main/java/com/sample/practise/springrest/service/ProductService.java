package com.sample.practise.springrest.service;

import java.util.List;

import com.sample.practise.springrest.dto.CartDetailsResponse;
import com.sample.practise.springrest.dto.CartProductListRequest;

public interface ProductService {

	public CartDetailsResponse calcaulateCartDetial(List<CartProductListRequest> cartProductListRequest);

	
}
