package com.jsp.cloth_show_room.dto;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ClothDetails implements Serializable{

	@Id
	private int clothBarCode;
	private String clothType;
	private String wearType;
	private double clothPrice;
	private int offer;
	
	@Lob
	private byte[] image;
	
	@OneToOne(mappedBy = "clothDetails")
	private UserCart cart;

}
