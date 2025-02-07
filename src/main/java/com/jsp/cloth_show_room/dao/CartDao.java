package com.jsp.cloth_show_room.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.cloth_show_room.dto.UserCart;

public class CartDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("showroom").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	/*
	 * saveDetails in Cart
	 * 
	*/
	public UserCart saveUserCart(UserCart userCart) {
		
		entityTransaction.begin();
		entityManager.persist(userCart);
		entityTransaction.commit();
		
		return userCart;
	}
	
	/*
	 * getById
	 */
	public UserCart getUserById(int userId) {
		return entityManager.find(UserCart.class, userId);
	}
	
	/*
	 * deleteUserById
	 */
	public void deleteUserById(int userId) {
		UserCart userCart=getUserById(userId);
		if(userCart!=null) {
			entityTransaction.begin();
			entityManager.remove(userCart);
			entityTransaction.commit();
		}
	}
	
	/*
	 * getAllCarts
	 * 
	 */
	public List<UserCart> getAllCarts(){ 
		return entityManager.createQuery("From UserCart").getResultList();
	}
}
