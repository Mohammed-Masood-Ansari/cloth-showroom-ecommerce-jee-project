package com.jsp.cloth_show_room.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.cloth_show_room.dto.BuyNow;
import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.dto.UserCart;

public class BuyNowDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("showroom").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	/*
	 * Order---Save
	 */
	public BuyNow saveBuyNow(BuyNow buyNow) {
		entityTransaction.begin();
		entityManager.persist(buyNow);
		entityTransaction.commit();
		return buyNow;
	}
	
	/*
	 * multiple order at a time
	 */
	public List<BuyNow> multipleOrderTime(List<BuyNow> buyNows){
		
		for (BuyNow buyNow : buyNows) {
			entityTransaction.begin();
			entityManager.persist(buyNow);
			entityTransaction.commit();
		}	
		
		return buyNows;
	}
	
	public List<BuyNow> getAllOrderDetailsByUserIdDao(int userId){
		return entityManager.createNativeQuery("select * from  product_order where userid=?1",BuyNow.class).setParameter(1, userId).getResultList();
	}
	
	public List<BuyNow> getAllBuyNows(){
		return entityManager.createQuery("FROM BuyNow").getResultList();
	}
	
	public UserCart getUserCartByCartId(int userCartId) {
	
		return entityManager.find(UserCart.class, userCartId);
	}
}
