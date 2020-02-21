package com.sample.practise.springrest.dto;

import java.io.Serializable;

public class CartDetailsResponse implements Serializable {
	private double totalBill;
	private double totalPromo;
	private double totalPayable;
	
	
	
	/**
	 * @return the totalBill
	 */
	public double getTotalBill() {
		return totalBill;
	}
	/**
	 * @param totalBill the totalBill to set
	 */
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	/**
	 * @return the totalPromo
	 */
	public double getTotalPromo() {
		return totalPromo;
	}
	/**
	 * @param totalPromo the totalPromo to set
	 */
	public void setTotalPromo(double totalPromo) {
		this.totalPromo = totalPromo;
	}
	/**
	 * @return the totalPayable
	 */
	public double getTotalPayable() {
		return totalPayable;
	}
	/**
	 * @param totalPayable the totalPayable to set
	 */
	public void setTotalPayable(double totalPayable) {
		this.totalPayable = totalPayable;
	}
	@Override
	public String toString() {
		return "CartDetailsResponse [totalBill=" + totalBill + ", totalPromo=" + totalPromo + ", totalPayable="
				+ totalPayable + "]";
	}
	public CartDetailsResponse(double totalBill, double totalPromo, double totalPayable) {
		super();
		this.totalBill = totalBill;
		this.totalPromo = totalPromo;
		this.totalPayable = totalPayable;
	}
	public CartDetailsResponse() {
		super();
	}

}
