package com.sample.practise.springrest.dto;

import java.io.Serializable;
import java.util.List;

public class ProductDetails implements Serializable{

	private int id;
	private String name;
	private double price;
	private List<Promotions> promotions;
	
	
	public ProductDetails(int id, String name, int price, List<Promotions> promotions) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.promotions = promotions;
	}

	public ProductDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", price=" + price + ", promotions=" + promotions + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the promotions
	 */
	public List<Promotions> getPromotions() {
		return promotions;
	}

	/**
	 * @param promotions the promotions to set
	 */
	public void setPromotions(List<Promotions> promotions) {
		this.promotions = promotions;
	}
	
	



}
