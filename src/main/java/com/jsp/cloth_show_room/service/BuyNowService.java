package com.jsp.cloth_show_room.service;

import com.jsp.cloth_show_room.dao.BuyNowDao;
import com.jsp.cloth_show_room.dto.BuyNow;

public class BuyNowService {

	BuyNowDao buyNowDao = new BuyNowDao();
	
	/*
	 * Order---Save
	 */
	public BuyNow saveBuyNow(BuyNow buyNow) {
		
		return buyNowDao.saveBuyNow(buyNow);
	}
}
