package com.jsp.cloth_show_room.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ClothDetails {

	@Id
	private int clothBarCode;
	private String clothType;
	private String wearType;
	private double clothPrice;
	private int offer;
	
	@Lob
	private byte[] image;
	
	public int getClothBarCode() {
		return clothBarCode;
	}
	public void setClothBarCode(int clothBarCode) {
		this.clothBarCode = clothBarCode;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
}
