package com.sample.practise.springrest.dto;

public class ProductListRequest {

	private int product_id;
	private int qauntity;
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQauntity() {
		return qauntity;
	}
	public void setQauntity(int qauntity) {
		this.qauntity = qauntity;
	}
	@Override
	public String toString() {
		return "ProductListRequest [product_id=" + product_id + ", qauntity=" + qauntity + "]";
	}
	public ProductListRequest(int product_id, int qauntity) {
		super();
		this.product_id = product_id;
		this.qauntity = qauntity;
	}
	public ProductListRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
