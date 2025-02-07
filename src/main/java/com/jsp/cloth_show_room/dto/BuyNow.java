package com.jsp.cloth_show_room.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "product_order")
public class BuyNow {
	
	/*
	 * Automatic Save
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String pinCode;
	private String address;
	private int quantity;
	private double price;
	
	/*
	 * Automatic Save
	 */
	@UpdateTimestamp
	private LocalDate bookingdate;
	
	/*
	 * Automatic Save
	 */
	private LocalDate delivarDate;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "clothbarcode")
	private ClothDetails clothDetails;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(LocalDate bookingdate) {
		this.bookingdate = bookingdate;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ClothDetails getClothDetails() {
		return clothDetails;
	}

	public void setClothDetails(ClothDetails clothDetails) {
		this.clothDetails = clothDetails;
	}

	public LocalDate getDelivarDate() {
		return delivarDate;
	}

	public void setDelivarDate(LocalDate delivarDate) {
		this.delivarDate = delivarDate;
	}
}
