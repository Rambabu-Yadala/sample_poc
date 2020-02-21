package com.sample.practise.springrest.dto;

import java.io.Serializable;

public class Promotions implements Serializable{

	private int id;
	private int requiredQuantity;
	private double price;
	private String type;
	private int freeQuantity;
	private double amount;
	
	public Promotions(int id, int requiredQuantity, double price, String type, int freeQuantity, double amount) {
		super();
		this.id = id;
		this.requiredQuantity = requiredQuantity;
		this.price = price;
		this.type = type;
		this.freeQuantity = freeQuantity;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Promotions [id=" + id + ", requiredQuantity=" + requiredQuantity + ", price=" + price + ", type=" + type
				+ ", freeQuantity=" + freeQuantity + ", amount=" + amount + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequiredQuantity() {
		return requiredQuantity;
	}
	public void setRequiredQuantity(int requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getFreeQuantity() {
		return freeQuantity;
	}
	public void setFreeQuantity(int freeQuantity) {
		this.freeQuantity = freeQuantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Promotions() {
		super();
	} 
	
	
}
