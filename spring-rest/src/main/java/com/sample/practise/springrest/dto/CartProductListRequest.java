package com.sample.practise.springrest.dto;

public class CartProductListRequest {

	private int product_id;
	private int quantity;
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartProductListRequest [product_id=" + product_id + ", quantity=" + quantity + "]";
	}
	public CartProductListRequest(int product_id, int quantity) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public CartProductListRequest() {
		super();
	}
	
	
	
}
