package com.jsp.cloth_show_room.service;

import com.jsp.cloth_show_room.dao.ClothDetailsDao;
import com.jsp.cloth_show_room.dto.ClothDetails;

public class ClothDetailsService {

	ClothDetailsDao detailsDao = new ClothDetailsDao();

	/*
	 * saveClothDetails
	 */
	public ClothDetails saveClothDetails(ClothDetails clothDetails) {
		return detailsDao.saveClothDetails(clothDetails);
	}
	
	/*
	 * getClothById
	 */
	public ClothDetails getClothDetails(int clothBarCode) {
		return detailsDao.getClothDetails(clothBarCode);
	}
	
	/*
	 * delete Cloth Details
	 */
	public void deleteCloth(int clothBarCode) {
		detailsDao.deleteCloth(clothBarCode);
	}
	
	/*
	 * updateClothDetails
	 */
	public void updateClothDetails(ClothDetails clothDetails) {
		detailsDao.updateClothDetails(clothDetails);
	}
}
