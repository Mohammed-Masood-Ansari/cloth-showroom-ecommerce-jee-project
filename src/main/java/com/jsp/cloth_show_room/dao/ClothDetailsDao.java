package com.jsp.cloth_show_room.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.cloth_show_room.dto.ClothDetails;

public class ClothDetailsDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("showroom").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	/*
	 * saveClothDetails
	 */
	public ClothDetails saveClothDetails(ClothDetails clothDetails) {
		
		entityTransaction.begin();
		entityManager.persist(clothDetails);
		entityTransaction.commit();
		
		return clothDetails;
	}
	
	/*
	 * getAllClothDetails
	 */
	public List<ClothDetails> getAllClothDetails(){
		return entityManager.createQuery("FROM ClothDetails").getResultList();
	}
	
	
	/*
	 * getClothById
	 */
	public ClothDetails getClothDetails(int clothBarCode) {
		return entityManager.find(ClothDetails.class, clothBarCode);
	}
	
	/*
	 * delete Cloth Details
	 */
	public void deleteCloth(int clothBarCode) {
		
		ClothDetails clothDetails=getClothDetails(clothBarCode);
		
		if(clothDetails!=null) {
			entityTransaction.begin();
			entityManager.remove(clothDetails);
			entityTransaction.commit();
		}
	}
	
	/*
	 * updateClothDetails
	 */
	public void updateClothDetails(ClothDetails clothDetails) {
		
		entityTransaction.begin();
		entityManager.merge(clothDetails);
		entityTransaction.commit();
	}
}
