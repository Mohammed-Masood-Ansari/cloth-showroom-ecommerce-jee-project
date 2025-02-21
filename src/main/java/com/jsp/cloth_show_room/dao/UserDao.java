package com.jsp.cloth_show_room.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.dto.User;

public class UserDao {

	ClothDetailsDao clothDetailsDao = new ClothDetailsDao();
	
	EntityManager entityManager = Persistence.createEntityManagerFactory("showroom").createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	/*
	 * saveUser
	 */
	public User saveUser(User user) {
	
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user;
		
	}
	
	public List<User> getAllUsers(){
		return entityManager.createQuery("FROM User").getResultList();
	}
	
	/*
	 * getUserByName
	 */
	public User getUserById(String userName) {
		
		List<User> users = getAllUsers();
		
		for(User user:users) {
			if(user.getUserEmail().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	public User getUserByEmailDao(String email) {
		Query query=entityManager.createQuery("Select u From User u Where u.userEmail=?1").setParameter(1, email);	
		try {
			return (User) query.getSingleResult();
		} catch (NoResultException|NonUniqueResultException e) {
			return null;
		}	
	}
	
	/*
	 * get only menwear details
	 */
	public List<ClothDetails> getAllMen(){
		
		List<ClothDetails> menwearDetails = new ArrayList<ClothDetails>();
		
		for (ClothDetails clothDetails2 : clothDetailsDao.getAllClothDetails()) {
			
			if(clothDetails2.getWearType().equalsIgnoreCase("men")) {
				menwearDetails.add(clothDetails2);
			}
		}
		
		return menwearDetails;
	}
	
	/*
	 * get only womenwear details
	 */
	public List<ClothDetails> getAllWomen(){
		
		List<ClothDetails> menwearDetails = new ArrayList<ClothDetails>();
		
		for (ClothDetails clothDetails2 : clothDetailsDao.getAllClothDetails()) {
			
			if(clothDetails2.getWearType().equalsIgnoreCase("women")) {
				menwearDetails.add(clothDetails2);
			}
		}
		
		return menwearDetails;
	}
}
