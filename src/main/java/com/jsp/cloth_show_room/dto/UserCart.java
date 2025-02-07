package com.jsp.cloth_show_room.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserCart {

	@Id
	private int userCartId;
	private String clothType;
	private String wearType;
	private double clothPrice;
	private int offer;
	
	public int getUserCartId() {
		return userCartId;
	}
	public void setUserCartId(int userCartId) {
		this.userCartId = userCartId;
	}
	public String getClothType() {
		return clothType;
	}
	public void setClothType(String clothType) {
		this.clothType = clothType;
	}
	public String getWearType() {
		return wearType;
	}
	public void setWearType(String wearType) {
		this.wearType = wearType;
	}
	public double getClothPrice() {
		return clothPrice;
	}
	public void setClothPrice(double clothPrice) {
		this.clothPrice = clothPrice;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
}
